
/**
 * @(#)Fibonacci.java
 *
 *
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

	// 20th Fibonacci number is 6765
	public static long computeFibonacci(int x) {

		if (x < 0) {
			throw new IllegalArgumentException("Invalid input. Try again.");
		}

		if (x == 1 || x == 0) {
			return x;
		} else {
			long answer = computeFibonacci(x - 2) + computeFibonacci(x - 1);
			return answer;
		}

	}

	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		boolean tryAgain = true;

		while (tryAgain) {
			try {
				System.out.print("Which fibonacci number would you like to find? --> ");
				int x = kboard.nextInt();
				long answer = computeFibonacci(x);
				System.out.println("The " + x + " fibonacci number is " + answer + ".");
				tryAgain = false;
			} catch (InputMismatchException e) {
				System.out.println("Wrong input type. Try again.");
				
			} catch (IllegalArgumentException e) {
				

			} catch (StackOverflowError e) {// need a 3rd one
				System.out.println("Stack full, infinite recursion.");
			}
		}
	}

}
