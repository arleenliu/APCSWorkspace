
/*
 * 
 * Flowchart Author: Matthew Li
 * 
 */

public class Package {
	
	private double dim1, dim2, dim3, weight;
	private double girth, size;
	
	public Package(double dim1, double dim2, double dim3, double weight) {
		this.dim1 = dim1;
		this.dim2 = dim2;
		this.dim3 = dim3;
		this.weight = weight;
	}
	
	/*
	 * 1 = acceptable
	 * 2 = too heavy
	 * 3 = too large
	 * 4 = too heavy and too large
	 */
	public int checkStatus() {
		double epsilon = 0.000001;
		
		if (dim1 < 0 || dim2 < 0 || dim3 < 0 || weight < 0) {
			throw new IllegalArgumentException("Invalid input.");
		}
		
		// Flowchart code
		if (dim1 > dim2 - epsilon) {
			if (dim1 > dim3 - epsilon) {
				girth = (dim2 + dim3) * 2;
				size = girth + dim1;
			} else {
				double a = dim1;
				dim1 = dim3;
				dim3 = a;
			}
		} else {
			if (dim2 > dim3 - epsilon) {
				double a = dim1;
				dim1 = dim2;
				dim2 = a;
			} else {
				double a = dim1;
				dim1 = dim3;
				dim3 = a;
			}
		}
		
		girth = (dim2 + dim3) * 2;
		size = girth + dim1;
		
		if (weight > 70) {
			if (size > 100) {
				return 4;
			} else {
				return 2;
			}
		} else {
			if (size > 100) {
				return 3;
			} else {
				return 1;
			}
		}
		
	}
	
}
