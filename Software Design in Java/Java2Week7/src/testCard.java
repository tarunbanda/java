// ======  Foothill.java ===================================================

public class testCard
{
   public static void main(String[] args)
   {
      DeckVec deck1 = new DeckVec(2);
      
      // deal first deck (two packs), unshuffled.
      while (deck1.getNumCards() > 0)
         System.out.print( deck1.dealCard() +  " /  ");
      System.out.println('\n');
      
      while (deck1.getNumCards() > 0)
         System.out.print( deck1.dealCard() +  " /  ");
      System.out.println('\n');

      // deal one pack in the second deck, first unshuffled ...
      DeckVec deck2 = new DeckVec();

      while (deck2.getNumCards() > 0)
         System.out.print( deck2.dealCard() +  " /  ");
      System.out.println('\n');

      // now shuffled (don't forget to reload the deck)
      deck2.init();
      deck2.shuffle();
      while (deck2.getNumCards() > 0)
         System.out.print( deck2.dealCard() +  " /  ");
      System.out.println('\n');
   }
}
//public class testCard
//{
//   public static void main(String[] args)
//   {
//      Deck deck1 = new Deck(2);
//      
//      // deal first deck (two packs), unshuffled.
//      while (deck1.getNumCards() > 0)
//         System.out.print( deck1.dealCard() +  " /  ");
//      System.out.println('\n');
//      
//      while (deck1.getNumCards() > 0)
//         System.out.print( deck1.dealCard() +  " /  ");
//      System.out.println('\n');
//
//      // deal one pack in the second deck, first unshuffled ...
//      Deck deck2 = new Deck();
//
//      while (deck2.getNumCards() > 0)
//         System.out.print( deck2.dealCard() +  " /  ");
//      System.out.println('\n');
//
//      // now shuffled (don't forget to reload the deck)
//      deck2.init();
//      deck2.shuffle();
//      while (deck2.getNumCards() > 0)
//         System.out.print( deck2.dealCard() +  " /  ");
//      System.out.println('\n');
//   }
//}