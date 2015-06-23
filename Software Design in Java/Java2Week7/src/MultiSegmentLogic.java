
public class MultiSegmentLogic implements Cloneable
{
    protected int numSegs;
    protected BooleanFunc[] segs;
    
    //default constructor that creats an array of booleanFunc
    public MultiSegmentLogic()
    {
        this.numSegs = 0;
        segs = new BooleanFunc[numSegs];
    }
    
    ////cunstructor to set the number of segments and create booleanFunc array
    public MultiSegmentLogic(int numberSegments)
    {
        this.numSegs = numberSegments;
        segs = new BooleanFunc[numberSegments];
    }
    
    
    public boolean setNumSegs(int numberSegments)
    {
        if (numberSegments >= 0)
        {
            this.numSegs = numberSegments;
            segs = new BooleanFunc[numberSegments];
            return true;
        }
        return false;
    }
    
    //sets segment to proper segment
    public boolean segSegment(int segNum, BooleanFunc funcForThisSeg)
    {
        if (segNum >= 0 || segNum < numSegs)
        {
            try
            {
                final BooleanFunc newFunction = (BooleanFunc) funcForThisSeg.clone();
                segs[segNum] = newFunction;
            } 
            catch (CloneNotSupportedException e)
            {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
    
    //gets value for a given boolean function
    public void eval(int input)
    {
        if (input >= BooleanFunc.MAX_TABLE_FOR_CLASS || input < 0)
            return;
        else
        {
            for(int i = 0; i < segs.length; i++)
                segs[i].eval(input);
        }
    }
    
    //clone method 
    public MultiSegmentLogic clone() throws CloneNotSupportedException
    {
        final MultiSegmentLogic newSegLogic = (MultiSegmentLogic)super.clone();
        for (int i = 0; i < segs.length; i++)
            newSegLogic.segs[i] = this.segs[i];
        return newSegLogic;
    }
    
}
