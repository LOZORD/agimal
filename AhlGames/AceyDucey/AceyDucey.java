import java.util.Random;
import java.util.Scanner;

public class AceyDucey
{
  public static final int NUM_SUITS = 4;
  public static final int ACE_NUM = 13;
  public static final int KING_NUM = 12;
  public static final int QUEEN_NUM = 11;
  public static final int JACK_NUM = 10;
  public static final int CARDS_PER_SUIT = ACE_NUM - 2;

  public static int [] deck;

  public static int player_money = 100;

  public static final String helpString = "Acey Ducey is played in the following manner:\n The dealer (this computer) deals two cards face up. You have an option to be or not to bet depending on whether or not you feel the card will have a value between the first two.";

  public static final Scanner userInput = new Scanner(System.in);

  public static void main (String [] args)
  {

    System.out.println("Welcome to Acey Ducey!");
    buildDeck();

    shuffle();

    //TODO gameplay, user input, multiple games, etc.
  }

  public static void buildDeck ()
  {
    deck = new int [NUM_SUITS  * CARDS_PER_SUIT + 1];

    //build the deck first
    for (int i = 0; i < NUM_SUITS; i++)
    {
      for (int j = 0; j <= CARDS_PER_SUIT; j++)
      {
        deck[i * CARDS_PER_SUIT + j]= j + 2;
      }
    }
  }

  public static void shuffle ()
  {
    Random rnd = new Random();

    for (int i = deck.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);

      //then just do a simple swap
      int a = deck[index];
      deck[index] = deck[i];
      deck[i] = a;
    }
  }
}
