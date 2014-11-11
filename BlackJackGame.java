public class BlackJackGame 
{
    private GUI gui;
    private ArrayList dealerCards, playerCards;
    private ArrayList dealerCardImages, playerCardImages;
    private Stack deck;
   
    public void playBlackJack(GUI Gui) 
    {
	gui = Gui;
	Shoe shoe = new Shoe(gui);
	deck = shoe.getShuffledDeck();

	
    }

    public void originalDeal()
    {
	dealerCards.add(deck.pop());
	dealerCards.add(deck.pop());

	playerCards.add(deck.pop());
	playerCards.add(deck.pop());
    }
    
    public ArrayList updateDisplayedCards()
    {
	int size = dealerCards.size();
	for(int i = 0; i < size; i++)
	{
	    dealerCardImages.removeRange(0, size);
	    dealerCardImages.add(dealerCards[i].getImage());
	}
	int size1 = playerCards.size();
	for(int j = 0; j < size1; j++)
	{
	    playerCardImages.removeRange(0, size1);
	    playerCardImages.add(playerCards[j].getImage());
	}
    }
    
    public ArrayList getDealerImages()
    {
	return dealerCardImages;
    }

    public ArrayList getPlayerImages()
    {
	return playerCardImages;
    }
}
