public class TestStackNode
{
   public static void main (String[] args)
   {
      StackNode node1 = new StackNode(), node2 = new StackNode();

      // one way to use Stack Nodes
      node1.next = node2;

      // a more common way to use StackNodes
      node2.next = new StackNode();

      for (StackNode p = node1; p != null; p = p.next)
         p.show();
      System.out.println();
   }
 }