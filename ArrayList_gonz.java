//Brandon Gonzalez
//AList-Asg2: ArrayLists Bk Program
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ArrayLists_gonz {
	
	public static void main(String[] args) 
	{
		//7.3
		ArrayList<Bell> myBells = new ArrayList<Bell>();
		
		for(int i = 0; i < 10; i++)

	}

	private static void r7_3(ArrayList<Bell> myBell) 
	{
		int min = myBell.get(0).id();
		int max = myBell[0].id(); 

		for(int i = 0; i < myBell.size(); ++i){
			if(myBell.get(i).id() < min)
				min = myBell.get(i).id()
			if(myBell.get(i).id() > max)
				max = myBell.get(i).id()
		}
		System.out.println("Min: " + min "; Max:" + max);
	}

	private static void r7_4()
	{
		Scanner myScanner = new Scanner(System.in);
		ArrayList<String> myArray = new ArrayList<String>();
		for(int i = 0; i < 10; ++i){
			String myString = myScanner.nextLine();
			myArray.add(myString);
		}

		for(int i = (myArray.size - 1); i > -1; --i){
			System.out.println(myArray.get(i));
		}
		
	}

	private static void r7_8() 
	{
		ArrayList<Int> myArray = new ArrayList<Int>();
		Random numGen = new Random();
		for(int i = 0; i < 10; ++i){
			myArray.add((numGen.nextInt(100) + 1));
		}
	}
}


class Bell {
	private int studentId;

	public Bell( int id ) {
		studentId = id;
	}

	public int id() {
		return studentId;
	}

	public int compareTo( Bell otherBell ) {
		return this.id - otherBell.id;
	}
}

class Polygon {
	
	public double perimeter(){

	}

	public double area(){

	}
}