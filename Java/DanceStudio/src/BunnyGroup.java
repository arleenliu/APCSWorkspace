import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class BunnyGroup implements StudentGroup{
	private Bunny snowflake;
	private Image frontLeftFoot, frontRightFoot, backLeftFoot, backRightFoot;


	private DanceFloor danceFloor;

	private enum State {READY, MOVING, STOPPED}
	private State currentState;

	// Constructor
	public BunnyGroup(DanceFloor df)
	{
		danceFloor = df;
		frontLeftFoot = (new ImageIcon("bunnyFoot.png")).getImage();
		frontRightFoot = (new ImageIcon("bunnyFoot.png")).getImage();
		backLeftFoot = (new ImageIcon("bunnyFoot.png")).getImage();
		backRightFoot = (new ImageIcon("bunnyFoot.png")).getImage();

	}

	// Sets up this group of participants
	public void setup(int floorDir, Dance steps1, Dance steps2)
	{
		int x = danceFloor.getWidth() / 2;
		int y = danceFloor.getHeight() / 2;
		if (floorDir == 0)
		{
			snowflake = new Bunny(x, y + Dancer.PIXELS_PER_INCH * 12, frontLeftFoot, frontRightFoot, backLeftFoot, backRightFoot);
			snowflake.turnLeft();

		}
		else
		{
			snowflake = new Bunny(x, y + Dancer.PIXELS_PER_INCH * 12, frontLeftFoot, frontRightFoot, backLeftFoot, backRightFoot);
			snowflake.turnRight();

		}
		currentState = State.READY;
		danceFloor.update(this);

		//maleHopper.learn(steps1);
	}

	// Moves the group by one step
	public void makeNextStep()
	{
		if (currentState == State.READY)
		{
			snowflake.firstStep();

			currentState = State.MOVING;
		}
		else if (currentState == State.MOVING)
		{
			snowflake.nextStep();

		}
		else if (currentState == State.STOPPED) // never happens
		{
			snowflake.turnAround();

			currentState = State.READY;
		}

		danceFloor.update(this);
	}

	// Draws this group
	public void draw(Graphics g)
	{
		snowflake.draw(g);

	}
}
