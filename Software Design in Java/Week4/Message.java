public class Message
{
    // full set of limits and defaults
    protected static int MAX_MSG_LENGTH = 200;
    protected static String DEFAULT_AUTHOR = "invalid author";
    protected static int MAX_AUTHOR_LENGTH = 65;
    protected static String DEFAULT_MSG = "invalid message";

    // protected members of Message class
    protected String message;
    protected String author;

    // default constructor
    public Message()
    {
        setAuthor(DEFAULT_AUTHOR);
        setMessage(DEFAULT_MSG);
    }

    // Message constructor that takes in author and message parameters
    public Message(String theAuth, String theMsg)
    {
        setAuthor(theAuth); // sends author parameter to setAuthor method
        setMessage(theMsg); // sends message parameter to setMessage method
    }

    // validates message and sets the message
    public boolean setMessage(String theMsg)
    {
        if (isNull(theMsg) || validMsg(theMsg))
        {
            this.message = theMsg;
            return true;
        }
        else
        {
            this.message = DEFAULT_MSG;
            return false;
        }
    }

    // validates author and sets the author
    public boolean setAuthor(String theAuth)
    {
        if (isNull(theAuth) ||validAuth(theAuth))
        {
            this.author = theAuth;
            return true;
        }
        else
        {
            this.author = DEFAULT_AUTHOR;
            return false;
        }
    }

    // accessor to get message
    public String getMessage()
    {
        return message;
    }

    // accessor to get author
    public String getAuthor()
    {
        return author;
    }

    // toString method to returns author and message
    public String toString()
    {
        final String retStr;
        retStr = "Author: " + author + "\nMessage: " + message + "\n";
        return retStr;
    }

    // validates message based on length
    private static boolean validMsg(String theMsg)
    {
        return theMsg.length() < MAX_MSG_LENGTH;
    }

    // validates author based on length
    private static boolean validAuth(String theAuth)
    {
        return theAuth.length() < MAX_AUTHOR_LENGTH;
    }
    
    //a protected helper to check for null values
    protected static boolean isNull(String testNull)
    {
        return testNull == null;
    }

}
