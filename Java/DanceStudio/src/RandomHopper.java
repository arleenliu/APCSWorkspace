import java.awt.Image;

public class RandomHopper extends Hopper {
	
	 // Constructor
	  public RandomHopper(int x, int y, Image leftPic, Image rightPic)
	  {
	    super(x, y, leftPic, rightPic);  // must be the first statement
	    //super.stepLength = PIXELS_PER_INCH * 12;
	  }  

	  // Makes a step
	  public void firstStep()
	  {
		  int x = (int)(Math.random()*4 + 1);
		    
		    if (x == 1){
		    	
		    } else if (x == 2){
		    	turnLeft();
		    } else if (x == 3){
		    	turnRight();
		    } else {
		    	turnAround();
		    }
			  
			super.firstStep();
	  }
	  
	  public void nextStep() {
		  
		  int x = (int)(Math.random()*4 + 1);
		    
		    if (x == 1){
		    	
		    } else if (x == 2){
		    	turnLeft();
		    } else if (x == 3){
		    	turnRight();
		    } else {
		    	turnAround();
		    }
			  
			super.nextStep();
	  }


	  // Stops this walker
	  public void stop()
	  {
	    super.stop();
	  }

	  // Returns the distance walked
	  public int distanceTraveled()
	  {
		 return super.distanceTraveled();
	  }
	
}
