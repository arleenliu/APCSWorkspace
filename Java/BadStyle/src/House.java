
import java.awt.*;
import javax.swing.*; 

//This class draws a house. Written by Jannie Z.

public class House extends JPanel
{ 
	//calls graphics component to draw house
	public void paintComponent(Graphics g)  
	{
		super.paintComponent(g);
		
		g.setColor(Color.GREEN);
		g.fillRect(120, 20, 17, 40); //draws green chimney
		
		g.setColor(Color.RED);
		g.fillRect(30, 40, 130, 45); //draws red rectangle for house  
		
		g.setColor(Color.BLUE);
		Polygon roof = new Polygon(); //draws shape of the roof
		roof.addPoint(30, 40);	      //}
		roof.addPoint(160, 40);       //} corners of roof
		roof.addPoint(95, 20);	      //}
		g.fillPolygon(roof);  //fills roof w/ the color blue
	}

	//creates background window
	public static void main(String[] args)
	{
		JFrame window = new JFrame("House"); 
		window.setBounds(300, 300, 200, 150);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		House panel = new House();                                        
		panel.setBackground(Color.WHITE);
		Container c = window.getContentPane();
		c.add(panel);
		
		window.setVisible(true);
	}
}


