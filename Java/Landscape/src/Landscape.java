import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;

import javax.swing.*;
//branch off classes
//-- character
//-- main method
//-- extend JFrame
//-- MovingImage (tree, house, sun)

/**
   TODO Write a one-sentence summary of your class here.
   TODO Follow it with additional details about its purpose, what abstraction
   it represents, and how to use it.
   
   This program is a virtual landscape set in Sunnyvale, CA. The 1, 2, and 3 keys are 
   used to toggle a sun, tree, and house respectively between a graphics picture and an image of the object
   The arrow keys can be used to move the character on the screen, and left-clicking on the the character 
   will move it back to its original position at (0, 310). Left-clicking on the sun will cause the word "Hello!"
   to be displayed over the sun, and clicking outside the sun will make it disappear.

   @author  TODO Jannie Zhong
   @version TODO 4/19/17

   Period - TODO Period 2
   Assignment - TODO Landscape

   Sources - TODO list collaborators
 */
public class Landscape extends JPanel implements KeyListener, MouseListener
{
	// TODO Your Instance Variables Here
	private Image tree, sun, person, house;
	private boolean drawSunAsImage, drawTreeAsImage, drawHouseAsImage, drawSky, drawString;
	private int personX, personY;

	//private MovingImage house, tree, sun, person;
	
	public Landscape () {
		super();

		setBackground(Color.WHITE);
		// TODO Add more customizations to the panel
		tree = (new ImageIcon("treeImg.png")).getImage();
		sun = (new ImageIcon("sunImg.png")).getImage();
		house = (new ImageIcon("houseImg.png")).getImage();
		person = (new ImageIcon("personImg.png")).getImage();

		drawSunAsImage = false;
		drawTreeAsImage = false;
		//drawHouseAsImage = false;
		drawSky = true;
		drawString = false;
		
		personX = 0;
		personY = 300;
		

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

		int width = getWidth();
		int height = getHeight();

		double xRatio = width/800.0;
		double yRatio = height/600.0;

		Graphics2D g2 = (Graphics2D)g;

		g2.scale(xRatio, yRatio);


		//the text

		if (drawSky){
			Color c3 = new Color(135, 204, 255);
			setBackground(c3);
		} else {
			setBackground(Color.WHITE);
		}
		
		Color c1 = new Color(125, 0, 125);
		g.setColor(c1);
		Font f1 = new Font ("Serif", Font.BOLD | Font.ITALIC, 40);
		g.setFont(f1);
		g.drawString("Sunnyvale, CA: A Scenic Landscape", 100, 525);

		//the ground
		g.setColor(Color.GREEN);
		g.drawLine(0, 450, 800, 450);


		if (drawSunAsImage){
			g.drawImage(sun, 600, 75, 100, 100, this);

		} else{
			g.setColor(Color.ORANGE);
			g.drawOval(600, 75, 100, 100);
		}

		if (drawTreeAsImage){
			g.drawImage(tree, 200, 300, 200, 150, this);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(200, 300, 50, 150);

			g.setColor(Color.GREEN);
			g.fillOval(150, 200, 150, 110);
		}

		if (drawHouseAsImage){
			g.drawImage(house, 550, 300, 200, 200, this);
		} else {
			g.setColor(c1);
			g.fillRect(550, 300, 150, 150);


			g.setColor(Color.BLUE);
			Polygon roof = new Polygon();
			roof.addPoint(550, 300);
			roof.addPoint(620, 250);
			roof.addPoint(700, 300);
			g.fillPolygon(roof);
		}
		g.drawImage(person, personX, personY, 125, 190, this);
		
		
		
		if (drawString){
			String hello = new String ("Hello!");
			g.drawString(hello, 600, 75);
		} else {
			
		}
		
		/*
    //the tree

    g.setColor(Color.BLACK);
    g.fillRect(200, 300, 50, 150);

    g.setColor(Color.GREEN);
    g.fillOval(150, 200, 150, 110);
		 */

		/*
    //the sun
    g.setColor(Color.ORANGE);
    g.drawOval(600, 75, 100, 100);
		 */

		/*
    //the house
    g.setColor(c1);
    g.fillRect(550, 300, 150, 150);


    g.setColor(Color.BLUE);
    Polygon roof = new Polygon();
    roof.addPoint(550, 300);
    roof.addPoint(620, 250);
    roof.addPoint(700, 300);
    g.fillPolygon(roof);

		 */
		// TODO Add any custom drawings here


	}


	// As your program grows, you may want to...
	//   1) Move this main method into its own 'main' class
	//   2) Customize the JFrame by writing a class that extends it, then creating that type of object in your main method instead.
	//   3) Rename this class (SimpleWindow is not a good name - this class actually represents the *Panel*, not the window)
	public static void main(String[] args)
	{
		JFrame w = new JFrame("Simple Window");
		w.setBounds(100, 100, 800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Landscape panel = new Landscape();
		w.add(panel);
		w.setResizable(true);
		w.setVisible(true);
		w.addKeyListener(panel);
		panel.addMouseListener(panel);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		///System.out.println("TEST!");

		int code = e.getKeyCode();
		if (code == KeyEvent.VK_1){
			drawSunAsImage = !drawSunAsImage;
		} else if (code == KeyEvent.VK_2){
			drawTreeAsImage = !drawTreeAsImage;
		} else if (code == KeyEvent.VK_3){
			drawHouseAsImage = !drawHouseAsImage;

		} else if (code == KeyEvent.VK_4) {
			drawSky = !drawSky;
		} else if (code == KeyEvent.VK_LEFT){
			if(personX <=0){
			} else{
				personX = personX - 5;
			}
		} else if (code == KeyEvent.VK_RIGHT){
			
			if (personX >= 675){
				
			} else {
				personX = personX + 5;
			}
		} else if (code == KeyEvent.VK_UP){
			if (personY <= 0){
				
			} else {
				personY -= 5;
			}
		} else if (code == KeyEvent.VK_DOWN){
			if (personY >= 410){
				
			} else {
				personY += 5;
			}
		}
		
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX() * 800/this.getWidth();
		int y = e.getY() * 600/this.getHeight();
		
		if (x >= personX && x <= (personX + 125) && y >= personY && y <= personY + 190){
			System.out.println("TEST!");
			personX = 0;
			personY = 310;
			
		}

		double distance = Math.sqrt((x-650.0)*(x-650.0) + (y-125.0)*(y-125.0));
		System.out.println("x="+x+", y="+y+", distance="+distance);
		//System.out.println(y);
		//System.out.println(distance);

		
		
		if (distance <= 50){
			System.out.println("TEST!");
			drawString = true;
		} else{
			System.out.println("OUTSIDE");

			drawString = false;
		}
			
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
