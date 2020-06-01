package aliu418.shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * 
 * @author aliu418
 * @version 1.0
 *
 */
public class Circle extends Shape {

	private double originalX, originalY;
	private double radius;

	/**
	 * 
	 * Creates a new instance of the Circle object with center set to 0, 0, no fill,
	 * and a black line with a width of 1.
	 * 
	 */
	public Circle() {
		super(0, 0, new Color(0, 0, 0), null, 1);
		originalX = 0;
		originalY = 0;
		radius = 0;
	}

	/**
	 * Creates a new instance of a Circle object with the center at x, y with a
	 * radius radius
	 * 
	 * @param x
	 *            The x-coordinate of the center of the circle.
	 * @param y
	 *            The y-coordinate of the center of the circle.
	 * @param r
	 *            The pixel length of the radius of the circle.
	 */
	public Circle(double x, double y, double r) {
		super(x, y, new Color(0, 0, 0), null, 1);
		originalX = x;
		originalY = y;
		radius = r;
	}

	/**
	 * 
	 * Calculates and returns the circumference of the circle.
	 * 
	 * @return The measure of the circumference of the circle.
	 */
	// Calculates and returns the perimeter of the circle
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	/**
	 * 
	 * Calculates and returns the area of the circle.
	 * 
	 * @return The measure of the area of the circle.
	 */
	// Calculates and returns the area of the circle
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	public boolean isPointInside(double x, double y) {
		double distance = Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
		if (distance <= radius) {
			return true;
		} else {
			return false;
		}
	}

	// Draws a new instance of a Circle object with the center at x, y, with a width
	// and height of twice the radius.
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.ellipse((float) x, (float) y, (float) radius * 2, (float) radius * 2);
	}

	/**
	 * 
	 * Reflects the circle back and forth across a horizontal or vertical tangent
	 * depending on the condition of the parameter.
	 * 
	 * @param isAcrossXAxis
	 *            The boolean indicator of which line the circle is reflected
	 *            across.
	 */
	public void reflect(boolean isAcrossXAxis) {
		if (isAcrossXAxis) {
			if (y >= originalY) {
				y = y - 2 * radius;
			} else {
				y = y + 2 * radius;
			}
		} else {
			if (x >= originalX) {
				x = x + 2 * radius;
			} else {
				x = x - 2 * radius;
			}
		}
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

}
