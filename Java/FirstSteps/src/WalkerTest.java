import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class WalkerTest extends JPanel
{
  private Image leftShoe, rightShoe;

  // Constructor
  public WalkerTest()
  {
    leftShoe = (new ImageIcon("leftshoe.gif")).getImage();
    rightShoe = (new ImageIcon("rightshoe.gif")).getImage();
  }

  // Called automatically when the panel needs repainting
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int x = 300;
    int y = 100;
    int stepLength = 100;

    //Create a walker object using the constructor
    Walker walkerA = new Walker(x, y, leftShoe, rightShoe);
    
    //Call methods on the object to put the walker in the correct configuration
    walkerA.draw(g);
    walkerA.firstStep();
    walkerA.nextStep();
    walkerA.stop();
 
    walkerA.draw(g);
    walkerA.firstStep();
    walkerA.nextStep();
    walkerA.stop();
    
    walkerA.firstStep();
    walkerA.nextStep();
    walkerA.stop();
    
    
    walkerA.draw(g);
    walkerA.firstStep();
    walkerA.nextStep();
    walkerA.stop();
  
    
    
/*    for(int count = 1; count <= 4; count++) {
    walkerA.draw(g);
    walkerA.firstStep();
    walkerA.nextStep();
    walkerA.stop();
  }
  */
    // Draw a cursor at the expected center of the first "shoe":
    g.drawLine(x - 50, y, x + 50, y);
    g.drawLine(x, y - 50, x, y + 50);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Feet");
    window.setBounds(100, 100, 500, 480);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    WalkerTest panel = new WalkerTest();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
  }
}