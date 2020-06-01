package aliu418.shapesdemo;

import muzaffar.shapes.Line;
import muzaffar.shapes.Shape;
import processing.core.PApplet;

public class PhysicsShape {

	private Shape boundingShape;
	
	private double vx, vy;
	
	public static final double GRAVITY = 0.5;
	
	public PhysicsShape(Shape s) {
		vx = 0;
		vy = 0;
		boundingShape = s;
	}
	
	public void draw(PApplet drawer)
	{
		boundingShape.draw(drawer);
	}
	
	public Shape getBoundingShape() {
		return boundingShape;
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void act() {
		boundingShape.moveBy(vx, vy);
	}
	
	public double getXVelocity() {
		return vx;
	} 
	
	public double getYVelocity() {
		return vy;
	}
	
	public double getX() {
		return boundingShape.getX();
	}
	
	public double getY() {
		return boundingShape.getY();
	}
	
	public void moveTo(double x, double y) {
		boundingShape.moveTo(x, y);
	}
	
	public void moveTo2(double x, double y) {
		Line l1 = (Line) boundingShape;
		l1.setPoint2((int) x, (int) y); 
	}
	
//	public boolean checkPointOnLine(double x, double y) {
//		Line l1 = (Line) boundingShape;
//		l1.
//	}
	
	public void setX(double x) {
		boundingShape.setX(x);
	}
	
	public void setY(double y) {
		boundingShape.setY(y);
	}
	
	public boolean isPointInside(double x, double y) {
		return boundingShape.isPointInside(x, y);
	}
}
