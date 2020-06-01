import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Object.*;
	import java.text.Format;
	import java.text.NumberFormat;
	import java.text.DecimalFormat;


public class CrapsStats extends JFrame
    implements ActionListener
{
  private CrapsGame game;
  private JTextField numberIn, statsOut;

  // Constructor
  public CrapsStats()
  {
    super("Craps test");

    Container c = getContentPane();
    c.setLayout(new FlowLayout());

    c.add(new JLabel("Number of games to run:"));

    numberIn = new JTextField(5);
    numberIn.addActionListener(this);
    c.add(numberIn);

    statsOut = new JTextField(18);
    statsOut.setEditable(false);
    c.add(statsOut);

    game = new CrapsGame();
  }

  // Called when a number is entered in the numberIn text field
  public void actionPerformed(ActionEvent e)
  {
    String s = numberIn.getText();
    int nGames = Integer.parseInt(s);
    int result, gameCount = 0, winCount = 0;
    Die die1 = new Die();
    Die die2 = new Die();
    while (gameCount < nGames)
    {
      die1.roll();
      die2.roll();
      int total = die1.getNumDots() + die2.getNumDots();
      result = game.processRoll(total);
      if (result != 0)
        gameCount++;
      if (result > 0)
        winCount++;
    }
    numberIn.setText("");
    NumberFormat nf = NumberFormat.getPercentInstance();
    double percentWon = (double)winCount/gameCount;
    String percentWonString = nf.format(percentWon);
    statsOut.setText(" Games: " + gameCount + " Percent of Wins: " + percentWonString);
  }

  public static void main(String args[])
  {
    CrapsStats window = new CrapsStats();
    window.setBounds(100, 100, 300, 100);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setVisible(true);
  }
}

