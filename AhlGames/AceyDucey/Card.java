/*
  A sneaky implementation of playing cards.
  For any integer, mod it by 52.
  This number is acts a card in a regular deck of 52.
  Integer divide this card number to find its suit,
    and mod by 13 to find its rank.
*/
public class Card extends Integer implements Comparable
{
  public enum Suit { CLUBS, DIAMONDS, HEARTS, SPADES }

  public abstract enum Rank;

  public enum AceHiDeck extends Rank
  {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN,
    EIGHT, NINE, JACK, QUEEN, KING, ACE
  }

  public enum AceLoDeck extends Rank
  {
    ACE, TWO, THREE, FOUR, FIVE, SIX,
    SEVEN, EIGHT, NINE, JACK, QUEEN, KING
  }

  public Deck deck;

  public Suit suit;
  public Rank rank;

  public Card (int i, Deck some_deck)
  {
    i %= deck.numCards;

    int numRanks = deck.numCards / deck.numSuits;

    super(i);

    this.deck = some_deck;

    this.suit = Suit.values()[i / numRanks];

    if (some_deck.isAceHigh())
    {
      this.rank = AceHiDeck.values()[i % numRanks];
    }
    else
    {
      this.rank = AceLoDeck.values()[i % numRanks];
    }
  }

  public int getIntSuit ()
  {
    return this.suit;
  }

  public char getCharSuit ()
  {
    switch (this.suit)
    {
      case Suit.CLUBS:
        return 'C';
      case Suit.DIAMONDS:
        return 'D';
      case Suit.HEARTS:
        return 'H';
      case Suit.SPADES:
        return 'S';
      default:
        return '_';
    }
  }

  public int getIntRank ()
  {
    return this.rank;
  }

  public char getCharRank ()
  {
    if (this.deck.isAceHigh())
    {
      switch (this.rank)
      {
        case AceHiDeck.TWO:
          return '2';
        case AceHiDeck.THREE:
          return '3';
        case AceHiDeck.FOUR:
          return '4';
        case AceHiDeck.FIVE_HI:
          return '5';
        case AceHiDeck.SIX:
          return '6';
        case AceHiDeck.SEVEN:
          return '7';
        case AceHiDeck.EIGHT:
          return '8';
        case AceHiDeck.NINE:
          return '9';
        case AceHiDeck.JACK:
          return 'J';
        case AceHiDeck.QUEEN:
          return 'Q';
        case AceHiDeck.KING:
          return 'K';
        case AceHiDeck.ACE:
          return 'A';
        default:
          return '_';
      }
    }
    else
    {
      switch (this.rank)
      {
        case AceLoDeck.ACE:
          return 'A';
        case AceLoDeck.TWO:
          return '2';
        case AceLoDeck.THREE:
          return '3';
        case AceLoDeck.FOUR:
          return '4';
        case AceLoDeck.FIVE:
          return '5';
        case AceLoDeck.SIX:
          return '6';
        case AceLoDeck.SEVEN:
          return '7';
        case AceLoDeck.EIGHT:
          return '8';
        case AceLoDeck.NINE:
          return '9';
        case AceLoDeck.JACK:
          return 'J';
        case AceLoDeck.QUEEN:
          return 'Q';
        case AceLoDeck.KING:
          return 'K';
        default:
          return '_';
      }
    }
  }

  public int compareTo (Card other)
  {
    if (this.deck != other.deck)
    {
      throw new IllegalArgumentException();
    }

    if (this.deck.isAceHigh())
    {
      //special logic
      if (this.rank == AceHiDeck.ACE)
      {
        if (other.rank == AceHiDeck.ACE)
        {
          return 0;
        }
        else
        {
          return 1;
        }
      }
      else if (other.rank == AceHiDeck.ACE)
      {
        return -1;
      }
      else
      {
        //regular logic
        if (this.rank > other.rank)
        {
          return 1;
        }
        else if (this.rank < other.rank)
        {
          return -1;
        }
        else
        {
          return 0;
        }
      }
    }
    else
    {
      //regular logic (ace == 0)
      if (this.rank > other.rank)
      {
        return 1;
      }
      else if (this.rank < other.rank)
      {
        return -1;
      }
      else
      {
        return 0;
      }
    }
  }
}
