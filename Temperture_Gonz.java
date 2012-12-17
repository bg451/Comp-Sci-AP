//Brandon Gonzalez
//FinalPrep-asg3
import java.util.Scanner;

public class Temperture_Gonz
{
    public static void main(String[] args) {
      //Swapped IO with Scanner
      Scanner myScanner = new Scanner(System.in);
      //Code from 19 
      System.out.println("Enter temperature scale: ");
      String scale = myScanner.nextLine();
      System.out.println("Enter Temperature: ");
      double degrees = myScanner.nextDouble();
      
      //Code from 18
      //Substituted the initial values from 18 for the input
      Temperature t1 = new Temperature(degrees, scale);
      Temperature t2 = t1;
      Temperature t3 = t2.lower(20);
      System.out.printf("t3 %s\n", t3.toString());
      Temperature t4 = t1.toFahrenheit();
      System.out.printf("t4 %s\n", t4.toString());
    }
}
/** 
  as featured in Barron's!
*/

class Temperature 
{
  private String myScale;
  private double myDegrees;
  
  public Temperature()
  {
    myScale = "F";
    myDegrees = 0;
  }
  
  public Temperature( double degrees, String scale )
  {
    myScale = scale;
    myDegrees = degrees;
  }
  
  public double getDegrees() { return myDegrees; }
  
  public String getScale()  { return myScale; }
  
  public Temperature toFahrenheit()
  {
    if(myScale.equals("C")) {
      myDegrees = (myDegrees * 9.0/5.0) + 32;
      myScale = "F";
    }
    return this;
  }
  
  public Temperature toCelsius()
  {
    if(myScale.equals("F")){
      myDegrees = ((myDegrees * (5/9.0) + 32));
    }
    return this;
    
  }
  
  public Temperature raise( double amt )
  {
    myDegrees += amt;
    return this;
  }
  
  public Temperature lower( double amt )
  {
  
    myDegrees -= amt;
    return this;
  }
  
  public static boolean isValidTemp( double degrees, String scale )
  {
    
    if(scale.equals("F"))
      if((degrees* 5/9 - 32 ) + 273.15 >= 0)
        return true;
    if(scale.equals("C"))
      if((degrees + 273.15) >= 0)
        return true;
    
    return false;
  }
  public String toString(){
    return "Temperature: "+ myDegrees+" "+myScale;
  }
}
