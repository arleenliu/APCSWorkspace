import java.awt.Point;

import aliu418.shapes.Line;
import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 * 
 * 
 * @author
 * @version
 */
public class GosperCurve {

	// TO DO
	private int length;
	private int level;

	public GosperCurve(int level, int length) {
		// TO DO
		this.length = length;
		this.level = level;
	}

	public void draw(PApplet marker) {
		marker.background(255);
		drawGosperCurve(marker, level, length, Math.PI / 2, marker.width / 2, marker.height / 2, true);
	}

	/*
	 * if level < 1 then Draw a straight line of the current length else Draw a k-1
	 * level Koch curve of 1/3 the current length
	 * 
	 * Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the
	 * current length, at an angle of 60 degrees with respect to the current angle
	 * 
	 * Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the
	 * current length, at an angle of -60 degrees with respect to the current angle
	 * 
	 * Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the
	 * current length
	 * 
	 */

	// angle has to be negative for proper direction
	private void/* TO DO */ drawGosperCurve(PApplet marker, int lvl, int lineLength, double angle, double startX,
			double startY, boolean isA) {

		if (lvl <= 1) {
			if (isA) {
				Line l1 = new Line(startX, startY, angle, lineLength, 0);
				l1.draw(marker);
				Line l2 = new Line(l1.getX2(), l1.getY2(), angle - Math.PI / 3, lineLength, 0);
				l2.draw(marker);
				Line l3 = new Line(l2.getX2(), l2.getY2(), angle - Math.PI, lineLength, 0);
				l3.draw(marker);
				Line l4 = new Line(l3.getX2(), l3.getY2(), angle - 2 * Math.PI / 3, lineLength, 0);
				l4.draw(marker);
				Line l5 = new Line(l4.getX2(), l4.getY2(), angle, 2 * lineLength, 0);
				l5.draw(marker);
				Line l6 = new Line(l5.getX2(), l5.getY2(), angle + Math.PI / 3, lineLength, 0);
				l6.draw(marker);
			} else {
				Line l1 = new Line(startX, startY, angle, lineLength, 0);
				l1.draw(marker);
				Line l2 = new Line(l1.getX2(), l1.getY2(), angle + Math.PI / 3, 2 * lineLength, 0);
				l2.draw(marker);
				Line l3 = new Line(l2.getX2(), l2.getY2(), angle + Math.PI, lineLength, 0);
				l3.draw(marker);
				Line l4 = new Line(l3.getX2(), l3.getY2(), angle - 2 * Math.PI / 3, lineLength, 0);
				l4.draw(marker);
				Line l5 = new Line(l4.getX2(), l4.getY2(), angle + 2 * Math.PI / 3, lineLength, 0);
				l5.draw(marker);
				Line l6 = new Line(l5.getX2(), l5.getY2(), angle + Math.PI / 3, lineLength, 0);
				l6.draw(marker);
			}
		} else {

			if (isA) {
				// A-B--B+A++AA+B-
				drawGosperCurve(marker, lvl - 1, lineLength, angle, startX, startY, true);
				// Line l1 = new Line(startX, startY, angle, lineLength, 0);
				angle -= (Math.PI / 3);
				Point p1 = getEndCoor(marker, startX, startY, angle, lineLength, true);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p1.getX(), p1.getY(), false);
				// Line l2 = new Line(l1.getX2(), l1.getY2(), angle, lineLength, 0);
				angle -= (2 * Math.PI / 3);
				Point p2 = getEndCoor(marker, p1.getX(), p1.getY(), angle, lineLength, false);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p2.getX(), p2.getY(), false);
				// Line l3 = new Line(l2.getX2(), l2.getY2(), angle, lineLength, 0);
				angle += (Math.PI / 3);
				Point p3 = getEndCoor(marker, p2.getX(), p2.getY(), angle, lineLength, false);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p3.getX(), p3.getY(), true);
				// Line l4 = new Line(l3.getX2(), l3.getY2(), angle, lineLength, 0);
				angle += (2 * Math.PI / 3);
				Point p4 = getEndCoor(marker, p3.getX(), p3.getY(), angle, lineLength, true);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p4.getX(), p4.getY(), true);
				// Line l5 = new Line(l4.getX2(), l4.getY2(), angle, lineLength, 0);
				Point p5 = getEndCoor(marker, p4.getX(), p4.getY(), angle, lineLength, true);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p5.getX(), p5.getY(), true);
				// Line l6 = new Line(l5.getX2(), l5.getY2(), angle, lineLength, 0);
				angle += (Math.PI / 3);
				Point p6 = getEndCoor(marker, p5.getX(), p5.getY(), angle, lineLength, true);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p6.getX(), p6.getY(), false);
				angle -= (Math.PI / 3);

			} else {
				// +A-BB--B-A++A+B
				angle += (Math.PI / 3);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, startX, startY, true);
				// Line l1 = new Line(startX, startY, angle, lineLength, 0);
				angle -= (Math.PI / 3);
				Point p1 = getEndCoor(marker, startX, startY, angle, lineLength, true);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p1.getX(), p1.getY(), false);
				// Line l2 = new Line(l1.getX2(), l1.getY2(), angle, lineLength, 0);
				Point p2 = getEndCoor(marker, p1.getX(), p1.getY(), angle, lineLength, false);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p2.getX(), p2.getY(), false);
				// Line l3 = new Line(l2.getX2(), l2.getY2(), angle, lineLength, 0);
				angle -= (2 * Math.PI / 3);
				Point p3 = getEndCoor(marker, p2.getX(), p2.getY(), angle, lineLength, false);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p3.getX(), p3.getY(), false);
				// Line l4 = new Line(l3.getX2(), l3.getY2(), angle, lineLength, 0);
				angle -= (Math.PI / 3);
				Point p4 = getEndCoor(marker, p3.getX(), p3.getY(), angle, lineLength, false);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p4.getX(), p4.getY(), true);
				// Line l5 = new Line(l4.getX2(), l4.getY2(), angle, lineLength, 0);
				angle += (2 * Math.PI / 3);
				Point p5 = getEndCoor(marker, p4.getX(), p4.getY(), angle, lineLength, true);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p5.getX(), p5.getY(), true);
				// Line l6 = new Line(l5.getX2(), l5.getY2(), angle, lineLength, 0);
				angle += (Math.PI / 3);
				Point p6 = getEndCoor(marker, p5.getX(), p5.getY(), angle, lineLength, false);
				drawGosperCurve(marker, lvl - 1, lineLength, angle, p6.getX(), p6.getY(), false);
			}

		}
	}

	private Point getEndCoor(PApplet marker, double startX, double startY, double angle, int lineLength, boolean isA) {
		if (isA) {
			Line l1 = new Line(startX, startY, angle, lineLength, 0);
			// l1.draw(marker);
			Line l2 = new Line(l1.getX2(), l1.getY2(), angle - Math.PI / 3, lineLength, 0);
			// l2.draw(marker);
			Line l3 = new Line(l2.getX2(), l2.getY2(), angle - Math.PI, lineLength, 0);
			// l3.draw(marker);
			Line l4 = new Line(l3.getX2(), l3.getY2(), angle - 2 * Math.PI / 3, lineLength, 0);
			// l4.draw(marker);
			Line l5 = new Line(l4.getX2(), l4.getY2(), angle, 2 * lineLength, 0);
			// l5.draw(marker);
			Line l6 = new Line(l5.getX2(), l5.getY2(), angle + Math.PI / 3, lineLength, 0);
			// l6.draw(marker);

			// System.out.println("x = " + l6.getX2() + ", y = " + l6.getY2());
			return new Point((int) l6.getX2(), (int) l6.getY2());
		} else {
			Line l1 = new Line(startX, startY, angle, lineLength, 0);
			// l1.draw(marker);
			Line l2 = new Line(l1.getX2(), l1.getY2(), angle + Math.PI / 3, 2 * lineLength, 0);
			// l2.draw(marker);
			Line l3 = new Line(l2.getX2(), l2.getY2(), angle + Math.PI, lineLength, 0);
			// l3.draw(marker);
			Line l4 = new Line(l3.getX2(), l3.getY2(), angle - 2 * Math.PI / 3, lineLength, 0);
			// l4.draw(marker);
			Line l5 = new Line(l4.getX2(), l4.getY2(), angle + 2 * Math.PI / 3, lineLength, 0);
			// l5.draw(marker);
			Line l6 = new Line(l5.getX2(), l5.getY2(), angle + Math.PI / 3, lineLength, 0);
			// l6.draw(marker);
			// System.out.println("x = " + l6.getX2() + ", y = " + l6.getY2());
			return new Point((int) l6.getX2(), (int) l6.getY2());
		}
	}
}
