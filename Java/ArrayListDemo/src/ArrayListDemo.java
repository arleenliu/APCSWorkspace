import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class ArrayListDemo extends JPanel implements MouseListener
{
  private ArrayList<Circle> circles;

  public ArrayListDemo () {
	  super();
	  circles = new ArrayList<Circle>();
	  addMouseListener(this);
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

    int width = getWidth();
    int height = getHeight();

	for(int i = 0; i < circles.size(); i++) {
		Circle aCircle = circles.get(i);
		aCircle.draw(g);
	}
  }
  
  public void mousePressed(MouseEvent e) {
  	if(e.getButton() == MouseEvent.BUTTON1) {
	  	int x = e.getX();
	  	int y = e.getY();
	  	int radius = (int)(20*Math.random())+5;
	  	Circle aCircle = new Circle(x,y,radius);
	  	circles.add(aCircle);
  	} else if(e.getButton() == MouseEvent.BUTTON3) {
  		int x = e.getX();
	  	int y = e.getY();
	  	for (int i = 0; i < circles.size(); i++) {
	  		Circle aCircle = circles.get(i);
	  		if (aCircle.isPointInCircle(x,y)) {
	  			circles.remove(i);
	  		}
	  	}
  	}
  	repaint();
  }
  
  public void mouseReleased(MouseEvent e) {
  }
  
  public void mouseClicked(MouseEvent e) {
  }
  
  public void mouseEntered(MouseEvent e) {
  }
  
  public void mouseExited(MouseEvent e) {
  }


  // As your program grows, you may want to...
  //   1) Move this main method into its own 'main' class
  //   2) Customize the JFrame by writing a class that extends it, then creating that type of object in your main method instead
  public static void main(String[] args)
  {
    JFrame w = new JFrame("ArrayList Demo");
    w.setBounds(100, 100, 640, 480);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ArrayListDemo panel = new ArrayListDemo();
    panel.setBackground(Color.WHITE);
    w.add(panel);
    w.setResizable(true);
    w.setVisible(true);
  }
}
