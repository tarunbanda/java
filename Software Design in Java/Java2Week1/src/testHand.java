
public class testHand
{

    public static void main(String[] args)
    {
        // initialize 4 card objects
        Card card1, card2, card3, card4;
        
        card1 = new Card();
        card2 = new Card('9', Card.Suit.hearts);
        card3 = new Card('F', Card.Suit.clubs);
        card4 = new Card('2', Card.Suit.diamonds);
        
        //initialize hand object
        Hand hand1;
        
        hand1 = new Hand();
        Card[] testCards = {card1, card2, card3, card4}; //create an array of cards to loop through
        System.out.println(card1 +"" + card2 + card3 + card4);
        int x;
        // for loop to assign cards 1-4 to hand until MAX_CARD
        for (int i = 0; i < Hand.MAX_CARD; i++)
        {
            x = i % 4;
            hand1.takeCard(testCards[x]);
        }
        
        // Can tell if your had is full
        System.out.println(hand1.numCards());
        if (hand1.numCards() == Hand.MAX_CARD)
        System.out.println("Hand full");
        
        // Prints hand object
        System.out.println(hand1.toString() + "\n");
        
        // test inspectCard()
        System.out.println("Testing inspectCard()\n" + hand1.inspectCard(0));
        System.out.println(hand1.inspectCard(1) + "\n");
       
        // while loop to play all cards in hand
        while (hand1.numCards() > 0)
        {
            
            System.out.println(hand1.playCard());
        
        }
        
        
        //Tests toString command after empyting hand
        System.out.println("\nAfter playing all cards");
        System.out.println(hand1.toString());
        
        int y;
        for (int i = 0; i < Hand.MAX_CARD; i++)
        {
            y = i % 4;
            hand1.takeCard(testCards[y]);
        }
        // Prints hand object
        System.out.println(hand1.toString() + "\n");
        
            hand1.resetHand();
            System.out.println(hand1.toString());
            System.out.println(hand1.playCard());
        
    }

}
