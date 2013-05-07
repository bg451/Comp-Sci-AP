//Brandon Gonzalez
//Sort-Asg2: OO Insertion Sort
import java.util.Random;
import java.util.ArrayList;
public class SortTester_gonz {
  public static void main(String[] args) {
    Comparable[] a = {9, 7, 5, 3, 2, 1}, b  = {9, 7, 5, 3, 2, 1};
    Comparable[]  c = {1, 10, 9, 5, 8, 3}, d =  {1, 10, 9, 5, 8, 3};
    SelectionSort s1 = new SelectionSort(a);
    InsertionSort i1 = new InsertionSort(b);
    SelectionSort s2 = new SelectionSort(c);
    InsertionSort i2 = new InsertionSort(d);
    s1.sort();
    i1.sort();
    System.out.println();
    s2.sort();
    i2.sort();
  }
  //Swap Method that is static for reference in the other classes
  public static void swap(Comparable[] arr, int i, int j) {
    Comparable temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}

/**
 * Has a sort function and two helper functions
 * min finds the minimun value and its index given a starting index
 * swap takes in two indexes that to be swapped as the parameter
 * sort uses min and swap to implement a selection sort algorithm
 * needs more cowbell
 */
class SelectionSort {
  private Comparable[] arr;

  public SelectionSort(Comparable[] arr) {
    this.arr = arr;
  }
  public int min(Comparable[] arr, int startIndex) {
    Comparable min = arr[startIndex];
    int x = startIndex;
    for(int i = startIndex + 1; i < arr.length; i++) {
      if(arr[i].compareTo(min) < 0) {
        min = arr[i];
        x = i;
      }
    }
    return x;
  }
  public void sort() {
    System.out.println("Selection Sort");
    System.out.println("Original list: " + toString());
    System.out.println("\nSorting...");
    for(int i = 0; i < arr.length - 1; i++){
      int j = min(arr, i);
      SortTester_gonz.swap(arr, i, j);
      System.out.println(toString());
    }
    System.out.println("Sorting is complete!");
  }
  public String toString() {
    String retString = "";
    for(Comparable swag: arr){
      retString += swag + " ";
    }
    return retString;
  }
}
/**
 * sort: Implements an insertion sort algorithm
 * toString: turns the array into a usable string
 */
class InsertionSort {
  private Comparable[] input;

  public InsertionSort(Comparable[] arr) {
    this.input = arr;
  }

  public void sort(){
    System.out.println("Insertion Sort ");
    int temp;

    for (int i = 1; i < input.length; i++) {
      for(int j = i ; j > 0 ; j--){
        if(input[j].compareTo(input[j-1]) < 0) {
          SortTester_gonz.swap(input, j, j-1);
        }
        System.out.println(toString());
      }
    }
    System.out.println("Sorting is complete!");
  }
  public String toString() {
    String retString = "";
    for(Comparable swag: input)
      retString += swag + " ";
    return retString;
  }
}

