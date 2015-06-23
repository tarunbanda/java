
public class CardQueue extends Queue
{
    //adds cards to queue 
    public boolean addCard(Card card)
    {
        if (card == null)
            return false;
        final CardNode x = new CardNode(card);
        super.add(x);
        return true;
    }
    
    //removes and returns oldest card in Queue
    public Card removeCard() throws QueueEmptyException
    {
        final CardNode x = (CardNode)remove();
        if(x == null)
            throw new QueueEmptyException();
        return x.getCard();
    }
    
    //uses base class Queue to return string
    public String toString()
    {
        return super.toString();
    }

}
