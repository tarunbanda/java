// SortableCard class, partial code
import java.util.Random;

public class SortableCard extends Card implements Comparable<SortableCard>
{
    protected static char[] valueRanks =
    { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };
    protected static Suit[] suitRanks =
    { Suit.clubs, Suit.diamonds, Suit.hearts, Suit.spades };
    protected static final int NUM_VALS = 13;

    // TODO: Hmmm... isn't somethin' missing 'ere?
    public SortableCard()
    {
        
    }

    public SortableCard(char val)
    {

    }

    public SortableCard(char val, Card.Suit suit)
    {

    }

    public int compareTo(SortableCard other)
    {
        if (this.value == other.value)
            return (getSuitRank(this.suit) - getSuitRank(other.suit));
        return getValueRank(this.value) - getValueRank(other.value);
    }

    public static int getSuitRank(Card.Suit st)
    {
        for (int k = 0; k < 4; k++)
            if (suitRanks[k] == st)
                return k;
        return 0; // should not happen
    }

    public static int getValueRank(char val)
    {
        for (int k = 0; k < NUM_VALS; k++)
            if (valueRanks[k] == val)
                return k;
        return 0; // should not happen
    }

    /**
     * Returns a random SortableCard. Note that you use java.util.Random, not
     * Math.random() here. YOU SHOULD NOT SET THE SEED. I WILL SEED THE RANDOM
     * GENERATOR DURING MY TESTS.
     */
    public static SortableCard generateRandomSortableCard(Random random)
    {
        Card.Suit suit = turnIntIntoSuit(random
                .nextInt(SortableCard.suitRanks.length));
        char val = turnIntIntoVal(random
                .nextInt(SortableCard.valueRanks.length));

        return new SortableCard(val, suit);
    }

    // note: this method not needed if we use int for suits instead of enum
    private static Card.Suit turnIntIntoSuit(int k)
    {
        return Card.Suit.values()[k];
    }

    private static char turnIntIntoVal(int k)
    {
        String legalVals = "23456789TJQKA";
        if (k < 0 || k >= legalVals.length())
            return '?';
        return legalVals.charAt(k);
    }
}