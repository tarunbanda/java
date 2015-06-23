
public class Email extends Message
{
    public static int MAX_EMAIL_ADDRESS_LENGTH = 100;
    public static String DEFAULT_EMAIL_ADDRESS = "invalid email";

    //private members to store email addresses
    private String fromAddress;
    private String toAddress;
    
    //email default constructor
    public Email()
    {
        super();
        setToAddress(DEFAULT_EMAIL_ADDRESS);
        setFromAddress(DEFAULT_EMAIL_ADDRESS);
    }
    
    //email chained constructor 
    public Email(String theAuth, String theMsg, String fromAddr, String toAddr)
    {
        super(theAuth, theMsg);
        setToAddress(toAddr);
        setFromAddress(fromAddr);
    }
    
    //toAddress mutator and checks for illegal values
    public boolean setToAddress(String toAddr)
    {
        if (super.isNull(toAddr) || isValidEAddr(toAddr))
        {
            this.toAddress = toAddr;
            return true;
        }
        else
        {
            this.toAddress= DEFAULT_EMAIL_ADDRESS;
            return false;
        }

    }
    
    //fromAddress mutator and checks for illegal values
    public boolean setFromAddress(String fromAddr)
    {
        if (super.isNull(fromAddr) || isValidEAddr(fromAddr))
        {
            this.fromAddress = fromAddr;
            return true;
        }
        else
        {
            this.fromAddress = DEFAULT_EMAIL_ADDRESS;
            return false;
        }
    }

    //toAddress accessor
    public String getToAddress()
    {
        return toAddress;
    }
    
    //fromAddress accessor
    public String getFromAddress()
    {
        return fromAddress;
    }
    
    //toString method that returns an email string
    public String toString()
    {
        final String retStr;
        
        retStr = "From: " + fromAddress +"\nTo: " + toAddress + "\n" 
                + super.message;
        return retStr;
    }
    
    //helper classs to validate email
    private static boolean isValidEAddr(String emailAddr)
    {
        final boolean hasChars = emailAddr.indexOf('@') >= 0 && 
                emailAddr.indexOf('.') >= 0;

        if  (hasChars)
            return emailAddr.length() < MAX_EMAIL_ADDRESS_LENGTH;
        else 
            return false;
    }
    
}
