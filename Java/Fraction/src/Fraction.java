// Represents a fraction with an int numerator and int denominator
// and provides methods for adding and multiplying fractions.

public class Fraction
{
  // *** instance variables ***
  private int num;
  private int denom;

  // *** Constructors ***

  public Fraction()       // no-args constructor
  {
    num = 0;
    denom = 1;
  }

  public Fraction(int n)
  {
    num = n;
    denom = 1;
  }

  public Fraction(int n, int d)
  {
    if (d != 0)
    {
      num = n;
      denom = d;
      reduce();
    }
    else
    {
      throw new IllegalArgumentException(
           "Fraction construction error: denominator is 0");
    }
  }

  public Fraction(Fraction other)  // copy constructor
  {
    num = other.num;
    denom = other.denom;
  }
  
  public Fraction (double var){

	  double var2 = var;
	  int numOf10 = 0;
	  int limit = 5;
	 
	  //System.out.println("double constructor: the number is " + var);

	  //System.out.println("denom = " + denom);

	  
	 while(var2 != (int)(var2) && limit > 0){
		 var2 *= 10;
		 numOf10 += 1;
		 limit--;
	 }
	 
	 
	  denom = (int) Math.pow(10, numOf10);
	  
//	  System.out.println("numOf10 = " + numOf10);
//	  System.out.println("denom = " + denom);

	  
	  num = (int) var2;
	  
	  
	 // System.out.println("num is " + num + " and denom = " + denom);
	  
	  
	  reduce();
	  
	  /*num = 0;
	  denom = 1;
	  
	  
	  while (var != (double)num/denom){
		  while (var < (num + 0.0)/denom){
			  num++;
		  }
		  while (var > (double)num/denom){
			  denom++;
		  }
	  }
	  
	  reduce();
	*/  
  }

  // *** public methods ***

  // Returns the sum of this fraction and other
  public Fraction add(Fraction other)
  {
    int newNum = num * other.denom + denom * other.num;
    int newDenom = denom * other.denom;
    return new Fraction(newNum, newDenom);
  }

  // Returns the sum of this fraction and m
  public Fraction add(int m)
  {
    return new Fraction(num + m * denom, denom);
  }
  
  public Fraction subtract(Fraction f) {
	  int newNum = num * f.denom - denom * f.num;
	    int newDenom = denom * f.denom;
	    return new Fraction(newNum, newDenom);
  }
  
  public Fraction subtract(int m){
	  return new Fraction(num - m * denom, denom);
  }

  // Returns the product of this fraction and other
  public Fraction multiply(Fraction other)
  {
    int newNum = num * other.num;
    int newDenom = denom * other.denom;
    return new Fraction(newNum, newDenom);
  }

  // Returns the product of this fraction and m
  public Fraction multiply(int m)
  {
    return new Fraction(num * m, denom);
  }

  public Fraction divide(Fraction f){
	  int newNum = num * f.denom;
	  int newDenom = denom * f.num;
	  return new Fraction(newNum, newDenom);
  }
  public Fraction divide (int m){
	    return new Fraction(num, denom * m);
  }
  // Returns the value of this fraction as a double
  public double getValue()
  {
    return (double)num / (double)denom;
  }

  // Returns a string representation of this fraction
  public String toString()
  {
    return num + "/" + denom;
  }
  
  public int round(){
	  double deciInt = (double)num/denom;
	  deciInt += 0.5;
	  int roundInt = (int)deciInt;
	  
	  return roundInt;
  }
  
  public double takeRoot (int pow){
	  double newNum = Math.pow(num, 1.0/pow);
	  double newDenom = Math.pow(denom, 1.0/pow);
	  double root = newNum/newDenom;
	  
	  
	  
	  return root;
  }
  

  // *** private methods ***

  // Reduces this fraction by the gcf and makes denom > 0
  private void reduce()
  {
    if (num == 0)
    {
      denom = 1;
      return;
    }

    if (denom < 0)
    {
      num = -num;
      denom = -denom;
    }

    int q = gcf(Math.abs(num), denom);
    num /= q;
    denom /= q;    
  }

  //  Returns the greatest common factor of two positive integers
  private int gcf(int n, int d)
  {
    if (n <= 0 || d <= 0)
    {
      throw new IllegalArgumentException(
                  "gcf precondition failed: " + n + ", " + d);
    }

    if (n % d == 0)
      return d;
    else if (d % n == 0)
      return n;
    else
      return gcf(n % d, d % n); 
  }
}
