import java.util.Scanner;

public class Multiplier {

	public static void main(String[] args) {

		System.out.println("Enter an integer:");

		Scanner keyBoard = new Scanner(System.in);

		int int1 = keyBoard.nextInt();

		System.out.println("Enter another integer:");

		int int2 = keyBoard.nextInt();

		System.out.println(int1 + " * " + int2 + " = " + (int1 * int2));


	}
}
