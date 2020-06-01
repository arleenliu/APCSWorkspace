import java.util.Scanner;

public class Hangman
{
  private static String[] words = {"inheritance", "abstraction", "encapsulation", "polymorphism"};

  public static void main(String[] args)
  {

    Scanner input = new Scanner(System.in);
    String word = words[(int)(Math.random() * words.length)];
    HangmanGame game = new HangmanGame(word);
    int count = 0;
    int failedGuesses = 0;

    boolean done = false;
    while (!done)
    {
      //int failedNum = failedGuesses.length();
      System.out.println("Tried: " + game.getTried());
      System.out.println("Failed guesses: " + failedGuesses);
      System.out.println(game.getGuessed());
      
      System.out.println("   ______     ");
      System.out.println("  |      |   ");
      System.out.println("  |     ( ) ");
      System.out.println("  |     \\|/              ");
      System.out.println("  |      |  ");
      System.out.println("  |     / \\   ");
      System.out.println("  ~~~~~~~~~~~");
      
      
      
      
      System.out.println();

      System.out.print("Enter next letter (or Quit): ");
      String s = input.next();
      if ("quit".equalsIgnoreCase(s))
        break;
      if (s.length() != 1)
      {
        System.out.println("\nInvalid input");
      }
      else
      {
        int result = game.tryLetter(s.charAt(0));
        switch(result)
        {
          case 0:

          System.out.println("\nAlready tried");
          break;
          
          case -1:

          System.out.println("\nSorry, not there");
          failedGuesses++;
          break;

          case 1:

          System.out.println("\nYes!");
          break;
        }
      }

      count++;

      if (game.getGuessed().indexOf('_') == -1)
      {
        System.out.println("\nYou guessed " + word + " in " + count + " tries.");
        done = true;
      }
    }
  }  
}
