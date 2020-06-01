/*
 * 
 * +: Good Job using Math.hypot... Didn't know that was a thing
 * 
 * -: Does your scale method work? Check DrawingSurface. What is the point of having a parameter, how are you going to use it?
 * 
 * Delta: Next Step: implement your Scale Method by calling it in DrawingSurface and maybe not using a parameter? Or at least not a double parameter? (Sorry i dont rlly get it)
 * 
 * 

 */
// for Point2D.Double
import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList; // for ArrayList

import aliu418.shapes.Shape;
import processing.core.PApplet; // for Processing

public class IrregularPolygon extends Shape {
	private ArrayList<Point2D.Double> myPolygon;

	// constructors
	public IrregularPolygon() {
		super(20, 10, new Color(0, 0, 0), new Color(0, 0, 0), 1);
		myPolygon = new ArrayList<>();
		myPolygon.add(new Point2D.Double(20, 10));
		myPolygon.add(new Point2D.Double(70, 20));
		myPolygon.add(new Point2D.Double(50, 50));
		myPolygon.add(new Point2D.Double(0, 40));

	}

	// public methods
	public void add(Point2D.Double aPoint) {
		myPolygon.add(aPoint);
	}
	
	public ArrayList<Point2D.Double> getPoints() {
		return myPolygon;
	}

	public void draw(PApplet marker) {
		super.draw(marker);
		marker.beginShape();
		for (int i = 0; i < myPolygon.size(); i++) {
			marker.vertex((float) myPolygon.get(i).getX(), (float) myPolygon.get(i).getY());
		}
		marker.endShape(marker.CLOSE);
		// marker.draw();
	}

	public double getPerimeter() {
		int sum = 0;
		
		for (int i = 0; i < myPolygon.size() - 1; i++) {
			double distance = Math.hypot(myPolygon.get(i).getX() - myPolygon.get(i + 1).getX(), myPolygon.get(i).getY() - myPolygon.get(i + 1).getY());
			sum += distance;
		}
		
		sum += Math.hypot(myPolygon.get(0).getX() - myPolygon.get(myPolygon.size() - 1).getX(), myPolygon.get(0).getY() - myPolygon.get(myPolygon.size() - 1).getY());
		
		return sum;
	}

	public double getArea() {
		double area1 = 0;
		double area2 = 0;
	
		for (int i = 0; i < myPolygon.size() - 1; i++) {
			double product = myPolygon.get(i).getX() * myPolygon.get(i + 1).getY();
			area1 += product;
		}
		
		double product = myPolygon.get(myPolygon.size() - 1).getX() * myPolygon.get(0).getY();
		area1 += product;
			
		for (int i = 0; i < myPolygon.size() - 1; i++) {
			double product2 = myPolygon.get(i).getY() * myPolygon.get(i + 1).getX();
			area2 -= product2;
		}
		
		double product2 = myPolygon.get(myPolygon.size() - 1).getY() * myPolygon.get(0).getX();
		area2 -= product;
		
		return 0.5 * Math.abs(area1 + area2);
	}

	@Override
	public boolean isPointInside(double x, double y) {
		
		// TODO Auto-generated method stub
		return false;
	}
	
	public void translate(int xDis, int yDis) {
		for (int i = 0; i < myPolygon.size(); i++) {
			myPolygon.get(i).setLocation(myPolygon.get(i).getX() + xDis, myPolygon.get(i).getY() + yDis);
		}
	}
	
	public void scale(double scale) {
		for (int i = 0; i < myPolygon.size(); i++) {
			myPolygon.get(i).setLocation(myPolygon.get(i).getX() * scale, myPolygon.get(i).getY() * scale);
		}
	}
	
	public void undo() {
		myPolygon.remove(myPolygon.size() - 1);
	}
}
