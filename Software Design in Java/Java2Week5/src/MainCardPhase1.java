import javax.swing.*;
import java.awt.*;


public class MainCardPhase1
{

    public static void main(String[] args)
    {
       int k;
       static int NUM_CARD_IMAGES = 7; // 52 + 4 jokers + 1 back-of-card image
       static Icon[] icon = new ImageIcon[NUM_CARD_IMAGES];
       static JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
       
       // prepare the image icon array
       CardsPhase1 x = new CardsPhase1();
       
       // establish main frame in which program will run
       JFrame frmMyWindow = new JFrame("Card Room");
       frmMyWindow.setSize(1150, 650);
       frmMyWindow.setLocationRelativeTo(null);
       frmMyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       // set up layout which will control placement of buttons, etc.
       FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 5, 20);   
       frmMyWindow.setLayout(layout);
       
       for (k = 0; k < NUM_CARD_IMAGES;k++)
       {
           icon[k] = 
       }
       
       // prepare the image label array
       JLabel[] labels = new JLabel[NUM_CARD_IMAGES];
       for (k = 0; k < NUM_CARD_IMAGES; k++)
       {
          //icon[i] = x.getIcon(card[i]);
          labels[k] = new JLabel(icon[k]);
       }
       // place your 3 controls into frame
       for (k = 0; k < NUM_CARD_IMAGES; k++)
       {
          frmMyWindow.add(labels[k]);
       }

       // show everything to the user
       frmMyWindow.setVisible(true);
    }
}
