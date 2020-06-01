
	import java.awt.Image;
public class Hopper extends Biped{
	// Represents a Biped that moves by hopping
	
	  private int stepLength;
	  private int stepsCount;
	  
	  // Constructor
	  public Hopper(int x, int y, Image leftPic, Image rightPic)
	  {
	    super(x, y, leftPic, rightPic);  // must be the first statement
	    stepLength = PIXELS_PER_INCH * 12;
	  }  

	  // Makes a step
	  public void firstStep()
	  {
		  getLeftFoot().moveForward(stepLength);
		  getRightFoot().moveForward(stepLength);
		    
		  stepsCount = 1;
	  }
	  
	  public void nextStep() {
		  
		  getLeftFoot().moveForward(stepLength);
		  getRightFoot().moveForward(stepLength);
		    
		  stepsCount++;
	  }


	  // Stops this walker
	  public void stop()
	  {
	    
	  }

	  // Returns the distance walked
	  public int distanceTraveled()
	  {
		  return stepsCount * stepLength;
	  }
	  	  
}




