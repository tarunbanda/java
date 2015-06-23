class Node
{

    // node object that points to next node
    protected Node next;

    // constructor
    public Node()
    {
        next = null;
    }

    // console display
    public String toString()
    {
        return "" + next;
    }
}