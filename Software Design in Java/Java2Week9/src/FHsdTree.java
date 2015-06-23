public class FHsdTree<E> implements Cloneable
{
    protected int mSize;
    FHsdTreeNode<E> mRoot;

    public FHsdTree()
    {
        clear();
    }

    public boolean empty()
    {
        return size() == 0;
    }

    public int size()
    {
        return checkSize(mRoot);
    }

    private int checkSize(FHsdTreeNode<E> x)
    {
        if (x == null)
            return 0;

        if (x.deleted)
            return checkSize(x.sib);

        return 1 + checkSize(x.firstChild) + checkSize(x.sib);
    }

    public void clear()
    {
        mSize = 0;
        mRoot = null;
    }

    public FHsdTreeNode<E> find(E x)
    {
        return find(mRoot, x, 0);
    }

    public boolean remove(E x)
    {
        return remove(mRoot, x);
    }

    public void display()
    {
        display(mRoot, 0);
    }

    public <F extends Traverser<? super E>> void traverse(F func)
    {
        traverse(func, mRoot, 0);
    }

    public FHsdTreeNode<E> addChild(FHsdTreeNode<E> treeNode, E x)
    {
        // empty tree? - create a root node if user passes in null
        if (mSize == 0)
        {
            if (treeNode != null)
                return null; // error something's fishy. treeNode can't right
            mRoot = new FHsdTreeNode<E>(x, null, null, null, false);
            mRoot.myRoot = mRoot;
            mSize = 1;
            return mRoot;
        }
        if (treeNode == null || treeNode.deleted)
            return null; // error inserting into non_null tree with a null
                         // parent
        if (treeNode.myRoot != mRoot)
            return null; // silent error, node does not belong to this tree

        // push this node into the head of the sibling list; adjust prev
        // pointers
        final FHsdTreeNode<E> newNode = new FHsdTreeNode<E>(x, treeNode.firstChild,
                null, treeNode, mRoot, false); // sb, chld, prv, rt, del
        treeNode.firstChild = newNode;
        if (newNode.sib != null)
            newNode.sib.prev = newNode;
        ++mSize;
        return newNode;
    }

    public FHsdTreeNode<E> find(FHsdTreeNode<E> root, E x, int level)
    {
        FHsdTreeNode<E> retval;

        if (mSize == 0 || root == null)
            return null;

        if (root.data.equals(x) && !root.deleted)
            return root;

        // otherwise, recurse. don't process sibs if this was the original call
        if (level > 0 && (retval = find(root.sib, x, level)) != null)
            return retval;
        return find(root.firstChild, x, ++level);
    }

    public boolean remove(FHsdTreeNode<E> root, E x)
    {
        FHsdTreeNode<E> tn = null;

        if (mSize == 0 || root == null)
            return false;

        if ((tn = find(root, x, 0)) != null)
        {
            tn.deleted = true;
            return true;
        }
        return false;
    }

    protected void removeNode(FHsdTreeNode<E> nodeToDelete)
    {
        if (nodeToDelete == null || mRoot == null)
            return;
        if (nodeToDelete.myRoot != mRoot)
            return; // silent error, node does not belong to this tree

        // remove all the children of this node
        while (nodeToDelete.firstChild != null)
            removeNode(nodeToDelete.firstChild);

        if (nodeToDelete.prev == null)
            mRoot = null; // last node in tree
        else if (nodeToDelete.prev.sib == nodeToDelete)
            nodeToDelete.prev.sib = nodeToDelete.sib; // adjust left sibling
        else
            nodeToDelete.prev.firstChild = nodeToDelete.sib; // adjust parent

        // adjust the successor sib's prev pointer
        if (nodeToDelete.sib != null)
            nodeToDelete.sib.prev = nodeToDelete.prev;
        --mSize;
    }

    public Object clone() throws CloneNotSupportedException
    {
        final FHsdTree<E> newObject = (FHsdTree<E>) super.clone();
        newObject.clear(); // can't point to other's data

        newObject.mRoot = cloneSubtree(mRoot);
        newObject.mSize = mSize;
        newObject.setMyRoots(newObject.mRoot);

        return newObject;
    }

    private FHsdTreeNode<E> cloneSubtree(FHsdTreeNode<E> root)
    {
        FHsdTreeNode<E> newNode;
        if (root == null)
            return null;

        // does not set myRoot which must be done by caller
        newNode = new FHsdTreeNode<E>(root.data, cloneSubtree(root.sib),
                cloneSubtree(root.firstChild), null, root.deleted);

        // the prev pointer is set by parent recursive call ... this is the
        // code:
        if (newNode.sib != null)
            newNode.sib.prev = newNode;
        if (newNode.firstChild != null)
            newNode.firstChild.prev = newNode;
        return newNode;
    }

    // recursively sets all myRoots to mRoot
    private void setMyRoots(FHsdTreeNode<E> treeNode)
    {
        if (treeNode == null)
            return;

        treeNode.myRoot = mRoot;
        setMyRoots(treeNode.sib);
        setMyRoots(treeNode.firstChild);
    }

    // define this as a static member so recursive display() does not need
    // a local version
    final static String blankString = "                                    ";

    // let be public so client can call on subtree
    public void display(FHsdTreeNode<E> treeNode, int level)
    {
        String indent;

        // stop runaway indentation/recursion
        if (level > (int) blankString.length() - 1)
        {
            System.out.println(blankString + " ... ");
            return;
        }

        if (treeNode == null)
            return;

        indent = blankString.substring(0, level);

        // pre-order processing done here ("visit")
        System.out.println(indent + treeNode.data);

        // recursive step done here
        display(treeNode.firstChild, level + 1);
        if (level > 0)
            display(treeNode.sib, level);
    }

    // often helper of typical public version, but also callable by on
    // subtree
    public <F extends Traverser<? super E>> void traverse(F func,
            FHsdTreeNode<E> treeNode, int level)
    {
        if (treeNode == null)
            return;

        func.visit(treeNode.data);

        // recursive step done here
        traverse(func, treeNode.firstChild, level + 1);
        if (level > 0)
            traverse(func, treeNode.sib, level);
    }

    public int sizePhysical()
    {
        return mSize;
    }

    protected void displayPhysical()
    {
        displayPhysical(mRoot, 0);
    }

    protected void displayPhysical(FHsdTreeNode<E> treeNode, int level)
    {
        String indent;

        // stop runaway indentation/recursion
        if (level > (int) blankString.length() - 1)
        {
            System.out.println(blankString + " ... ");
            return;
        }

        if (treeNode == null)
            return;

        indent = blankString.substring(0, level);

        // pre-order processing done here ("visit")
        if (treeNode.deleted)
            System.out.println(indent + " (D)" + treeNode.data);
        else
            System.out.println(indent + treeNode.data);

        // recursive step done here
        displayPhysical(treeNode.firstChild, level + 1);
        if (level > 0)
            displayPhysical(treeNode.sib, level);
    }

    public boolean collectGarbage()
    {
        return collectGarbage(mRoot);
    }

    protected boolean collectGarbage(FHsdTreeNode<E> root)
    {
        while (root != null)
        {
            if (root.deleted)
                removeNode(root);
            else
            {
                collectGarbage(root.firstChild);
                collectGarbage(root.sib);
            }
            return true;
        }
        return false;

    }
}
