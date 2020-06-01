
import java.util.Scanner;

//I got through part 1, 2, and 3. 
//Part 4  kind of works for hit, but not for stay.
//I didn't get to the bonuses.

public class BlackJack1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int player1;
		int player2;
		int dealer1;
		int dealer2;
		
		player1 = (int)(Math.random() * 13.0 + 0.5);
		player2 = (int)(Math.random() * 13.0 + 0.5);
		dealer1 = (int)(Math.random() * 13.0 + 0.5);
		dealer2 = (int)(Math.random() * 13.0 + 0.5);
		
		System.out.println("Player : " + player1 + "  " + player2);
		System.out.println("Dealer : " + dealer1 +  "  " + dealer2);
		
		int playerTotal;
		int dealerTotal;
		int result;
		
		if(player1 > 10)
		{
			player1 = 10;
		}
		if(player2 > 10)
		{
			player2 = 10;
		}
		if(dealer1 > 10)
		{
			dealer1 = 10;
		}
		if(dealer2 > 10)
		{
			dealer2 = 10;
		}
		
		playerTotal = player1 + player2;
		dealerTotal = dealer1 + dealer2;
		
		System.out.println("\n");
		System.out.println("Player total = " + playerTotal);
		System.out.println("Dealer total = " + dealerTotal);
	
		String hitStay;
		int newPlayerTotal;
		
		
		do
		{
		Scanner kboard = new Scanner(System.in);
		System.out.println("Hit or Stay?");
		hitStay = kboard.next();
		
		int player3;
		
		if(hitStay.equals("hit"))
		{
			player3 = (int)(Math.random() * 13.0 + 0.5);
			newPlayerTotal = playerTotal + player3;
		}
		else if(hitStay.equals("stay"))
		{
			player3 = 0;
			newPlayerTotal = playerTotal;
		}
		else
		{
			System.out.println("I'm sorry that is not an option.");
			player3 = 0;
			newPlayerTotal = playerTotal;
		}
		
		System.out.println("New player total = " + newPlayerTotal);
		} while(!hitStay.equals("stay"));
		
		
		if((newPlayerTotal > dealerTotal) && newPlayerTotal <= 21)
		{
			result = 1;
		}
		else if((newPlayerTotal <= 21) && (dealerTotal <= 21) && (newPlayerTotal == dealerTotal))
		{
			result = 0;
		}
		else if(dealerTotal > 21)
		{
			result = 1;
		}
		else
		{
			result = -1;
		}
		
		System.out.println("\n");
		
		if(result == 1)
		{
			System.out.println("Player wins");
		}
		else if(result == 0)
		{
			System.out.println("It's a draw");
		}
		else
		{
			System.out.println("Dealer wins");
		}
	
	}




}
