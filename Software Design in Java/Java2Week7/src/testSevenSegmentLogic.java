
public class testSevenSegmentLogic
{
    public static void main(String[] args)
    {
        int inputX, k;
        SevenSegmentLogic my7Seg, myCopy;
        
        my7Seg = new SevenSegmentLogic();
        
        
        try
        {
           myCopy = (SevenSegmentLogic) my7Seg.clone();
        }
        catch  ( CloneNotSupportedException e )
        {
           System.out.println("** Clone Unsuccessful **");
           myCopy = new SevenSegmentLogic();
        }
        
        for ( inputX = 0; inputX < 16; inputX++ )
        {
           myCopy.eval( inputX );
           System.out.print("\n| ");
           for ( k = 0; k < 7; k++ )
              System.out.print( myCopy.getValOfSeg( k ) + " | ");
           System.out.println();
        }
        
        my7Seg.setNumSegs(15);
        for ( inputX = 0; inputX < 16; inputX++ )
        {
           myCopy.eval( inputX );
           System.out.print("\n| ");
           for ( k = 0; k < 15; k++ )
              System.out.print( myCopy.getValOfSeg( k ) + " | ");
           System.out.println();
        }
        
    }

}
