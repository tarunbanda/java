import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;

public class Foothill
{
    static int NUM_CARDS_PER_HAND = 7;
    static int NUM_PLAYERS = 2;
    static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
    static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];
    static JLabel[] playedCardLabels = new JLabel[NUM_PLAYERS];
    static JLabel[] playLabelText = new JLabel[NUM_PLAYERS];

    // static method to generate random card icons
    static Icon generateRandomCard()
    {
        final GUICard rndCard = new GUICard();
        GUICard.loadCardIcons();

        final Card card = new Card(rndCard.turnIntIntoCardValueChar((int) (Math
                .random() * 13)),
                rndCard.turnIntIntoSuit((int) (Math.random() * 3)));
        return GUICard.getIcon(card);
    }

    public static void main(String[] args)
    {

        int k;
        final String title = "CS1B CardTable";
        GUICard.loadCardIcons();

        // create cardTabel object to show cards on
        final CardTable myCardTable = new CardTable(title, NUM_CARDS_PER_HAND,
                NUM_PLAYERS);
        myCardTable.setSize(800, 600);
        myCardTable.setLocationRelativeTo(null);
        myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set cards as visible
        myCardTable.setVisible(true);

        // use FlowLayout to add objects to frame
        final FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
        myCardTable.setLayout(layout);

        // create an array of card backs for computer hand
        for (k = 0; k < NUM_CARDS_PER_HAND; k++)
        {
            computerLabels[k] = new JLabel(GUICard.getBackCardIcon());
        }

        // create two random cards to simulate cards being played
        for (k = 0; k < NUM_PLAYERS; k++)
        {
            playedCardLabels[k] = new JLabel(generateRandomCard(),
                    JLabel.CENTER);
        }

        // create two labels to represent cards that are played
        playLabelText[0] = new JLabel("Computer", JLabel.CENTER);
        playLabelText[1] = new JLabel("You", JLabel.CENTER);

        // create card random card icons to represent hand
        for (k = 0; k < NUM_CARDS_PER_HAND; k++)
        {
            humanLabels[k] = new JLabel(generateRandomCard());
        }

        // place your hand and computer hand into frame
        for (k = 0; k < NUM_CARDS_PER_HAND; k++)
        {
            myCardTable.player.add(humanLabels[k]);
            myCardTable.computer.add(computerLabels[k]);
        }

        // place 2 cards and into frame
        for (k = 0; k < NUM_PLAYERS; k++)
        {
            myCardTable.playArena.add(playedCardLabels[k]);
        }

        // add two labels to frame
        myCardTable.playArena.add(playLabelText[0]);
        myCardTable.playArena.add(playLabelText[1]);

        // set cards as visible
        myCardTable.setVisible(true);
    }
}
