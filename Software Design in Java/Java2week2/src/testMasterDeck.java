
public class testMasterDeck
{

    public static void main(String[] args)
    {
        Card[] masterPack = new Card[52];
        final String cardVals = "23456789TJQKA";
        
        int i, j;
        
        for (i=0; i<52; i++)
        {
            if (i<13)
            {
                masterPack[i] = new Card(cardVals.charAt(i), Card.Suit.clubs);
                System.out.println(masterPack[i]);
            }
            if (i >= 13 && i < 26)
                {
                masterPack[i] = new Card(cardVals.charAt(i%13), Card.Suit.diamonds);
                System.out.println(masterPack[i]);
                }
            if (i >= 26 && i < 39)
            {
                masterPack[i] = new Card(cardVals.charAt(i%13), Card.Suit.hearts);
                System.out.println(masterPack[i]);
            }
            if (i >= 39 && i < 52)
            {
                masterPack[i] = new Card(cardVals.charAt(i%13), Card.Suit.spades);
                System.out.println(masterPack[i]);
            }
        }
        
//        Card.Suit st;
//        char val;
//        for (i = 0; i < masterPack.length; i++)
//            masterPack[i] = new Card();
//
//        for (i = 0; i < 4; i++)
//        {
//            // set the suit for this loop pass
//            switch (i)
//            {
//            case 0:
//                st = Card.Suit.clubs;
//                break;
//            case 1:
//                st = Card.Suit.diamonds;
//                break;
//            case 2:
//                st = Card.Suit.hearts;
//                break;
//            case 3:
//                st = Card.Suit.spades;
//                break;
//            default:
//                // should not happen but ...
//                st = Card.Suit.spades;
//                break;
//            }
//
//            // now set all the values for this suit
//            for (val = '2', j = 0; val <= '9'; val++, j++)
//                masterPack[13 * i + j].set(val, st);
//            masterPack[13 * i + 8].set('T', st);
//            masterPack[13 * i + 9].set('J', st);
//            masterPack[13 * i + 10].set('Q', st);
//            masterPack[13 * i + 11].set('K', st);
//            masterPack[13 * i + 12].set('A', st);
//            }
    }
}
