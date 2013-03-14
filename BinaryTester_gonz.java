//Brandon Gonzalez
//Binary Search
/**
 * I didnt really encounter any bugs while writing the program
 * There were a few syntax errors here and there, and the only bug
 * that I did encounter was looking at the first and last index
 * but that turned out to be an easy fix
 */
import java.util.Scanner;
/**
* Scans for the teacher name and then attempts to find the teacher
* in the array
*/
public class BinaryTester_gonz {
  public static void main(String[] args) {
    BinaryFinder finder = new BinaryFinder();
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
 *  Binary Search algorithm class stuff
 *  Implements finder which implements a binary search alg
 */
class BinaryFinder implements Finder {
  /**
  * Returns the index of the object if found
  * if not found, returns -1
  */
  public int find(String[] hayStack, String needle) {
    int hi = hayStack.length, lo = 0, index;
    int count = 0;
    Boolean found = false;
    index = (hi - lo)/2 + lo;
    while(hi > lo) {
      if(hayStack[index].compareTo(needle) > 0)
        hi = index -1;
      else if(hayStack[index].compareTo(needle) < 0)
        lo = index + 1;
      else if(hayStack[index].compareTo(needle) == 0){
        return index;
      }
      index = (hi - lo)/2 + lo;
    }
    return -1;
  }
}
