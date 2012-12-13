/**
 *  Brandon Gonzalez
 *  Chapter 6 programs
 */

import java.util.*;

public class IterationTester_gonz {
  
  public static void main(String[] args) {
    System.out.println("-----------------------");
    System.out.println("-Brandon Gonzalez Ch 6-");
    System.out.println("-----------------------");

    p6_3();
    //6_5
    p6_5();
    p6_6();
    p6_13();
    
    p6_2();
  }

  public static void p6_3(){
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to the Euro currency converter!\nHave Fun");
    boolean end = false;
    String in = new String("");
    double number;
    double euroToDollar = .7705;
    
    while(!end){ 
      System.out.printf("\nPlease enter the amount you would like to convert, Q to exit: ");
      in = input.nextLine();
      if(in.equalsIgnoreCase("Q")){
        end = true;
      } else {
        number = Double.parseDouble(in);      
        number = number * euroToDollar;
        System.out.println(number + " Euros");
      }
    }
  }
  public static void p6_5(){
    System.out.println("\n\nPower Generator :D");
    PowerGenerator gen = new PowerGenerator();
    gen.printPower(12);
  }
  public static void p6_6(){
    Scanner input = new Scanner(System.in);
    FibonacciGenerator gen = new FibonacciGenerator();
    int n;
    System.out.println("\nFibonacci gen\nPlease enter n: ");
    n = input.nextInt();
    
    for(int i = 0; i < n; ++i){  
      gen.nextNumber();
    }
  }

  public static void p6_13() {
    System.out.println("This is p6_13");
    Random generator = new Random();
    DataSet data = new DataSet();
    for(int i = 0; i < 100; ++i){
      int temp = generator.nextInt(901) + 100;
      data.add(temp);
    }
    System.out.println("The maximum is: " +data.retMax());
    System.out.println("The average is: " + data.getAverage());
  }

  public static void p6_2(){
    Scanner input = new Scanner(System.in);
    int cardNumber, firstSet, secondSet;
    int[] number = new int[9];
    int power = 10;
    System.out.println("Please enter your card number. It has to be 8 digits");
    cardNumber = input.nextInt();
    for(int i = 0; i < 8; ++i){
      number[i] = cardNumber % 10;
      cardNumber = cardNumber/10;
    }
    firstSet = number[0] + number[2] + number[4] + number[6];
    secondSet = number[1] + number[3] + number[5] + number[7];
    int total = firstSet + secondSet;
    if(total == 50){
      System.out.println("That is a valid card!");
    } else {
      System.out.println("That is an invalide card!");
    }
  }
}


class PowerGenerator{
  public double number, factor;

  public PowerGenerator(){
    number = 1;
    factor = 10;
  }
  public PowerGenerator(double aFactor) {
    number = 1;
    factor = aFactor;
  }
  public void nextFactor() {
    number *= factor;
  }
  public void printPower(int length) {
    System.out.println(number);
    for(int i = 0; i < length; ++i){
      nextFactor();
      System.out.println(number);
    }
  }
}

class FibonacciGenerator{
  private Scanner input = new Scanner(System.in);
  private int a = 0;
  private int b = 1;
  private int c;

  public void nextNumber(){
    c = a + b;
    a = b;
    b = c;
    System.out.println(c);
  } 
}
// Data set class
class DataSet{
  private double sum;
  private double maximum;
  private int count;

  public DataSet(){
    sum = 0;
    count = 0;
    maximum = 0;
  }

  public void add(double x) {
    sum += x;
    if(count == 0 || maximum < x){
      maximum = x;
    }
    ++count;
  }

  public double retMax() {
    return maximum;
  }
  public double getAverage(){
    if(count == 0){ 
      return 0;
    }
    else {
      return sum / count;
    }
  }
}

