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

public class Line {

	private int x1, y1, x2, y2;
	private int crossX, crossY;
	private int moreX, lessX, moreY, lessY;
	private double slope;

	public Line(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		crossX = 0;
		crossY = 0;

		if (x2 != x1) {
			slope = (double) (this.y2 - this.y1) / (this.x2 - this.x1);
		} else {
			slope = 0;
		}

	}

	public void draw(PApplet drawer) {
		drawer.line((float) x1, (float) y1, (float) x2, (float) y2);

//		System.out.println("x1 = " + x1 + ", x2 = " + x2);

	}

	private void setMoreLess() {
		moreX = Math.max(x1, x2);
		lessX = Math.min(x1, x2);

		moreY = Math.max(y1, y2);
		lessY = Math.min(y1, y2);
	}

	private void calculateIntersection(Line l2) {

		//if (x1 != x2 && l2.x1 != l2.x2 && y1 != y2 && l2.y1 != l2.y2) {
		crossX = ((x1 * y2 - y1 * x2) * (l2.x1 - l2.x2) - (x1 - x2) * (l2.x1 * l2.y2 - l2.y1 * l2.x2))
				/ ((x1 - x2) * (l2.y1 - l2.y2) - (y1 - y2) * (l2.x1 - l2.x2));
		crossY = ((x1 * y2 - y1 * x2) * (l2.y1 - l2.y2) - (y1 - y2) * (l2.x1 * l2.y2 - l2.y1 * l2.x2))
				/ ((x1 - x2) * (l2.y1 - l2.y2) - (y1 - y2) * (l2.x1 - l2.x2));
		//}

	}

	public boolean intersects(Line l2) {
		
		setMoreLess();
		l2.setMoreLess();

		System.out.println("MoreX = " + moreX + ", LessX = " + lessX);

		System.out.println(crossX + ", " + crossY);
		
		// checks if they're parallel
		if (Math.abs((x1 - x2) * (l2.y1 - l2.y2) - (y1 - y2) * (l2.x1 - l2.x2)) > 0.0001) { 
			calculateIntersection(l2);
			// checks if intersection point is in the segment
			if (crossX <= moreX && crossX <=l2.moreX && crossX >= lessX && crossX >= l2.lessX && crossY <= moreY
					&& crossY <= l2.moreY && crossY >= lessY && crossY >= l2.lessY) {
				System.out.println("in segment");				
				return true;
			} else {
				System.out.println("out of segment");
				return false;
			}
		} else { // it is parallel
			System.out.println("parallel");
			return false;
		}
			
			
//			if (x1 == x2 && l2.x1 <= x1 && l2.x2 >= x1) {
//			return true;
//		} else if (y1 == y2 && l2.y1 <= y1 && l2.y2 >= y1) {
//			return true;
//		} else if (l2.y1 == l2.y2 && l2.y1 >= y1 && l2.y1 <= y2) {
//			return true;
//		} else if (l2.x1 == l2.x2 && x1 <= l2.x1 && x2 >= l2.x1) {
//			return true;
//		} else if (x1 == x2 && x1 == l2.x1 && l2.x1 == l2.x2 ){
//			return true;
//		} else {
//			return false;
//		}

	}

	public void setPoint2(int x, int y) {
		x2 = x;
		y2 = y;
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public int getCrossX() {
		return crossX;
	}

	public int getCrossY() {
		return crossY;
	}

}
