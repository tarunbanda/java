
public class SevenSegmentLogic extends MultiSegmentLogic
{
    //sevensegementlopgic constructor
    public SevenSegmentLogic()
    {
        super.setNumSegs(7);
        loadSegments();
    }
    
    //gets value of a segment 
    public boolean getValOfSeg(int seg)
    {
        if (seg >= numSegs || seg < 0)
            return false;
        return segs[seg].getState();
    }
    
    
    //loads 7 boolean functions with truth tables
    private void loadSegments()
    {
        final BooleanFunc a = new BooleanFunc();
        final BooleanFunc b = new BooleanFunc();
        final BooleanFunc c = new BooleanFunc();
        final BooleanFunc d = new BooleanFunc();
        final BooleanFunc e = new BooleanFunc();
        final BooleanFunc f = new BooleanFunc();
        final BooleanFunc g = new BooleanFunc();
        
        final int aFalse[] = {1,4,11,13};
        final int bFalse[] = {5,6,11,12,14,15};
        final int cFalse[] = {2,12,14,15};
        final int dFalse[] = {1,4,7,10,15};
        final int eFalse[] = {1,3,4,5,7,9};
        final int fFalse[] = {1,2,3,7,13};
        final int gFalse[] = {0,1,7,12};
        
        a.setTruthTableUsingFalse(aFalse);
        b.setTruthTableUsingFalse(bFalse);
        c.setTruthTableUsingFalse(cFalse);
        d.setTruthTableUsingFalse(dFalse);
        e.setTruthTableUsingFalse(eFalse);
        f.setTruthTableUsingFalse(fFalse);
        g.setTruthTableUsingFalse(gFalse);
        
        segSegment(0, a);
        segSegment(1, b);
        segSegment(2, c);
        segSegment(3, d);
        segSegment(4, e);
        segSegment(5, f);
        segSegment(6, g);
        
    }
}
