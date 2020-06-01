package aliu418.shapes;

import java.awt.Color;

import processing.core.PApplet;

/*
 * Good:
 * implementing an Vertical & Horizontal intersect method
 * Console printing out the numbers for debugging
 * 
 * Bad:
 * Is the drawer really a part of line? Wouldn't it make more sense for it to be in the draw method? Move out the drawer to the draw method parameter
 * Maybe add some documentation so that everyone who reads the code will understand it by reading the comments? Add some comments on the methods
 */

/**
 * 
 * @author aliu418
 * @version 1.0
 *
 */
public class Line extends Shape {

	private double x2, y2;

	/**
	 * 
	 * Creates a new instance of the Line object with starting point set to 0, 0,
	 * and a black line with a width of 1.
	 * 
	 */
	public Line() {
		super(0, 0, new Color(0, 0, 0), null, 1);
		x2 = 0;
		y2 = 0;
	}

	/**
	 * 
	 * Creates a new instance of a Line object with a starting point at x1, y1, and
	 * ending point at x2, y2.
	 * 
	 * @param x1
	 *            The x-coordinate of the starting point of the line.
	 * @param y1
	 *            The y-coordinate of the starting point of the line.
	 * @param x2
	 *            The x-coordinate of the ending point of the line.
	 * @param y2
	 *            The y-coordinate of the ending point of the line.
	 */
	public Line(double x1, double y1, double x2, double y2) {
		super(x1, y1, new Color(0, 0, 0), null, 1);
		this.x2 = x2;
		this.y2 = y2;
	}

	/**
	 * 
	 * Creates a new instance of a Line object with a starting point at x1, y1,
	 * oriented at a specified angle and extends a specified length.
	 * 
	 * @param x1
	 *            The x-coordinate of the starting point of the line.
	 * @param y1
	 *            The y-coordinate of the starting point of the line.
	 * @param angle
	 *            The angle that the line is oriented at.
	 * @param length
	 *            The length that the line extends.
	 * @param x 
	 * 			  A dummy parameter indicating which constructor to use.  
	 */
	public Line(double x1, double y1, double angle, double length, int x) {
		super(x1, y1, new Color(0, 0, 0), null, 1);
		x2 = x1 + length * Math.cos(angle);
		y2 = y1 - length * Math.sin(angle);
	}

	public void draw(PApplet drawer) {
		super.draw(drawer);
		drawer.line((float) x, (float) y, (float) x2, (float) y2);
		// System.out.println("x1 = " + x1 + ", x2 = " + x2);

	}

	/**
	 * 
	 * Calculate and determines whether two Line objects intersects or not.
	 * 
	 * @param l2
	 *            The second Line object that the method checks the first Line
	 *            against for any intersection.
	 * @return A boolean signifying whether the two Line objects intersect or not.
	 */
	public boolean intersects(Line l2) {

		double moreX = Math.max(x, x2);
		double lessX = Math.min(x, x2);

		double moreY = Math.max(y, y2);
		double lessY = Math.min(y, y2);

		double moreX2 = Math.max(l2.x, l2.x2);
		double lessX2 = Math.min(l2.x, l2.x2);

		double moreY2 = Math.max(l2.y, l2.y2);
		double lessY2 = Math.min(l2.y, l2.y2);

		// System.out.println("MoreX = " + moreX + ", LessX = " + lessX);

		// System.out.println(crossX + ", " + crossY);

		// checks if they're not parallel
		if (Math.abs((x - x2) * (l2.y - l2.y2) - (y - y2) * (l2.x - l2.x2)) > 0.0001) {
			double crossX = ((x * y2 - y * x2) * (l2.x - l2.x2) - (x - x2) * (l2.x * l2.y2 - l2.y * l2.x2))
					/ ((x - x2) * (l2.y - l2.y2) - (y - y2) * (l2.x - l2.x2));
			double crossY = ((x * y2 - y * x2) * (l2.y - l2.y2) - (y - y2) * (l2.x * l2.y2 - l2.y * l2.x2))
					/ ((x - x2) * (l2.y - l2.y2) - (y - y2) * (l2.x - l2.x2));
			// checks if intersection point is in the segment
			if (crossX <= moreX && crossX <= moreX2 && crossX >= lessX && crossX >= lessX2 && crossY <= moreY
					&& crossY <= moreY2 && crossY >= lessY && crossY >= lessY2) {
				return true;
			} else {
				return false;
			}
		} else { // if parallel
			return false;
		}

		// if (x1 == x2 && l2.x1 <= x1 && l2.x2 >= x1) {
		// return true;
		// } else if (y1 == y2 && l2.y1 <= y1 && l2.y2 >= y1) {
		// return true;
		// } else if (l2.y1 == l2.y2 && l2.y1 >= y1 && l2.y1 <= y2) {
		// return true;
		// } else if (l2.x1 == l2.x2 && x1 <= l2.x1 && x2 >= l2.x1) {
		// return true;
		// } else if (x1 == x2 && x1 == l2.x1 && l2.x1 == l2.x2 ){
		// return true;
		// } else {
		// return false;
		// }

	}

	/**
	 * 
	 * Sets the end point of the Line object to a new point x, y
	 * 
	 * @param x
	 *            The x-coordinate of the new end point of the Line object.
	 * @param y
	 *            The y-coordinate of the new end point of the Line object.
	 */
	public void setPoint2(int x, int y) {
		x2 = x;
		y2 = y;
	}

	/**
	 * 
	 * Returns the x-coordinate of the ending point of the Line object.
	 * 
	 * @return The x-coordinate of the ending point of the Line object.
	 */
	public double getX2() {
		return x2;
	}

	/**
	 * 
	 * Returns the y-coordinate of the ending point of the Line object.
	 * 
	 * @return The y-coordinate of the ending point of the Line object.
	 */
	public double getY2() {
		return y2;
	}

	/**
	 * 
	 * Calculates and returns the x-coordinate of the intersection point of two Line
	 * objects.
	 * 
	 * @param l2
	 *            The second Line object that the method uses to calculate the
	 *            intersection point with.
	 * @return The x-coordinate of the intersection point of two Line objects.
	 */
	public double getCrossX(Line l2) {
		return (((x * y2 - y * x2) * (l2.x - l2.x2) - (x - x2) * (l2.x * l2.y2 - l2.y * l2.x2))
				/ ((x - x2) * (l2.y - l2.y2) - (y - y2) * (l2.x - l2.x2)));
	}

	/**
	 * 
	 * Calculates and returns the y-coordinate of the intersection point of two Line
	 * objects.
	 * 
	 * @param l2
	 *            The second Line object that the method uses to calculate the
	 *            intersection point with.
	 * @return The y-coordinate of the intersection point of two Line objects.
	 */
	public double getCrossY(Line l2) {
		return (((x * y2 - y * x2) * (l2.y - l2.y2) - (y - y2) * (l2.x * l2.y2 - l2.y * l2.x2))
				/ ((x - x2) * (l2.y - l2.y2) - (y - y2) * (l2.x - l2.x2)));
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
	}

	@Override
	public boolean isPointInside(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

}
