public class BooleanFunc implements Cloneable
{
    public static int MAX_TABLE_FOR_CLASS = 65536;
    public static int DEFAULT_TABLE_SIZE = 16;
    private boolean[] truthTable; //boolean array for truthTable
    private boolean evalReturnIfError; //sets bool for error
    private boolean state; 

    //default constructor create an array of length 16
    public BooleanFunc()
    {
        this.truthTable = new boolean[DEFAULT_TABLE_SIZE];
    }

    //constructor that sets table size
    public BooleanFunc(int tableSize)
    {
        if (tableSize < 1)
            this.truthTable = new boolean[DEFAULT_TABLE_SIZE];
        else
            this.truthTable = new boolean[tableSize];
    }

    //constructor to set truthTable and error value
    public BooleanFunc(int tableSize, boolean evalError)
    {
        if (tableSize < 1)
            this.truthTable = new boolean[DEFAULT_TABLE_SIZE];
        else
        {
            truthTable = new boolean[tableSize];
            this.evalReturnIfError = evalError;
        }
    }

    //sets truthValues at each of the input indices
    public boolean setTruthValuesAt(int[] inputs, boolean truthValue)
    {

        if (inputs.length <= truthTable.length)
        {
            for (int i = 0; i < inputs.length; i++)
            {
                final int valueAt = inputs[i];
                if (valueAt >= truthTable.length)
                    continue;
                truthTable[valueAt] = truthValue;
            }
            return true;
        }
        return false;
    }

    //sets truthtable with true indices and false for all other values in array
    public boolean setTruthTableUsingTrue(int[] inputsThatProduceTrue)
    {
        setTableToConstant(false);

        if (inputsThatProduceTrue.length <= truthTable.length)
        {
            for (int i = 0; i < inputsThatProduceTrue.length; i++)
            {
                final int valueAt = inputsThatProduceTrue[i];
                if (valueAt >= truthTable.length)
                    continue;
                truthTable[valueAt] = true;
            }
            return true;
        }
        return false;
        
    }

    //sets truthtable with false values at indices
    public boolean setTruthTableUsingFalse(int[] inputsThatProduceFalse)
    {
        setTableToConstant(true);
        if (inputsThatProduceFalse.length <= truthTable.length)
        {
            for (int i = 0; i < inputsThatProduceFalse.length; i++)
            {
                final int valueAt = inputsThatProduceFalse[i];
                if (valueAt >= truthTable.length)
                    continue;
                truthTable[valueAt] = false;
            }
            return true;
        } 
        return false;
    }

    //sets value for state 
    public boolean eval(int input)
    {
        if (input >= truthTable.length || input < 0)
            this.state = evalReturnIfError;
        else
        {
            this.state = truthTable[input];
        }
        return state;
    }

    //returns value for state 
    public boolean getState()
    {
        return state;
    }

    // helper 
    private void setTableToConstant(boolean value)
    {
        for (int i = 0; i < truthTable.length; i++)
            truthTable[i] = value;
    }
    
    //clone method to deep copy BooleanFunc
    public BooleanFunc clone() throws CloneNotSupportedException
    {
        final BooleanFunc newBoolFunc = (BooleanFunc)super.clone();
        for (int i = 0; i < truthTable.length; i++)
            newBoolFunc.truthTable[i] = this.truthTable[i];
        return newBoolFunc;
    }
}
