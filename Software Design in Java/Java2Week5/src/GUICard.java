import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

class GUICard extends JFrame
{

    private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
    private static Icon iconBack;
    private static boolean iconsLoaded = false;
    
    private static String cardlValsConvertAssist = "23456789TJQKAX";
    private static String suitValsConvertAssist  = "CDHS";
    private static Card.Suit suitConvertAssist[] =
    {
       Card.Suit.clubs,
       Card.Suit.diamonds,
       Card.Suit.hearts,
       Card.Suit.spades
    };

    static void loadCardIcons()
    {
        if (iconsLoaded)
            return;
        iconsLoaded = true;
        
        String imageFileName;
        int intSuit, intVal;
        
        for (intSuit = 0; intSuit < 4; intSuit++)
        {
            for (intVal = 0; intVal < 14; intVal++ )
            {
                imageFileName = "images/"
                        + turnIntIntoCardValueChar(intVal) 
                        + turnIntIntoCardSuitChar(intSuit)
                        + ".gif";
                iconCards[intVal][intSuit] = new ImageIcon(imageFileName);
            }
        }
        imageFileName = "images/BK.gif";
        iconBack = new ImageIcon(imageFileName);
    }

    static public Icon getIcon(Card card)
    {
        loadCardIcons(); // will not load twice, so no worries.
        return iconCards[turnCardValueIntoInt(card)]
                [turnCardSuitIntoInt(card)];
    }
    
    static public Icon getBackCardIcon()
    {
        loadCardIcons();
        return iconBack;
    }
    
    static char turnIntIntoCardSuitChar(int k)
    {
       if ( k < 0 || k > 3)
          return '?'; 
       return suitValsConvertAssist.charAt(k);
    }
    
    static char turnIntIntoCardValueChar(int k)
    {
    
       if ( k < 0 || k > 13)
          return '?'; 
       return cardlValsConvertAssist.charAt(k);
    }
    
    static Card.Suit turnIntIntoSuit(int k)
    {
       if ( k < 0 || k > 3)
          return suitConvertAssist[3]; 
       return suitConvertAssist[k];
    }
    
    private static int turnCardValueIntoInt(Card card)
    {
        return cardlValsConvertAssist.indexOf(card.getVal());
    }
    
    private static int turnCardSuitIntoInt(Card card)
    {
        return Arrays.asList(suitConvertAssist).indexOf(card.getSuit());
    }
}
