import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	private KochCurve curve;
	private KochSnowflake sf1, sf2, sf3;
	private int level, length;
	private int startX, startY;

	public DrawingSurface() {
		level = 1;
		length = 100;
		startX = 100;
		startY = 150;
		curve = new KochCurve(level, length);
		sf1 = new KochSnowflake(level, length, 0, startX, startY, true);
		sf2 = new KochSnowflake(level, length, 2 * Math.PI / 3, startX + (int) (3 * length * Math.cos(Math.PI / 3)),
				startY + (int) (3 * length * Math.sin(Math.PI / 3)), true);
		sf3 = new KochSnowflake(level, length, 4 * Math.PI / 3, startX + 3 * length, startY, false);
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {

	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {
		background(255); // Clear the screen with a white background

		textSize(12);
		fill(0);
		text("Use the mouse wheel to change length, use UP/DOWN keys to change level.", 0, 15);

		stroke(0);
		// curve.draw(this);

		sf1.draw(this);
		sf2.draw(this);
		sf3.draw(this);
	}

	public void mouseWheel(MouseEvent event) {
		int num = event.getCount();
		length -= num * 10;
		// curve = new KochCurve(level,length);
		sf1 = new KochSnowflake(level, length, 0, startX, startY, true);
		sf2 = new KochSnowflake(level, length, 2 * Math.PI / 3, startX + (int) (3 * length * Math.cos(Math.PI / 3)),
				startY + (int) (3 * length * Math.sin(Math.PI / 3)), true);
		sf3 = new KochSnowflake(level, length, 4 * Math.PI / 3, startX + 3 * length, startY, false);
	}

	public void keyPressed() {
		if (keyCode == UP) {
			System.out.println("Up pressed.");
			level++;
			// curve = new KochCurve(level,length);
			sf1 = new KochSnowflake(level, length, 0, startX, startY, true);
			sf2 = new KochSnowflake(level, length, 2 * Math.PI / 3, startX + (int) (3 * length * Math.cos(Math.PI / 3)),
					startY + (int) (3 * length * Math.sin(Math.PI / 3)), true);
			sf3 = new KochSnowflake(level, length, 4 * Math.PI / 3, startX + 3 * length, startY, false);
		} else if (keyCode == DOWN) {
			level--;
			// curve = new KochCurve(level,length);
			sf1 = new KochSnowflake(level, length, 0, startX, startY, true);
			sf2 = new KochSnowflake(level, length, 2 * Math.PI / 3, startX + (int) (3 * length * Math.cos(Math.PI / 3)),
					startY + (int) (3 * length * Math.sin(Math.PI / 3)), true);
			sf3 = new KochSnowflake(level, length, 4 * Math.PI / 3, startX + 3 * length, startY, false);
		}
	}

}
