
public class Hand
{

    public static final int MAX_CARD = 30; //max cards in hand is 30
    
    private Card[] myCards; // private Card Array
    private int numCards; // private variable to store number of cards in hand
    
    // default constructor for Hand object
    public Hand()
    {
        this.myCards = new Card[MAX_CARD];
    }
    
    //reset hand 
    public void resetHand()
    {
        myCards = null;
        numCards = 0;
    }
    
    // take card mutator which adds a card to your hand
    public boolean takeCard(Card card)
    {
        if (numCards >= MAX_CARD)
            return false;
        else
            this.myCards[numCards] = card;
        numCards++;
        return true;    
    }
    // mutator playCard, plays the top card from a players hand
    public Card playCard()
    {
        Card topCard;
        
        topCard = myCards[numCards -1];
        myCards[numCards - 1] = null;
        numCards--;
        return topCard;
        
    }
    
    //accessor shows number of cards 
    public int numCards()
    {
        return numCards;
    }
    
    //accessor to inspect a specific card in hand
    public Card inspectCard(int k)
    {
        return myCards[k]; 
    }
    
    // stringizer to print hand
    public String toString()
    {
        String retHand = ""; // initialize retHand
        
        for (int i = 0; i < numCards; i++)
            if (i < MAX_CARD -1)
                retHand = retHand + inspectCard(i) + ", ";
            else 
                retHand = retHand + inspectCard(i);
        return "Hand = ( " + retHand + " )";
           
         
    }
}
