// Card.java

public class Card
{

    public enum Suit
    {
        clubs, diamonds, hearts, spades
    }

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
    public Card(Card card)
    {
        this(card.value, card.suit);
    }

    // default constructor
    public Card()
    {
        this('A', Suit.spades);
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
        final String legalVals = "23456789TJQKA"; // string with legal values

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

    // equals method to compare card objects
    boolean equals(Card card)
    {
        if (this.value != card.value)
            return false;
        if (this.suit != card.suit)
            return true;
        if (this.errorFlag != card.errorFlag)
            return false;
        return true;
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