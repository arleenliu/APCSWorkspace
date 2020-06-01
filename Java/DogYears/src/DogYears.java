/**
 * @(#)DogYears.java
 *

  For testing purposes:
  Dog age of 1 = Human age 13
  Dog age of 2 = Human age 18
  Dog age of 5 = Human age 34
  Dog age of 8 = Human age 50
  Dog age of 12 = Human age 72

 *
 * @author
 * @version
 */

import java.util.Scanner;

public class DogYears {

    public int convertToHumanYears(int dog) {
    	int human = (int)(13+((dog-1)/3.0*16)+0.5);
    	return human;
    }

	
    public int convertToDogYears(int human) {
    	// Work on this once you have finished convertToHumanYears()!
    	int dog = (int)(1+((human-13)/16.0*3)+0.5);
    	return dog;
    }
    

	public static void main (String[] args) {
		// TAKE IN USER INPUT
		Scanner choice = new Scanner(System.in);
		System.out.println("Are you a human or a dog?");
		String choice2 = choice.next();
		
		if(choice2 == "DOG"){
			
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your dog age:");
		int dog = keyboard.nextInt();
		
		DogYears converterToHuman = new DogYears();
		int human = converterToHuman.convertToHumanYears(dog);
		
		
		// PRINT OUT THE RESULT
		System.out.println("Your age in human years is " + human);
		}
		if(choice2=="HUMAN"){
		Scanner keyboard2 = new Scanner(System.in);
		System.out.print("Enter your human age:");
		int human2 = keyboard2.nextInt();
		
		
		DogYears converterToDog = new DogYears();
		int dog2 = converterToDog.convertToDogYears(human2);
		
		// PRINT OUT THE RESULT
		System.out.println("Your age in dog years is " + dog2);
		}
		

		
		/*System.out.println("Would you like to stop?");
		String choice = keyboard.next();
		
		(for (int x = 0; x < 100; x++) {
		
		if (choice == "QUIT") {
			System.exit(0);
		}
		if (choice == "NO") {
		System.out.print("Enter your human age:");
		int human2 = keyboard.nextInt();
		int dog2 = converterToDog.convertToDogYears(human2);
		
		// PRINT OUT THE RESULT
		System.out.println("Your age in dog years is " + dog2);
		System.out.println("Would you like to stop?");
		String choice2 = keyboard.next();
		}
		}*/
	}

}