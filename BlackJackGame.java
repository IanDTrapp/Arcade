public class BlackJackGame 
{
    private GUI gui;
    private ArrayList dealerCards, playerCards;
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
}
