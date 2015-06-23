import java.util.Random;

public class Deck
{
    // initializing private variables
    private Card[] cards;
    private int topCard;
    private int numPacks;

    // initializing static variables
    private final static int MAX_PACKS = 6;
    private final static int NUM_CARDS_PER_PACK = 52;
    private final static int MAX_CARDS_PER_DECK = MAX_PACKS*NUM_CARDS_PER_PACK;
    private static final int DEFAULT_PACKS = 1;
    
    //initialize static masterPack
    private static Card[] masterPack;
    private static int masterPackInt; //int that is 0 or 1 

    // deck constructor with input #packs
    public Deck(int numPacks)
    {
        allocateMasterPack();
        this.numPacks = numPacks;
        init(numPacks);
    }

    // default deck constructor
    public Deck()
    {
        allocateMasterPack();
        init(DEFAULT_PACKS); // creates deck object with one pack
    }

    // initializes deck
    public boolean init(int numPacks)
    {
        boolean initVal;//stores and returns boolean value
        int k;
        this.numPacks = numPacks;

        // only constructs deck if numPack is valid
        if (this.numPacks > 0 && this.numPacks <= MAX_PACKS)
        {
            topCard = numPacks * NUM_CARDS_PER_PACK;
            cards = new Card[topCard];
            for (k = 0; k < cards.length; k++)
                cards[k] = masterPack[k % NUM_CARDS_PER_PACK];
            initVal = true;
        } 
        else
            initVal = false;

        return initVal;
    }

    // shuffles deck
    public void shuffle()
    {
        final Random random = new Random(1L);

        for (int i = topCard - 1; i > 0; i--)
        {
            final int randInt = random.nextInt(i + 1);
            final Card temp = cards[i];
            cards[i] = cards[randInt];
            cards[randInt] = temp;
        }
    }

    // deals cards from top to bottom of deck
    public Card dealCard()
    {
        final Card errorFlag = new Card('E', Card.Suit.spades);

        if (topCard == 0)
            return errorFlag;
        else
        {
            return new Card(cards[--topCard]);
        }
    }

    // returns topCard
    public int getNumCards()
    {
        return topCard;
    }

    // returns card object from the deck array
    public Card inspectCard(int k)
    {
        final Card errorFlag = new Card('E', Card.Suit.spades);

        if (k > 0 && k <= cards.length)
            return new Card(cards[k - 1]);
        else
            return errorFlag;
    }

    // outputs deck to string
    public String toString()
    {
        int i;
        String deckString = "{ ";

        for (i = 0; i < topCard; i++)
        {
            deckString += cards[i].toString();
            if (i < topCard - 1)
                deckString += ", ";
        }
        deckString += " }";
        return deckString;
    }

    // creates a masterpack of 52 cards
    private static void allocateMasterPack()
    {
        if (masterPackInt != 0)
            return;
        else
        {
            masterPackInt = 1;
            masterPack = new Card[NUM_CARDS_PER_PACK];
            final String cardVals = "23456789TJQKA"; 
            final int firstQuarter = 13;
            final int secondQuarter = 26;
            final int thirdQuarter = 39;
            int i; 

            //for loop that populates a full deck
            for (i = 0; i < NUM_CARDS_PER_PACK; i++) 
            {
                if (i < firstQuarter) //first 13 cards are clubs
                {
                    masterPack[i] = new Card(cardVals.charAt(i),
                            Card.Suit.clubs);
                    System.out.println(masterPack[i]);
                }
                if (i >= firstQuarter && i < secondQuarter) // next 13 are diamonds
                {
                    masterPack[i] = new Card(cardVals.charAt(i % firstQuarter),
                            Card.Suit.diamonds);
                    System.out.println(masterPack[i]);
                }
                if (i >= secondQuarter && i < thirdQuarter)// hearts
                {
                    masterPack[i] = new Card(cardVals.charAt(i % firstQuarter),
                            Card.Suit.hearts);
                    System.out.println(masterPack[i]);
                }
                if (i >= thirdQuarter && i < NUM_CARDS_PER_PACK) // last 13 are spades
                {
                    masterPack[i] = new Card(cardVals.charAt(i % firstQuarter),
                            Card.Suit.spades);
                    System.out.println(masterPack[i]);
                }
            }
        }
    }
}
