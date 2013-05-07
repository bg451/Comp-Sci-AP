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
    Comparable[] a = createRandomArray(n);
    s.sort(a);
    System.out.println("The sorting is complete!");
  }
  public  static Comparable[]  createRandomArray(int size) {
    Random r = new Random();
    Comparable[] retarray = new Comparable[size];
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

  public int min(Comparable[] arr, int startIndex) {

    int min = arr.get(startIndex);
    int x = startIndex;
    for(int i = startIndex + 1; i < arr.length; i++) {
      if(arr.get(i) < min){
        min = arr[i];
        x = i;
      }
    }
    return x;
  }
  public void swap(int[] arr, int i, int j) {
    int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
  }
  public void sort(int[] arr) {
    for(int i = 0; i < arr.length - 1; i++){
      //min index
      int j = min(arr, i);
      //swap5
      swap(arr, i, j);
      for(int swag: arr){
        System.out.printf("%d ", swag);
      }
      System.out.println();
    }
  }
}

class InsertionSort {
  public void swap(ArrayList< Integer >  arr, int i, int j) {
    arr.set(i, j);
  }

  private ArrayList< Integer > insertionSort(ArrayList< Integer > input){

    int temp;

    for (int i = 1; i < input.length; i++) {
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
