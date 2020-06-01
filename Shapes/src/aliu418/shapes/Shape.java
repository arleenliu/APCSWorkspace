package aliu418.shapes;

import java.awt.Color;

import processing.core.PApplet;

/**
 * 
 * @author aliu418
 *
 */
public abstract class Shape {

	/**
	 * Holds the x coordinate of a Shape object.
	 */
	protected double x;

	/**
	 * Holds the y-coordinate of a Shape object.
	 */
	protected double y;

	private Color strokeColor, fillColor;
	private int strokeWidth;

	/**
	 * 
	 * Creates new instance with coordinates at x, y and sets values for
	 * stroke and fill.
	 * 
	 * @param x
	 *            The x-coordinate of the Shape object.
	 * @param y
	 *            The y-coordinate of the Shape object.
	 * @param strokeColor The color of the lines outlining the shape.
	 * @param fillColor The color of the inside of the shape.
	 * @param strokeWidth The width of the lines outlining the shape.
	 */
	public Shape(double x, double y, Color strokeColor, Color fillColor, int strokeWidth) {
		this.x = x;
		this.y = y;
		this.strokeColor = strokeColor;
		this.fillColor = fillColor;
		this.strokeWidth = strokeWidth;
	}

	/**
	 * 
	 * Draws a shape object on the screen with a specified stroke color, stroke
	 * width, and fill color.
	 * 
	 * @pre Any fill or stroke modifications will not affect the drawing.
	 * @pre Setting the fill color to null with result in no fill for the shape.
	 * @param drawer
	 *            The PApplet instance used to draw the object on the screen.
	 * @post stroke, fill and strokeWeight properties of the drawer object will be
	 *       set to however the shape turns out.
	 */
	public void draw(PApplet drawer) {
		drawer.stroke(strokeColor.getRGB());
		
		if(fillColor != null) {
			drawer.fill(fillColor.getRGB());
		} else {
			drawer.noFill();
		}
		
		drawer.strokeWeight(strokeWidth);
	}

	/**
	 * Calculates and returns the area of the shape.
	 * 
	 * @return The area of the shape.
	 */
	// Calculates and returns the area of the rectangle
	public abstract double getArea();

	/**
	 * Calculates and returns the perimeter of the Shape object.
	 * 
	 * @return The perimeter of the shape.
	 */
	public abstract double getPerimeter();

	/**
	 * 
	 * Moves the shape a certain horizontal and vertical distance.
	 * 
	 * @param x
	 *            The horizontal distance that the shape moves.
	 * @param y
	 *            The vertical distance that the shape moves.
	 */
	public void translate(double x, double y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * Determines whether the point x,y is contained inside this shape.
	 * 
	 * @param x
	 *            The x-coordinate of the tested point.
	 * @param y
	 *            The y-coordinate of the tested point.
	 * @return A boolean signifying whether the tested point is inside the shape or
	 *         not.
	 */
	public abstract boolean isPointInside(double x, double y);

	/**
	 * 
	 * Sets the x- and y-coordinates to a new specified x and y value.
	 * 
	 * @param x
	 *            The new x-coordinate of the shape.
	 * @param y
	 *            The new y-coordinate of the shape.
	 */
	public void move(double x, double y) {
		this.x = x;
		this.y = y;

	}

	/**
	 * 
	 * Returns the value of the current x-coordinate.
	 * 
	 * @return The current value of the x-coordinate.
	 */
	public double getX() {
		return x;
	}

	/**
	 * 
	 * Returns the value of the currentu y-coordinate.
	 * 
	 * @return The current value of the y-coordinate.
	 */
	public double getY() {
		return y;
	}

	/**
	 * 
	 * Sets the stroke color to a specified color c.
	 * 
	 * @param c
	 *            The color to be set as the stroke color.
	 */
	public void setStrokeColor(Color c) {
		strokeColor = c;
	}

	/**
	 * 
	 * Sets the stroke width to a specified width.
	 * 
	 * @param width
	 *            The pixel width of the stroke (line).
	 */
	public void setStrokeWidth(int width) {
		strokeWidth = width;
	}

	/**
	 * 
	 * Sets the fill color to a specified color c.
	 * 
	 * @param c
	 *            The color to be set as the fill color.
	 */
	public void setFillColor(Color c) {
		fillColor = c;
	}
}
