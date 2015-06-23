import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.*;
import java.text.*;

public class CardTable extends JFrame
{
    static int MAX_CARDS_PER_HAND = 57;
    static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games
    
    private int numCardsPerHand;
    private int numPlayers;
    
    public JPanel computer, player, playArena;
    
    public CardTable(String title, int numCardsPerHand, int numPlayers)
    {
        // TODO Auto-generated constructor stub
        super(title);
        
        //set up main components
        computer = new JPanel(new GridLayout(1, numCardsPerHand, 10,10));
        player = new JPanel(new GridLayout(1, numCardsPerHand, 10,10));
        playArena = new JPanel(new GridLayout(2, numPlayers, 50,30));
        playArena.setPreferredSize(new Dimension(575, 250));
        
        //user border layout and put panels in proper areas
        setLayout(new BorderLayout(20,10));
        add(computer, BorderLayout.NORTH);
        add(playArena, BorderLayout.CENTER);
        add(player, BorderLayout.SOUTH);
        
        //set borders around panels
        computer.setBorder(new TitledBorder("Computer Hand"));
        playArena.setBorder(new TitledBorder("Playing Area"));
        player.setBorder(new TitledBorder("Your Hand"));

    }
    
    public int getNumCardsPerHand()
    {
        return numCardsPerHand;
    }
    
    public int getNumPlayers()
    {
        return numPlayers;
    }

}
