package aliu418.shapesdemo;

import java.awt.Color;

import muzaffar.shapes.Circle;
import muzaffar.shapes.Line;
import muzaffar.shapes.Rectangle;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {

	private PhysicsShape shape1;
	private PhysicsShape shape2;
	private PhysicsShape shape3;
	private double vx, vy;
	private boolean isIntersecting;

	public DrawingSurface() {
		shape1 = new PhysicsShape(new Circle(26, 100.0, 50.0, 50.0, Color.RED, Color.BLACK, 1));
		shape2 = new PhysicsShape(new Line(100, 500, 150, 500, Color.BLACK, 10));
		shape3 = new PhysicsShape(new Rectangle(100.0, 100.0, 50.0, 50.0, null, Color.BLACK, 1));
		vx = Math.random() * 5 * PhysicsShape.GRAVITY + 2;
		vy =  0;
		isIntersecting = false;
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		// background(255);
	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		background(255); // Clear the screen with a white background

		shape1.draw(this);
		shape2.draw(this);
		shape3.draw(this);
		
		shape2.moveTo(mouseX, 500);
		shape2.moveTo2(mouseX + 50, 500);
				
		if (shape1.getY() + 25 >= 500 && shape1.getY() + 25 <= 525 && shape1.getX() - 25 < mouseX + 50 && shape1.getX() + 25 > mouseX && isIntersecting == false) {
			// shape1.moveTo(shape1.getX(), 500 - 25);
			vy = -vy;
			// shape1.setVelocity(vx, vy);
			// System.out.println(vy);
			isIntersecting = !isIntersecting;
		} else  {
			vy = vy + 0.4;
			if(shape1.getY() < 500 - 200) {
				isIntersecting = false;
			}
		} 
	
		if(shape1.getX() + 25 >= width) {
			vx = -vx;
		} else if(shape1.getX() - 25 <= 0) {
			vx = -vx;
		}
		
		if(shape1.getY() - 25 >= height) {
			shape1.moveTo(26, 100);
			vy = 0;
			//shape1.setVelocity(vx, vy);
		}
		
		if (shape3.isPointInside(shape1.getX(), shape2.getY()) || 
			shape3.isPointInside(shape1.getX(), shape1.getY() + 25) || 
			shape3.isPointInside(shape1.getX() + 25, shape1.getY()) || 
			shape3.isPointInside(shape1.getX(), shape1.getY() - 25) || 
			shape3.isPointInside(shape1.getX() - 25, shape1.getY())) {
			shape3.setX(600 * Math.random() + 100);
			shape3.setY(400 * Math.random() + 100);
			System.out.println("inside rectangle!");
		}
		
		//System.out.println(vy);
		shape1.setVelocity(vx, vy);
		shape1.act();
		
	}

	public void mousePressed() {

	}

	public void mouseClicked() {

	}

	public void mouseDragged() {
		
	}

}
