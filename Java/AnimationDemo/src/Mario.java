
public class Mario extends MovingImage {
	// FIELDS
	private double velX, velY;
	
	// CONSTRUCTOR
	public Mario(int x, int y) {
		super("mario.png",x,y,40,50);
		velX = 0;
		velY = 0;
		
	}
	
	// METHODS
	public void walk(int dir) {
		// WALK!
		super.moveByAmount(dir*2, 0);
	}
	
	public void jump() {
		// JUMP!
		
		velY = -10;
		
	}
	
	public void fall(MovingImage platform) {
		// FALL!
		
		//Gravity
		velY += 0.8;
		
		
		int xPos = getX();
		int yPos = getY();
		
		yPos += getHeight();
		xPos += getWidth()/2;
		
		super.moveByAmount(0, (int)(velY));

		
		if (platform.isPointInImage(xPos, yPos)){
			super.moveByAmount(0, -(yPos-platform.getY()));
			velY= 0;
		} 
	
	}
}