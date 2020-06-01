/*
 * 
 *These classes are taking in the fields that would be the property of an user so getting the calculate tax could be taken from an other class
 *You should provide an example of entering the income because putting a comma will give you an error. 
 *Instead of saying invalid input specify relating to the actual error
 *
 *1) 7 relational operators 
 *2) 6 relational operators
 *3) 4 relational operators
 *4) 4 relational operators
 */
public class TaxCalculator {

	private int status;
	private double income;

	public TaxCalculator(int status, double income) {
		this.status = status;
		this.income = income;
	}

	public double calculateTax() {
		if (status == 1) {
			if (income >= 0) {
				if (income <= 27050) {
					return 0.15 * income;
				} else if (income <= 65550) {
					return 0.275 * (income - 27050) + 4057.5;
				} else if (income <= 136750) {
					return 0.305 * (income - 65550) + 14645;
				} else if (income <= 297350) {
					return 0.355 * (income - 136750) + 36361;
				} else {
					return 0.391 * (income - 297350) + 93374;
				}
			} else {
				throw new IllegalArgumentException("Invalid input.");
			}
		} else if (status == 2) {
			if (income >= 0) {
				if (income <= 45200) {
					return 0.15 * income;
				} else if (income <= 109250) {
					return 0.275 * (income - 45200) + 6780;
				} else if (income <= 166500) {
					return 0.305 * (income - 109250) + 24393.75;
				} else if (income <= 297350) {
					return 0.355 * (income - 166500) + 41855;
				} else {
					return 0.391 * (income - 297350) +  88306;
				}
			} else {
				throw new IllegalArgumentException("Invalid input.");
			}
		} else {
			throw new IllegalArgumentException("Invalid input.");
		}
	}
}
