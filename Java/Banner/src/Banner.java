// This applet displays a message moving horizontally
// across the screen.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Banner extends JApplet
  implements ActionListener
{
  private int xPos, yPos;  // hold the coordinates of the banner

  public void init()
  {
    Container c = getContentPane();
    c.setBackground(Color.WHITE);
    xPos = c.getWidth();
    yPos = c.getHeight() / 2;
    Timer clock = new Timer(10, this);  // fires every 30 milliseconds 
    clock.start();

  }

  // Called automatically after a repaint request
  public void paint(Graphics g)
  {
    super.paint(g);
    //g.drawString("Hello, World!", xPos, yPos); 
    g.setColor(Color.CYAN);
    g.fillRect(xPos, yPos, 10, 10);
  }

  // Called automatically when the timer fires
  public void actionPerformed(ActionEvent e)
  {
    Container c = getContentPane();

    // Adjust the horizontal position of the banner:
    xPos++;
    if (xPos > 240)
    {
    	//xPos = c.getWidth();
    	xPos = c.getWidth()/40;
    }

    // Set the vertical position of the banner:
    yPos = c.getHeight()/2 +(int)(40*Math.sin(xPos/20.0));

    repaint();
  }
}


