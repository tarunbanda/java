public class Automaton
{
   // class constants
   public final static int MAX_DISPLAY_WIDTH = 121;
       
   // private members
   private boolean rules[];  // allocate rules[8] in constructor!
   private String thisGen;   // same here
   private String extremeBit; // bit, "*" or " ", implied everywhere "outside"
   private int displayWidth;  // an odd number so it can be perfectly centered
   private StringBuffer finalDisp;

   // public constructors, mutators, etc. (need to be written)
   public Automaton(int new_rule)
   {
       setRule(new_rule);
       setDisplayWidth(79);
       this.thisGen = "*";
       this.extremeBit = " ";
       
   }
   public void resetFirstGen()
   {
       this.thisGen = "*";
       this.extremeBit = " ";
   }
   public boolean setRule(int newRule)
   {
       int i;
       
       //sanitize rule and set rule to 0 as a default
       if (newRule < 0 || newRule > 255)
       {
           setRule(0);
           return false;
       }
       rules = new boolean[8];
       for (i = 0; i < 8; i++)
           rules[i] = (newRule & (1 << i)) != 0;
       return true;
   }
   
   public boolean setDisplayWidth(int width)
   {
       if (width <= MAX_DISPLAY_WIDTH && width%2 == 1)
       {
           this.displayWidth = width;
           return true;
       }
       else
       {
           return false;
       }

   }
   public String toStringCurrentGen()
   {
       int center = (displayWidth)/2;
       int genCenter = (thisGen.length()+1)/2;
       
       finalDisp = new StringBuffer();
       if (thisGen.length() <= displayWidth)
       {
           for (int i = 0; i < displayWidth;i++)
               if ((i <= center-genCenter) || i >= (center + genCenter))
                   finalDisp.append(extremeBit);
               else
               {
                   finalDisp.append(thisGen);
                   i = center+genCenter;
               }
       }
       else
       {
           finalDisp = new StringBuffer(thisGen.substring(genCenter-center-1, genCenter+center));
           
       }

       return finalDisp.toString();
   }
   public void propagateNewGeneration()
   {
       StringBuffer tempGen = new StringBuffer(extremeBit)
           .append(extremeBit)
           .append(thisGen)
           .append(extremeBit)
           .append(extremeBit);
   
       int[] bitset = new int[tempGen.length()];
       for (int i = 0; i < tempGen.length(); i++)
           if (tempGen.charAt(i) == '*') 
               bitset[i] = 1;
       if (extremeBit == "*" && rules[0])
           this.extremeBit = " ";
       if (extremeBit == " " && rules[0])
           this.extremeBit = "*";

       
       StringBuffer nextGen = new StringBuffer();
       for (int i = 0; i < bitset.length-2; i++) 
       {
          int pos1 = bitset[i];
          int pos2 = bitset[i+1];
          int pos3 = bitset[i+2];
          int index = (pos1 << 2) | (pos2 << 1) | pos3;
          if (rules[index])
              nextGen.append('*');
          else
              nextGen.append(' ');
       }
       this.thisGen = nextGen.toString();
       
       

   }
}