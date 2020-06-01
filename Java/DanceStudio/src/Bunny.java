import java.awt.Image;
import java.awt.Graphics;

public class Bunny extends Biped{
	private int stepLength;
	private int stepsCount;
	private Foot leftBackFoot, rightBackFoot;
	
	  // Constructor
	  public Bunny(int x, int y, Image leftFront, Image rightFront, Image leftBack, Image rightBack)
	  {
	    super(x, y, leftFront, rightFront);  // must be the first statement
	    stepLength = PIXELS_PER_INCH * 12;
	    
	    leftBackFoot =  new Foot(x, y + PIXELS_PER_INCH * 12, leftBack);//location?
	    rightBackFoot = new Foot(x + PIXELS_PER_INCH * 8, y + PIXELS_PER_INCH * 12, rightBack);
	    leftBackFoot.turn(270);
	    rightBackFoot.turn(270);
	  }  
	  
	// Makes a step
		  public void firstStep()
		  {
			  getLeftFoot().moveForward(stepLength/2);
			  getRightFoot().moveForward(stepLength/2);
			    
			  stepsCount = 1;
		  }
		  
		  public void nextStep() {
			  
			 if (stepsCount % 2 == 0){
				 getLeftFoot().moveForward(stepLength);
				 getRightFoot().moveForward(stepLength);
				 
				    
			 } else {
				 leftBackFoot.moveForward(stepLength);
				 rightBackFoot.moveForward(stepLength);
				 
			 }
			  stepsCount++;
			  
		  }


		  // Stops this walker
		  public void stop()
		  {
			  if (stepsCount % 2 == 0){
				  getLeftFoot().moveForward(stepLength/2);
				  getRightFoot().moveForward(stepLength/2);
			  } else {
				  leftBackFoot.moveForward(stepLength/2);
				  rightBackFoot.moveForward(stepLength/2);
			  }
		    
		  }

		  // Returns the distance walked
		  public int distanceTraveled()
		  {
			  return stepsCount * stepLength;
		  }
		  public void draw(Graphics g){
			  super.draw(g);
			  leftBackFoot.draw(g);
			  rightBackFoot.draw(g);
			  
		  }
		  	  
	}

	

