import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RandomHoppingGroup implements StudentGroup
{
  private RandomHopper maleRandomHopper;
  private Image leftMansShoe, rightMansShoe;
 

  private DanceFloor danceFloor;

  private enum State {READY, MOVING, STOPPED}
  private State currentState;

  // Constructor
  public RandomHoppingGroup(DanceFloor df)
  {
    danceFloor = df;
    leftMansShoe = (new ImageIcon("leftshoe.gif")).getImage();
    rightMansShoe = (new ImageIcon("rightshoe.gif")).getImage();
   
  }

  // Sets up this group of participants
  public void setup(int floorDir, Dance steps1, Dance steps2)
  {
    int x = danceFloor.getWidth() / 2;
    int y = danceFloor.getHeight() / 2;
    if (floorDir == 0)
    {
      maleRandomHopper = new RandomHopper(x, y + Dancer.PIXELS_PER_INCH * 12, leftMansShoe, rightMansShoe);
      maleRandomHopper.turnLeft();
     
    }
    else
    {
      maleRandomHopper = new RandomHopper(x, y - Dancer.PIXELS_PER_INCH * 12, leftMansShoe, rightMansShoe);
      maleRandomHopper.turnRight();
  
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
      maleRandomHopper.firstStep();
      
      currentState = State.MOVING;
    }
    else if (currentState == State.MOVING)
    {
      maleRandomHopper.nextStep();
   
    }
    else if (currentState == State.STOPPED) // never happens
    {
      maleRandomHopper.turnAround();
    
      currentState = State.READY;
    }

    danceFloor.update(this);
  }

  // Draws this group
  public void draw(Graphics g)
  {
    maleRandomHopper.draw(g);
   
  }
}
