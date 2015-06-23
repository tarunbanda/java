import java.util.Scanner;

public class testDeck2
{

    public static void main(String args[])
    {
        // interact with hand object
        Scanner scanIn = new Scanner(System.in);

        System.out.println("How many hands? (1 - 10, please): ");
        int numHands = scanIn.nextInt();

        Deck dealerDeck = new Deck();
        dealerDeck.shuffle();
        Hand[] playerHands = new Hand[numHands];

        for (int i = 0; i < numHands; i++)
        {
            playerHands[i] = new Hand();
        }
        int stopDeal = dealerDeck.getNumCards() % numHands;
        while (dealerDeck.getNumCards() > 0 && dealerDeck.getNumCards() > stopDeal)
        {
                for (int i = 0; i < numHands; i++)
                {
                    playerHands[i].takeCard(dealerDeck.dealCard());
                }
        }
        
        for (int i = 0; i < numHands; i++)
        {
            System.out.println(playerHands[i]);
        }
    }
}
