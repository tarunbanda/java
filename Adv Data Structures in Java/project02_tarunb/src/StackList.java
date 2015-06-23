import java.util.Iterator;
import java.util.NoSuchElementException;


//Class Stack ---------------------------------------
class StackList<E> implements Cloneable, Iterable<E>
{
   // pointer to top node in stack
   private Node top;
   private int size;
   
   private class Node {
		private E data;
		private Node next;
	}
   
   // constructor
   public StackList()
   {
	   top = null;
       size = 0;
   }
   
   //helper class to determine if stack is empty
   public boolean isEmpty()
   {
      return top == null;
   }
   
   //helper class, clears stacklist
   public void clearStackList()
   {
	   top = null;
	   size = 0;
   }
   
   //accessor for size
   public int size()
   {
	   return size;
   }
   
   //adds nodes to the top of the stack
   public void push(E data)
   {   
	   if(data == null)
		   return;
	   
	   Node oldtop = top;
       top = new Node();
       top.data = data;
       top.next = oldtop;
       size++;
   }  
   
   //removes and returns nodes form the top of the stack
   public E pop()
   {
	   if (isEmpty()) throw new NoSuchElementException("Stack Empty"); 
	   E temp = top.data;        
       top = top.next;            
       size--;
       return temp;      
   }
   
   //returns nodes from the top of the stack without removing them 
   public E peek()
   {
	   if (isEmpty()) throw new NoSuchElementException("Stack Empty"); 
	   return top.data;
   }

   public String toString() {
		String delim = "";
		StringBuilder s = new StringBuilder();
		for (E item : this)
		{
			s.append(delim).append(item);
			delim = ",\n";
		}
		return   "[" +s.toString() + "]";
	}

	public Iterator<E> iterator() {
		return new StackIterator();
	}

	//iteragor to loop through the stack
	private class StackIterator implements Iterator<E> {
		private Node current = top;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E temp = current.data;
			current = current.next;
			return temp;
		}
	}
}