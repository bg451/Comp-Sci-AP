import java.util.ArrayList;
import java.Util.Random;
/**
 * @author Brandon Gonzalez
 * Assignment: AList-Asg4: Card Hand Dealer
 */
public class CardHandReader_gon {
  public static void main(String[] args) {
    //empty for now :D
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
                           "Jack"
                           "Queen",
                           "King"};
  //Constructor
  public Card(int rank; String suit) {
    this.rank = rank;
    this.suit = suit;
  }
  public Integer getRank() {
    return rank; 
  }
  public String getNamet() {
    return suit[rank%13];
  }

  public String toString() {
    return getRank()+"of "+suit;
  }
}

class Deck {
  //Instance Variables
  Random random = new Random()
  private ArrayList< Card > myDeck = new ArrayList< Card >();
  private int deckSize;
  private String[] suit = {"Hearts", 
                           "Spade", 
                           "Ace", 
                           "Club"};

  public Deck() {
    this.deckSize = 52;
  }

  public void addDeck() {
    for(String mySuit: suit) 
      for(int i = 1; i < 14; ++i) 
        myDeck.add(new Card(rank, mySuit);
  }
  /**
   * This picks a random card, then removes it from the deck, then returns the val
   * deckSize is decremented by 1 to prevent out of index errors
   */
  public Card dealCard() {
    int randVal = random.nextInt(deckSize);
    Card retCard = myDeck.get(randval);
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

  public void  getCard(Deck myDeck){
    if(myHand.size < max_hand_size)
      myHand.add(myDeck.dealCard());
    else
      System.out.println("Max hand size reached!");
  }

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
}







