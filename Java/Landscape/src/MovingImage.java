import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class MovingImage {
	//FIELDS
	
	private Image img;
	private Boolean isVisible;
	private int x, y, width, height;
	
	
	
	//CONSTRUCTORS
	public MovingImage(String filename, int locX, int locY, int w, int h){
		isVisible = true;
		
		this.x = locX;
		this.y = locY;
		this.width = w;
		this.height = h;
		
		img = (new ImageIcon(filename)).getImage();
	}
	
	//METHODS
	
	public void draw(ImageObserver io, Graphics g){
		if (isVisible){
			g.drawImage(img, x, y, width, height, io);
		}
		
	}
	
	public void toggleVisibility(){
		isVisible = !isVisible;
	}
	public void moveTo (int x, int y){
		this.x = x;
		this.y = y;
		
	}
	public void moveBy(int x, int y){
		this.x += x;
		this.y += y;
	}
	
	public boolean isClickInImage(int clickX, int clickY){
		return false;
	}
}
