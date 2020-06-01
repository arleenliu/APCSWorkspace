//By: Jannie Zhong. Date: 12/7/16
//This program is a series of examples in using loops to code.
//


import java.util.Scanner;


public class IntroLoops {


	public static void main(String[] args) {
		int menuChoice;
		do {
			Scanner kboard = new Scanner(System.in);
			System.out.println("---MENU---");
			System.out.println("What would you like to see? Type 1, 2, 3, 4, 5, 6, 7, or 8");
			System.out.println("1) Division");
			System.out.println("2) Print A Series");
			System.out.println("3) Repeat A Word");
			System.out.println("4) Formatting A Table of Contents");
			System.out.println("5) Standard Deviation");
			System.out.println("6) Finding Triangular Numbers");
			System.out.println("7) The Fibonacci Sequence");
			System.out.println("8) Quit");
			System.out.print("-----> ");
			menuChoice = kboard.nextInt();
	
			if (menuChoice == 1) {
				 	System.out.print("Enter the first number --> ");
		    	    int m = kboard.nextInt( );
	
		    	    System.out.print("Enter the second number --> ");
		    	    int n = kboard.nextInt( );
		    	    IntroLoops tester = new IntroLoops();
		    	    tester.divide(m, n);
	
			} else if (menuChoice == 2) {
					System.out.print("Enter Start:");
					int start = kboard.nextInt( );
	
					System.out.print("Enter End:");
					int end = kboard.nextInt( );
					
					IntroLoops tester = new IntroLoops();
		    	    tester.printSeries(start, end);
	
			} else if (menuChoice == 3){
				System.out.print("Enter a word --> ");
	    	    String word = kboard.next( );
	    	    IntroLoops tester = new IntroLoops();
	    	    tester.repeatWord(word);
	    	    
			} else if (menuChoice == 4){
				System.out.print("Enter the first word --> ");
	    	    String word1 = kboard.next( );
	    	    System.out.print("Enter the second word --> ");
	    	    String word2 = kboard.next( );
	    	    IntroLoops tester = new IntroLoops();
	    	    tester.printIndexLine(word1, word2);
	    	    
			} else if (menuChoice == 5){
				System.out.print("Enter the number of numbers to follow --> ");
	    	    int N = kboard.nextInt( );
	    	    IntroLoops tester = new IntroLoops();
	    	    tester.standardDeviation(N);
	     
			} else if (menuChoice == 6){
					System.out.println("Enter the number -->");
					int num1 = kboard.nextInt();
					
					IntroLoops tester = new IntroLoops();
					int answer = tester.findTriangular(num1);
					System.out.println("The "+ num1+ "th triangular number is " + answer);
			
			} else if (menuChoice == 7){
						System.out.println("Enter the number -->");
						int num1 = kboard.nextInt();
						
						IntroLoops tester = new IntroLoops();
						long answer = tester.fibonacci(num1);
					if (answer >=0){
						System.out.println("The "+ num1 + "th fibonacci number is " + answer);
					}
					else {
						System.out.println(num1 + " is not a valid input number.");
					}
				
			} else if (menuChoice == 8){
			
			} else {
				System.out.println("Error - " + menuChoice + " is not a menu option.");
			}
		} while (menuChoice != 8);

	}

	
	public void divide(int m, int n) {
		int quotient = 0;
		if (n != 0){
			while (n <= m){
				m = m-n;
				quotient++;
			}
			int remainder = m;
			System.out.println("The quotient is " + quotient + " and the remainder is " + remainder + ".");
		}
		else {
			System.out.println(("Error - Result is undefined."));
		}
	}

	public void printSeries(int start, int end) {
		if (end >= start) {
			while (end >= start){
			System.out.println(start);
			start++;
			}
		}
		else {
			System.out.println("The range " + start + " to " + end + " is not valid.");
		}
	}

	public void repeatWord(String word) {
		int times = word.length();
		int count = 1;
		while (times >= count){
			System.out.println(word);
			count++;
		}
	}

	public void printIndexLine(String word1, String word2) {
	
		int length1 = word1.length();
		int length2 = word2.length();
		if(length1 + length2 <= 30){
			System.out.print(word1);
			int numDots = 30 - length1 - length2;
			int count = 1;
			while (numDots >= count){	
				System.out.print(".");
				count++;
			}
			System.out.print(word2);
			
		}
		else {
			System.out.println("Your words are too long to fit. Please shorten them or find new words.");
		}
	}
	public void standardDeviation(int N){
		Scanner kboard = new Scanner(System.in);
		int count = 1;
		double sumNum = 0.0;
		double sumSquareNum = 0.0;
		if (N > 0){
			while (N >= count){
				System.out.println("Enter the number No. " + count);
				double number = kboard.nextDouble();
				sumNum = sumNum + number;
				sumSquareNum = sumSquareNum + (number*number);
				count++;
			}
			double avg = sumNum/N;
			double avgSquare = sumSquareNum/N;
			double SD = Math.sqrt(avgSquare - (avg*avg)) ;
			System.out.println(SD);
		}
		else {
			System.out.println(N + "is  not a valid number.");
		}

	}
	
	
	public int findTriangular (int n){
		int result = 0;
		for (int i = 1; i <= n; i++){
			result += i;
		}
		return result;
	}

	public static long fibonacci(int n){
		int previousNum = 1;
		int penultimateNum = 1;
		int currentNum;
		long result;
		if (n >= 0){
			
			if (n == 1 || n == 2){
				return (long)1;
			}
			else {
			
				for (int i = 1; i <= n - 3; i++){
					currentNum = previousNum + penultimateNum;
					previousNum = penultimateNum;
					penultimateNum = currentNum;
					
				}
			result = previousNum + penultimateNum;
			return result;
			}
		}
		else {
			return (long)-1;
		}
		
		
	}
	
}