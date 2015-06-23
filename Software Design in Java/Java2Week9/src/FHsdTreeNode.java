public class FHsdTreeNode<E>
{
    // use protected access so the tree, in the same package,
    // or derived classes can access members
    protected FHsdTreeNode<E> firstChild;
    protected FHsdTreeNode<E> sib;
    protected FHsdTreeNode<E> prev;
    protected E data;
    protected FHsdTreeNode<E> myRoot; // needed to test for certain error
    protected boolean deleted;

    public FHsdTreeNode(E d, FHsdTreeNode<E> sb, FHsdTreeNode<E> chld,
            FHsdTreeNode<E> prv, boolean del)
    {
        firstChild = chld;
        sib = sb;
        prev = prv;
        data = d;
        myRoot = null;
        deleted = del;
    }

    public FHsdTreeNode()
    {
        this(null, null, null, null, false);
    }

    public E getData()
    {
        return data;
    }

    // for use only by FHtree (default access)
    protected FHsdTreeNode(E d, FHsdTreeNode<E> sb, FHsdTreeNode<E> chld,
            FHsdTreeNode<E> prv, FHsdTreeNode<E> root, boolean del)
    {
        this(d, sb, chld, prv, del);
        myRoot = root;
    }
}
