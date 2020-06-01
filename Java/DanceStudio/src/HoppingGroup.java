import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HoppingGroup implements StudentGroup
{
  private Hopper maleHopper;
  private Image leftMansShoe, rightMansShoe;
 

  private DanceFloor danceFloor;

  private enum State {READY, MOVING, STOPPED}
  private State currentState;

  // Constructor
  public HoppingGroup(DanceFloor df)
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
      maleHopper = new Hopper(x, y + Dancer.PIXELS_PER_INCH * 12, leftMansShoe, rightMansShoe);
      maleHopper.turnLeft();
     
    }
    else
    {
      maleHopper = new Hopper(x, y - Dancer.PIXELS_PER_INCH * 12, leftMansShoe, rightMansShoe);
      maleHopper.turnRight();
  
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
      maleHopper.firstStep();
      
      currentState = State.MOVING;
    }
    else if (currentState == State.MOVING)
    {
      maleHopper.nextStep();
   
    }
    else if (currentState == State.STOPPED) // never happens
    {
      maleHopper.turnAround();
    
      currentState = State.READY;
    }

    danceFloor.update(this);
  }

  // Draws this group
  public void draw(Graphics g)
  {
    maleHopper.draw(g);
   
  }
}
