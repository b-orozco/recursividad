import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sierpinsky extends JPanel {

    
  int nivel;

  
  public Sierpinsky(int n) {
      nivel = n;
      setPreferredSize(new Dimension(800, 800));
  }

  
  public void paintComponent(Graphics g) {
      Graphics2D g2d = (Graphics2D) g;
      Dimension tam = getSize();
      g2d.setColor(Color.BLACK);
      g2d.fill(new Rectangle(0, 0, tam.width, tam.height));
      g2d.setColor(Color.BLUE);

      int x1, y1, x2, y2, x3, y3;
      
      x1 = 700;
      y1 = 700;

      x2 = 30;
      y2 = 700;

      x3 = 365;
      y3 = 120;

      trazaTriangulo(g2d,
              new Point(x1, y1), new Point(x2, y2), new Point(x3, y3),
              nivel);
  }

 
  public static void trazaTriangulo(Graphics2D objGrafico,
          Point p1,
          Point p2,
          Point p3,
          int i) {
      
      
      int dx1 = (p2.x + p1.x) / 2;
      int dy1 = (p2.y + p1.y) / 2;

      int dx2 = (p3.x + p2.x) / 2;
      int dy2 = (p3.y + p2.y) / 2;

      int dx3 = (p1.x + p3.x) / 2;
      int dy3 = (p1.y + p3.y) / 2;

      
      if (i <= 0) {

          objGrafico.drawLine(p1.x, p1.y, p2.x, p2.y);
          objGrafico.drawLine(p2.x, p2.y, p3.x, p3.y);
          objGrafico.drawLine(p3.x, p3.y, p1.x, p1.y);
          
      } else {

          
          trazaTriangulo(objGrafico, new Point((p1.x), (p1.y)),
                  new Point(dx1, dy1),
                  new Point(dx3, dy3),
                  i - 1);

          trazaTriangulo(objGrafico, new Point((p2.x), (p2.y)),
                  new Point(dx2, dy2),
                  new Point(dx1, dy1),
                  i - 1);

          trazaTriangulo(objGrafico, new Point((p3.x), (p3.y)),
                  new Point(dx3, dy3),
                  new Point(dx2, dy2),
                  i - 1);

      }

  }

 
  public static void uso() {
      System.err.println("Programa para trazar ...");
      System.err.println("Uso: java XYZ <nivel>");
      System.err.println("nivel es un entero no negativo,");
      System.err.println("indica el nivel de construccion.");
  }

  
  public static void main(String[] args) {
      if (args.length == 1) {
          try {
              int niv = Integer.parseInt(args[0]);
              JFrame frame = new JFrame("Sierpinsky");
              frame.getContentPane().add(new Sierpinsky(niv), BorderLayout.CENTER);
              frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              frame.pack();
              frame.setVisible(true);
          } catch (NumberFormatException nfe) {
              uso();
          }
      } else {
          uso();
      }
  }    
} 

