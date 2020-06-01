// Question 2-13-b

import java.awt.*;
import javax.swing.*;

/**
 *  This program displays a bullseye on a white
 *  background.
 */

public class Bullseye extends JPanel
{
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method
                              //   to paint the background
    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    
    g.setColor(Color.RED);
    g.fillOval(xCenter-50, yCenter-50, 100, 100);
    
    g.setColor(Color.WHITE);
    g.fillOval(xCenter-30, yCenter-30, 60, 60);
    
    g.setColor(Color.RED);
    g.fillOval(xCenter-10, yCenter-10, 20, 20);
  }

  public static void main(String[] args)
  {
    JFrame window = new JFrame("Bullseye");
    window.setBounds(300, 300, 200, 200);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Bullseye panel = new Bullseye();
    panel.setBackground(Color.WHITE);
    Container c = window.getContentPane();
    c.add(panel);
    window.setVisible(true);
  }
}

