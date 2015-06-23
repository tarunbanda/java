import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;


public class MainCardTable
{
    static int NUM_CARDS_PER_HAND = 7;
    static int NUM_PLAYERS = 2;
    static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
    static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
    static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
    static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS];
    
    static Icon generateRandomCard()
    {
        GUICard rndCard = new GUICard();
        rndCard.loadCardIcons();
        int val,suit;
        
        val = (int)(Math.random()*13);
        suit = (int)(Math.random()*3);
        Card card = new Card(
                rndCard.turnIntIntoCardValueChar(val),
                rndCard.turnIntIntoSuit(suit));
        return GUICard.getIcon(card);
    }

    public static void main(String[] args)
    {
        
        int k;
        String title = "CS1B CardTable";
        GUICard.loadCardIcons();

        CardTable myCardTable = new CardTable(title, NUM_CARDS_PER_HAND,
                NUM_PLAYERS);
        myCardTable.setSize(800, 600);
        myCardTable.setLocationRelativeTo(null);
        myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myCardTable.setVisible(true);

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
        myCardTable.setLayout(layout);

        for (k = 0; k < NUM_CARDS_PER_HAND; k++)
        {
            computerLabels[k] = new JLabel(GUICard.getBackCardIcon());
        }
        
        for (k = 0; k < NUM_PLAYERS; k++)
        {
            playedCardLabels[k] = new JLabel(generateRandomCard(),JLabel.CENTER);
        }
        
        playLabelText[0] = new JLabel("Computer",JLabel.CENTER);
        playLabelText[1] = new JLabel("You",JLabel.CENTER);
        
        //
        for (k = 0; k < NUM_CARDS_PER_HAND; k++)
        {
            humanLabels[k] = new JLabel(generateRandomCard());
        }

        // place your 3 controls into frame
        for (k = 0; k < NUM_CARDS_PER_HAND; k++)
        {
            myCardTable.player.add(humanLabels[k]);
        }
        
        for (k = 0; k < NUM_PLAYERS; k++)
        {
            myCardTable.playArena.add(playedCardLabels[k]);
        }
        
        myCardTable.playArena.add(playLabelText[0]);
        myCardTable.playArena.add(playLabelText[1]);
        
         for (k = 0; k < NUM_CARDS_PER_HAND; k++)
         {
             myCardTable.computer.add(computerLabels[k]);
         }
         
        myCardTable.setVisible(true);
    }
}
