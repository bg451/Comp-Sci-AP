/*Brandon Gonzalez
	Please forgive the stupid innefeciency that is prog7.11 :(

    R7.7 b, c, d
    R7.8 R7.11 a, c
    R7.12 c
    R7.14
    R7.17
    Prog7.9
    Prog7.11


7.7b.
	int[] cow = new int[12];
	for(int i=0; i < 20; i+=2){
		cow[i] = i/2;
	}

	c.
	int[] cow = new cow[10]
	for(int i = 0; i < 10; i++)
		int[i] = (i +1)(i+1);
	d.
	int[] cow = new cow[10];
	for(i=0; i < 10; i++)
		int[i] = 0;

7.8
	import java.util.random
	int[] a = new int[10];
	Random gen = new Random();
	for(int i = 0; i < 10; ++i)
		a[i] = gen.nextInt(100);

7.11 a.
			double sum;
			for(int i = 0; i < values.length; ++i)
				sum += values[i];
		c. for(int i = 0; i < values.length; ++i)
					values[i] = 2 * values[i];

7.12 c
	int i = 0;
	for(double element : values){
		if(element == target)
			return i;
		i++;
	}

7.14 pos is never actually declared;

7.17. Parallel arrays are a set of arrays that represent different data fields, but pertain to the same overall data set
			An example would be having 2 arrays, one for first name and the other for last name. The 0 element of both belong to the 
			same overall set. The problem with them is that it takes alot of effort to delete or add an overall data set to them.
			They are really innefecient. Bad locality of reference is probably the biggest. They can be avoided by making multi dimensional arrays(lol)
			or creating an object that contains the various sets of data inside of it, then make an array of that object.
*/
import java.util.Random;

public class Arrays_Gonz{
	public static void main(String[] args) 
	{
		
		P79();
		System.out.println();
		P711();
	}	

	public static void P79()
	{
		Random gen = new Random();
		boolean inRun = false;
		int prev = -9999;
		int[] roll = new int[22];
		roll[21] = 0;

		for(int i = 0; i < roll.length - 1; ++i)
			roll[i] = gen.nextInt(6) + 1;

		for(int i = 0; i < roll.length - 1; ++i)
		{
			if(inRun)
			{
				if(roll[i]!= roll[i-1]) {
					System.out.printf(")");
					inRun = false;
				}
			} 
			else if(!inRun)
			{
				if(roll[i] == roll[i+1])
				{
					System.out.printf("(");
					inRun = true;
				}
			}
			System.out.printf("%d", roll[i]);
		}

		if(inRun)
			System.out.printf(")");
		System.out.println();
	}

	//sorta had a brain fart last night and all logic failed me. 
	public static void P711() 
	{
		boolean[] stalls = new boolean[10];
		int prevpos, curPos, futurePos;
		int places[][] = new int[10][3];
		int x, y;
		boolean spotFound = false;
		while(!(stalls[0] && stalls[1] && stalls[2] && stalls[3] && stalls[4] && stalls[5] && stalls[6] && stalls[7] && stalls[8] && stalls[9]))
		{
			prevpos = 0;
			curPos = 0;
			x = 0;
			y = 0;
			
			for(int i = 0; i < ) //Fills in the differences
			{
				if(stalls[curPos])
				{
					places[x][0] = prevpos;
					places[x][1] = curPos;
					places[x][2] = curPos - prevpos;
					x++;
					prevpos = curPos;
				}
				curPos++;
			}
			
			int max = -99999;
			int twodindex = 0;
			
			for(int i = 0; i < places.length; i++)
			{
				if(places[i][2] > max) {
					max = places[i][2];
					twodindex = i;
				}
			}

			int temp = (int) places[twodindex][0] + places[twodindex][2]/2;

			stalls[temp] = true;

			for(int i = 0; i < stalls.length; ++i)
			{
				if (stalls[i])
					System.out.printf("x");
				else
					System.out.printf("_");
			}
			System.out.println();

		}
	}

		
}
