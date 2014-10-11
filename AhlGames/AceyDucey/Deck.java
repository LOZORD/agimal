public class Deck
{
  public Card [] cards;

  public boolean isAceHigh;

  public int numSuits;

  public int numCards;

  public RankSet rankSystem;

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

    this.isAceHigh = aceType;

    if (this.isAceHigh)
    {
      this.rankSystem = new AceHiDeck();
    }
    else
    {
      this.rankSystem = new AceLoDeck();
    }

    this.cards = new Card [numCards];

    for (int i = 0; i < numCards; i++)
    {
      this.cards[i] = new Card(i, this);
    }
  }

  public boolean isAceHigh ()
  {
    return this.isAceHigh;
  }
}
