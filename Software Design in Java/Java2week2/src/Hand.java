public class Hand
{
    public static final int MAX_CARD = 50; // max cards in hand is 30

    private Card[] myCards; // private Card Array
    private int numCards; // private variable to store number of cards in hand

    // default constructor for Hand object
    public Hand()
    {
        this.myCards = new Card[MAX_CARD];
        resetHand();
    }

    // reset hand
    public void resetHand()
    {
        numCards = 0;
    }

    // take card mutator which adds a card to your hand
    public boolean takeCard(Card card)
    {
        if (numCards >= MAX_CARD)
            return false;
        if (myCards[numCards] == null)
            myCards[numCards] = new Card();
        myCards[numCards++].set(card.getVal(), card.getSuit());
        return true;
    }

    // mutator playCard, plays the top card from a players hand
    public Card playCard()
    {
        final Card errorFlag = new Card('E', Card.Suit.spades);

        if (numCards == 0)
            return errorFlag;
        else
            return myCards[--numCards];
    }

    // accessor shows number of cards
    public int numCards()
    {
        return numCards;
    }

    // accessor to inspect a specific card in hand
    public Card inspectCard(int k)
    {
        final Card errorFlag = new Card('E', Card.Suit.spades);
        // check card validity
        if (k < 0 || k >= numCards)
            return errorFlag;
        else
            return new Card(myCards[k]);// return valid card
    }

    // stringizer to print hand
    public String toString()
    {
        String retHand = ""; // initialize retHand

        for (int i = 0; i < numCards; i++)
            if (i < MAX_CARD - 1)
                retHand = retHand + inspectCard(i) + ", ";
            else
                retHand = retHand + inspectCard(i);
        return "Hand = ( " + retHand + " )";

    }
}
