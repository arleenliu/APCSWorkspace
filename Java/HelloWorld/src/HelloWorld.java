import java.util.Scanner;

public class HelloWorld {
private static String e = "3" + 3;
private static int random = 3;
	public static void main(String[] args) {

		System.out.println("What is your first name?");
		
		Scanner keyBoard = new Scanner(System.in);
		
		String firstName = keyBoard.next();
		
		System.out.println("What is your last name?");
		
		String lastName = keyBoard.next();
		
		System.out.println("Hello, " + firstName + " " + lastName);
		//System.out.println(random + "Hello");


	}
	
	
	
	
	
	
	
	
}
