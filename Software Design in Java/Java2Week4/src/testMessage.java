
public class testMessage
{

    public static void main(String[] args)
    {
        for (int i = 0; i < 2;i++)
        {
//-----------------------------------------------------------------------------
//------------------------------Test Message-----------------------------------

        Message abc = new Message(null, null);
        
        System.out.println("Test Message class");
        System.out.println(abc);
        System.out.println(abc.getMessage());
        
        System.out.println("\nTest setAuthor");
        abc.setAuthor("abcdefg");
        System.out.println(abc);
        abc.setAuthor("-1");
        System.out.println(abc);
        abc.setAuthor(" implementation is correct. Instantiate two or merereferereffererfdf ferere");
        System.out.println(abc.getAuthor());
        System.out.println("\nTest getAuthor");
        abc.setAuthor("brenna");
        System.out.println(abc.getAuthor());
        
        System.out.println("\nTest setMessage");
        abc.setMessage("I'm getting really sleepy....just kidding");
        System.out.println(abc);
        
        System.out.println("\nSet valid Author, invalid message");
        abc.setAuthor("tarun");
        abc.setMessage("satisfy yourself that your implementation is correct. Instantiate two or more Message objects, some using the default constructor and some using the parameter-taking constructor.  Mutate one or more of the members, and after that use the toString() to assist a screen output so you can see what all of your objects contain.  Next, test one or more accessors.  Finally, test two or more mutators, providing both legal and illegal arguments and testing the return values (thus demonstrating that the mutators do the right thing).  Here is a sample run from my test (but you will have to imagine/deduce the source I used and create your own source for your testing, which will produce a different output)");
        System.out.println(abc);
        System.out.println(abc.getAuthor());
        System.out.println(abc.getMessage());
        System.out.println("\nRe-test Valid message");
        abc.setMessage("test valid message");
        System.out.println(abc);
        
        abc.toString();
        
//-----------------------------------------------------------------------------
//------------------------------Test Email-------------------------------------
        
        Email x = new Email("Tarun Banda", null, null, null);
        //System.out.println(x.toString());
        System.out.println(x.getAuthor());
        

        System.out.println("\nTest Email fromAddress accessor");
        System.out.println(x.getFromAddress());
        System.out.println("\nTest Email toAddress accessor");
        System.out.println(x.getToAddress());
        System.out.println("\nTest setFromAddress legal");
        x.setFromAddress("abcdefg@gmail.com");
        System.out.println(x.getFromAddress());
        System.out.println("\nTest setFromAddress illegal");
        x.setFromAddress("abcdefg@gmail");
        System.out.println(x.getFromAddress());
        x.setFromAddress("satisfyyourselfthatyourimplementationiscorrectInstantiatetwoormoreMessageobjects,someusingthedefaultconstructorandsomeusing@gmail.com");
        System.out.println(x.getFromAddress());
        x.setFromAddress("n is correct@gmail");
        System.out.println(x.getFromAddress());
        x.setFromAddress("0");
        System.out.println(x.getFromAddress());
        
        System.out.println("\nTest settoAddress legal");
        x.setToAddress("brenna@yahoo.com");
        System.out.println(x.getToAddress());
        System.out.println(x.getAuthor());
        x.setAuthor("ABCDERF");
        System.out.println(x.getAuthor());
        System.out.println(x.getMessage());
        x.setMessage("TEST ABCDEFEGEHDHF");
        System.out.println(x.getMessage());
        
        
        System.out.println("\nTest settoAddress illegal");
        x.setToAddress("");
        System.out.println(x.getToAddress());
        x.setToAddress("abcdefg@gmail");
        System.out.println(x.getToAddress());
        x.setToAddress("satisfyyourselfthatyourimplementationiscorrectInstantiatetwoormoreMessageobjects,someusingthedefaultconstructorandsomeusing@gmail.com");
        System.out.println(x.getToAddress());
        x.setToAddress("0");
        System.out.println(x.getToAddress());
        
        System.out.println("\nre-Test email legal");
        x.setFromAddress("abcdefg@gmail.com");
        System.out.println(x.getFromAddress());
        x.setToAddress("brenna@yahoo.com");
        System.out.println(x.getToAddress());
        
        
        System.out.println("\nTest Shweet");
        Shweet tweet = new Shweet("Tarun Banda", "ABCD", null);
        System.out.println(tweet);
        System.out.println(tweet.getAuthor());
        System.out.println(tweet.getFromID());
        System.out.println(tweet.getMessage());
        
        System.out.println("\nTest FromID legal");
        tweet.setFromID("Tban");
        System.out.println(tweet.toString());
        System.out.println("\nTest FromID illegal");
        tweet.setFromID("Tban##$#");
        System.out.println(tweet.toString());
        tweet.setFromID("ab cd dg");
        System.out.println(tweet.toString());
        
        System.out.println(tweet.getAuthor());
        tweet.setAuthor("A-Z");
        System.out.println(tweet.getAuthor());
        
        }
    }

}
