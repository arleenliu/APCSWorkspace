// By: Jannie Zhong  Date: 12/9/16
// This project calculates a student GPA based on user input.

import java.util.Scanner;

public class GPACalculator {
	
	public static void main(String[] args) {
		String menuChoice;
		do {
			//Menu to choose what to do---
			Scanner kboard = new Scanner(System.in);
			System.out.println("---MENU---");
			System.out.println("What would you like to do? Type 1 or 2");
			System.out.println("1) GPA Calculator");
			System.out.println("2) Quit");
			System.out.print("-----> ");
			menuChoice = kboard.next();
			
			//paths to take if a choice is chosen
			
			String choice;
			if (menuChoice.equalsIgnoreCase("1")) {
				do {
				 	System.out.print("Enter the number of classes you are taking --> ");
		    	    int N = kboard.nextInt( );
		    	    GPACalculator tester = new GPACalculator();
		    	    tester.calculateGPA(N);
		    	    
		    	    System.out.println("Would you like to calculate another GPA? Type Y or N");
		    	    choice = kboard.next();

				} while (choice.equalsIgnoreCase("Y"));
		    	 
			} else if (menuChoice.equalsIgnoreCase("2")){
					
			} else {
				System.out.println("Error - " + menuChoice + " is not a valid menu option");
			}

		 } while (!menuChoice.equalsIgnoreCase("2"));	
	}
	
	public double calculateGPA (int N){
		
			if (N > 0) {
				Scanner kboard = new Scanner(System.in);
				double total = 0.0;
				String ending = "st";
				int numberGrade = 0;
		
				//Adding the grammatically correct ending to numbers
				for (int i = 1; i <= N; i++){
					if (i == 1){
						ending = "st";
					} else if (i == 2){
						ending = "nd";
					} else if (i == 3){
						ending = "rd";
					} else {
						ending = "th";
					}
					
			//user input, for the their grades		
					System.out.println("Enter the letter grade of your " + i + ending + " class (A-F):");
					String letterGrade = kboard.next();
					
					if (letterGrade.equalsIgnoreCase("A")){
						numberGrade = 4;
					} else if (letterGrade.equalsIgnoreCase("B")){
						numberGrade = 3;
					} else if (letterGrade.equalsIgnoreCase("C")){
						numberGrade = 2;
					} else if (letterGrade.equalsIgnoreCase("D")){
						numberGrade = 1;
					} else if (letterGrade.equalsIgnoreCase("F")){
						numberGrade = 0;
					} else {
						System.out.println(letterGrade + " is not a valid letter grade.");
						return 0;
					}
					total = total + numberGrade;
				}
				//calculating the average (GPA) of the student
				double average = total/N;
				//rounding to 2 decimal places
				average = (int)((average*100) + 0.5)/100.0;
				System.out.println(average);
				return average;
				
		} else if (N == 0){
			System.out.println("If you're taking no classes, why are you using this calculator?");
			return 0.0;
			
		} else {
			System.out.println("You can't take a negative number of classes...Stop trolling the program!");
			return 0.0;
		}
		
	}
}