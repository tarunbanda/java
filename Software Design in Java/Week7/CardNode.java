class CardNode extends Node
{
    //Create private card member
    private Card card;
    
    //constructor CardNode passes card to node
    public CardNode(Card newCard)
    {
        // TODO Auto-generated constructor stub
        super();
        card = newCard;
    }
    
    //returns card object
    public Card getCard()
    {
        return card;
    }

    //stringizer 
    public String toString()
    {
        return card.toString();
    }
}

