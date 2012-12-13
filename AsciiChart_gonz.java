public class AsciiChart_gonz {
	public static void main(String[] args){
	char i = 32;
	while(i < 127) {
		for(int r = 0; r < 5; r++){
			System.out.printf("%c", i);
			i++;
		}
		System.out.println();
	}
	} 
}

/*class Asii {
	int i = 32
	while(i < 127) {
		for(int r = 0; r < 5; r++){
			System.out.printf("%i %c", i, i)
			i++;
		}
	}
}*/
