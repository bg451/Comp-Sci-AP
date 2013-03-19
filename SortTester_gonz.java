//Brandon Gonzalez
//Sort-Asg1
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
public class SortTester_gonz {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    SelectionSort s = new SelectionSort();
    System.out.println("Enter the size of the array to be sorted:");
    int n = scan.nextInt();
    ArrayList< Integer > a = createRandomArray(n);
    s.sort(a);
    System.out.println("The sorting is complete!");
  }
  public  static ArrayList< Integer > createRandomArray(int size) {
    Random r = new Random();
    ArrayList< Integer > retarray = new ArrayList< Integer > ();
    for(int i = 0; i < size; i++) {
      retarray.add( r.nextInt(size) );
    }
    return retarray;
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

  public Integer min(ArrayList< Integer > arr, int startIndex) {
    int min = arr.get(startIndex);
    int x = startIndex;
    for(int i = startIndex + 1; i < arr.size(); i++) {
      System.out.println("Looking at "+ i);
      System.out.println("Min is "+ min);
      if(arr.get(i) < min){
        min = arr.get(i);
        x = i;
      }
    }
    return x;
  }
  public void swap(ArrayList< Integer > input, int i, int j) {
    int temp = input.get(j);
    input.set(j, input.get(j-1));
    input.set(j-1, temp);
  }
  public void sort(ArrayList< Integer > arr) {
    for(int i = 0; i < arr.size() - 1; i++){
      //min index
      int j = min(arr, i);
      //swap
      swap(arr, i, j);
      for(int swag: arr){
        System.out.printf("%d ", swag);
      }
      System.out.println();
    }
  }
}

class InsertionSort {
  public void swap(ArrayList< Integer >  input, int i, int j) {
    int temp = input.get(j);
    input.add(input.get(j), input.get(j-1));
    input.add(j-1, temp);
  }

  private ArrayList< Integer > insertionSort(ArrayList< Integer > input){

    int temp;

    for (int i = 1; i < input.size(); i++) {
      for(int j = i ; j > 0 ; j--){
        if(input.get(j) < input.get(j-1)){
          temp = input.get(j);
          input.add(input.get(j), input.get(j-1));
          input.add(j-1, temp);
        }
      }
    }
    return input;
}
}
