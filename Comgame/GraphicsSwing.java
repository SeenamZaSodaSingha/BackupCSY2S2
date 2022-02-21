import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.lang.Math;

class GraphicsSwing extends JPanel implements Runnable {

    static final int FRAME_WIDTH = 1000;
    static final int FRAME_HEIGHT = 1000;
    // pixel per secound.
    static final int PPS = 100;

    // is velocity facter equal to real_velocity/pps
    int v_facter[] = {4, 4};
    int position[] = {0, 0};


    // final double pi = Math.pi;

    double angleMove = 0.0;
    public static void main(String[] args) {
        GraphicsSwing m = new GraphicsSwing();

        JFrame f = new JFrame();
        f.add(m);
        // f.setTitle();
        // f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(FRAME_WIDTH,FRAME_HEIGHT);
        f.setVisible(true);

        (new Thread(m)).start();
    }

    public void run() {

        double elapsedTime, curTime;
        double lastTime = System.currentTimeMillis();

        while (true) {

            //control time.
            curTime = System.currentTimeMillis();
            elapsedTime = curTime - lastTime;
            lastTime = curTime;

            //update
            angleMove += elapsedTime * PPS / 1000;
            updatePos(elapsedTime, PPS);

            //display
            repaint();

        }
   }

    public void updatePos(double elapsedTime, int pps){
        double v = elapsedTime * pps / 1000;
        position[0] += (int) (v_facter[0]*v);
        position[1] += (int) (v_facter[1]*v);

        System.out.println("Position: " + position[0] + " " + position[1]);
   }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        oneFrameCircle(g2, position[0], position[1], 10);
        rotatingSquare(g2, 300, 300, 300 ,300, angleMove);
    }

    //draw circle and delete imdiatelly.
    public void oneFrameCircle(Graphics2D g2, int h, int k, int r) {
        //delete circle
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        //draw circle
        g2.setColor(Color.RED);
        drawCircle((Graphics) g2, h, k, r);
    }

    public void rotatingSquare(Graphics2D g, int x, int y, int width, int height, double angle) {
        g.rotate(Math.toRadians(angle), x + (int)(width/2), y + (int)(height/2));
        g.drawRect(x, y, width, height);
    }




    //draw circle with 
    public void drawCircle(Graphics g, int h, int k, int r) {
        drawElipse(g, h, k , r, r);
    }

    //draw ellipse 
    public void drawElipse(Graphics g, int h, int k, int a, int b) {
        float a2 = a * a;
        float b2 = b * b;
        float twoa2 = 2 * a2;
        float twob2 = 2 * b2;

        float x = 0;
        float y = b;
        float D = Math.round(b2 - a2*b + a2/4);
        float Dx = 0;
        float Dy = twoa2*y;

        while (Dx <= Dy){
            int intx = (int) x;
            int inty = (int) y;
            g.fillRect(intx  + h , inty  + k  , 1,1);
            g.fillRect(-intx + h , inty  + k  , 1,1);
            g.fillRect(intx  + h , -inty + k  , 1,1);
            g.fillRect(-intx + h , -inty + k  , 1,1);

            x += 1;
            Dx += twob2;
            D += Dx + b2;
            
            if (D > 0){
                y -= 1;
                Dy -= twoa2;
                D -= Dy;
            }
        }

        x = a; 
        y = 0;
        D = Math.round(a2 - b2*a + b2/4);
        Dx = twob2*x;
        Dy = 0;

        while (Dx >= Dy){
            int intx = (int) x;
            int inty = (int) y;
            g.fillRect(intx  + h , inty  + k  , 1,1);
            g.fillRect(-intx + h , inty  + k  , 1,1);
            g.fillRect(intx  + h , -inty + k  , 1,1);
            g.fillRect(-intx + h , -inty + k  , 1,1);
            y += 1;
            Dy += twoa2;
            D += Dy + a2;
            
            if (D > 0){
                x -= 1;
                Dx -= twob2;
                D -= Dx;
            }
        }
    }
}