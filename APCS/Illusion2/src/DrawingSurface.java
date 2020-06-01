
import java.awt.Color;
import java.util.ArrayList;

import aliu418.shapes.Line;
import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	ArrayList<Line> lines;
	
	public DrawingSurface() {
		lines = new ArrayList<>();
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
		
		for(int i = 40; i >= 1; i--) {
			new Line(200, 150, i*Math.PI/20, 50).draw(this);
		}
		
		for (int i = 0; i < 6; i++) {
			lines.add(new Line(155.0 + 18 * i, 100.0, 155 + 18 * i, 200));
		}
		
		for (int i = 0; i < 6; i++) {
			lines.get(i).setStrokeWidth(3);
			lines.get(i).setStrokeColor(Color.RED);
			lines.get(i).draw(this);;
		}
		
	}	
	
	
	public void mousePressed() {

	}
	
	public void mouseClicked() {
	
	}
	
	public void mouseDragged() {

	}
	
	
}










