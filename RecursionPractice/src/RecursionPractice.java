
/*
 * Hanoi(1) = 1
 * Hanoi(2) = 3
 * Hanoi(3) = 7
 * Hanoi(4) = 15
 * Hanoi(5) = 31
 * Hanoi(6) = 63
 * Hanoi(7) = 127
 * Hanoi(8) = 255
 * Hanoi(9) = 511
 * Hanoi(10) = 1023
 * 
 */

public class RecursionPractice {
	
	private static int count = 0;

	public static int triangleNumber(int n) {
		if (n == 1)
			return 1;
		else
			return n + triangleNumber(n - 1);
	}

	public static int squareNumber(int n) {
		if (n == 1)
			return 1;
		else
			return squareNumber(n - 1) + 2 * n - 1;
	}

	public static int logBase2(int n) {
		if (n == 1)
			return 0;
		else
			return 1 + logBase2(n / 2);
	}

	public static int pow(int n) {
		if (n == 0)
			return 1;
		else
			return 2 * pow(n - 1);
	}

	public static int pentagonalNumber(int n) {
		if (n == 1)
			return 1;
		else
			return 1 + (n - 1) * 3 + pentagonalNumber(n - 1);
	}
	
	public static int findFibonacciRecursion(int n) {
		
		count++;
		
		if (n == 1 || n == 0) {
			return n;
		} else {
			return findFibonacciRecursion(n-1) + findFibonacciRecursion(n-2);
		}
	}
	
	public static int findFibonacciIteration(int n) {
		int num1 = 1;
		int num2 = 1;
		
		for (int i = 0; i < n - 2; i++) {
			if (num1 >= num2) {
				num2 += num1;
			} else {
				num1 += num2;
			}
		}
		
		if (num1 >= num2) {
			return num1;
		} else {
			return num2;
		}
		
	}
	
	public static void printHanoiSolution(int numberOfDisks) {
		printHanoiSolution(numberOfDisks, 1, 3);
	}
	
	private static void printHanoiSolution(int numDisks, int startPeg, int endPeg) {
		count++;
		int otherPeg = 6 - (startPeg + endPeg);
		if (numDisks == 1) {
			System.out.println("Place the top disk from peg #" + startPeg + " onto peg #" + endPeg);
		} else {
			printHanoiSolution(numDisks - 1, startPeg, otherPeg);
			System.out.println("Place the top disk from peg #" + startPeg + " onto peg #" + endPeg);
			printHanoiSolution(numDisks - 1, otherPeg, endPeg);
		}
	}

	public static void main(String[] args) {
		int n = 3;
		printHanoiSolution(10);
		// System.out.println("The " + n + "th fibonacci number is " + test);
		System.out.println(count);
	}

}