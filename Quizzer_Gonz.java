//Brandon Gonzalez
//Java
//I am soso sorry to whoever has to read this for th mess that happened in the questioner
//function. C++ habits made me do things that werent allowed in java, so i had to fix it
//last second. please forgive me

import Java.util.Scanner;

public class Quizzer_Gonz{
	public static void main(String[] args) {
		Quizzer test = new Quizzer();
		test.questioner();
		test.summary();
		
	}
}
class QuizzerFunctions {
	private double score = 1;
	public String name;
	public String mcQues1, mcQues2, mcQues3, mcQues4, frQues1, frQues2;
	public String answer1, answer2, answer3, answer4, answer5, answer6;

	//Here is the constructors
	public QuizzerFunctions() {
		mcQues1 = "Who was the first president of the US?\na:George Washington\nb: Obama\nc: Romney\nd: Dorian Chan";
		mcQues2 = "What is the average air velocity of an unladen swallow?\na:10 m/s \nb:12 m/s\nc:14 m/s\nd:Dorian Speed";
		mcQues3 = "What is the meaning of life?\na:42\nb:52\nc:24\nd:100";
		mcQues4 = "What is Dorian's 5th period class?\na: Math\nb:Swag theory\nc: Compsci AP/nd:English 2";
		frQues1 = "What is your favorite color?";
		frQues2 = "What do you think of facebooks privacy policy?";
	}

	/******************************
	** Should probably find a more*
	** secure way to do this      *
	*******************************/
	public void getName(String name){
	  this.name = name;
	}
	
	public void pushScore(double value) {
		score += value;
	}
	
	public double getScore() {
		return score;
	}

	public void popScore(double value){
		if((score - value) <= 0) {
			score = 0;
		} else {
			score -= value;
		}
	}
	
	public void pushQuestion(String question) {
		System.out.println(question);
	}
	
	public String getResponse() {
		Scanner input = new Scanner(System.in);
		answer = input.nextLine();
		return answer;
	}
	
	public boolean checkAnswer(String input, String answer, int points){
		int tries = 0;
		if(input.equals(answer)) {
			return true;
			pushScore();
		} else {
			System.out.println("That is incorrect!");
			
			while(!input.equals(answer) || tries < 3 ) {
				input = getResponse();
			}
			return false;
		}
	}
	public void cls() {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

  public void questioner() {
		QuizzerFunctions quiz = new QuizzerFunctions();
		//Starting of the quiz
		quiz.pushQuestion("What is your name?");
		name = getResponse();
		
		if(name.equals("")) {
			System.out.println("You didnt enter your name, so you lose a point");
			quiz.popScore();
		}

		//First actual question
		pushQuestion(mcQues1);
		quiz.answer1 = quiz.getResponse();
		quiz.checkAnswer(quiz.answer1, "a", 1);
		quiz.cls();
		//Second question
		quiz.pushQuestion(mcQues2);
		quiz.answer2 = getResponse();
		quiz.checkAnswer(quiz.answer2, "b");
		quiz.cls();
		if(quiz.answer2.equals("b")) {
			//Peanut butter third question time
			quiz.pushQuestion(mcQues3);
			quiz.answer3 = quiz.getResponse();
		
			quiz.checkAnswer(quiz.anwer3, "a");
		}

		quiz.cls();
				
		//Question 4
		quiz.pushQuestion(mcQues4);
		quiz.answer4 = quiz.getResponse();
		quiz.checkAnswer(quiz.answer4,"c");
			
		//question 5		
		quiz.pushQuestion(quiz.frQues1);
		quiz.answer5 = quiz.getResponse();
		quiz.checkAnswer(quiz.answer5, "blue");
		quiz.cls();

		//question 6
		quiz.pushQuestion(quiz.frQues2);
		quiz.answer6 = quiz.getResponse();
		int tries = 0;
		while(tries < 4){
			if(quiz.answer5.equals("no thoughts") || quiz.answer5.equals("bad") || quiz.answer5.equals("its bad")){
				quiz.pushScore();
				tries = 100; //this is pretty bad practice. dont judge me
			} else {
				System.out.println("That is incorrect!\nPlease try again!!!");
				quiz.answer6 = quiz.getResponse();
				tries++;
			}

		}
	}

  public void summary(){
		System.out.println("You scored a total of " + getScore() + " Out of 6");
	  System.out.println("Percentage: " + (getScore/6 * 100) + "%");
	  System.out.printf("Your answers were %s\n%s\n%s\n%s\n%s\n%s\n", answer1, answer2, answer3, answer4, answer5, answer6);   

  }

}