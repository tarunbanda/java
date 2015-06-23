// ------------- Class stackExample -------------- 
public class stackExample
{ 
   // -------  main --------------
   public static void main(String[] args)
   {    
      MyStack stk1 = new MyStack();
      MyStack stk2 = new MyStack();
      int k;
      double result;
      final double STACK_EMPTY = Double.MIN_VALUE;
   
      // Test the Stack - there should be nothing on it -----
      if ( !stk1.testStack(1) )
         System.out.println("empty stack; cannot pop");
   
      // push too much intentionally
      for (k = 0; k < 11; k++)
         if ( ! stk1.push( k * 1.1 ) )
            System.out.println("stack stk1 full; cannot push");
   
      for (k = 0; k < 5; k++)
         if ( ! stk2.push( k * 9 ) )
            System.out.println("stack stk2 full; cannot push");
   
      // pop too much intentionally 
      System.out.println("\n--------- First Stack ---------");
      for (k = 0; k < 11; k++)
         if ( stk1.testStack(1) )
            System.out.println( stk1.pop() + " : " );
         else
            System.out.println("empty stack; cannot pop");
      System.out.println();
       
      // pop too much intentionally 
      System.out.println("\n--------- Second Stack ---------");
      for (k = 0; k < 11; k++)
         if ( stk2.testStack(1) )
            System.out.println( stk2.pop() + " : " );
         else
            System.out.println("empty stack; cannot pop");
      System.out.println();
   } 
} // end of class Foothill ---------------------

