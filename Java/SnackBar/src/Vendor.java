/*
   This class implements a vendor that sells one kind of items.
   A vendor carries out sales transactions.
*/

public class Vendor
{
  // Fields:
	private int numItems;
	private int price;
	private int moneyIn;
	private int changeOut;
	private static int totalSales;
	
	
	
	
	private static int numSales;
	
	
  //  Constructor
  //  Parameters:
  //    int price of a single item in cents
  //    int number of items to place in stock
  public Vendor (int priceOfProduct, int numItemsToAdd)
  {
	  numItems = numItemsToAdd;
	  moneyIn = 0;
	  price = priceOfProduct;
	  changeOut = 0;


  }

  //  Sets the quantity of items in stock.
  //  Parameters:
  //    int number of items to place in stock
  //  Return:
  //    None
  public void setStock (int s)
  {
    numItems = s;
  }

  //  Returns the number of items currently in stock.
  //  Parameters:
  //    None
  //  Return:
  //    int number of items currently in stock
  public int getStock ()
  {
    return numItems;
  }

  //  Adds a specified amount (in cents) to the deposited amount.
  //  Parameters:
  //    int number of cents to add to the deposit
  //  Return:
  //    None
  public void addMoney(int numCents)
  {
    moneyIn = moneyIn + numCents;
  }

  //  Returns the currently deposited amount (in cents).
  //  Parameters:
  //    None
  //  Return:
  //    int number of cents in the current deposit
  public int getDeposit ()
  {
    return moneyIn;
  }

  //  Implements a sale.  If there are items in stock and
  //  the deposited amount is greater than or equal to
  //  the single item price, then adjusts the stock
  //  and calculates and sets change and returns true;
  //  otherwise refunds the whole deposit (moves it into change)
  //  and returns false.
  //  Parameters:
  //    None
  //  Return:
  //    boolean successful sale (true) or failure (false)
  public boolean makeSale()
  {
	  if (numItems >= 1 && moneyIn >= price){
		  numItems--;
		  totalSales += price;
		  changeOut = moneyIn - price;
		  moneyIn = 0;
		  numSales++;
		  return true;
	  } else{
		  changeOut = moneyIn;
		  moneyIn = 0;
		  return false;
	  }
  }

  //  Returns and zeroes out the amount of change (from the last
  //  sale or refund).
  //  Parameters:
  //    None
  //  Return:
  //    int number of cents in the current change
  public int getChange()
  {
    int change = changeOut;
    changeOut = 0;
	return change;
  }
  
  public int returnMoney()
  {
	  changeOut = moneyIn;
	  moneyIn = 0;
	  int change = changeOut;
	  changeOut = 0;
	  return change;
  }
  public static double getTotalSales(){
	  double x = totalSales/100.0;
	  totalSales = 0;
	  return x;
  }
  public static int getNumSales(){
	 
	  int x = numSales;
	  numSales = 0;
	  return x;
  }


}
