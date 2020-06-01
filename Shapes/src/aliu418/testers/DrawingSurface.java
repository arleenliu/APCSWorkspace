package aliu418.testers;

import aliu418.shapes.Circle;
import aliu418.shapes.Rectangle;
import aliu418.shapes.RegularPolygon;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	private Rectangle r;
	private Circle c;
	private RegularPolygon rp;
	private boolean isAcrossXAxis;
	private int counter;
	
	public DrawingSurface() {
		r = new Rectangle(250, 100, 100, 70);
		c = new Circle(100, 100, 50);
		isAcrossXAxis = false;
		rp = new RegularPolygon(300, 200, 20, 50);
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		counter = 0;
		
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background
		
		//r.draw(this);
		//c.draw(this);
		rp.draw(this);
		//rp.drawBoundingCircles(this);
		
		mouseDragged();
		
		//System.out.println("Rectangle perimeter: " + r.getPerimeter() + ", area = " + r.getArea());
		//System.out.println("Circle perimeter: " + c.getPerimeter() + ", area = " + c.getArea());
		
		if(keyPressed && key == ' ' && counter < 1) {
			isAcrossXAxis = !isAcrossXAxis;
			r.reflect(isAcrossXAxis);
			counter++;
		}
		
		//stroke(255);
		//text(r.getPerimeter()+"\n"+r.getArea(),(float)(r.getX() + r.getWidth()/2),(float)(r.getY() + r.getHeight()/2));
	}
	
	
	public void mousePressed() {
		if (mouseButton == LEFT) {
//			System.out.println("LeftDown");
//			l1 = new Line(mouseX,mouseY,mouseX,mouseY);
		} else if (mouseButton == RIGHT) {
//			System.out.println("RightDown");
//			l2 = new Line(mouseX,mouseY,mouseX,mouseY);
		}
	}
	
	public void mouseClicked() {
		if (mouseButton == LEFT) {
			c.translate(mouseX - c.getX(), mouseY - c.getY());
		}
		
		if (mouseButton == RIGHT) {
			r.translate(mouseX - r.getX(), mouseY - r.getY());
		}
	}
	
	public void mouseDragged() {
		if (mouseButton == LEFT) {
		} else if (mouseButton == RIGHT) {
//			System.out.println("RightDrag " + mouseX + " " + mouseY);
//			l2.setPoint2(mouseX,mouseY);
		}
	}
	
	
}










