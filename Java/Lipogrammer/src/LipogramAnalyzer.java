
import java.util.*;

public class LipogramAnalyzer {
	
	//Fields
	private String inputString;

	
	//Constructors
	public LipogramAnalyzer(String s){
		inputString = s;
		
	}

	
	
	//Methods
	public String mark(char banned){
		String outputString = inputString;
		int length = outputString.length();
		
		for (int i = 0; i < length; i++){
			Character currentChar = new Character(outputString.charAt(i));
			if(currentChar.equals(banned)){
				String beginning = outputString.substring(0, i);
				String end = outputString.substring(i+1);
				outputString = beginning + "#" + end;
			} else{
				
			}
		}
		
		return outputString;
	}

	public String allWordsWith (char banned) {
		String output = inputString;
		String list = "";
		while (output.indexOf(banned) > -1){
			int bannedLoc = output.indexOf(banned);
			int startLoc = bannedLoc - 1;
			while (startLoc > -1 && (Character.isLetter(output.charAt(startLoc)) || output.charAt(startLoc) == '-' || output.charAt(startLoc) == '\'')){
				startLoc--;
			}
			startLoc++;
			int endLoc = bannedLoc + 1;
			while (endLoc < output.length() && (Character.isLetter(output.charAt(endLoc)) || output.charAt(endLoc) == '-' || output.charAt(endLoc) == '\'')){
				endLoc++;
			}
		
			String bannedWord = output.substring(startLoc, endLoc);
			output = output.replaceFirst(bannedWord, "");
			if (list.indexOf(bannedWord) == -1){
			list = list + bannedWord + "\n";
			}
		}
			return list;
		}
		
	public String getWordCount(String s){
		int startLoc = 0;
		int wordCount = 0;
		
		while(startLoc < s.length()-1){
			while(!Character.isLetter(s.charAt(startLoc)) && s.charAt(startLoc) != '-' && s.charAt(startLoc) != '\''){
				s = s.substring(1);
			}
			int currentLoc = 0;
			while (currentLoc < s.length() && (Character.isLetter(s.charAt(currentLoc)) || s.charAt(currentLoc) == '-' || s.charAt(currentLoc) == '\'')){
				currentLoc++;
			}
			int endLoc = currentLoc;
			
			s = s.replaceFirst(s.substring(startLoc, endLoc), "");
			wordCount++;
		}
		
		
		return wordCount + "";
	}
}
	