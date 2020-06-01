import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.event.MouseEvent;

public class DrawingSurface3 extends PApplet {

	private BoxFractal curve;
	private int level, length;
	private int startX, startY;

	public DrawingSurface3() {
		level = 1;
		length = 100;
		startX = 100;
		startY = 150;
		curve = new BoxFractal(level, length);
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
		curve.draw(this);
	}

	public void mouseWheel(MouseEvent event) {
		int num = event.getCount();
		length -= num * 10;
		curve = new BoxFractal(level,length);
		
	}

	public void keyPressed() {
		if (keyCode == UP) {
			System.out.println("Up pressed.");
			level++;
			curve = new BoxFractal(level,length);
		} else if (keyCode == DOWN) {
			level--;
			curve = new BoxFractal(level,length);
		}
	}

}
