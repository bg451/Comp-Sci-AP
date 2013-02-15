import java.awt.Color;
import java.util.Random;

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

public class PresStudent_gonz extends Student implements Dateable {
  private Color hairColor;

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
    PresStudent_gonz tester = new PresStudent_gonz("Swag master", 1337, Color.GREEN);
    if(tester.askOut(100000))
      System.out.println("Congrats :D");
    else
      System.out.println("You were rejected but its k you have bellarmine");
  }
}
