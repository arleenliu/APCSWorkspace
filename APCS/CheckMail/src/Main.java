import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	/*
	 * 1 = acceptable
	 * 2 = too heavy
	 * 3 = too large
	 * 4 = too heavy and too large
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		double[] input1 = new double[3];
		double input2;
		int result = 0;
		Package tc;

		System.out.println("Enter dimensions, separated by commas.");
		String x = s.nextLine().replace(" ", "");
		String[] y = x.split(",");
		
		for (int i = 0; i < y.length; i++) {
			input1[i] = Double.parseDouble(y[i]);
		}
		
		System.out.println("Enter weight");
		input2 = s.nextDouble();

		tc = new Package(input1[0], input1[1], input1[2], input2);
		result = tc.checkStatus();
		
		if (result == 1) {
			System.out.println("Package is acceptable.");
		} else if (result == 2) {
			System.out.println("Package is too heavy.");
		} else if (result == 3) {
			System.out.println("Package is too large.");
		} else {
			System.out.println("Package is too heavy and too large.");
		}
		

	}

}
