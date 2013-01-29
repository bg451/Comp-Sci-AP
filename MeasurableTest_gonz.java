public class MeasurableTest_gonz {
	public static void main(String[] args) {
		int rolls = 10;
		DataSet dataSet1 = new DataSet();
		DataSet dataSet2 = new DataSet();

		for (int i = 1; i <= rolls; ++i) {
			Die myDie = new Die();
			int n = myDie.roll();
			dataSet1.add(myDie);
		}
		System.out.println("Average: " + dataSet1.getAverage());

		dataSet2.add(new Person("Joe", 102));
		dataSet2.add(new Person("Bob", 115));
		dataSet2.add(new Person("Jack", 2034));
		System.out.println("Max Name: " + dataSet2.getMaximum().getName() + " Average height: " + dataSet2.getAverage());
	}
}

interface Measurable {
	public double getMeasure();
	public String getName();
}

class Die implements Measurable{
	private final int MAX_FACE = 6;
	private int faceValue;

	public int roll(){
		return faceValue = (int)(Math.random() * MAX_FACE) + 1;
	}

	public double getMeasure(){
		return faceValue;
	}
	public String getName() {
			return null;
	}
}

class Person implements Measurable {
	private String name;
	private int height;

	public Person(String name, int height) {
		this.name = name;
		this.height = height;
	}

	public String getName() {
		return name;
	}
	public double getMeasure() {
		return height;
	}
}

class DataSet {
	private double sum;
	private Measurable maximum;
	private int count;
	
	public DataSet() {
		sum = 0;
		count = 0;
		maximum = null;
	}

	public void add(Measurable x) {
		sum = sum + x.getMeasure();
		if (count == 0 || maximum.getMeasure() < x.getMeasure())
			maximum = x;
		count++;
	}

	public double getAverage() {
		if (count == 0) return 0;
		else return sum / count;
	}

	public Measurable getMaximum() {
		return maximum;
	}
}
