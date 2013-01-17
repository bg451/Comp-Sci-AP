import java.util.ArrayList;
import java.util.Random;
/**
 * @author Brandon Gonzalez
 * Assignment: AList-Asg4: Card Hand Dealer
 */
public class CardHandReader_gonz {
  public static void main(String[] args) {
    Random random = new Random();
    ArrayList< Hand > myHands = new ArrayList< Hand >();
    Deck myDeck = new Deck();
    myDeck.addDeck();
    //init myHands
    for(int i = 0; i < 4; ++i) {
      myHands.add(new Hand(random.nextInt(6) + 2));
    }

    //Adds cards to hand 
    for(int i = 0; i< myHands.size(); ++i) {
      for(int x = 0; x < myHands.get(i).getSize(); ++x1)
        myHands.get(i).getCard(myDeck);
    }
    //Prints out the cards from each hand
    for(int i = 0; i < myHands.size(); ++i) {
      System.out.println("Hand "+(i+1));
      myHands.get(i).printCards();
      System.out.println();
    }
  }
}

class Card {
  //Instance variables
  private int rank;
  private String suit;
  private String[] name = {"Ace", 
                           "Two",
                           "Three",
                           "Four",
                           "Five",
                           "Six",
                           "Seven",
                           "Eight",
                           "Nine",
                           "Ten",
                           "Jack",
                           "Queen",
                           "King"};
  //Constructor
  public Card(int rank, String suit) {
    this.rank = rank;
    this.suit = suit;
  }
  
  /**
   * Returns the rank
   */
  public Integer getRank() {
    return rank; 
  }
  /**
   *  Returns the card name
   */
  public String getName() {
    return name[rank%13];
  }
  /**
   * ToString methode that prints out the rank and suit
   */

  public String toString() {
    return getName()+" of "+suit;
  }
}

class Deck {
  //Instance Variables
  Random random = new Random();
  private ArrayList< Card > myDeck = new ArrayList< Card >();
  private int deckSize;
  private String[] suit = {"Hearts", 
                           "Spade", 
                           "Ace", 
                           "Club"};

  public Deck() {
    this.deckSize = 52;
  }

  /**
   *  Adds a 52 card deck to the myDeck arrayList
   */
  public void addDeck() {
    for(String mySuit: suit) 
      for(int i = 1; i < 14; ++i)
        myDeck.add(new Card(i, mySuit));
  }
  /**
   * This picks a random card, then removes it from the deck, then returns the val
   * deckSize is decremented by 1 to prevent out of index errors
   */
  public Card dealCard() {
    int randVal = random.nextInt((deckSize-2) + 2);
    Card retCard = myDeck.get(randVal);
    myDeck.remove(randVal);
    deckSize--;
    return retCard;
  }
}

class Hand {
  //Instance variable
  private ArrayList< Card > myHand = new ArrayList< Card >();
  private int max_hand_size;
  public Hand(int maxSize) {
    this.max_hand_size = maxSize;  
  }

  /**
   *  Gets a card from the Deck passed in the params
   *  Calls Deck.dealCard() which removes the card from the deck
   */
  public void  getCard(Deck myDeck){
    if(myHand.size() < max_hand_size)
      myHand.add(myDeck.dealCard());
    else
      System.out.println("Max hand size reached!");
  }
  /**
   * Prints out all the cards
   */

  public void printCards() {
    for(Card myCard: myHand)
      System.out.println(myCard.toString());
  }
  
  public void  useCard() {
     /* Needs to be implemented
     * Print out cards in hand -> prompt to pick which card
     * -> use that card -> remove card from hand -> reinsert into deck?
     */
  }

  public int getSize() {
    return max_hand_size;
  }
}







