import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int input1;
		double input2;
		TaxCalculator tc;

		System.out.println("Married or single? (1 for single, 2 for married)");
		input1 = s.nextInt();

		System.out.println("Income? (in dollars, i.e. 45000)");
		input2 = s.nextDouble();

		tc = new TaxCalculator(input1, input2);

		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String output = nf.format(tc.calculateTax());

		System.out.println("Your tax is: " + output);

	}

}
