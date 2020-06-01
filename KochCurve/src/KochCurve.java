import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 * 
 * 
 * @author
 * @version
 */
public class KochCurve {

	// TO DO
	private int length;
	private int level;

	public KochCurve(int level, int length) {
		// TO DO
		this.length = length;
		this.level = level;
	}

	public void draw(PApplet marker) {
		marker.background(255);
		drawKochCurve(marker, level, length, 0, 100, 250/* TO DO */);
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
	private void/* TO DO */ drawKochCurve(PApplet marker, int lvl, int lineLength, double angle, int startX,
			int startY/* TO DO */) {
		int x = (int) (startX + ((lineLength) * Math.cos(angle + 0)));
		int y = (int) (startY - ((lineLength) * Math.sin(angle + 0)));
		// TO DO
		if (level < 1) {
			x = (int) (startX + ((3*lineLength) * Math.cos(angle + 0)));
			y = (int) (startY - ((3*lineLength) * Math.sin(angle + 0)));
			marker.line(startX, startY, 3* x, 3*y);
		}
		
		if (lvl < 1) {
			// marker.line(startX, startY, (int) (startX - (lineLength*Math.cos(angle))),
			// (int) (startY + (lineLength*Math.sin(angle))));
			// marker.line(startX, startY, x, y);
		} else {
			drawKochCurve(marker, lvl - 1, lineLength / 3, angle, startX, startY);
			
			if (lvl == 1) {
				marker.line(startX, startY, x, y);
			}
			angle += Math.PI / 3;
			startX = x;
			startY = y;
			x = (int) (x + ((lineLength) * Math.cos(angle)));
			y = (int) (y - ((lineLength) * Math.sin(angle)));
			drawKochCurve(marker, lvl - 1, lineLength / 3, angle, startX, startY);
			if (lvl == 1) {
				marker.line(startX, startY, x, y);
			}
			angle += 4 * Math.PI / 3;
			startX = x;
			startY = y;
			x = (int) (x + ((lineLength) * Math.cos(angle)));
			y = (int) (y - ((lineLength) * Math.sin(angle)));
			drawKochCurve(marker, lvl - 1, lineLength / 3, angle, startX, startY);
			if (lvl == 1) {
				marker.line(startX, startY, x, y);
			}
			angle += Math.PI / 3;
			startX = x;
			startY = y;
			x = (int) (startX + ((lineLength) * Math.cos(angle)));
			y = (int) (startY - ((lineLength) * Math.sin(angle)));
			drawKochCurve(marker, lvl - 1, lineLength / 3, angle, startX, startY);
			if (lvl == 1) {
				marker.line(startX, startY, x, y);
			}
		}
	}

}
