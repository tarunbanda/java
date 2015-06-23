public class Card
{
    // type and constants
    public enum Suit
    {
        clubs, diamonds, hearts, spades
    }

    static char DEFAULT_VAL = 'A';
    static Suit DEFAULT_SUIT = Suit.spades;

    // private data
    protected char value;
    protected Suit suit;
    protected boolean errorFlag;

    // 4 overloaded constructors
    public Card(char theValue, Suit theSuit)
    {
        // because mutator sets errorFlag, we don't have to test
        set(theValue, theSuit);
    }

    public Card(char theValue)
    {
        this(theValue, DEFAULT_SUIT);
    }

    public Card()
    {
        this(DEFAULT_VAL, DEFAULT_SUIT);
    }

    public Card(Card card)
    {
        this(card.value, card.suit);
    }

    public boolean set(char theValue, Suit theSuit)
    {
        final char upVal = Character.toUpperCase(theValue);

        if (!isValid(upVal, theSuit))
        {
            errorFlag = true;
            return false;
        }

        // else implied
        errorFlag = false;
        this.value = upVal;
        this.suit = theSuit;
        return true;
    }

    public char getVal()
    {
        return value;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public boolean getErrorFlag()
    {
        return errorFlag;
    }

    public String toString()
    {
        String retVal;

        if (errorFlag)
            return "** illegal **";

        retVal = String.valueOf(value);
        retVal += " of ";
        retVal += String.valueOf(suit);

        return retVal;
    }

    private static boolean isValid(char value, Suit suit)
    {
        // don't need to test suit (enum), but leave in for clarity
        char upVal; // string to hold the 1-char value
        final String legalVals = "23456789TJQKA";

        // convert to uppercase to simplify (need #include )
        upVal = Character.toUpperCase(value);

        // check for validity
        return legalVals.indexOf(upVal) >= 0;
    }

    public boolean equals(Card card)
    {
        if (this.value != card.value)
            return false;
        if (this.suit != card.suit)
            return false;
        if (this.errorFlag != card.errorFlag)
            return false;
        return true;
    }
}