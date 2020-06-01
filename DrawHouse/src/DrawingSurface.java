import java.awt.Image;
import java.awt.Toolkit;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;

public class DrawingSurface extends PApplet {

	private float originHeight, originWidth;
	PImage img1, img2, img3, img4, img5, img6;

	public DrawingSurface() {
		originHeight = 600f;
		originWidth = 800f;

	}

	public void setup() {
		img1 = loadImage("vikram.jpg");
		img2 = loadImage("vikram.jpg");
		img3 = loadImage("vikram.jpg");
		img4 = loadImage("vikram.jpg");
		img5 = loadImage("vikram.jpg");
		img6 = loadImage("vikram.jpg");
	}

	public void draw() {

		background(255);   // Clear the screen with a white background
		fill(0);
		// scale(width / originWidth, height / originHeight);
		rect(300, 200, 200, 50);
		image(img1, 0, 0);
		

	}

	public void mouseWheel(MouseEvent event) {

	}

	public void keyPressed() {
		loop();
	}

	public void mouseReleased() {

	}

}
