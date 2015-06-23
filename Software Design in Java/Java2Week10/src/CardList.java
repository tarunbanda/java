import java.util.LinkedList;


public class CardList<T extends Comparable<T>> extends LinkedList<T> 
{
    public void insert(T x)
    {
        
    }
    
    public boolean remove(T x) // True if found and removed, false otherwise
    {
        return true;
    }
    
    public boolean removeAll(T x) // True if found and removed at least one
    {
        return true;
    }
    
    public String toString() // See below
    {
        return "";
    }
}

//class FloatList extends List
//{
//   public void insert(double x){ ... }  // insert in increasing numerical order
//   public boolean remove(double x) { ... }  // remove the first occurrence from list
//}