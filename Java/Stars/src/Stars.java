import java.util.Scanner;

public class Stars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String menuChoice;
		do {
			Scanner kboard = new Scanner(System.in);
			System.out.println("---MENU---");
			System.out.println("What would you like to see? Type 1, 2, 3, 4, 5, 6, or Q");
			System.out.println("1) Row of Stars");
			System.out.println("2) Star Square");
			System.out.println("3) Star Triangle");
			System.out.println("4) Inverted Star Triangle");
			System.out.println("5) Star Pyramid");
			System.out.println("6) Star Diamond");
			System.out.println("Q) Quit");
			System.out.print("-----> ");
			menuChoice = kboard.next();
	
			if (menuChoice.equals("1")) {
		    	    System.out.print("How many stars would you like? --> ");
		    	    int n = kboard.nextInt( );
		    	    Stars runner = new Stars();
		    	    System.out.println("");
		    	    runner.printStars(n);
	
			} else if (menuChoice.equals("2")) {
					System.out.print("How big would you like your square to be?");
					int n = kboard.nextInt( );
			    	Stars runner = new Stars();
			    	System.out.println("");
			    	runner.printStarSquare(n);
			    	    
			} else if (menuChoice.equals("3")){
					System.out.print("How big would you like your triangle to be?");
					int n = kboard.nextInt();
					Stars runner = new Stars();
					System.out.println("");
					runner.printStarTriangle(n);
			
			} else if (menuChoice.equals("4")){
				System.out.print("How big would you like your triangle to be?");
				int n = kboard.nextInt();
				Stars runner = new Stars();
				System.out.println("");
				runner.printInvertedStarTriangle(n);
			
			} else if (menuChoice.equals("5")){
				System.out.print("How big would you like your pyramid to be?");
				int n = kboard.nextInt();
				Stars runner = new Stars();
				System.out.println("");
				runner.printStarPyramid(n);
			
			} else if (menuChoice.equals("6")){
				System.out.print("How big would you like your diamond to be?");
				int n = kboard.nextInt();
				Stars runner = new Stars();
				System.out.println("");
				runner.printStarDiamond(n);
	
			} else if (menuChoice.equalsIgnoreCase("Q")){
			
				System.out.println("Goodbye!");
			
			} else {
				System.out.print("Error - " + menuChoice + " is not a menu option.");
			}
		} while (!menuChoice.equalsIgnoreCase("Q"));

	}
	
	
	
	
	
	
	
	public void printStars(int x) {
		
		for(int i = 0; i < x; i++) {
			System.out.print("*");
		}
		System.out.println("\n");
	}
	
	
	
	public void printStarSquare(int n) {
		
		for(int row = 0; row < n; row++){
			
			for(int x = 0; x < n; x++) {
				
				System.out.print("*");
			}
			
		System.out.println("");
		
		}
		
		System.out.println("\n");
	}
	
	public void printStarTriangle(int n){
		
			for(int row = 0; row < n; row++){
				
				for(int x = 0; x < row + 1; x++) {
					System.out.print("*");
				}
				
				System.out.println();
			}

			System.out.println("");
		
		

	
	}

	
	public void printInvertedStarTriangle(int n){
		
		for(int row = 1; row <= n; row++){
			
			for(int z = n; z >= row; z--) {
				
				System.out.print(" ");
			}
			
			for(int x = 0; x < row; x++) {
				
				System.out.print("*");
			}
			
			System.out.println();
		}

		System.out.println("");
		
	}
		
	public void printStarPyramid(int n){
		
		for(int row = 1; row <= n; row++){
			
			for(int z = n; z >= row; z--) {
				
				System.out.print(" ");
			}
			
			for(int x = 0; x < 2*row-1; x++) {
				
				System.out.print("*");
			}
			
			System.out.println();
		}

		System.out.println("");

	}
	
	public void printStarDiamond(int n){
		
		for(int row = 1; row <= n; row++){
			
			for(int z = 0; z < (int)(Math.abs((n + 1.0)/2-row)); z++) {
				
				System.out.print(" ");
			}
			
			for(int x = 0; x < (int)(n - 2 * Math.abs((n+1.0)/2-row)); x++) {
				
				System.out.print("*");
			}
			
			System.out.println();
		
		}
		
		System.out.println("");

		
		}
	
}

//5801 ------5800-5810
