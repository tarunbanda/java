public class TestFloatStack
{
   public static void main (String[] args)
   {
      FloatStack fstk = new FloatStack();
      float f;

      fstk.pushFloat(1.1F);
      fstk.pushFloat(2.2F);
      fstk.pushFloat(3.3F);
      fstk.pushFloat(4.4F);
      
      for (int k = 0; k < 5; k++)
         if ( (f = fstk.popFloat()) != FloatStack.STACK_EMPTY)
            System.out.print( f + " ");
         else
            System.out.print("(empty stack) ");
      System.out.println();
   }
 }