import java.util.ArrayList;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Scanner; // for input

// New sound stuff
import javax.sound.sampled.*;
import java.io.File;


/**
  Specifies the header for methods common to all animals.
*/
interface Speakable {
	/**
		All methods are public in an interface. No need to write public.
	*/
	void speak();
}

/**
  A common animal that has a deep throaty speaking sound
*/

class Animal implements Speakable {
	String name;
	public Animal(String name) {
		this.name = name;
	}
	public void speak() {
		System.out.println(toString());
	}
	public String toString() {
		return "Name: " + this.name;
	}
}
class Horse implements Speakable {
	public void speak() {
		System.out.println("Monkey sound goes here");

		String fileName = "./sound/Horse.wav";
		AudioClip clip = InterfaceZoo_gonz.getAudioClip(fileName);
		clip.play();
		InterfaceZoo_gonz.wait(1);
	}
}
class Dog implements Speakable {
	public void speak() {
		System.out.println("woof");

		// Setup file name for the sound for this animal. The file should be in same folder as
		//    the class file that contains main
		String fileName = "./sound/dogbark4.wav";
		AudioClip clip = InterfaceZoo_gonz.getAudioClip(fileName);
		clip.play();
		InterfaceZoo_gonz.wait(3);
	}

	public void sleep() {
		System.out.println("zZz");
	}
}


class Cat implements Speakable {
	public void speak() {
		System.out.println("meow");

		// Setup file name for the sound for this animal. The file should be in same folder as
		//    the class file that contains main
		String fileName = "./sound/catme.wav";
		AudioClip clip = InterfaceZoo_gonz.getAudioClip(fileName);
		clip.play();
		InterfaceZoo_gonz.wait(3);
	}
}

/**
  Tests out the Speakable hierarchy by having those creatures speak.
*/
public class InterfaceZoo_gonz {

	/**
	 * Based on the file name provided, this will load the corresponding
	 * AudioClip (au wav aif mid formats) and return that AudioClip object
	 * @param relativeURL - this is the file name for the sound file, it
	 * 	  is in the same folder that you are executing this application from
	 * @return an AudioClip that you can play
	 */
	public static AudioClip getAudioClip( String relativeURL ) {
		URL completeURL = null;
		try {
			URL baseURL = new URL("file:" + System.getProperty("user.dir") + "/");
			completeURL = new URL(baseURL, relativeURL);
			System.out.println( "Accessing: " + completeURL.toString() );
		} catch (MalformedURLException e){
			System.err.println(e.getMessage());
		} catch( Exception e) {

		}
		AudioClip audioClip = Applet.newAudioClip(completeURL);
		return audioClip;
	}

	/**
	 * Convenience method to halt this thread of execution for specified number
	 * of seconds
	 * @param numSeconds
	 */
	public static void wait(int numSeconds) {
		try {
			Thread.sleep(numSeconds * 1000); // it wants milliSeconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	  Test driver. Creates animals, has them speak, puts them in ArrayList
	  and has them speak. great fun.
	*/
	public static void main(String[] args) {
		ArrayList<Speakable> zoo = new ArrayList<Speakable>();
		Speakable horse = new Horse();
		Speakable rover  = new Dog();

		// Rover speaks.
		rover.speak();
		Scanner scan = new Scanner(System.in);
		System.out.println("Rover spoke, hit <Enter> to continue...");
		scan.nextLine();

		// Add first animal to zoo, a zoo of 1!
		zoo.add(rover);
		// casting required below (and must be parenthesized so that the cast takes place
		//   before the "." operator
		((Dog)rover).sleep();

		// Create 2nd animal.
		Speakable suzie = new Cat();
		// Add 2nd animal to zoo, a zoo of 2!
		zoo.add(suzie);

		// Suzie speaks:
		suzie.speak();
		System.out.println("Suzie spoke, hit <Enter> to continue...");
		scan.nextLine();

		suzie = rover;   // no problems, but we lost our cat ....

		rover = suzie;   // no problems, 2 references to same object now

		// The new suzie speaks
		suzie.speak();
		System.out.println("The new Suzie spoke, hit <Enter> to continue...");
		scan.nextLine();

		// iterate over each element in ArrayList
		for(Speakable obj : zoo)
		{
			obj.speak();   // tell each Speakable to speak

		}
		System.out.println("All animals spoke, hit <Enter> to end program");
		scan.nextLine();

		// This will end our program, even if we have a graphical window
		System.exit(0);
	} // end main
}// end class Interfacezoo_gonz
