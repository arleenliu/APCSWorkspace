
public class HangmanGame {
	//FIELDS
	private StringBuffer board;
	private StringBuffer triedLetters;
	private String answer;
	private int numGuess;
	
	
	
	
	
	
	

	  //CONSTRUCTORS
	  public HangmanGame(String word){
		answer = word; 
		triedLetters = new StringBuffer();
		board = new StringBuffer();
		 for (int i = 0; i < word.length(); i++){
			 board.append("_");
		 }
		  
	  }
	  
	  
	  
	  
	  
	  
	  
      //METHODS
	public String getTried (){
		return triedLetters.toString();
	}
	public String getGuessed(){
		return board.toString();
	}
	public int tryLetter(char letter){
		int test = answer.indexOf(letter);
		int man = 0;
		if (test >= 0){
			test = 1;
		}
		if (triedLetters.indexOf(letter + "") >= 0 || board.indexOf(letter+"") >= 0){
			test = 0;
		}
		
		if (test == -1){
			//System.out.println("The letter " + letter + " is not in the word.");
			triedLetters.append(letter);
			man++;
		} else if (test == 0){
			//System.out.println("You have already guessed this letter.");
		} else if (test == 1){
			for(int i = 0; i < answer.length(); i++){
				if (answer.charAt(i) == letter){
					board.replace(i, i+1, letter + "");
				}
			}
		}
		
		while (man > 0){
			
			
			man--;
		}
		
		return test;
	}



}
