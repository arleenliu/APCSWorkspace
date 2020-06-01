// Programmed by Jannie Z, period 2

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Rainbow extends JPanel
	implements ActionListener
{
	private int time; //time to keep track of animation
	
  // Declare skyColor:
  //
	private final Color skyColor = new Color(153,200,255);
	private final Color red = Color.RED;
	private final Color orange = new Color(255, 128, 0);
	private final Color yellow = Color.YELLOW;
	private final Color green = new Color(0, 204, 102);
	private final Color blue = new Color(0, 128, 255);
	private final Color indigo = new Color(0, 0, 153);
	private final Color purple = new Color(102, 0, 204);
	
	


  public Rainbow()
  {
    setBackground(skyColor);
    
    time = 0;
    Timer clock = new Timer(30, this);
    clock.start();
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    
    int height = getHeight();

    // Declare and initialize local int variables xCenter, yCenter
    // that represent the center of the rainbow rings:
    // ________________________________________________
    
    
    int xCenter = width/2;
    int yCenter = height*3/4;
 
    // Declare and initialize the radius of the large semicircle:
    // ________________________________________________
    int largeRadius = width/4;

    g.setColor(red);

    // Draw the large semicircle:
    // g.fillArc( ______________ );
    g.fillArc(xCenter-largeRadius, yCenter-largeRadius, 2*largeRadius, 2*largeRadius, 0, 180);

    // Declare and initialize the radii of the small and medium
    // semicircles and draw them:
    int orangeRadius = largeRadius * 7/8;
    int yellowRadius = largeRadius * 6/8;
    int greenRadius = largeRadius * 5/8;
    int blueRadius = largeRadius * 4/8;
    int indigoRadius = largeRadius * 3/8;
    int purpleRadius = largeRadius * 2/8;
    int skyRadius = largeRadius * 1/8;

    // Calculate the radius of the innermost (sky-color) semicircle
    // so that the width of the middle (green) ring is the
    // arithmetic mean of the widths of the red and magenta rings:
    // ________________________________________________

    g.setColor(orange);
    g.fillArc(xCenter-orangeRadius, yCenter-orangeRadius, 2*orangeRadius, 2*orangeRadius, 0, 180);
    
    g.setColor(yellow);
    g.fillArc(xCenter-yellowRadius, yCenter-yellowRadius, 2*yellowRadius, 2*yellowRadius, 0, 180);
    
    g.setColor(green);
    g.fillArc(xCenter-greenRadius, yCenter-greenRadius, 2*greenRadius, 2*greenRadius, 0, 180);

    g.setColor(blue);
    g.fillArc(xCenter-blueRadius, yCenter-blueRadius, 2*blueRadius, 2*blueRadius, 0, 180);
    
    g.setColor(indigo);
    g.fillArc(xCenter-indigoRadius, yCenter-indigoRadius, 2*indigoRadius, 2*indigoRadius, 0, 180);
    
    g.setColor(purple);
    g.fillArc(xCenter-purpleRadius, yCenter-purpleRadius, 2*purpleRadius, 2*purpleRadius, 0, 180);
    
 // Draw the sky-color semicircle:
    g.setColor(skyColor);
    g.fillArc(xCenter-skyRadius, yCenter-skyRadius, 2*skyRadius, 2*skyRadius, 0, 180);
   
 
    
   for(int t = 0; t < 15; t++) {
    
	   int x = (int) (Math.random()*getWidth());
	   int y = (int) (Math.random()*getHeight());
	   int a = x - 10;
	   int b = y - 20;
	   //super.paintComponent(g);
   
	   g.setColor(Color.GRAY);
	   g.drawLine(x, y, a, b);

   }
    }
    

  public void actionPerformed(ActionEvent e)
  {
    time++;
    repaint();
  }

  
  
  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
