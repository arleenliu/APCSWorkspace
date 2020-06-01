import java.lang.Object;
import java.lang.Math;

public class Die {
	private int numDotsFacingUp;
	
	public void roll(){
		numDotsFacingUp = (int)(Math.random()*6) + 1;
	}
	
	public int getNumDots(){
		
		return numDotsFacingUp;
	}

}
