import java.lang.Exception;

public class Queue
{

    //pointer to first and last node in the Queue
    private Node head;
    private Node tail;
    private int n; //counter for length of Queue

    // constructor
    public Queue()
    {
        head = null;
        tail = null;
    }

    //adds new nodes to Queue 
    public boolean add(Node newNode)
    {
        if (newNode == null)
            return false;
        if (n == 0)
        {
            tail = newNode;
            head = tail;
            n++;
            return true;
        }
        else
        {
            final Node prev = tail;
            tail = newNode;
            prev.next = tail;
            n++;
            return true;
        }
    }

    //accessor to get length of Queue
    public int getQueueLength()
    {
        return n;
    }

    //removes oldest node from queue, and throws exception if empty
    public Node remove() throws QueueEmptyException
    {
        if (head == null)
            throw new QueueEmptyException();
        Node temp;

        temp = head;
        if (n == 0)
        {
            return null;
        }
        else
        {
            head = head.next;
            temp.next = null;
            n--;
        }
        return temp;
    }
    
    //defines QueueEmptyException
    public class QueueEmptyException extends Exception
    {

    }

    //prints string of all items in node from oldest to newest
    public String toString()
    {
        Node p;
        String x = null;

        // Display all the nodes in the stack
        for (p = head; p != null; p = p.next)
            x = p.toString();
        return x;
    }

}
