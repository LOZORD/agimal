public class Deck
{
  public Card [] cards;

  public boolean isAceHigh;

  public int numSuits;

  public int numCards;

  public Deck ()
  {
    this(48, true, 4);
  }

  public Deck (int numCards)
  {
    this(numCards, true, 4);
  }

  public Deck (int nC, boolean aceType, int nS)
  {
    this.numCards = nC;

    this.numSuits = nS;

    this.cards = new Card [numCards];

    for (int i = 0; i < numCards; i++)
    {
      this.cards[i] = new Card(i, this);
    }

    this.isAceHigh = aceType;
  }

  public boolean isAceHigh ()
  {
    return this.isAceHigh;
  }
}
