/*
	This is the ConditionTester template. Use this class to test simple boolean methods!

	Coded by: Jannie Z.
	Date: 11/9/16
	Textbook pg. 191 problem #: 15
*/

import java.util.Scanner;

public class ConditionTester
{
  public static void main(String[ ] args)
  {
	 System.out.println("~~~~~~~~MENU~~~~~~~~~~");
	 System.out.println("A) isPointInRectangle");
	 System.out.println("B) isLeapYear");
	 System.out.println("C) hasTwoEndingZeros");
	 System.out.println("D) isLater");
	 System.out.println("E) getOrderTotal");
	 System.out.println("");
	 System.out.println("---->     ");
	 
	 
    Scanner kboard = new Scanner(System.in);

    String selection = kboard.next();
    
    if (selection.equalsIgnoreCase("A")){
    	 System.out.print("Enter the first number --> ");
    	    int num1 = kboard.nextInt( );

    	    System.out.print("Enter the second number --> ");
    	    int num2 = kboard.nextInt( );
    	    
    	    System.out.print("Enter the third number --> ");
    	    int num3 = kboard.nextInt( );
    	    
    	    System.out.print("Enter the fourth number --> ");
    	    int num4 = kboard.nextInt( );

    	    System.out.print("Enter the fifth number --> ");
    	    int num5 = kboard.nextInt( );
    	    
    	    System.out.print("Enter the six number --> ");
    	    int num6 = kboard.nextInt( );
    	    
    	   
    	    // Change this code so that it calls your testing method.
    	    ConditionTester tester = new ConditionTester();
    	    
    	    boolean result = tester.isPointInRectangle(num1, num2, num3, num4, num5, num6);
    	    System.out.println("The result of the test: " + result);
    	    
    } else if (selection.equalsIgnoreCase("B")){
    	
    	System.out.print("Enter a number --> ");
	    int num1 = kboard.nextInt( );
    	
	    ConditionTester tester = new ConditionTester();
	    boolean result = tester.isLeapYear(num1);
	    System.out.println("The result of the test: " + result);
	    
    } else if (selection.equalsIgnoreCase("C")){
    	
    	System.out.print("Enter a number --> ");
	    int num1 = kboard.nextInt( );
    	
	    ConditionTester tester = new ConditionTester();
	    boolean result = tester.hasTwoEndingZeros(num1);
	    System.out.println("The result of the test: " + result);
    
    } else if (selection.equalsIgnoreCase("D")){
    	 System.out.print("Enter the first number --> ");
    	    int num1 = kboard.nextInt( );

    	    System.out.print("Enter the second number --> ");
    	    int num2 = kboard.nextInt( );
    	    
    	    System.out.print("Enter the third number --> ");
    	    int num3 = kboard.nextInt( );
    	    
    	    System.out.print("Enter the fourth number --> ");
    	    int num4 = kboard.nextInt( );

    	    System.out.print("Enter the fifth number --> ");
    	    int num5 = kboard.nextInt( );
    	    
    	    System.out.print("Enter the six number --> ");
    	    int num6 = kboard.nextInt( );
    	    
    	    ConditionTester tester = new ConditionTester();
    	    boolean result = tester.isLater(num1, num2, num3, num4, num5, num6);
    	   
    	    System.out.println("The result of the test: " + result);

    	    
    } else if (selection.equalsIgnoreCase("E")){
   	 System.out.print("Enter the first number --> ");
   	    int num1 = kboard.nextInt( );

   	    System.out.print("Enter the second number --> ");
   	    int num2 = kboard.nextInt( );
   	    
   	    ConditionTester tester = new ConditionTester();
   	    double cost = tester.getOrderTotal(num1, num2);
   	    
   	    System.out.println("The result of the test: " + cost);
   	    
    } else {
    	System.out.println("Error - " + selection + " is not a menu option.");
    }
    
    
    /*
    // Copy-Paste more of these lines if more input is necessary
    System.out.print("Enter the first number --> ");
    int num1 = kboard.nextInt( );

    System.out.print("Enter the second number --> ");
    int num2 = kboard.nextInt( );
    
    System.out.print("Enter the third number --> ");
    int num3 = kboard.nextInt( );
    
    System.out.print("Enter the fourth number --> ");
    int num4 = kboard.nextInt( );

    System.out.print("Enter the fifth number --> ");
    int num5 = kboard.nextInt( );
    
    System.out.print("Enter the six number --> ");
    int num6 = kboard.nextInt( );
    
   
    // Change this code so that it calls your testing method.
    ConditionTester tester = new ConditionTester();
    
    //boolean result = tester.isPointInRectangle(num1, num2, num3, num4, num5, num6);
    // boolean result = tester.isLeapYear(num1);
    //boolean result = tester.hasTwoEndingZeros(num1);
    boolean result = tester.isLater(num1, num2, num3, num4, num5, num6);
    
    // Printing out the result of the test!
    System.out.println("The result of the test: " + result);

    */
    
  }



  // This method tests the parameters in some way, then returns the result of the test
  public boolean isPointInRectangle (int x, int y, int rectX, int rectY, int rectWidth, int rectHeight)
  {

  	boolean result = false;
  	
  	if(x >= rectX && x <= rectX + rectWidth && y >= rectY && y <= rectY + rectHeight){
  		result = true;
  	}
  	// Complete your if statement (or series of if statements) here
  	// if ...

  	return result;
  }
  
  
  
  
  public boolean isLeapYear(int year) {
	  boolean result = false;
	  if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
		  result = true;
	  }
	  return result;
  }
  

  
  
  public boolean hasTwoEndingZeros (int x) {
	  boolean result = false;
	  if (x % 100 == 0 && x % 1000 != 0) {
		  result = true;
	  }
	  
	  return result;
  }
  
  public boolean isLater (int month1, int day1, int year1, int month2, int day2, int year2) {
	  boolean result = false;
	  if (year1 > year2 || (year1 == year2 && month1 > month2) || (year1 == year2 && month1 == month2 && day1 > day2)) {
		  result = true;
	  }
	  
	  return result;
  }
  
  public static double getOrderTotal(int bp, int nb){
	  
	  double cost = 0;
	  if (bp + nb == 1) {
		  if (bp == 1) {
			  cost = 18.95;
		  }
		  else {
			  cost = 21.95;
		  }
	  }
	  if (bp + nb == 2) {
		 if (nb == 1){
			 cost = 37.95;
		 }
		 if (nb == 0){
			 cost = 2 * 18.95; 
		 }
		 else {
			 cost = 2 * 21.95;
		 }
		 
	  }
	  if (bp + nb >= 3) {
		  if (bp + nb < 12){
			  cost = 15.95 * (bp + nb);
		  }
		  else {
			  cost = 14.00 * (bp + nb);
		  }
	  }
	 
	  return cost;
  }


  
  
}
