﻿using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;
using System.Collections.Generic;

namespace Checker
{
    public class Checker : Game
    {
        const int _TILESIZE = 75;

        private GraphicsDeviceManager _graphics;
        private SpriteBatch _spriteBatch;

        enum PlayerTurn
        {
            RedTurn,
            YellowTurn
        }

        PlayerTurn _currentPlayerTurn;

        Point _selectedTile;

        //TODO: Game State Machine

        enum GameState
        {
            WaitingForSelection,
            ChipSelected
        }

        GameState _currentGameState;

        MouseState _mouseState, _previousMouseState;
        Point _clickedPos;

        //TODO: Image files and font
        Texture2D _chip, _horse, _rect;



        int[,] _gameTable;

        public Checker()
        {
            // constructer method call first
            //aka setup
            _graphics = new GraphicsDeviceManager(this);

            Content.RootDirectory = "Content";
            IsMouseVisible = true;
        }

        protected override void Initialize()
        {
            _graphics.PreferredBackBufferWidth = 600;  // set this value to the desired width of your window
            _graphics.PreferredBackBufferHeight = 600;   // set this value to the desired height of your window
            _graphics.ApplyChanges();

            _currentPlayerTurn = PlayerTurn.RedTurn;

            _currentGameState = GameState.WaitingForSelection;

            _gameTable = new int[8, 8]
            {
                { 1,0,1,0,1,0,1,0},
                { 0,1,0,1,0,1,0,1},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { 0,0,0,0,0,0,0,0},
                { -1,0,-1,0,-1,0,-1,0},
                { 0,-1,0,-1,0,-1,0,-1}
            };

            base.Initialize();
        }

        protected override void LoadContent()
        {
            _spriteBatch = new SpriteBatch(GraphicsDevice);
            _chip = this.Content.Load<Texture2D>("Chip");
            _horse = this.Content.Load<Texture2D>("Horse");

            _rect = new Texture2D(_graphics.GraphicsDevice, _TILESIZE, _TILESIZE);

            Color[] data = new Color[_TILESIZE * _TILESIZE];
            for(int i = 0; i < data.Length; i++)
            {
                data[i] = Color.White;
            }

            _rect.SetData(data);
            // TODO: use this.Content to load your game content here
        }

        protected override void Update(GameTime gameTime)
        {
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed || Keyboard.GetState().IsKeyDown(Keys.Escape))
                Exit();

            _previousMouseState = _mouseState;

            //TODO: Game logic in state machine

            switch (_currentGameState)
            {
                case GameState.WaitingForSelection:

                    _mouseState = Mouse.GetState();

                    if (_mouseState.LeftButton == ButtonState.Pressed &&
                        _previousMouseState.LeftButton == ButtonState.Released)
                    {
                        int xPos = _mouseState.X / _TILESIZE,
                        yPos = _mouseState.Y / _TILESIZE;

                        _selectedTile = new Point(xPos, yPos);
                        _currentGameState = GameState.ChipSelected;
                    }
                    break;

                case GameState.ChipSelected:

                    _mouseState = Mouse.GetState();

                    if (_mouseState.LeftButton == ButtonState.Pressed &&
                        _previousMouseState.LeftButton == ButtonState.Released)
                    {
                        int xPos = _mouseState.X / _TILESIZE,
                        yPos = _mouseState.Y / _TILESIZE;


                        _gameTable[yPos, xPos] = _gameTable[_selectedTile.Y, _selectedTile.X];
                        _gameTable[_selectedTile.Y, _selectedTile.X] = 0;

                        _currentGameState = GameState.WaitingForSelection;
                    }
                    break;
            }
            base.Update(gameTime);
        }

        protected override void Draw(GameTime gameTime)
        {
            GraphicsDevice.Clear(Color.White);

            // TODO: Add your drawing code here
            _spriteBatch.Begin();

            //TODO: Draw board
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    if((i + j) % 2 == 0)
                    _spriteBatch.Draw(_rect, new Vector2(_TILESIZE * j, _TILESIZE * i), null, Color.Black, 0f, Vector2.Zero, 1f, SpriteEffects.None, 0f);
                }
            }
            _spriteBatch.Draw(_rect, new Vector2(_selectedTile.X * _TILESIZE, _selectedTile.Y * _TILESIZE), null, Color.Blue, 0f, Vector2.Zero, 1f, SpriteEffects.None, 0f);

            //TODO: draw chips
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    switch(_gameTable[i, j])
                    {
                        case 1:
                            _spriteBatch.Draw(_chip, new Vector2(_TILESIZE * j, _TILESIZE * i), null, Color.Yellow, 0f, Vector2.Zero, 1f, SpriteEffects.None, 0f);
                            break;
                        case -1:
                            _spriteBatch.Draw(_chip, new Vector2(_TILESIZE * j, _TILESIZE * i), null, Color.Red, 0f, Vector2.Zero, 1f, SpriteEffects.None, 0f);
                            break;
                        case 2:
                            _spriteBatch.Draw(_horse, new Vector2(_TILESIZE * j, _TILESIZE * i), null, Color.Yellow, 0f, Vector2.Zero, 1f, SpriteEffects.None, 0f);
                            break;
                        case -2:
                            _spriteBatch.Draw(_horse, new Vector2(_TILESIZE * j, _TILESIZE * i), null, Color.Red, 0f, Vector2.Zero, 1f, SpriteEffects.None, 0f);
                            break;
                    }
                }
            }


            _spriteBatch.End();

            _graphics.BeginDraw();

            base.Draw(gameTime);
        }
    }
}
