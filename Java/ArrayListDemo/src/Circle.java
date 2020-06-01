import java.awt.*;
import java.awt.geom.*;

public class Circle {
	
	private int x, y;
	private int radius;
	private Color c;
	
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		c = new Color((float)Math.random(),(float)Math.random(),(float)Math.random());
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.fillOval(x-radius,y-radius,radius*2,radius*2);
	}
	
	public boolean isPointInCircle(int x2, int y2) {
		double distance = Point2D.distance(x,y,x2,y2);
		if (distance <= radius) {
			return true;
		}
		return false;
	}
	
}