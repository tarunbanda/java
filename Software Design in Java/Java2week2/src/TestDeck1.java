import java.util.Random;
import java.util.Scanner;


public class TestDeck1
{
    public static void main(String[] args)
    {
        
       Deck deck1, deck2, deck3, deck4, deck5;
       
       deck1 = new Deck(1);
       deck1.init(2);
       deck1.init(3);
       
       //System.out.println(deck1.getNumCards());

       System.out.println(deck1.toString());
       System.out.println("\n");
       //System.out.print(deck2.toString());
       
       System.out.println(deck1.getNumCards());
       deck1.shuffle();
       //System.out.println(deck1.getNumCards());
       System.out.println(deck1.toString());
       
       System.out.println(deck1.getNumCards());
       System.out.println(deck1.dealCard());
       System.out.println("\n");
       System.out.println(deck1.dealCard());
       System.out.println(deck1.getNumCards());
       //System.out.println(deck1.toString());
       
       System.out.println(deck1.inspectCard(0));
       System.out.println(deck1.inspectCard(150));
       
       int x =deck1.getNumCards();
       System.out.println(x);
       
       for (int i = 0; i < x; i++)
           {
           deck1.dealCard();
           System.out.println(deck1.getNumCards());
           }
       
           System.out.println(deck1.toString());
       }
}
