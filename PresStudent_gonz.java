import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

interface Dateable
{
  public boolean askOut( int numberOfCandies );
}

class Person
{
  private String name;

  public Person( String theName ) {
    name = theName;
  }
  public String getName() {
    return name;
  }
}

class Student extends Person {
  private int id;

  public Student(String aname, int id) {
    super(aname);
    this.id = id;
  }
}

public class PresStudent_gonz extends Student implements Dateable, Comparable<PresStudent_gonz> {
  private Color hairColor;

  public int compareTo(PresStudent_gonz o) {
    return ((this.getName()).compareTo(o.getName()));
  }
  public PresStudent_gonz(String name, int id, Color hairColor) {
    super(name, id);
    this.hairColor=hairColor;
  }
  public Color getHairColor() {
    return this.hairColor;
  }
  public boolean askOut(int numberOfCandies) {
    Random  rand = new Random();
    int a = rand.nextInt(10);
    if(a > 5)
      return true;
    else
      return false;
  }

  public static void main(String[] args) {
    ArrayList< PresStudent_gonz > girls = new ArrayList< PresStudent_gonz >(5);
    girls.add(new PresStudent_gonz("Jane", 01, Color.BLUE));
    girls.add(new PresStudent_gonz("Mary", 02, Color.RED));
    girls.add(new PresStudent_gonz("Will Ferrel", 03, Color.GREEN));
    girls.add(new PresStudent_gonz("Jennifer lawrence", 04, Color.GREEN));
    girls.add(new PresStudent_gonz("If Anne has a will, Anne hathaway", 05, Color.BLACK));
    Collections.sort(girls);
    int count = 1;
    for(PresStudent_gonz girl: girls) {
      System.out.println(count +") " + girl.getName());
      count++;
    }
    if (girls.get(0).compareTo(girls.get(1)) > 0)
      System.out.println(girls.get(0).getName());
    else
      System.out.println(girls.get(1).getName());

  }
}
