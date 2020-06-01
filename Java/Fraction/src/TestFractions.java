public class TestFractions
{
  public static void testConstructors()
  {
    Fraction f1 = new Fraction();
    Fraction f2 = new Fraction(7);
    Fraction f3 = new Fraction(12, -20);
    Fraction f4 = new Fraction(f3);
    Fraction f5 = new Fraction(0.25);
    Fraction f6 = new Fraction(1.5);
    Fraction f7 = new Fraction(-0.125);
    Fraction f8 = new Fraction(0.0);
    Fraction f9 = new Fraction(0.17);
    Fraction f10 = new Fraction(1.0/3.0);
    Fraction f11 = new Fraction(5.0E-9);
    Fraction f12 = new Fraction(1000000.5);
    Fraction f13 = new Fraction(Math.PI);
    Fraction f14 = new Fraction(Math.E);
    Fraction f15 = new Fraction(Double.MAX_VALUE);


    
    System.out.println("f1 = " + f1);
    System.out.println("f2 = " + f2);
    System.out.println("f3 = " + f3);
    System.out.println("f4 = " + f4);
    System.out.println("f5 = " + f5);
    System.out.println("f6 = " + f6);
    System.out.println("f7 = " + f7);
    System.out.println("f8 = " + f8);
    System.out.println("f9 = " + f9);
    System.out.println("f10 = " + f10);
    System.out.println("f11 = " + f11);
    System.out.println("f12 = " + f12);
    System.out.println("f13 = " + f13);
    System.out.println("f14 = " + f14);
    System.out.println("f15 = " + f15);

    System.out.println();
    
    
  }

  public static void testArithmetic()
  {
    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(1, 3);
    Fraction f3 = new Fraction(4, 5);

    Fraction sum = f1.add(f2);
    System.out.println(f1 + " + " + f2 + " = " + sum);

    
    Fraction product = f1.multiply(f2);
    System.out.println(f1 + " * " + f2 + " = " + product);
    
    
    Fraction subtract = f1.subtract(f2);
    System.out.println(f1 + " - " + f2 + " = " + subtract);
   
    Fraction subtract1 = f2.subtract(f3);
    System.out.println(f2 + " - " + f3 + " = " + subtract1);
   
    Fraction subtract2 = f1.subtract(f3);
    System.out.println(f1 + " - " + f3 + " = " + subtract2);
    
    Fraction subtract3 = f3.subtract(f2);
    System.out.println(f3 + " - " + f2 + " = " + subtract3);
    
    Fraction subtract4 = f1.subtract(2);
    System.out.println(f1 + " - " + "2" + " = " + subtract4);
    
    Fraction subtract5 = f3.subtract(-5);
    System.out.println(f1 + " - " + "-5" + " = " + subtract5);

    Fraction f4 = new Fraction(1, 8);
    Fraction f5 = new Fraction(1, 27);
    Fraction f6 = new Fraction(64, 125);
    
    
    Fraction divide = f1.divide(f2);
    System.out.println(f1 + " / " + f2 + " = " + divide);
    
    double root1 = f4.takeRoot(3);
    System.out.println("sqrt(" + f4 + ") = " + root1);
    
    double root2 = f5.takeRoot(3);
    System.out.println("sqrt(" + f5 + ") = " + root2);
    
    double root3 = f6.takeRoot(3);
    System.out.println("sqrt(" + f6 + ") = " + root3);
    
    Fraction f7 = new Fraction(8, 1);
    Fraction f8 = new Fraction(5, 2);
    Fraction f9 = new Fraction(125, 64);
    
    int round1 = f7.round();
    System.out.println(f7 + " ≈ " + round1);
    
    int round2 = f8.round();
    System.out.println(f8 + " ≈ " + round2);
    
    int round3 = f9.round();
    System.out.println(f9 + " ≈ " + round3);
    

    System.out.println();
  }

  public static void testValues()
  {
    Fraction f = new Fraction(2, 3);
    System.out.println(f + " = " + f.getValue());
    System.out.println();
  }

  public static void main(String[] args)
  {
    testConstructors();
    testArithmetic();
    testValues();
  }
}
