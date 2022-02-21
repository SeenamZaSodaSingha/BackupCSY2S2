import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Assignment1_63050144_63050136 extends JPanel {
     public static void main(String[] args) throws Exception {
          Assignment1_63050144_63050136 m = new Assignment1_63050144_63050136();

          JFrame f = new JFrame();
          f.add(m);
          f.setTitle("Chubby Tiger");
          f.setSize(600, 600);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          f.setVisible(true);
          // while(true){
          //      Thread.sleep(100);
          //      f.repaint();;
          //      f.setVisible(true);
          // }
          
     }

     public void paintComponent(Graphics g) {
          BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
          Graphics2D g2 = buffer.createGraphics();
          g2.setColor(Color.WHITE);
          g2.fillRect(0, 0, 600, 600);

          Color eye = new Color(253, 198, 82, 255),
                nose = new Color(246, 198, 192, 255),
                skin = new Color(242, 174, 93, 255),
                tone = new Color(29, 23, 20, 255),
                triangle = new Color(232, 232, 232, 255);

          // most cool triangle
          g2.setColor(triangle);
          int[] xtri = {50, 538, 294}, ytri = {540, 540, 20};
          g2.fillPolygon(xtri, ytri, xtri.length);
          g2.setColor(Color.BLACK);

          // Face
          // upper innner curve
          g2.setColor(new Color(121, 123, 118, 255));
          bezierCurve(g2, 177, 150, 55, 162, 69, 324, 117, 377, 2);
          // end of upper curve

          g2.setColor(Color.BLACK);
          bezierCurve(g2, 214, 120, 263, 85, 390, 110, 412, 140, 3);
          bezierCurve(g2, 412, 140, 475, 145, 480, 200, 498, 227, 3);
          bezierCurve(g2, 498, 227, 575, 250, 575, 410, 462, 430, 4);
          bezierCurve(g2, 340, 503, 340, 520, 460, 470, 462, 430, 5);
          bezierCurve(g2, 340, 503, 277, 518, 176, 479, 108, 421, 3);

          // ear;
          g2.setColor(Color.BLACK);
          bezierCurve(g2, 125, 100, 170, 80, 192, 130, 214, 120, 3);
          bezierCurve(g2, 125, 100, 85, 110, 90, 180, 130, 170, 4);
          bezierCurve(g2, 108, 421, 44, 363, 26, 235, 120, 174, 3);

          //face bg fix
          buffer = floodFill(buffer, 307, 315, triangle, Color.WHITE);
          

          // inner face curve
          g2.setColor(new Color(121, 123, 118, 255));
          bezierCurve(g2, 117, 377, 156, 419, 232, 461, 339, 447, 2);
          bezierCurve(g2, 306, 447, 336, 433, 360, 428, 380, 429, 2);
          bezierCurve(g2, 400, 427, 395, 422, 460, 430, 456, 432, 2);
          bezierCurve(g2, 433, 429, 424, 438, 401, 450, 380, 445, 2);
          g2.setColor(Color.BLACK);
          
          // Left eye
          bresenhamLine(g2, 332, 179, 379, 197, 2);
          bresenhamLine(g2, 379, 197, 380, 216, 3);
          bezierCurve(g2, 340, 182, 320, 200, 375, 225, 381, 205, 3);
          bezierCurve(g2, 379, 197, 390, 192, 380, 200, 394, 183, 3);

          bezierCurve(g2, 358, 188, 358, 200, 360, 200, 366, 191, 3);//eye ball Enchance
          buffer = floodFill(buffer, 360, 193, Color.WHITE, Color.BLACK);
          buffer = floodFill(buffer, 346, 193, Color.WHITE, eye);
          
          // Right eye
          bresenhamLine(g2, 450, 211, 482, 226, 2);
          bezierCurve(g2, 453, 211, 432, 210, 469, 260, 482, 226, 2);

          bezierCurve(g2, 462, 218, 460, 226, 464, 230, 470, 221, 2);//eye ball Enchance
          buffer = floodFill(buffer, 465, 220, Color.WHITE, Color.BLACK);
          buffer = floodFill(buffer, 470, 231, Color.WHITE, eye);
          
          // nose
          bezierCurve(g2, 448, 225, 445, 235, 465, 248, 467, 260, 2);
          bezierCurve(g2, 452, 198, 458, 205, 440, 220, 448, 225, 2);
          bezierCurve(g2, 450, 260, 460, 255, 463, 258, 470, 263, 2);
          bezierCurve(g2, 419, 256, 430, 240, 440, 255, 450, 260, 2);
          bezierCurve(g2, 415, 248, 408, 250, 435, 280, 441, 283, 2);
          bezierCurve(g2, 441, 283, 450, 285, 470, 275, 467, 260, 2);
          bresenhamLine(g2, 416, 232, 419, 237, 3);
          buffer = floodFill(buffer, 450, 265, Color.WHITE, nose);
          bezierCurve(g2, 425, 265, 430, 264, 438, 265, 430, 275, 2);// left nasal
          bezierCurve(g2, 454, 280, 454, 270, 460, 270, 460, 279, 2);// right nasal
          buffer = floodFill(buffer, 430, 267, nose, Color.BLACK);// Left nasal
          buffer = floodFill(buffer, 456, 278, nose, Color.BLACK);// right nasal

          // mouth
          bezierCurve(g2, 413, 322, 435, 315, 435, 300, 440, 283, 2);
          bezierCurve(g2, 441, 283, 435, 300, 420, 323, 434, 327, 2);
          bezierCurve(g2, 414, 324, 428, 318, 430, 320, 434, 330, 1);
          buffer = floodFill(buffer, 428, 318, Color.WHITE, Color.BLACK);

          // right beard
          bezierCurve(g2, 375, 245, 382, 250, 395, 262, 400, 265, 2);
          bezierCurve(g2, 355, 265, 365, 273, 375, 280, 400, 278, 2);
          bezierCurve(g2, 352, 291, 365, 298, 390, 298, 388, 295, 2);

          // left beard
          bezierCurve(g2, 467, 280, 470, 281, 475, 285, 480, 282, 2);
          bezierCurve(g2, 462, 295, 470, 300, 480, 308, 484, 305, 2);
          bezierCurve(g2, 458, 313, 462, 317, 468, 323, 473, 322, 2);

          //camouflague
          bresenhamLine(g2, 535, 255, 516, 272, 1);
          bresenhamLine(g2, 516, 272, 492, 269, 1);
          bresenhamLine(g2, 492, 269, 520, 283, 1);
          bresenhamLine(g2, 520, 283, 545, 266, 1);
          buffer = floodFill(buffer, 529, 263, Color.WHITE, tone);
          //---------------------------------------------------------

          bezierCurve(g2, 496, 216, 495, 228, 512, 250, 484, 252, 1);
          bezierCurve(g2, 484, 252, 506, 253, 507, 232, 507, 235, 1);
          buffer = floodFill(buffer, 500, 235, Color.WHITE, tone);
          //---------------------------------------------------------

          bresenhamLine(g2, 467, 163, 473, 196, 1);
          bresenhamLine(g2, 473, 196, 480, 182, 1);
          buffer = floodFill(buffer, 473, 180, Color.WHITE, tone);
          //---------------------------------------------------------

          bresenhamLine(g2, 453, 152, 452, 180, 1);
          bezierCurve(g2, 447, 151, 445, 161, 456, 171, 452, 180, 1);
          buffer = floodFill(buffer, 452, 165, Color.WHITE, tone);
          //---------------------------------------------------------

          bresenhamLine(g2, 415, 140, 433, 166, 1);
          bresenhamLine(g2, 433, 166, 424, 139, 1);
          buffer = floodFill(buffer, 424, 147, Color.WHITE, tone);
          //---------------------------------------------------------

          bresenhamLine(g2, 406, 135, 409, 151, 1);
          bresenhamLine(g2, 409, 151, 410, 137, 1);
          buffer = floodFill(buffer, 408, 138, Color.WHITE, tone);
          //---------------------------------------------------------

          bezierCurve(g2, 380, 123, 379, 130, 388, 148, 375, 157, 1);
          bezierCurve(g2, 372, 116, 369, 131, 377, 144, 375, 157, 1);
          buffer = floodFill(buffer, 377, 135, Color.WHITE, tone);
          //---------------------------------------------------------

          bezierCurve(g2, 340, 111, 328, 120, 304, 131, 288, 128, 1);
          bezierCurve(g2, 311, 106, 305, 117, 299, 122, 288, 128, 1);
          buffer = floodFill(buffer, 311, 123, Color.WHITE, tone);

          //---------------------------------------------------------

          //scar
          bezierCurve(g2, 330, 141, 334, 135, 336, 138, 342, 141, 1);
          bezierCurve(g2, 330, 141, 336, 160, 336, 160, 342, 141, 1);
          buffer = floodFill(buffer, 335, 145, Color.WHITE, tone);

          bezierCurve(g2, 346, 129, 343, 135, 349, 143, 352, 147, 1);
          bezierCurve(g2, 346, 129, 352, 133, 352, 140, 352, 147, 1);
          buffer = floodFill(buffer, 348, 135, Color.WHITE, tone);

          bezierCurve(g2, 205, 168, 198, 171, 186, 174, 184, 181, 1);
          bezierCurve(g2, 184, 181, 170, 192, 172, 215, 191, 222, 1);
          bezierCurve(g2, 184, 181, 180, 193, 182, 212, 191, 222, 1);
          bezierCurve(g2, 191, 222, 196, 219, 196, 227, 200, 231, 1);
          buffer = floodFill(buffer, 176, 203, Color.WHITE, tone);

          bezierCurve(g2, 314, 152, 310, 165, 320, 170, 325, 180, 2);
          bezierCurve(g2, 314, 152, 300, 170, 320, 170, 320, 183, 2);
          buffer = floodFill(buffer, 317, 172, Color.WHITE, tone);
          bezierCurve(g2, 325, 180, 300, 185, 325, 225, 340, 225, 2);
          bezierCurve(g2, 320, 178, 280, 190, 320, 220, 340, 225, 2);
          buffer = floodFill(buffer, 308, 200, Color.WHITE, tone);

          bezierCurve(g2, 266, 150, 260, 158, 260, 163, 266, 166, 1);
          bezierCurve(g2, 233, 175, 245, 165, 250, 170, 266, 166, 1);
          bezierCurve(g2, 233, 175, 245, 200, 220, 225, 240, 220, 1);
          bezierCurve(g2, 240, 220, 270, 222, 300, 250, 322, 245, 1);
          
          bezierCurve(g2, 266, 150, 260, 162, 270, 163, 278, 167, 1);
          bezierCurve(g2, 272, 181, 275, 178, 278, 172, 278, 167, 1);
          bezierCurve(g2, 252, 181, 262, 183, 265, 183, 272, 181, 1);
          bezierCurve(g2, 252, 181, 255, 190, 255, 200, 254, 211, 1);
          bezierCurve(g2, 254, 211, 275, 210, 285, 240, 310, 245, 1);
          buffer = floodFill(buffer, 250, 200, Color.WHITE, tone);


          //Skin && Shadow
          //ear shadow
          g2.setColor(new Color(225, 228, 221, 255));
          bezierCurve(g2, 100, 144, 150, 140, 150, 140, 180, 151, 1);
          buffer = floodFill(buffer, 130, 155, Color.WHITE, new Color(225, 228, 221, 255));

          //neck skin
          g2.setColor(new Color(246, 175, 100, 255));
          bezierCurve(g2, 133, 390, 140, 410, 130, 410, 115, 430, 1);
          buffer = floodFill(buffer, 115, 395, Color.WHITE, new Color(246, 175, 100, 255));

          //face skin
          //outer-left
          bezierCurve(g2, 213, 123, 235, 165, 170, 200, 212, 239, 1);
          bezierCurve(g2, 212, 239, 280, 270, 340, 270, 378, 245, 1);
          bezierCurve(g2, 388, 258, 430, 290, 430, 300, 415, 248, 1);
          //outer-right
          bezierCurve(g2, 470, 265, 480, 270, 450, 280, 462, 295, 1);
          bezierCurve(g2, 470, 300, 510, 280, 530, 305, 549, 293, 1);
          
          //inner-left
          bezierCurve(g2, 310, 126, 290, 150, 290, 170, 305, 188, 1);
          bezierCurve(g2, 338, 225, 430, 245, 380, 140, 393, 127, 1);

          //inner-right
          bezierCurve(g2, 440, 150, 455, 175, 430, 190, 447, 216, 1);
          bezierCurve(g2, 458, 245, 475, 250, 485, 240, 497, 228, 1);

          buffer = floodFill(buffer, 268, 192, Color.WHITE, skin);
          buffer = floodFill(buffer, 483, 261, Color.WHITE, skin);

          //chin shadow
          g2.setColor(new Color(230, 233, 236, 255));
          bezierCurve(g2, 517, 293, 515, 334, 504, 379, 479, 397, 1);
          bezierCurve(g2, 479, 397, 465, 360, 431, 400, 432, 391, 1);
          bezierCurve(g2, 432, 391, 422, 400, 392, 391, 388, 392, 1);
          bezierCurve(g2, 388, 392, 384, 379, 369, 377, 347, 389, 1);
          bezierCurve(g2, 347, 389, 323, 404, 256, 420, 134, 390, 1);
          buffer = floodFill(buffer, 450, 405, Color.WHITE, new Color(230, 233, 236, 255));

          //bg
          Random rd = new Random();
          buffer = floodFill(g2, buffer, rd.nextInt(599)+1, 1, Color.WHITE, true);

          g.drawImage(buffer, 0, 0, null);
     }

     // <<--------------------------------- D R A W I N G M E T H O D S --------------------------------------------->>

     public void bezierCurve(Graphics g2, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int size) {
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

               plot(g2, x, y, size);
          }
     }

     public void bresenhamLine(Graphics g2, int x1, int y1, int x2, int y2, int size) {
          int dx = Math.abs(x2 - x1);
          int dy = Math.abs(y2 - y1);
          int sx = (x1 < x2) ? 1 : -1;
          int sy = (y1 < y2) ? 1 : -1;
          boolean isSwap = false;
          int temp;

          if (dy > dx) {
               temp = dx;
               dx = dy;
               dy = temp;
               isSwap = true;
          }
          int D = 2 * dy - dx;
          int x = x1;
          int y = y1;
          for (int i = 1; i <= dx; i++) {
               plot(g2, x, y, size);
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
     
     //Overload
     public BufferedImage floodFill(Graphics g, BufferedImage m, int x, int y, Color targetColor, boolean RGB) {
          Graphics2D g2 = m.createGraphics();

          Queue<Point> q = new LinkedList<Point>();
          Color replacementColor;
          plot(g2, x, y, 1);
          q.add(new Point(x, y));

          while (!q.isEmpty()) {
               Point p = q.poll();
               replacementColor = fillRGB(g, p.x, p.y);
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


     public float sine_fun(float len, float fun, float p, float brightness){
          brightness = (1 - brightness) / 2;
          return 255* (float) ((Math.sin(len*fun + p)*brightness +1 -brightness)) ;
      }
  
      public Color fillRGB(Graphics g, int x, int y) {
          //setting RGB color.
          float fun = (x+2*y)/3;
          // an alternative color
       
          float a = (float) (1.0/50.0);
          float c = (float) 0.4;
  
          int red = (int) sine_fun(a,fun,0,c);
          int green = (int) sine_fun(a,fun,(float)(2*Math.PI/3),c);
          int blue = (int) sine_fun(a,fun,(float)(4*Math.PI/3),c);
          Color color = new Color(red,green,blue);
          
          return color;
      }
  

     public void plot(Graphics g2, int x, int y, int size) {
          g2.fillRect(x, y, size, size);
     }

     public void fill(Graphics g2, int[] x, int[] y, Color color) {
          g2.setColor(color);
          g2.fillPolygon(x, y, x.length);
          g2.setColor(Color.black);
     }
}