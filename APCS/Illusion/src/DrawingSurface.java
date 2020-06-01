

import aliu418.shapes.*;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	
	public DrawingSurface() {
		
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		background(255);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		// background(255);   // Clear the screen with a white background
		
		for(int i = 16; i >= 1; i--) {
			new Circle(200, 150, i * 4).draw(this);
		}
		
		new Rectangle(150, 100, 100, 100).draw(this);
		
	}	
	
	
	public void mousePressed() {

	}
	
	public void mouseClicked() {
	
	}
	
	public void mouseDragged() {

	}
	
	
}










