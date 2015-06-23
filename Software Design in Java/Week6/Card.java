// Card.java

public class Card implements Cloneable
{

    public enum Suit { clubs, diamonds, hearts, spades }

    // for ordering
    public static char[] valueRanks = { '2', '3', '4', '5', '6', '7', '8', '9', 
        'T', 'J', 'Q', 'K', 'A'};
    static Suit[] suitRanks = {Suit.clubs, Suit.diamonds, Suit.hearts, 
        Suit.spades};
    static int numValsInOrderingArray = 13;

    // private data
    private char value; // takes the card value
    private Suit suit; // takes the card suite
    private boolean errorFlag; // takes on boolean value for error in value

    // overloaded card constructors
    public Card(char setValue, Suit setSuit)
    {
        set(setValue, setSuit);
    }

    // constructor for only the value
    public Card(char setValue)
    {
        this(setValue, Suit.spades);
    }

    // constructor to copy card
    protected Card clone() throws CloneNotSupportedException
    {
        final Card newCard = (Card)super.clone();
        newCard.set(newCard.getVal(), (Suit)newCard.getSuit());
        return newCard;
    }

    // default constructor
    public Card()
    {
        this('A', Suit.spades);
    }
    
    // sort member methods
    public int compareTo(Object other)
    {
        if (!(other instanceof Card))
            return -1;

        final Card otherCard = (Card) other;

        if (this.value == otherCard.value)
            return getSuitRank(this.suit) - getSuitRank(otherCard.suit);
        return getValueRank(this.value) - getValueRank(otherCard.value);
    }

    // helpers for compareTo()
    public static int getSuitRank(Suit st)
    {
        int k;

        for (k = 0; k < 4; k++)
            if (suitRanks[k] == st)
                return k;
        // should not happen
        return 0;
    }

    public static int getValueRank(char val)
    {
        int k;

        for (k = 0; k < numValsInOrderingArray; k++)
            if (valueRanks[k] == val)
                return k;

        // should not happen
        return 0;
    }

    // mutator
    public boolean set(char setValue, Suit setSuit)
    {
        final char upCase = Character.toUpperCase(setValue);

        // validates the value parameter
        if (isValid(upCase, setSuit))
        {
            this.value = upCase;
            this.suit = setSuit;
            errorFlag = false;
            return true;
        }

        errorFlag = true;
        return false;
    }

    // static helper
    private static boolean isValid(char value, Suit suit)
    {
        char upCase; // for upcasing char
        final String legalVals = "23456789TJQKAX"; // string with legal values

        // convert to uppercase to simplify
        upCase = Character.toUpperCase(value);

        // check for validity
        return legalVals.indexOf(upCase) >= 0;
    }

    // accessors
    public char getVal()
    {
        return value;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public boolean errorFlag()
    {
        return errorFlag;
    }

    // stringizer shows card values and error
    public String toString()
    {
        String retVal; // initialize retVal

        // if errorFlag is true return illegal string message
        if (errorFlag)
            return "** illegal **";

        // return string value and suit for card object
        retVal = String.valueOf(value) + " of " + String.valueOf(suit);

        return retVal;

    }
}