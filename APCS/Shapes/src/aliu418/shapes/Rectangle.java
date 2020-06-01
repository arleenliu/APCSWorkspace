package aliu418.shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * 
 * @author aliu418
 * @version 1.0
 *
 */
public class Rectangle extends Shape {

	private double originalX, originalY;
	private double width, height;
	// Creates a default instance of a Rectangle object with all dimensions
	// set to zero.

	/**
	 * 
	 * Creates a new instance of the Rectangle object with upper left corner set to
	 * 0, 0, no fill, and a black line with a width of 1.
	 * 
	 */
	public Rectangle() {
		super(0, 0, new Color(0, 0, 0), null, 1);
		originalX = 0;
		originalY = 0;
		width = 0;
		height = 0;
	}

	/**
	 * Creates a new instance of a Rectangle object with the left and right edges of
	 * the rectangle at x and x + width. The top and bottom edges are at y and y +
	 * height.
	 * 
	 * @param x
	 *            The x-coordinate of the upper left corner.
	 * @param y
	 *            The y-coordinate of the upper left corner.
	 * @param width
	 *            The pixel width of the Rect.
	 * @param height
	 *            The pixel height of the Rect.
	 */
	// Creates a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public Rectangle(double x, double y, double width, double height) {
		super(x, y, new Color(0, 0, 0), null, 1);
		this.width = width;
		this.height = height;
		originalX = x;
		originalY = y;
	}

	public double getPerimeter() {
		return 2 * width + 2 * height;
	}

	public double getArea() {
		return width * height;
	}

	// Determines whether the point x,y is contained inside this rectangle
	public boolean isPointInside(double x, double y) {
		if (x >= this.x && x <= x + width && y >= this.y && y <= y + height) {
			return true;
		} else {
			return false;
		}
	}

	// Draws a new instance of a Rectangle object with the left and right
	// edges of the rectangle at x and x + width. The top and bottom edges
	// are at y and y + height.
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.rect((float) x, (float) y, (float) width, (float) height);
	}

	/**
	 * 
	 * Reflects the rectangle back and forth across its horizontal or vertical edge
	 * depending on the condition of the parameter.
	 * 
	 * @param isAcrossXAxis
	 *            The boolean indicator of which edge the rectangle is reflected
	 *            across.
	 */
	public void reflect(boolean isAcrossXAxis) {
		if (isAcrossXAxis) {
			if (y >= originalY) {
				y = y - height;
			} else {
				y = y + height;
			}
		} else {
			if (x >= originalX) {
				x = x + width;
			} else {
				x = x - width;
			}
		}
	}

	/**
	 * 
	 * Sets the upper left x-coordinate to a specified value.
	 * 
	 * @param x
	 *            The new x-coordinate of the upper left corner of the rectangle.
	 */

	/**
	 * 
	 * Returns the current width of the rectangle.
	 * 
	 * @return The current width of the rectangle.
	 */
	public double getWidth() {
		return width;

	}

	/**
	 * 
	 * Returns the current height of the rectangle.
	 * 
	 * @return The current height of the rectangle.
	 */
	public double getHeight() {
		return height;
	}

}
