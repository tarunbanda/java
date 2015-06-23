public class Foothill
{
   public static void main(String[] args)
   {
      Card card1, card2, card3, card4;

      card1 = new Card();
      card2 = new Card('9', Suit.hearts);
      card3 = new Card('j', Suit.clubs);
      card4 = new Card('1', Suit.diamonds);
      
      System.out.println(card1 + "\n" + card2 + "\n" + card3 + "\n" + card4);
      
      card1.set('1', Suit.hearts);
      System.out.println("\n" + card1);
      
      System.out.println(card2.equals(card3));
      card3.set('9', Suit.hearts);
      System.out.println(card2.equals(card3));
      
      //System.out.println(card2 + " " + card4);
      
//      String report = card1.toString() + ", " + card2.toString() + ", "
//            + card3.toString() + ", " + card4.toString() + ", "
//            + ", " + ". ";
//
//      System.out.println(report);
//
//      if (!card1.set('1', Suit.clubs))
//         System.out.println("Set failed:  card1.set('1', Suit.clubs)");
//      if (!card1.set('T', Suit.clubs))
//         System.out.println("Set failed:  card1.set('T', Suit.clubs)");
//
//      
//      // test assignment operator for objects
//      System.out.println("card1: " + card1.toString() + "     card3: "
//            + card3.toString());
//
//      // notice the assignment operator is not a reference copy (unlike C++)
//      card1.set('Q', Suit.spades);
//      System.out.println("card1: " + card1.toString() + "     card3: "
//            + card3.toString());
   }
}