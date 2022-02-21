if(currentTime - squareStartTime >= 3.0){
                squareMove = true;
            }
            if(squareMove){
                sqx += velocityX * elapsedTime / 1000;
                sqy += velocityY * elapsedTime / 1000;
            }