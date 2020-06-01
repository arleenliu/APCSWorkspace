package muzaffar.shapesdemo;



import aliu418.shapes.Circle;
import aliu418.shapes.Line;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	PhysicsShape c;
	Line l1,l2,l3,l4;
	
	public DrawingSurface() {
		c = new PhysicsShape(new Circle(200,150,10));
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {

	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		
		c.draw(this);
		c.checkBounds(width, height, 0, 0);
		
	}
	
	public void mousePressed() {
		if (mouseButton == LEFT)
			c.changeVelocityBy((mouseX - c.getX())/50,(mouseY - c.getY())/50);
		else 
			c.changeVelocityBy((mouseX - c.getX())/(0-50),(mouseY - c.getY())/(0-50));
		
	}
	
	public void mouseReleased() {
		
	}
	
	
	public void mouseDragged() {
		
	}
	
	public void keyPressed() {
		if (keyCode == 32)
			c.setVelocity(0, 0);
	}
	
	
}