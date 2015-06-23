

public class testProject
{

    public static void main(String[] args)
    {
        
        Card[] masterPack = new Card[52];
        final String cardVals = "23456789TJQKA";
        int i;
        CardQueue test = new CardQueue();
        CardNode p;
        
//        for (i=0; i<52; i++)
//        {
//            if (i<13)
//            {
//                masterPack[i] = new Card(cardVals.charAt(i), Card.Suit.clubs);
//                p = new CardNode(masterPack[i]);
//                //System.out.println(masterPack[i]);
//            }
//            if (i >= 13 && i < 26)
//                {
//                masterPack[i] = new Card(cardVals.charAt(i%13), Card.Suit.diamonds);
//                p = new CardNode(masterPack[i]);
//                //System.out.println(masterPack[i]);
//                }
//            if (i >= 26 && i < 39)
//            {
//                masterPack[i] = new Card(cardVals.charAt(i%13), Card.Suit.hearts);
//                p = new CardNode(masterPack[i]);
//                //System.out.println(masterPack[i]);
//            }
//            if (i >= 39 && i < 52)
//            {
//                masterPack[i] = new Card(cardVals.charAt(i%13), Card.Suit.spades);
//                p = new CardNode(masterPack[i]);
//                //System.out.println(masterPack[i]);
//            }
//        }
        
        
        
        Card f = new Card('B', Card.Suit.spades);
//        for (i = 0; i < 52; i++)
//        {
//            test.addCard(masterPack[i]);
//        }
        test.addCard(f);
        System.out.println(test.getQueueLength());
        //f = test.removeCard();
        try
        {
            System.out.println(test.removeCard());
            
//            for (i = 0; i < 52; i++)
//            {
//                System.out.println(test.removeCard());
//                System.out.println(test.getQueueLength());
//            }
            //System.out.println(test.removeCard());
//            test.addCard(masterPack[2]);
//            test.addCard(masterPack[3]);
//            System.out.println(test.removeCard());
//            test.addCard(masterPack[4]);
//            System.out.println(test.removeCard());
//            test.addCard(masterPack[3]);
//            System.out.println(test.removeCard());
//            test.addCard(masterPack[6]);
//            System.out.println(test.removeCard());
//            System.out.println(test.removeCard());
        }
        catch (Queue.QueueEmptyException ex ) 
        {
            System.out.println("");
        }
        
        System.out.println(test.getQueueLength());

        //fstk.addCard(card[0]);
        // fstk.pushFloat(2.2F);
        // fstk.pushFloat(3.3F);
        // fstk.pushFloat(4.4F);

//        for (int k = 0; k < 5; k++)
//            if ((f = test.removeCard()) != null)
//                System.out.print(f + " ");
//            else
//                System.out.print("(empty stack) ");
//        System.out.println();
    }

}
