// Implements the game of Craps logic

public class CrapsGame
{
  private int point = 0;

  /**
   *  Calculates the result of the next dice roll in the Craps game.
   *  The parameter total is the sum of dots on two dice.
   *  point is set to the saved total, if the game continues,
   *  or 0, if the game has ended.
   *  Returns 1 if player won, -1 if player lost,
   *  0 if player continues rolling.
   */
  public int processRoll(int total)
  {
    int result = 0;
    
    /* Pseudocode:
     * 	If there is currently not a point value (first roll)
     * 		If you roll a seven or eleven, you win. Result = 1
     * 		If you roll a 2, 3, 12, you lose. Result = -1
     * 		Else, you neither win nor lose. Result = 0, save total as point value.
     * 
     * If there is currently a point value
     * 		If you roll a seven, you lose. Result = -1, point = 0
     * 		If you reroll the same point, total = point, Result = 1, point = 0;
     * 		If you neither win nor lose, give back a 0
     */
  
    
    if (point == 0){
    	
    	if (total == 7 || total == 11){
    		result = 1;
    	}

    	else if (total == 2 || total == 3 || total == 12){
    		result = -1;
    	}
    	
    	else {
    		point = total;
    		result = 0;
    	
    	}

    }
    
    else {
    	if(total == 7){
    		point = 0;
    		result = -1;
    	}
    	
    	else if(total == point){
    		point = 0;
    		result = 1;
    	}
    	
    	else {
    		result = 0;
    	}
    	
    }
    
    return result;
  }

  /**
   *  Returns the saved point
   */
  public int getPoint()
  {
	  return point;
  }
}
