import java.util.Scanner;

/*
 * Parts 1 through 4 are all completed, and Bonus C has been added as well.
 */ 

public class BlackJack3 {

	public static void main(String[] args) {
		int x = 0;
		int playerCard1 = (int)(12 * Math.random() + 1);
		int playerCard2 = (int)(12 * Math.random() + 1);
		int dealerCard1 = (int)(12 * Math.random() + 1);
		int dealerCard2 = (int)(12 * Math.random() + 1);
		
		if (playerCard1 == 11 || playerCard1 == 12 || playerCard1 == 13) {
			playerCard1 = 10;
		}
		if (playerCard2 == 11 || playerCard2 == 12 || playerCard2 == 13) {
			playerCard2 = 10;
		}
		if (dealerCard1 == 11 || dealerCard1 == 12 || dealerCard1 == 13) {
			dealerCard1 = 10;
		}
		if (dealerCard2 == 11 || dealerCard2 == 12 || dealerCard2 == 13) {
			dealerCard2 = 10;
		}
		
		int dealerTotal = dealerCard1 + dealerCard2;
		int playerTotal = playerCard1 + playerCard2;
		
		System.out.println("Dealer's cards: " + dealerCard1 + " " + dealerCard2 + " Total = " + dealerTotal);
		System.out.println("Your cards: " + playerCard1 + " " + playerCard2 + " Total = " + playerTotal);
		
		Scanner sc= new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println();
			System.out.println("Press 1 to hit or press 2 to stay -->");
			choice = sc.nextInt();
			int nextCard = 0;
			
			if (choice == 1) {
				nextCard = (int)(12 * Math.random() + 1);
				System.out.println("You were dealt a(n) " + nextCard + ".");
				
				if (nextCard == 11 || nextCard == 12 || nextCard == 13) {
					nextCard = 10;
				} 
				
				playerTotal += nextCard;
				System.out.println("Your total is now " + playerTotal + ".");
			} else if (choice == 2) {
				System.out.println("You stayed.");
				System.out.println();
			}
		} while (playerTotal < 21 && choice != 2);
		
		while(dealerTotal < 17) {
			int nextCard = (int)(12 * Math.random() + 1);
			System.out.println("The dealer was dealt a " + nextCard + ".");
			if (nextCard == 11 || nextCard == 12 || nextCard == 13) {
				nextCard = 10;
			} 
			dealerTotal += nextCard;
			System.out.println("The dealer's total is now " + dealerTotal + ".");
		}
		System.out.println();
		if (playerTotal == dealerTotal && playerTotal <= 21) {
			System.out.println("You tie.");
		} else if ((dealerTotal > 21 || playerTotal > dealerTotal) && playerTotal <= 21) {
			System.out.println("You win!");
		} else {
			System.out.println("You lose!");
		}
	}
}
