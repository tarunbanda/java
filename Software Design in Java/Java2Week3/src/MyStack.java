// ------------- Class MyStack -------------- 
public class MyStack
{
   final private static int SIZE = 10;
   private double stck[];
   private int tos;
    
   // ---------------------------------------------------
   public  MyStack()
   {
      tos = 0;
      stck = new double[SIZE];
   }
     
   // ---------------------------------------------------
   public boolean push( double item )
   {
      if (tos == SIZE)
         return false;
      stck[tos++] = item;
      return true;
   }
     
   // ---------------------------------------------------
   public double pop()
   {
      if (tos == 0)
         return Double.MIN_VALUE;  // non-optimal way to flag error
          
      return stck[--tos];
   }
   //---------------------------------------------------
   // returns true if at least num_needed items are on the stack
   public boolean testStack( int num_needed )
   {
      if (tos >= num_needed)
         return  true;
      else
         return  false;
   }
} // end of class MyStack -------------------------