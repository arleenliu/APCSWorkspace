
public class StringToolBox {
	
	
	/*s = s.trim();
	 *i = s.indexof(" ");
	 * firstName = s.substring(0, i);
	 * lastName = s.substring(i); 
	 * lastName = lastName.toUpperCase();
	 * name = firstName + lastName;
	 */
	public static String nameEcho(String s) {
		s = s.trim();
		int i = s.indexOf(" ");
		String firstName = s.substring(0, i);
		String lastName = s.substring(i+1); 
		lastName = lastName.toUpperCase();
		String name = firstName + " " + lastName;
		
		return name;
	}
	
	public static String caesar(String str, int n){
		String output = "";
		for (int i = 0; i < str.length(); i++){

			char thisChar = str.charAt(i);
			//Character character = new Character(thisChar);
			boolean lowerCase = Character.isLowerCase(thisChar);
			
			if (Character.isLetter(thisChar) == false){
				output += thisChar;
			} else{
				int charAsInt = (int)thisChar;
				charAsInt = charAsInt + n;
				thisChar = (char) charAsInt;
				
			
				if (lowerCase == true){
					if (charAsInt > (char) 'z'){
						charAsInt -= 26;
					} if (charAsInt < (char) 'a'){
						charAsInt += 26;
					}
					
				} else {
					if (charAsInt > (char)'Z'){
						charAsInt -= 26;
					} if (charAsInt < (char)'A'){
						charAsInt += 26;
					}
					
				}
				
				thisChar = (char)charAsInt;
				output = output + thisChar;
			}
		}
		return output;
	}
	
	public static String backwards(String s){
		StringBuffer sBuffer = new StringBuffer(s);
		sBuffer.reverse();
		s = sBuffer.toString();
		
		return s;
		
	}
	
	/*int length()
	 *int last IndexOf
	 *if IndexOf = length - 1, then true
	 * otherwise false
	 */
	public static boolean endsWithStar(String s) {
		
		if (s.length() > 0){
			int l = s.length();
			int j = s.lastIndexOf("*");
			if (j == l-1){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
		//boolean result = s.endsWith("*");
		//return result;
		
	}

	
	/*
	 * int length
	 * if (length >=2)	
	 * 	find last Index Of **
	 */
	public static boolean endsWithTwoStars(String s) {
		
		int l = s.length();
		if(l >= 2){
			int j = s.lastIndexOf("**");
			if(j == l-2){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
		
		//boolean result = s.endsWith("**");
		//return result;
	}

	/*
	 * replace all spaces with empty (s.replace)
	 * s.length
	 * s.substring
	 */
	
	public static String last4(String s) {
		s = s.replace(" ", "");
		int l = s.length();
		String last4 = s.substring(l-4);
		
		return last4;
	}
	
	/*
	 * replace all spaces with empty (s.replace)
	 * s.length
	 * s.substring
	 */
	
	public static String last5(String s) {
		s = s.replace(" ", "");
		int l = s.length();
		String last5 = s.substring(l-5);
		
		return last5;
	}
	
	/*s.substring for the first character, and then a substring for everything else
	 *
	 */
	public static String scroll(String s) {
		String begChar = s.substring(0,1);
		String endString = s.substring(1);
		
		return endString + begChar;
	}

	
	/*find comma index number
	 * split into s.substrings----1. 0, comma   2. comma + 1
	 * s.trim both
	 * put together with a space in between
	 */
	public static String convertName(String s) {
		int commaIdx = s.indexOf(",");
		String lastN = s.substring(0, commaIdx);
		lastN = lastN.trim();
		
		String firstN = s.substring(commaIdx + 1);
		firstN = firstN.trim();
		
		return firstN + " " + lastN;
	}
	
	public static String removeDashes(String s){
		String noDashes = s.replace("-", "");
		return noDashes;
	}
	
	public static String dateStr(String dateStr){
		int firSlash = dateStr.indexOf("/");
		int secSlash = dateStr.indexOf("/", firSlash+1);
		String month = dateStr.substring(0, firSlash);
		String day = dateStr.substring(firSlash + 1, secSlash);
		String year = dateStr.substring(secSlash + 1);
		
		if (month.length() == 1){
			month = "0" + month;
		}
		if (day.length() == 1){
			day = "0" + day;
		}
		
		
		return day + "-" + month + "-" + year;
	}
	
	public static String negativeBits(String s){
		s = s.replace("0", "2");
		s = s.replace("1", "0");
		s = s.replace("2", "1");
		
		return s;
	}
	
	public static String containsSameChar(String s){
		String str = "" + StringToolBox.scroll(s);
		if (str.equals(s)){
			return "true";
		}
		else {
			return "false";
		}
	}
	
	public static String removeComments(String s){
		//int start = s.indexOf("/*");
		//int end = s.lastIndexOf("*/");
		int length = s.length();
		/*
		if (start != -1 && end != -1){
			if (start < end){
				String str = s.substring(start, end + 2);
				s = s.replace(str, "");
				return s;
			} else {
				return "Error: The start is after the end";
			}
		} else{
			return s;
		}
		*/
		int fStart = 0;
		int fEnd = 0;
		int start = s.indexOf("/*", fEnd);
		int end = s.indexOf("*/", start);
		
		while (start != -1 || end != -1){

			String str = s.substring(start, end + 2);
			s = s.replace(str, "");
			
			start = s.indexOf("/*", fEnd);
			end = s.indexOf("*/", start);
			
		}
		
		return s;
		

	}
	
	public static boolean isPalindrome(String s){
		
		int length = s.length();
		String finalOut = "";
		
		for (int i = 0; i < length; i++){
			if (Character.isLetter(s.charAt(i)) || Character.isDigit(s.charAt(i))){
				char x = s.charAt(i);
				finalOut = finalOut + x;
			}
		}
		//System.out.print(finalOut);
		length = finalOut.length();
		
		
		for (int i = 0; i <= length/2; i++){
			String beginning = "" + finalOut.charAt(i);
			String end = "" + finalOut.charAt(length - i - 1);
			if (beginning.equalsIgnoreCase(end)){
				
			} else {
				return false;
			}
			
		}
		
		return true;
	}
	
	public static boolean validPassword (String s){
		boolean isUppercase = false;
		boolean isLowercase = false;
		boolean isNumberDigit = false;
		
		int length = s.length();
		if (length < 7){
			System.out.print("Password is not long enough.");
			return false;
		}
		
		for (int i = 0; i < length; i++){
			if (Character.isWhitespace(s.charAt(i))){
				return false;
			}
			if (Character.isLowerCase(s.charAt(i))){
				isLowercase = true;
			}
			if (Character.isUpperCase(s.charAt(i))){
				isUppercase = true;
			}
			if (Character.isDigit(s.charAt(i))){
				isNumberDigit = true;
			}
			
		}
		if (isLowercase && isUppercase && isNumberDigit){
			return true;
		} else {
			return false;
		}
	
	}
	
	
}