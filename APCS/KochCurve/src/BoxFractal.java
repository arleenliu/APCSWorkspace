import processing.core.PApplet;

/**
 * @(#)KochCurve.java
 * 
 * 
 * @author
 * @version
 */
public class BoxFractal {

	// TO DO
	private int length;
	private int level;

	public BoxFractal(int level, int length) {
		// TO DO
		this.length = length;
		this.level = level;
	}

	public void draw(PApplet marker) {
		marker.background(255);
		drawBoxFractal(marker, level, length, (marker.width / 2) - (length / 2), (marker.height / 2) - (length / 2)/* TO DO */);
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
	private void/* TO DO */ drawBoxFractal(PApplet marker, int lvl, int lineLength, int startX,
			int startY/* TO DO */) {
		if (lvl <= 1) {
			marker.rect(startX, startY, lineLength, lineLength);
		} else {
			drawBoxFractal(marker, lvl - 1, lineLength / 3, startX, startY);
			drawBoxFractal(marker, lvl - 1, lineLength / 3, startX, startY + (2 * lineLength / 3));
			drawBoxFractal(marker, lvl - 1, lineLength / 3, startX + (2 * lineLength / 3), startY);
			drawBoxFractal(marker, lvl - 1, lineLength / 3, startX + (2 * lineLength / 3), startY + (2 * lineLength / 3));
			drawBoxFractal(marker, lvl - 1, lineLength / 3, startX + (lineLength / 3), startY + (lineLength / 3));
			
		}
	}

}
