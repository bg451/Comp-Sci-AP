//Brandon Gonzalez
//Searching Assign 1
/**
 * The program runs pretty well.
 * The only thing i ran into was a few missing semicolons and for some reasons
 * I made the find function static because I wasnt paying attention
 * Used about 20 test cases and none failed :D
 */

import java.util.Scanner;
/**
* Sequential Tester has the moves like jagger.
* Scans for the teacher name and then attempts to ifnd the teacher
* in the array
*/
public class SequentialTester_gonz {
  public static void main(String[] args) {
    SequentialFinder finder = new SequentialFinder();
    Scanner myScanner = new Scanner(System.in);
    System.out.println("Please enter the teacher you want to search for: ");
    String input = myScanner.nextLine();
    int x = finder.find(getNames(), input);
    if(x == -1)
      System.out.println("Teacher not found!");
    else
      System.out.println( getNames()[x] + " was found @ " + x);
  }
  public static String[] getNames() {
    String[] names =  { "Adams", "Amarillas", "Baxter", "Duong","Giraudo",
                      "Gonzalez", "Hansbrough", "Kniffin", "Lindemann",
                      "Lum", "Mathurin", "McCullough", "Molina",
                      "Reyerson", "Ward", "Wolf", "Wong", "Zabinski" };
    return names;
  }
}

interface Finder {
  public int find(String[] hayStack, String needle);
}

/**
 *  Linear Search algorithm class stuff
 *  Implements finder which implements a linear search alg
 */
class SequentialFinder implements Finder {
  /**
  * Returns the index of the object if found.
  * If not found, returns -1
  */
  public int find(String[] hayStack, String needle) {
    int x = -1;
    for(int i = 0; i < hayStack.length; i++) {
      if (hayStack[i].equals(needle))
        x = i;
    }
    return x;
  }
}
