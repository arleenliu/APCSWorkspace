package muzaffar.shapesdemo;

import aliu418.shapes.Shape;
import processing.core.PApplet;

public class PhysicsShape {

	private Shape boundingShape;
	
	private double vx, vy;

	int gravCount;
	
	public PhysicsShape(Shape boundingShape) {
		this.boundingShape = boundingShape;
		vx = 0;
		vy = 0;
		gravCount = 0;
	}
	
	public void draw(PApplet drawer) {

		gravCount++;
		this.changeVelocityBy(0, 0.1);
		if (vx > 0)
			this.changeVelocityBy(-0.02, 0);
		if (vx < 0)
			this.changeVelocityBy(0.02, 0);
		if (vy > 0)
			this.changeVelocityBy(0, -0.02);
		if (vy < 0)
			this.changeVelocityBy(0, 0.02);
		
		boundingShape.translate(vx, vy);
		
		boundingShape.draw(drawer);
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void changeVelocityBy(double vx, double vy) {
		this.vx += vx;
		this.vy += vy;
	}
	
	public void checkBounds(int maxX, int maxY, int minX, int minY) {
		if (boundingShape.getX()>maxX) {
			boundingShape.move(maxX, boundingShape.getY());
			vx = -vx;
		}
		if (boundingShape.getY()>maxY) {
			boundingShape.move(boundingShape.getX(), maxY);
			vy = -vy;
		}
		if (boundingShape.getX()<minX) {
			boundingShape.move(minX, boundingShape.getY());
			vx = -vx;
		}
		if (boundingShape.getY()<minY) {
			boundingShape.move(boundingShape.getX(), minY);
			vy = -vy;
		}
	}
	
	public void act() {
		boundingShape.translate(vx, vy);
	}
	
	public double getX() {
		return boundingShape.getX();
	}
	
	public double getY() {
		return boundingShape.getY();
	}
	

	
}
