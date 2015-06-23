import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;



public class testCardBack
{

    public static void main(String[] args)
    {
        int NUM_CARDS_PER_HAND = 7;
        int NUM_PLAYERS = 2;
        String title = "CS1B CardTable";
        Card x;
        
        //GUICard.loadCardIcons();
        GUICard tempCard = new GUICard();
        tempCard.loadCardIcons();
        //GUICard.loadCardIcons();
        //Icon tempIcon = GUICard.getIcon(new Card('A', Card.Suit.spades));
        //Icon tempIcon = new ImageIcon("images/BK.gif");
        Icon tempIcon = GUICard.getBackCardIcon();
        
        
        // TODO Auto-generated constructor stub
        JFrame frmMyWindow = new JFrame("Card Room");
        frmMyWindow.setSize(1150, 650);
        frmMyWindow.setLocationRelativeTo(null);
        frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frmMyWindow.setVisible(true);
        
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);
        frmMyWindow.setLayout(layout);
        

        
        JLabel label = new JLabel(tempIcon);
        label.setForeground(Color.BLUE);
        frmMyWindow.add(label);
        frmMyWindow.setVisible(true);
        
        
        
    }

}
