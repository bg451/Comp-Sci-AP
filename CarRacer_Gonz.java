//Brandon Gonzaez
// Graphics-Asg3: Car Racing
import java.awt.Color;
import acm.graphics.*;
import acm.program.*;
import java.util.Random;

/**
 * Main class 
 * Creates and initializes three vehicles
 * Vehicles move a random amount between 1-16
 */
public class CarRacer_Gonz extends GraphicsProgram {
  Random generator = new Random();

  public void run() {      
    Vehicle[] car = {new Vehicle(100,100, Color.YELLOW), new Vehicle(100, 200, Color.RED), new Vehicle(100, 300, Color.BLUE)};

    car[0].addTo(this);
    car[1].addTo(this);
    car[2].addTo(this);
    
    GRect finish = new GRect(1000, 0, 10, 5000);
    finish.setFilled(true);
    finish.setFillColor(Color.BLACK);
    add(finish);
    final int finishLine = 1000;

    //start the race
    boolean finished = false;
    String winner = " ";
    while(car[0].getX() < finishLine || car[1].getX() < finishLine || car[2].getX() < finishLine) {
      if(!finished) {
         if(car[0].getX() >= finishLine) {
            finished = true;
            winner = "Car one is the winner!";
         }   
         else if(car[1].getX() >= finishLine) {
            finished = true;
            winner = "Car Two is the winner!";
         } else if(car[2].getX() >= finishLine) {
            finished = true;
            winner = "Car Three is the winner!";
         }   
      }   
      
      int rand;
      if(car[0].getX() < finishLine) {
         rand = (int)( 1 + (generator.nextInt(15)));
         car[0].move(rand, 0);
      }
      if(car[1].getX() < finishLine) {
         rand = (int)( 1 + (generator.nextInt(15)));
         car[1].move(rand, 0);
      }
      if(car[2].getX() < finishLine) {   
         rand = (int)( 1 + (generator.nextInt(15)));
         car[2].move(rand, 0);
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
