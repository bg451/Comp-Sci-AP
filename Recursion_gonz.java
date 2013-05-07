//Brandon Gonzalez
//Recursion Programming
public class Recursion_gonz {

  public static void main(String[] args) {
    System.out.println( "1*7 = " + multiply(1,7) );
    System.out.println( "8*7 = " + multiply(8,7) );
    System.out.println( "9*1 = " + multiply(9,1) );

    int n1 = 0;
    System.out.println( n1 + "! = " + factorial(n1) );
    int n2 = 8;
    System.out.println( n2 + "! = " + factorial(n2) );
    int[] a = {5,7,2,3,12,5,9,1,6};
    System.out.println( "3^8 is " + power(3, 8) );
    System.out.println( "4^0 is " + power(4, 0) );
  }

  public static int multiply(int x, int y) {
    return y == 0 ? 0 : y == 1 ? x : x + multiply(x, y-1);
  }
  public static int factorial(int n) {
    return n == 0 ? 1 : n * factorial(n-1);
  }
  public static int power(int base, int exponent){
    return exponent == 0 ? 1 : base * power(base, exponent - 1);
  }

}
