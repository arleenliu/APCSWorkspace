package colors;

import java.awt.Color;

public enum GridColor {
	RED (Color.RED),
	MAGENTA (Color.MAGENTA),
	YELLOW (Color.YELLOW),
	GREEN (Color.GREEN),
	BLUE (Color.BLUE);
	
	private Color c;
	GridColor(Color c) {
		this.c = c;
	}
	
	public Color getColor() {
		return c;
	}
}
