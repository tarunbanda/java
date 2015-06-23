enum Suit
{
    clubs, diamonds, hearts, spades
}

// Card.java

public class Card
{
    // private data
    private char value; // takes the card value
    private Suit suit;  // takes the card suite
    private boolean errorFlag; // takes on boolean value for error in value


    // overloaded card constructors
    public Card( char value, Suit suit)
    {
        set(value, suit);
    }

    // default constructor
    public Card()
    {
        this('A', Suit.spades);
    }

    // mutator
    public boolean set(char value, Suit suit)
    {

        // suit is enum, so no test needed: all suits allowed
        this.suit = suit;

        // validates the value parameter
        if (isValid(value, suit))
        { 
            this.value = value;
            return errorFlag = false;
        }
        else 
            return errorFlag = true;
    }

    // static helper 
    static boolean isValid(char value, Suit suit)
    {
        char upCase; // for upcasing char
        // test val:  convert to uppercase to simplify
        upCase = Character.toUpperCase(value);


        // check for validity
        if (upCase == 'A' || upCase == 'K' || upCase == 'Q' || upCase == 'J'
                || upCase == 'T' || (upCase >= '2' && upCase <= '9'))
            return true;
        else
        {
            return false;
        }
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

        if (card.value == value && card.suit == suit)
            return true;
        else 
        {
            return false;
        }

    }

    // stringizer shows card values and error
    public String toString()
    {
        String retVal; // initialize retVal

        if (errorFlag)
        {
            retVal = "** illegal **";
        }
        else 
        {
            retVal = String.valueOf(value) + " of " + suit;
        }
        return retVal;

    }
}