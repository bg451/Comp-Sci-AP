//Brandon Gonzalez
//Searching-Asg4: Speed Test
/**
 * Reflection
 * The only issue I had was considering the efficiency of bin search and cpu speed, milliseconds
 * was not a precise enough measurement, so i had to swap it for nanoseconds
 */
import java.util.Random;
import java.util.Arrays;
import java.lang.System;

public class SpeedTest_gonz {
  public static void main(String[] args) {
    LinearSearch lin = new LinearSearch();
    BinarySearch bin = new BinarySearch();

    System.out.println("\nLinear search for an array size of: " + 100000);
    runTest(100000, lin);
    System.out.println("\nBinary search for an array size of: " + 100000);
    runTest(100000, bin);
  }
  /**
   * @param: int size: size of array/random number range
   */
  public static void runTest(int size, IntFinder finder) {
    Random rand = new Random();
    Integer[] list = new Integer[size];
    for(int i = 0; i < size; ++i)
      list[i] = (rand.nextInt(size));
    Arrays.sort(list);

    for(int j = 0; j < 10; j++){
      long start = System.nanoTime();
      int result = finder.find(list, (rand.nextInt(size)));
      long end = System.nanoTime();
      System.out.printf("Case: %3d | Result: %10s | Time(nanoSeconds): %d\n", (j+1), result != -1 ? result : "Not Found" , (end - start));
    }
  }
}

interface IntFinder {
  public Integer find(Integer[] hayStack, Integer needle);
}

/**
  * @function: find searches through an array linearly
  */
class LinearSearch implements IntFinder {
  public Integer find(Integer[] hayStack, Integer needle) {
    Integer x = -1;
    for(Integer i = 0; i < hayStack.length; i++) {
      if(hayStack[i].equals(needle))
        x = i;
    }
    return x;
  }
}

/**
  * @function: find searches through an array using a binary search algorithm
  */
class BinarySearch implements IntFinder {

  public Integer find(Integer[] hayStack, Integer needle){
    Integer hi = hayStack.length, lo = 0, index;
    Integer count = 0;
    Boolean found = false;
    index = (hi - lo)/2 + lo;
    while(hi > lo) {
      if(hayStack[index].compareTo(needle) > 0)
        hi = index - 1;
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
