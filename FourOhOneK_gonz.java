import java.util.Scanner;
import java.util.Random;

// Brandon Gonzalez
// 401k Earnings

public class FourOhOneK_gonz{
	public static void main(String[] args){
		Scanner inp = new Scanner(System.in); // scanner made
		
		System.out.println("Enter the amount to be contributed yearly: ");
		double contrib = inp.nextDouble();
		
		System.out.println("Please enter the start year: ");
		int sYear = inp.nextInt();
		
		System.out.println("Please enter the end year: ");
		int eYear = inp.nextInt();
		
		System.out.println();
		
		Retirement test1 = new Retirement(contrib, sYear, eYear);
		test1.printChart();
		//Hard coded variables
		
		System.out.printf("\n\n Hard Coded values: 1000 dollars yearly contribution, 2011-2012 \n\n");
		Retirement test2 = new Retirement(1000, 2011, 2021);
		test2.printChart();
	}
}
/**
 * The retirement class takes hard values and then creates a simulated 401k 
 * using random gains and loses.
 */
class Retirement{
	double annualContribution;
	double profit;
	double oldBalance;
	double currentBalance;
	double retRate;
	int yearStart;
	int yearEnd;
	char asciiLine = 179;
	Random generator = new Random();


	//Constructor
	public Retirement(double annualContribution, int yearStart, int yearEnd)
	{
		this.annualContribution = annualContribution;
		this.yearStart = yearStart;
		this.yearEnd = yearEnd;
		oldBalance = this.annualContribution;
	}

	public void printChart() {
		
		for(int year = yearStart; year < yearEnd + 1; ++year)
		{
			retRate = (-4.0 + (generator.nextFloat()*((12 - -4.0)))) / 100.0;
			double ret = retRate * 100;
			double profit = (oldBalance + 0.5*annualContribution) * retRate;
			currentBalance = oldBalance + profit;
			// Makes the upper half of the table
			System.out.printf("%c", 218);
			for(int i = 0; i < 114; ++i){
				System.out.printf("%c", 196);
			}
			System.out.printf("%c\n", 191);

			System.out.printf("%c%1d %c Deposit: $%7.2f %c Old Balance: $%7.2f %c Return Rate: %4.1f%% %c Profit: $ %7.2f %c New Balance:$ %7.2f %c\n",asciiLine ,year,asciiLine, annualContribution, asciiLine, oldBalance, asciiLine,ret,asciiLine, profit, asciiLine, currentBalance, asciiLine);
			//Makes the lower half of the table
			System.out.printf("%c", 192);
			for(int i = 0; i < 114; ++i){
				System.out.printf("%c", 196);
			}
			System.out.printf("%c\n", 217);
			oldBalance = currentBalance;
		}
	}
}