
public class Shweet extends Message
{

    public static int MAX_SHWITTER_ID_LENGTH = 15;
    public static int MAX_SHWEET_LENGTH = 140;
    public static String DEFAULT_USER_ID = "defaultID";
    public static String DEFAULT_SHWEET = "invalidShweetID";
    
    //single private member for class Shweet
    private String fromID;
    
    //default Shweet constructor
    public Shweet()
    {
        super();
        setFromID(DEFAULT_USER_ID);
    }
    
    //chained constructor for Shweet
    public Shweet(String theAuth, String theMsg, String userID)
    {
        super.setAuthor(theAuth);
        setMessage(theMsg);
        setFromID(userID);
    }
    
    //setMessage overridden method which checks for valid tweets
    public boolean setMessage(String theMsg)
    {
        if (super.isNull(theMsg) || isValidShweet(theMsg))
        {
            super.setMessage(theMsg);
            return true;
        }
        else
        {
            super.setMessage(DEFAULT_SHWEET);
            return false;
        }
    }
    
    //mutator sets id and checks for validity
    public boolean setFromID(String userID)
    {
        if (super.isNull(userID) || isValidShwitterID(userID))
        {
            this.fromID = userID;
            return true;
        }
        else
        {
            this.fromID = DEFAULT_USER_ID;
            return false;
        }
    }
    
    //fromID accessor
    public String getFromID()
    {
        return fromID;
    }

    //toString method
    public String toString()
    {
        final String retStr;
        
        retStr = "Shweet: " + super.author + "@" + fromID +"\n"
                + super.message + "\n";
        
        return retStr;
    }
    
    //helper method to validate tweet
    private static boolean isValidShweet(String theMessage)
    {
        return theMessage.length() < MAX_SHWEET_LENGTH;
    }
    
    //helper class to validate SwitterID
    private static boolean isValidShwitterID(String userID)
    {
        final boolean isValidID = userID.length() < MAX_SHWITTER_ID_LENGTH;
        
        if (isValidID)
            return stringHasOnlyAlphaOrNumOrUnderscore(userID);
        else
            return true;
    }
    
    //helper-helper to check for alphanumeric and underscore only characters
    private static boolean stringHasOnlyAlphaOrNumOrUnderscore(String userID)
    {
        final boolean hasNonAlpha = userID.matches("^.*[^a-zA-Z0-9_].*$");
        return hasNonAlpha;
    }
}
