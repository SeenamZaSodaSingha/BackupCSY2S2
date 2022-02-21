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
        g.drawString("63050144", 400, 50);
        g.setColor(Color.RED);
        ddaLine(g, 100, 100, 400, 200);
        ddaLine(g, 400, 200, 100, 100);
        ddaLine(g, 100, 100, 200, 400);
        bresenhamLine(g, 100, 100, 400, 200);
        bresenhamLine(g, 400, 200, 100, 100);
        bresenhamLine(g, 100, 100, 200, 400);
    }

    public void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1, sy = y1 < y2 ? 1 : -1;
        boolean isSwap = false;

        if(dy > dx){
            int tmp = dy;
            dy = dx;
            dx = tmp;
            isSwap = true;
        }

        int D = 2 * dy - dx;
        int x = x1, y = y1;

        for(int i = 1; i <= dx; i++){
            plot(g, x, y, 3);
            if(D >= 0){
                if (isSwap) x += sx;
                else y += sy;

                D -= 2 * dx;
            }

            if (isSwap) y += sy;
            else x += sx;

            D += 2 * dy;
        }
    }

    public void ddaLine(Graphics g, int x1, int y1, int x2, int y2) {
        double dx = x2 - x1, dy = y2 - y1;
        double m = dy / dx;
        double x, y;

        if (m <= 1 && m >= 0) {
            // System.out.println(" \"CASE 1\"");
            y = Math.min(y1, y2);
            for (x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                y += m;
                plot(g, (int)x, (int)y, 3);
            }
        } else if (m >= -1 && m < 0) {
            // System.out.println(" \"CASE 2\"");
            y = Math.min(y1, y2);
            for (x = Math.max(x1, x2); x >= Math.min(x1, x2); x--) { //remarks
                y -= m;
                plot(g, (int)x, (int)y, 3);
            }
        } else if (m > 1) {
            // System.out.println(" \"CASE 3\"");
            x = Math.min(x1, x2);
            for (y = Math.min(y1, y2); y <= Math.max(y1,y2); y++) {
                x += 1 / m;
                plot(g, (int)x, (int)y, 3);
            }
        } else {
            // System.out.println(" \"CASE 4\"");
            x = Math.min(x1, x2);
            for (y = Math.max(y1, y2); y >= Math.min(y1, y2); y--) { //remarks
                x -= 1 / m;
                plot(g, (int)x, (int)y, 3);
            }
        }
    }

    public void naiveLine(Graphics g, int x1, int y1, int x2, int y2) {
        double dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        double m = dy / dx;
        double b = y1 - m * x1;

        for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
            int y = (int) Math.round(m * x + b);
            plot(g, x, y, 3);
        }
    }

    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}