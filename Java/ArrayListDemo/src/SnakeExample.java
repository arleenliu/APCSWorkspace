import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.geom.*;


/**
 * 
 * This class is a practical example of using ArrayLists along with an animation "run" loop.
 * 
 * @author john_shelby
 *
 */

class GamePane extends JPanel implements KeyListener {
	Point2D.Double startLocation;
	double startDirection;

private aSnake ego;
private ArrayList<Yummy> yummies;
private Arena level;
private String stats;

	GamePane() {
		level = new Arena();
		startLocation = new Point2D.Double(315,15);
		startDirection = Math.PI * 1.5;

		ego = new aSnake(startLocation,startDirection);

		yummies = new ArrayList<Yummy>();
		for (int x = 0; x < 5; x++) generateAYummy();

		updateStats();

	}

	void updateStats () {
		stats = ego.toString();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setBackground(Color.white);
		g2.clearRect(0,0,getWidth(),getHeight());

		for (int a = 0; a < yummies.size(); a++) {
			try {
				yummies.get(a).draw(g2);
			} catch (ArrayIndexOutOfBoundsException e) {}
		}

		level.draw(g2);

		g2.drawString(stats,50,345);

		ego.draw(g2);
	}

	void generateAYummy() {
		Yummy temp = new Yummy();
		while (temp.testBounced(ego.snakeParts) || temp.testBounced(level.walls) || temp.testBounced(yummies)) temp.randomizeMe();
		yummies.add(temp);
	}

	public void run() {
		while(true) {

			if (ego.alive) {
				ego.grow();
				if (ego.growTime == 0) ego.shrink(); else ego.growTime--;
				if (ego.testAteAYummy(yummies)) generateAYummy();
				ego.testCrashed(null);
				ego.testCrashed(level.walls);
			}
			int yumSize = yummies.size();
			for (int x = 0; x < yumSize; x++) {
				Yummy temp = yummies.get(x);
				if (!temp.testBounced(level.walls) && !temp.testBounced(ego.snakeParts)) temp.testBounced(yummies);
			}
			for (int x = 0; x < yumSize; x++) {
				Yummy temp = yummies.get(x);
				temp.move();
			}
			updateStats();
			repaint();

			try {
                Thread.sleep(10);
			} catch (InterruptedException e) {}

		}
	}

	public static void main(String[] args) {
	    JFrame frame = new JFrame();

	    frame.setTitle("Snake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		GamePane field = new GamePane();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(field,BorderLayout.CENTER);
		frame.addKeyListener(field);
		frame.setSize(650,380);
        frame.setVisible(true);
        
        
        field.run();
    }


	public void keyTyped(KeyEvent e) { }

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_LEFT) {
			ego.turn(1);
		}
		else if (code == KeyEvent.VK_RIGHT) {
			ego.turn(-1);
		}
		else if (code == KeyEvent.VK_SPACE) ego.newSnake(startLocation,startDirection);
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_LEFT || code == KeyEvent.VK_RIGHT) {
			ego.turn(0);
		}
	}
}