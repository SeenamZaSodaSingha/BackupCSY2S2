import java.awt.*;
import javax.swing.*;
import java.util.Random;

class GraphicsSwing extends JPanel {
    static Random rd = new Random(69420);

    public static void main(String[] args) {
        GraphicsSwing m = new GraphicsSwing();

        JFrame frame = new JFrame();
        frame.add(m);
        frame.setSize(600, 600);
        frame.setTitle("First swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) { // always call when create frame
        bezierCurve(g, 100, 500, 200, 300, 400, 300, 500, 500);
    }

    public void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        //bezier like this is freaking slow
        for(int i = 0; i < 1000; i++){
            double t = i / 1000.0;
            int x = (int)(Math.pow((1-t), 3) * x1 + 
            t * Math.pow((1-t), 2) * x2 +
            t * t * (1-t) * x3 + 
            t * t * t * x4);

            int y = (int)(Math.pow((1-t), 3) * y1 + 
            t * Math.pow((1-t), 2) * y2 +
            t * t * (1-t) * y3 + 
            t * t * t * y4);

            plot(g, x, y, 3);
        }
    }

    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}