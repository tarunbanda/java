import java.util.*;
import java.text.*;

public class TestFloatNode
{
   public static void main (String[] args)
   {
      FloatNode flt1 = new FloatNode(3.33F), 
         flt2 = new FloatNode(4.44F), flt3 = new FloatNode(5.55F), p;

      // link up our three FloatNodes
      flt1.next = flt2;
      flt2.next = flt3; 

      // show the stack
      for ( p = flt1; p != null; p = (FloatNode)(p.next) )
      {
         p.show();
      }
      System.out.println();
   }
 }