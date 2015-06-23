public class Automaton
{
    // class constants
    public final static int MAX_DISPLAY_WIDTH = 121;
    private final static int DEFAULT_WIDTH = 79;
    private final static int MAX_RULE = 255;
    private final static String star = "*";
    private final static String space = " ";
    private final static int arrayLength = 8;

    // private members
    private boolean rules[]; // allocate rules[8] in constructor!
    private String thisGen; // same here
    private String extremeBit; // bit, "*" or " ", implied everywhere "outside"
    private int displayWidth; // an odd number so it can be perfectly centered
    private StringBuffer finalDisp;
    

    // public constructors, mutators, etc. (need to be written)
    public Automaton(int new_rule)
    {
        setRule(new_rule);
        setDisplayWidth(DEFAULT_WIDTH);
        this.thisGen = star;
        this.extremeBit = space;
    }

    public void resetFirstGen()
    {
        this.thisGen = star;
        this.extremeBit = space;
    }

    public boolean setRule(int newRule)
    {
        int i;

        // sanitize rule and set rule to 0 as a default
        if (newRule < 0 || newRule > MAX_RULE)
        {
            setRule(0);
            return false;
        }
        rules = new boolean[arrayLength];
        for (i = 0; i < rules.length; i++)
            rules[i] = (newRule & (1 << i)) != 0;
        return true;
    }

    public boolean setDisplayWidth(int width)
    {
        if (width <= MAX_DISPLAY_WIDTH && width % 2 == 1)
        {
            this.displayWidth = width;
            return true;
        } 
        else
            return false;
    }

    public String toStringCurrentGen()
    {
        final int center = displayWidth / 2;
        final int genCenter = (thisGen.length() + 1) / 2;
        int i =0;
        
        finalDisp = new StringBuffer();
        if (thisGen.length() <= displayWidth)
        {
            while (i < displayWidth)
            {
                if ((i <= center - genCenter) || i >= (center + genCenter))
                {
                    finalDisp.append(extremeBit);
                    i++;
                }
                else
                {
                    finalDisp.append(thisGen);
                    i = center + genCenter;
                }
            }
        } 
        else
        {
            finalDisp = new StringBuffer(thisGen.substring(genCenter - center
                    - 1, genCenter + center));
        }
        return finalDisp.toString();
    }

    public void propagateNewGeneration()
    {
        final StringBuffer tempGen = new StringBuffer(extremeBit)
            .append(extremeBit).append(thisGen)
            .append(extremeBit).append(extremeBit);

        final int[] bitset = new int[tempGen.length()];
        for (int i = 0; i < tempGen.length(); i++)
            if (tempGen.charAt(i) == '*')
                bitset[i] = 1;
        if (star.equals(extremeBit) && rules[0])
            this.extremeBit = space;
        if (space.equals(extremeBit) && rules[0])
            this.extremeBit = star;

        final StringBuffer nextGen = new StringBuffer();
        for (int i = 0; i < bitset.length - 2; i++)
        {
            final int pos1 = bitset[i];
            final int pos2 = bitset[i + 1];
            final int pos3 = bitset[i + 2];
            final int index = (pos1 << 2) | (pos2 << 1) | pos3;
            if (rules[index])
                nextGen.append('*');
            else
                nextGen.append(' ');
        }
        this.thisGen = nextGen.toString();

    }
}