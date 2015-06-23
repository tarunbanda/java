import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

class GUICard extends JFrame
{
    // 14 = A thru K +joker
    private static Icon[][] iconCards = new ImageIcon[14][4]; 
    private static Icon iconBack;
    private static boolean iconsLoaded = false;

    private static String cardlValsConvertAssist = "23456789TJQKAX";
    private static String suitValsConvertAssist = "CDHS";
    private static Card.Suit suitConvertAssist[] =
    { Card.Suit.clubs, Card.Suit.diamonds, Card.Suit.hearts, Card.Suit.spades };

    // loadcards method which contains all cards and a cardback
    static void loadCardIcons()
    {
        if (iconsLoaded)
            return;
        iconsLoaded = true;

        String imageFileName;
        int intSuit;
        int intVal;

        for (intSuit = 0; intSuit < 4; intSuit++)
            for (intVal = 0; intVal < 14; intVal++)
            {
                imageFileName = "images/" + turnIntIntoCardValueChar(intVal)
                        + turnIntIntoCardSuitChar(intSuit) + ".gif";
                iconCards[intVal][intSuit] = new ImageIcon(imageFileName);
            }
        imageFileName = "images/BK.gif";
        iconBack = new ImageIcon(imageFileName);
    }

    // getIcon accessor that can give a card icon
    static public Icon getIcon(Card card)
    {
        loadCardIcons(); // will not load twice, so no worries.
        return iconCards[turnCardValueIntoInt(card)][turnCardSuitIntoInt(card)];
    }

    // accessor that can return the cardBack icon
    static public Icon getBackCardIcon()
    {
        loadCardIcons();
        return iconBack;
    }

    // static helper to turn int into suit char
    static public char turnIntIntoCardSuitChar(int k)
    {
        if (k < 0 || k > 3)
            return '?';
        return suitValsConvertAssist.charAt(k);
    }

    // static helper to turn int into value char
    static public char turnIntIntoCardValueChar(int k)
    {

        if (k < 0 || k > 13)
            return '?';
        return cardlValsConvertAssist.charAt(k);
    }

    // static helper to turn into into card suit
    static public Card.Suit turnIntIntoSuit(int k)
    {
        if (k < 0 || k > 3)
            return suitConvertAssist[3];
        return suitConvertAssist[k];
    }

    // static helper to turn card value to int
    static public int turnCardValueIntoInt(Card card)
    {
        return cardlValsConvertAssist.indexOf(card.getVal());
    }

    // static helper to turn card suit into int
    static public int turnCardSuitIntoInt(Card card)
    {
        return Arrays.asList(suitConvertAssist).indexOf(card.getSuit());
    }
}
