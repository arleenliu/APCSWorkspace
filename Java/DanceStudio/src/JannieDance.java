
public class JannieDance implements Dance{

	private int distance = 72;
	private int numSteps = 16;
	@Override
	public DanceStep getStep(int i) {
		// TODO Auto-generated method stub
		//Make a Dance step object by passing in 8 numbers
		//make it depend on the parameter
		//return the object
		
		
		if (i % numSteps == 0){
			DanceStep nextStep = new DanceStep (0, 0, 0, 0, 0, -distance, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 1){
			DanceStep nextStep = new DanceStep (0, -distance, 0, 0, 0, 0, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 2){
			DanceStep nextStep = new DanceStep (0, 0, 0, 0, 0, 0, distance, 0);
			return nextStep;
			
		} else if (i % numSteps == 3){
			DanceStep nextStep = new DanceStep (0, 0, distance, 0, 0, 0, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 4){
			DanceStep nextStep = new DanceStep (0, 0, 0, 0, 0, distance, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 5){
			DanceStep nextStep = new DanceStep (0, distance, 0, 0, 0, 0, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 6){
			DanceStep nextStep = new DanceStep (0, 0, -distance, 0, 0, 0, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 7){
			DanceStep nextStep = new DanceStep (0, 0, 0, 0, 0, 0, -distance, 0);
			return nextStep;
			
		} else if (i % numSteps == 8){
			DanceStep nextStep = new DanceStep (0, 0, -distance, 0, 0, 0, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 9){
			DanceStep nextStep = new DanceStep (0, 0, 0, 0, 0, 0, -distance, 0);
			return nextStep;
			
		} else if (i % numSteps == 10){
			DanceStep nextStep = new DanceStep (0, 0, 0, 0, 0, distance, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 11){
			DanceStep nextStep = new DanceStep (0, distance, 0, 0, 0, 0, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 12){
			DanceStep nextStep = new DanceStep (0, 0, 0, 0, 0, 0, distance, 0);
			return nextStep;
			
		} else if (i % numSteps == 13){
			DanceStep nextStep = new DanceStep (0, 0, distance, 0, 0, 0, 0, 0);
			return nextStep;
			
		} else if (i % numSteps == 14){
			DanceStep nextStep = new DanceStep (0, 0, 0, 0, 0, -distance, 0, 0);
			return nextStep;
			
		} else {
			DanceStep nextStep = new DanceStep (0, -distance, 0, 0, 0, 0, 0, 0);
			return nextStep;
		} 
		
	}

	@Override
	public int getTempo() {
		// TODO Auto-generated method stub
		return 700;
	}

	@Override
	public int getBeat(int i) {
		// TODO Auto-generated method stub
		//return one or two to choose a sound
		if (i % 2 == 0){
			if (i % 4 == 0){
				return 3;
			} else {
				return 2;
			}	
		} else{
			return 1;
		}
		
	}

	public String toString()
	{
		return "Jannie's Dance";
	}


}
