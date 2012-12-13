import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import java.util.Random;

/**
 * Main class 
 * Creates and initializes three vehicles
 * 
 */
public class CarRacer_Gonz extends GraphicsProgram {
  Random generator = new Random();

  public void run() {      
    Vehicle carOne = new Vehicle(100,100, Color.YELLOW);
    carOne.addTo(this);

    Vehicle carTwo = new Vehicle(100, 200, Color.RED);
    carTwo.addTo(this);
    
    Vehicle carThree = new Vehicle(100, 300, Color.BLUE);
    carThree.addTo(this);
    
    GRect finish = new GRect(1000, 0, 10, 5000);
    finish.setFilled(true);
    finish.setFillColor(Color.BLACK);
    add(finish);
    final int finishLine = 1000;

    //start the race
    boolean finished = false;
    String winner = " ";
    while(carOne.getX() < finishLine || carTwo.getX() < finishLine || carThree.getX() < finishLine) {
      if(!finished) {
         if(carOne.getX() >= finishLine) {
            finished = true;
            winner = "Car one is the winner!";
         }   
         else if(carTwo.getX() >= finishLine) {
            finished = true;
            winner = "Car Two is the winner!";
         }else if(carThree.getX() >= finishLine) {
            finished = true;
            winner = "Car Three is the winner!";
         }   
      }   
      if(carOne.getX() < finishLine) {
         int rand = (int)( 1 + (generator.nextFloat() * (12 - 1) ));
         carOne.move(rand, 0);
      }
      if(carTwo.getX() < finishline) {
         rand = (int)( 1 + (generator.nextFloat() * (12 - 1) ));
         carTwo.move(rand, 0);
      }
      if(carThree.getX() < finishLine) {   
         rand = rand = (int)( 1 + (generator.nextFloat() * (12 - 1) ));
         carThree.move(rand, 0);
      }
      pause(20);
    }
    
    GLabel test = new GLabel(winner,50, 60);
    add(test);
  }

  public static void main(String[] args) {
    new CarRacer_Gonz().start(args);
  }
}
/**
 * This is the vehicle class
 * Every instance creates a basic car that has a move function
 * and a getX function that allows for a check
 */
class Vehicle
{
  private int xLoc = 0;
  private int yLoc = 0;
  private GRect body;
  private GRect window;
  private GOval frontBumper, backBumper;
  private GOval wheel1, wheel2;
  
  public Vehicle(int xLoc, int yLoc, Color color) {
    this.xLoc = xLoc;
    this.yLoc = yLoc;

    body = new GRect(xLoc, yLoc, 100, 50);
    backBumper = new GOval(xLoc - 10, yLoc + 23, 25, 25);
    wheel1 = new GOval(xLoc + 15, yLoc + 40, 20, 20);
    wheel2 = new GOval(xLoc + 65, yLoc + 40,20, 20);

    body.setFilled(true);
    body.setFillColor(color);
    body.setColor(color);
    backBumper.setFilled(true);
    backBumper.setFillColor(color);
    backBumper.setColor(color);
    wheel1.setFilled(true);
    wheel1.setFillColor(Color.BLACK);

    wheel2.setFilled(true);
    wheel2.setFillColor(Color.BLACK);
  }

  public void addTo(GraphicsProgram gp) {
    gp.add(body);
    gp.add(backBumper);
    gp.add(wheel1);
    gp.add(wheel2);
  }

  public void move(int dx, int dy) {
    body.move(dx, dy);
    backBumper.move(dx, dy);
    wheel1.move(dx, dy);
    wheel2.move(dx, dy);
  }
  public int getX() {
    return (int)body.getX();
  }

}
