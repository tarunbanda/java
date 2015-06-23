import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Cloneable, Iterable<E> {
	private int size; //size of Queue
	private Node head; 
	private Node tail;
	private String name;

	private class Node {
		private E item;
		private Node next;
	}

	//default constructor
	public Queue() { 
		head = null;
		tail = null;
		size = 0;

	}

	//overload constructor which takes string as a param
	public Queue(String string) {
		head = null;
		tail = null;
		size = 0;
		name = string;
		
	}

	//accessor for size of queue
	public int size() {
		return size;
	}

	//helper class to determine if queue is empty 
	public boolean isEmpty() {
		return head == null;
	}

	//adds objects to the end of queue
	public void enqueue(E item) {
		Node oldtail = tail;
		tail = new Node();
		tail.item = item;
		tail.next = null;
		if (isEmpty())
			head = tail;
		else
			oldtail.next = tail;
		size++;
	}

	//removes objects from the head of the queue
	public E dequeue() {
		if (isEmpty())
			throw new NoSuchElementException();
		E item = head.item;
		head = head.next;
		size--;
		return item;
	}

	public String toString() {
		String delim = "";
		StringBuilder s = new StringBuilder();
		for (E item : this)
		{
			s.append(delim).append(item);
			delim = ",";
		}
		return "\n[" +s.toString() + "]";
	}

	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	//iterator class to loop through queue
	private class QueueIterator implements Iterator<E> {
		private Node current = head;

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E item = current.item;
			current = current.next;
			return item;
		}
	}
}