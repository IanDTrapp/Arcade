import java.util.Stack;
import java.util.ArrayList;

public class BlackJackGame 
{
    private GUI gui;
    private ArrayList dealerCards = new ArrayList();
    private ArrayList playerCards = new ArrayList();
    private ArrayList dealerCardImages = new ArrayList();
    private ArrayList playerCardImages = new ArrayList();
    private Stack deck = new Stack();
    private Card card1, card2, card3, card4;

    public void playBlackJack(GUI Gui) 
    {
	gui = Gui;
	Shoe shoe = new Shoe(gui);
	deck = shoe.getShuffledDeck();
	originalDeal();
	fillImageArrays();
	gui.updateCards(dealerCardImages, "dealer");
	gui.updateCards(playerCardImages, "player");
    }

    public void originalDeal()
    {
	card1 = (Card)deck.pop();
	System.out.println(card1.getValue());
	System.out.println(card1.getSuit());
	card2 = (Card)deck.pop();
	System.out.println(card2.getValue());
	System.out.println(card2.getSuit());
	card3 = (Card)deck.pop();
	System.out.println(card3.getValue());
	System.out.println(card3.getSuit());
	card4 = (Card)deck.pop();
	System.out.println(card4.getValue());
	System.out.println(card4.getSuit());

	dealerCards.add(card1);
	dealerCards.add(card2);

	playerCards.add(card3);
	playerCards.add(card4);
    }
    
    public void fillImageArrays()
    {
	int size = dealerCardImages.size();
	
	dealerCardImages.subList(0, size).clear();
	dealerCardImages.add(card1.getImage());
	dealerCardImages.add(card2.getImage());
       
	int size1 = playerCardImages.size();
	
	playerCardImages.subList(0, size).clear();
	playerCardImages.add(card3.getImage());
	playerCardImages.add(card4.getImage());
    }

    public void hit(String player)
    {
	Card card5 = (Card)deck.pop();
	if(player.equalsIgnoreCase("player"))
	{
	    playerCards.add(card5);
	    playerCardImages.add(card5.getImage());
	    gui.updateCards(playerCardImages, "player");
	}
	else if(player.equalsIgnoreCase("dealer"))
	{
	    dealerCards.add(card5);
	    playerCardImages.add(card5.getImage());
	    gui.updateCards(dealerCardImages, "dealer");
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
