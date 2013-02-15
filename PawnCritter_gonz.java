import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class PawnCritter_gonz extends Critter {

  public ArrayList< Actor > getActors() {

    ArrayList< Actor > actors = new ArrayList< Actor >();
    int[] dirs = {Location.HALF_LEFT, Location.HALF_RIGHT};
    for(Location loc: getLocationsInDirections(dirs)) {

      Actor myActor = getGrid().get(loc);
      if(myActor != null)
        actors.add(myActor);
    }
    return actors;
  }

  public Location getMoveLocation() {
    Location loc =  new Location(0,0);
    int[] dir = {Location.AHEAD};
    if(getActors().size() == 0) {
      // Checks if there is an actor in front of it
      Actor myActor = getGrid().get(getLocationsInDirections(dir).get(0));
      // Actor ahead or Not a valid move ie off grid
      if(myActor != null) {
        loc = getLocation();
        //Reverses direction
        setDirection(180);
      } else //if there is nothing in front, it moves up
         loc = getLocationsInDirections(dir).get(0);
    } else {
      Random myRandom = new Random();
      //Randomly choses an actor in the diagonals to consume
      int index = myRandom.nextInt(getActors().size());
      //Moves to the chosen actors location
      Actor myActor = getActors().get(index);
      if(myActor instanceof Rock)
        loc = getLocationsInDirections(dir).get(0);
      else {
        loc = myActor.getLocation();
        processActor(myActor);
      }
    }
    return loc;
  }


  public void makeMove(Location loc) {
    super.makeMove(loc);
  }
  public void act() {
    if (getGrid() == null)
      return;
    Location loc = getMoveLocation();
    makeMove(loc);
  }

    public void processActor(Actor actor)
  {
    if (!(actor instanceof Rock))
      actor.removeSelfFromGrid();
  }

  public ArrayList<Location> getLocationsInDirections(int[] directions) {
    ArrayList<Location> locs = new ArrayList<Location>();
    Grid gr = getGrid();
    Location loc = getLocation();

    for (int d : directions)
    {
      Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
      if (gr.isValid(neighborLoc))
        locs.add(neighborLoc);
    }
    return locs;
  }
}
