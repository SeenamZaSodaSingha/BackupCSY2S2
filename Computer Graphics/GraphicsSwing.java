import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Random;
import java.awt.geom.*;

class GraphicsSwing extends JPanel implements Runnable {
    static Random rd = new Random(69420);
    double circleMove = 0.0, squareRotate = 0.0;
    double x = 300, y = 200, velocity = 50, angle = 0, sqAngle = -45, squareVelocity = 100, sqx = 0, sqy = 465;
    int r = 150;

    double velocityX, velocityY, velocitySQX, velocitySQY;

    public static void main(String[] args) {
        GraphicsSwing m = new GraphicsSwing();

        JFrame frame = new JFrame();
        frame.add(m);
        frame.setSize(600, 600);
        frame.setTitle("First swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        (new Thread(m)).start();
    }

    //<<------------------------------------------ T H R E D S ------------------------------------------------>>

    public void run(){

        double elapsedTime, currentTime, lastTime = System.currentTimeMillis(), squareStartTime = lastTime;
        boolean moveForward = true, squareMove = false;

        velocityX = velocity * Math.cos(Math.toRadians(angle));
        velocityY = velocity * Math.sin(Math.toRadians(angle));

        velocitySQX = velocity * Math.cos(Math.toRadians(sqAngle));
        velocitySQY = velocity * Math.sin(Math.toRadians(sqAngle));

        while(true){
            //control time
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = System.currentTimeMillis();

            //update
            //move 50 pixels per sec
            // circleMove += elapsedTime * 50 / 1000;
            // squareRotate += 0.2 * elapsedTime /1000;

            //square move
            if((currentTime - squareStartTime)/1000 >= 3.0){
                // System.out.println((currentTime - squareStartTime)/1000);
                squareMove = true;
            }
            if(squareMove){
                sqx += velocitySQX * elapsedTime / 1000;
                sqy += velocitySQY * elapsedTime / 1000;
            }

            if(x + r <= 600 && moveForward){ //move forward
                x += velocityX * elapsedTime / 1000;
                // System.out.println("Move forward X:" + x);
            }
            else{ //move backward, x > 600
                // System.out.println("Move backward X: " + x);
                moveForward = false;
                x -= velocityX * elapsedTime / 1000;
                if(x <= 0) moveForward = true;
            }
            // x += velocityX * elapsedTime / 1000;
            y += velocityY * elapsedTime / 1000;

            //display
            repaint();
        }
    }
 
    //<<------------------------------------ P A I N T C O M P O N E N T ---------------------------------------->> 

    public void paintComponent(Graphics g) { // always call when create frame

        Graphics2D g2 = (Graphics2D)g;
        // g2.setColor(Color.white);
        // g2.fillRect(0, 0, 600, 600);
        // g2.setColor(Color.black);
        // midpointCircle(g, (int)circleMove, 200, 100, 3);
        // g2.drawOval((int)circleMove, 0, 100, 100);
        
        g2.setTransform(new AffineTransform(1, 0, 0, 1, -200, -200));
        g2.setTransform(new AffineTransform(1, 0, 0, 1, 100, 100));
        g2.drawRect(200, 200, 200, 200);


        // g2.drawOval((int)x, (int)y, r, r);
        // g2.setColor(Color.GREEN);
        // g2.fillRect((int)sqx, (int)sqy, 100, 100);
        //change anchor point
        // g2.rotate(squareRotate, 300, 300);
        // x + width/2, y + height/2
        // g2.drawRect(200, 200, 200, 200);

    }

    // <<----------------------------------------C I R C L D R A W I N G---------------------------------->>
    public void midpointCircle(Graphics g, int xc, int yc, int r, int size) {
        int x = 0, y = r;
        int dx = 2 * x, dy = 2 * y;
        int d = 1 - r;

        while (x <= y) {
            plot(g, x + xc, y + yc, size);
            plot(g, -x + xc, y + yc, size);
            plot(g, x + xc, -y + yc, size);
            plot(g, -x + xc, -y + yc, size);
            plot(g, y + xc, x + yc, size);
            plot(g, -y + xc, -x + yc, size);
            plot(g, y + xc, -x + yc, size);
            plot(g, -y + xc, x + yc, size);
            // plot 8 octants of (x, y)
            x++;
            dx += 2;
            d = d + dx + 1;

            if (d >= 0) {
                y--;
                dy -= 2;
                d = d - dy;
            }
        }
    }

    public void fillMidpointCircle(Graphics g, int xc, int yc, int r) {
        // fill by drawing layer of circle from center to edge
        for (int i = 0; i <= r; i++) {
            midpointCircle(g, xc, yc, i, 3);
        }
    }

    public void midpointEllipse(Graphics g, int xc, int yc, int a, int b, int size) {
        // region 1
        int x = 0,
        y = b,
        d = Math.round(b * b - a * a * b + a * a / 4);

        while (b * b * x <= a * a * y) {
            plot(g, x + xc, y + yc, size);
            plot(g, -x + xc, y + yc, size);
            plot(g, x + xc, -y + yc, size);
            plot(g, -x + xc, -y + yc, size);
            // can do only 4 points

            x++;
            d = d + 2*b*b*x + b*b;

            if(d >= 0){
                y--;
                d = d- 2*a*a*y;
            }
        }

        // region 2
        x = a;
        y = 0;
        d = Math.round(a*a - b*b*a + b*b/4);

        while (b * b * x >= a * a * y) {
            plot(g, x + xc, y + yc, size);
            plot(g, -x + xc, y + yc, size);
            plot(g, x + xc, -y + yc, size);
            plot(g, -x + xc, -y + yc, size);
            // can do only 4 points

            y++;
            d = d + 2*a*a*y + a*a;

            if(d >= 0){
                x--;
                d = d- 2*b*b*x;
            }
        }
    }

    // <<----------------------------------F I L L A L G O R I T H M-------------------------------------->>
    public BufferedImage floodFill(BufferedImage m, int x, int y, Color targetColor, Color replacementColor) {
        Graphics2D g2 = m.createGraphics();

        Queue<Point> q = new LinkedList<Point>();
        g2.setColor(replacementColor);
        plot(g2, x, y, 1);
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();

            // south
            if (p.y < 600 && new Color(m.getRGB(p.x, p.y + 1)).equals(targetColor)) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y + 1, 1);
                q.add(new Point(p.x, p.y + 1));
            }
            // north
            if (p.y > 0 && new Color(m.getRGB(p.x, p.y - 1)).equals(targetColor)) {
                g2.setColor(replacementColor);
                plot(g2, p.x, p.y - 1, 1);
                q.add(new Point(p.x, p.y - 1));
            }
            // east
            if (p.x < 600 && new Color(m.getRGB(p.x + 1, p.y)).equals(targetColor)) {
                g2.setColor(replacementColor);
                plot(g2, p.x + 1, p.y, 1);
                q.add(new Point(p.x + 1, p.y));
            }
            // west
            if (p.x > 0 && new Color(m.getRGB(p.x - 1, p.y)).equals(targetColor)) {
                g2.setColor(replacementColor);
                plot(g2, p.x - 1, p.y, 1);
                q.add(new Point(p.x - 1, p.y));
            }
        }

        return m;
    }

    // <<--------------------L I N E D R A W I N G A L G O R I T H M------------------------------------>>

    public void bezierCurve(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // bezier like t his is freaking slow
        for (int i = 0; i < 1000; i++) {
            double t = i / 1000.0;
            int x = (int) (Math.pow((1 - t), 3) * x1 +
                    3 * t * Math.pow((1 - t), 2) * x2 +
                    3 * t * t * (1 - t) * x3 +
                    t * t * t * x4);

            int y = (int) (Math.pow((1 - t), 3) * y1 +
                    3 * t * Math.pow((1 - t), 2) * y2 +
                    3 * t * t * (1 - t) * y3 +
                    t * t * t * y4);

            plot(g, x, y, 3);
        }
    }

    public void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1), dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1, sy = y1 < y2 ? 1 : -1;
        boolean isSwap = false;

        if (dy > dx) {
            int tmp = dy;
            dy = dx;
            dx = tmp;
            isSwap = true;
        }

        int D = 2 * dy - dx;
        int x = x1, y = y1;

        for (int i = 1; i <= dx; i++) {
            plot(g, x, y, 3);
            if (D >= 0) {
                if (isSwap)
                    x += sx;
                else
                    y += sy;

                D -= 2 * dx;
            }

            if (isSwap)
                y += sy;
            else
                x += sx;

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
                plot(g, (int) x, (int) y, 3);
            }
        } else if (m >= -1 && m < 0) {
            // System.out.println(" \"CASE 2\"");
            y = Math.min(y1, y2);
            for (x = Math.max(x1, x2); x >= Math.min(x1, x2); x--) { // remarks
                y -= m;
                plot(g, (int) x, (int) y, 3);
            }
        } else if (m > 1) {
            // System.out.println(" \"CASE 3\"");
            x = Math.min(x1, x2);
            for (y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
                x += 1 / m;
                plot(g, (int) x, (int) y, 3);
            }
        } else {
            // System.out.println(" \"CASE 4\"");
            x = Math.min(x1, x2);
            for (y = Math.max(y1, y2); y >= Math.min(y1, y2); y--) { // remarks
                x -= 1 / m;
                plot(g, (int) x, (int) y, 3);
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

    // <<-----------------------D O T H E P L O T H E R E---------------->>
    public void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }
}