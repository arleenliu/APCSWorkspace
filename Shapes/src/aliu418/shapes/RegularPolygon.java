package aliu418.shapes;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PShape;

public class RegularPolygon extends Shape {

	private int numSides; // # of sides
	private double sideLength; // length of side
	private Circle outCircle; // the circumscribed Circle
	private Circle inCircle; // the inscribed Circle
	private ArrayList<Line> sides; // array of Line objects for each side
	private double angle;
	private PShape s;

	// constructors
	/**
	 * 
	 * Creates a new instance of the RegularPolygon class that is a triangle with
	 * center at (0, 0) and a side length of 100 pixels.
	 * 
	 * @pre The default sets the polygon to have no fill and a black border of width
	 *      1.
	 * 
	 */
	public RegularPolygon() {
		super(0, 0, new Color(0, 0, 0), null, 1);
		numSides = 3;
		sideLength = 100;
		outCircle = new Circle();
		inCircle = new Circle();
		calcr();
		calcR();
		sides = new ArrayList<>();

	}

	/**
	 * 
	 * Creates a new instance of the RegularPolygon class with a specified number of
	 * sides, specified side length, and center coordinates at (x, y).
	 * 
	 * @param x
	 *            The x-coordinate of the center of the RegularPolygon.
	 * @param y
	 *            The y-coordinate of the center of the RegularPolygon.
	 * @param numSides
	 *            The number of sides the RegularPolygon object has.
	 * @param sideLength
	 *            The pixel length of each side.
	 * 
	 * @pre The default sets the polygon to have no fill and a black border of width
	 *      1.
	 */
	public RegularPolygon(double x, double y, int numSides, double sideLength) {
		super(x, y, new Color(0, 0, 0), null, 1);
		this.numSides = numSides;
		this.sideLength = sideLength;
		outCircle = new Circle(x, y, 0);
		inCircle = new Circle(x, y, 0);
		angle = Math.PI * (numSides - 2.0) / numSides;
		calcr();
		calcR();
		sides = new ArrayList<>();

		double prevX = x;
		double prevY = y - outCircle.getRadius();
		for (int i = 0; i < numSides; i++) {
			Line l = new Line(prevX, prevY, Math.PI + Math.PI - ((Math.PI + angle) / 2) + i * (2 * Math.PI / numSides),
					sideLength, 1);
			sides.add(l);
			prevX = l.getX2();
			prevY = l.getY2();
		}
		System.out.println(sides.size());

	}

	// private methods
	private void calcr() {
		inCircle.setRadius(Math.tan(angle / 2) * (sideLength / 2));
	}

	private void calcR() {
		outCircle.setRadius((sideLength / 2) / (Math.cos(angle / 2)));
	}

	// public methods
	
	/**
	 * 
	 * Calculates and returns the measure of an interior angle of the polygon, in radians.
	 * 
	 * @return The radian measure of the interior angle of the polygon.
	 */
	public double calcVertexAngle() {
		angle = Math.PI * (sideLength - 2.0) / sideLength;
		return angle;
	}

	public double getPerimeter() {
		return numSides * sideLength;
	}

	public double getArea() {
		return 0.5 * inCircle.getRadius() * numSides * sideLength;
	}

	/**
	 * 
	 * Returns the number of sides the polygon has.
	 * 
	 * @return The number of sides the polygon has.
	 */
	public int getNumSides() {
		return numSides;
	}

	/**
	 * 
	 * Returns the pixel length of one side of the polygon.
	 * 
	 * @return The pixel length of one side of the polygon.
	 */
	public double getSideLength() {
		return sideLength;
	}
	
	/**
	 * 
	 * Returns the value of the radius of the circle circumscribing the polygon.
	 * 
	 * @return The value of the radius of the circle circumscribing the polygon.
	 */
	public double getR() {
		return outCircle.getRadius();
	}

	/**
	 * 
	 * Returns the value of the radius of the circle inscribed in the polygon.
	 * 
	 * @return The value of the radius of the circle inscribed in the polygon.
	 */
	public double getr() {
		return inCircle.getRadius();
	}

	public void draw(PApplet marker) {
		super.draw(marker);
		s = marker.createShape();
		s.beginShape();
		s.stroke(0);

		for (int i = 0; i < numSides; i++) {
			s.vertex((float) sides.get(i).getX(), (float) sides.get(i).getY());
		}

		s.endShape(PApplet.CLOSE);
		marker.shape(s, 0, 0);
	}
	
	/**
	 * 
	 * Draws both the circle circumscribing and the circle inscribed by the polygon.
	 * 
	 * @param marker The PApplet instance that draws the circles onto the screen.
	 */
	public void drawBoundingCircles(PApplet marker) {
		super.draw(marker);
		marker.ellipse((float) inCircle.getX(), (float) inCircle.getY(), 2 * (float) inCircle.getRadius(),
				2 * (float) inCircle.getRadius());
		marker.ellipse((float) outCircle.getX(), (float) outCircle.getY(), 2 * (float) outCircle.getRadius(),
				2 * (float) outCircle.getRadius());
	}

	/**
	 * 
	 * Non-operational method.
	 * 
	 */
	@Override
	public boolean isPointInside(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

}
