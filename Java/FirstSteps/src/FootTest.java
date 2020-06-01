import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class FootTest extends JPanel
{
  private Image shoe;

  // Constructor
  public FootTest()
  {
    shoe = (new ImageIcon("leftshoe.gif")).getImage();
  }

  // Called automatically when the panel needs repainting
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    int x = 300;
    int y = 100;
    int stepLength = 100;

    Foot leftFoot = new Foot(x, y, shoe);
/*
    leftFoot.turn(270);
    for (int count = 1; count <= 4; count++)
    {
    leftFoot.draw(g);
    leftFoot.moveSideways(stepLength);
    }
*/
    for (int count = 1; count <= 4; count++)
    {
    leftFoot.draw(g);
    leftFoot.turn(90);
    leftFoot.moveSideways(-stepLength/2);
    leftFoot.moveForward(stepLength/2);
    }
    
    // Draw a cursor at the expected center of the first "shoe":
    g.drawLine(x - 50, y, x + 50, y);
    g.drawLine(x, y - 50, x, y + 50);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Feet");
    window.setBounds(100, 100, 500, 480);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    FootTest panel = new FootTest();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);

    window.setVisible(true);
  }
}