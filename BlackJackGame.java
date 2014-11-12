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
    private int dealerTotal, playerTotal;
    private int dealerWins, playerWins;

    public void playBlackJack(GUI Gui) 
    {
	gui = Gui;
	Shoe shoe = new Shoe(gui);
	deck = shoe.getShuffledDeck();
	
	originalDeal();
	gui.updateCards(dealerCardImages, "dealer");
	gui.updateCards(playerCardImages, "player");
    }
    
    public ArrayList getDealerCards()
    {
	return dealerCards;
    }
    
    public ArrayList getPlayerCards()
    {
	return playerCards;
    }

    public void refresh()
    {
	dealerTotal = 0;
	playerTotal = 0;

	dealerCards.subList(0, dealerCards.size()).clear();
	playerCards.subList(0, playerCards.size()).clear();
	dealerCardImages.subList(0, dealerCardImages.size()).clear();
	playerCardImages.subList(0, dealerCardImages.size()).clear();
    }

    public void updateLists(ArrayList newList, String player)
    {
	if(player.equalsIgnoreCase("player"))
	{
	    playerCardImages.subList(0, playerCardImages.size()).clear();
	    playerCardImages.addAll(newList);
	}
	else if(player.equalsIgnoreCase("dealer"))
	{
	    dealerCardImages.subList(0, dealerCardImages.size()).clear();
	    dealerCardImages.addAll(newList);
	}
    }

    public void addWin(String player)
    {
	if(player.equalsIgnoreCase("player"))
	{
	    playerWins++;
	}
	else if(player.equalsIgnoreCase("dealer"))
	{
	    dealerWins++;
	}
    }

    public void originalDeal()
    {
	card1 = (Card)deck.pop();
	card2 = (Card)deck.pop();
	card3 = (Card)deck.pop();
	card4 = (Card)deck.pop();
	int int1, int2, int3, int4;

	dealerCards.add(card1);
	dealerCards.add(card2);
	dealerCardImages.add(card1.getImage());
	dealerCardImages.add(card2.getImage());
	int1 = card1.getValue().getValue();
	dealerTotal += int1;
	int2 = card2.getValue().getValue();
	dealerTotal += int2;

	playerCards.add(card3);
	playerCards.add(card4);
	playerCardImages.add(card3.getImage());
	playerCardImages.add(card4.getImage());
	int3 = card3.getValue().getValue();
	playerTotal += int3;
	int4 = card4.getValue().getValue();
	playerTotal += int4;
    }
 

    public void hit(String player)
    {
	Card card5 = (Card)deck.pop();
	int temp = card5.getValue().getValue();

	if(player.equalsIgnoreCase("player"))
	{
	    playerCards.add(card5);
	    playerTotal += temp;
	    playerCardImages.add(card5.getImage());
	    gui.updateCards(playerCardImages, "player");
	    if(playerTotal > 21)
	    {
		gui.bjGameOver("player");
		dealerWins++;
	    }
	}
	else if(player.equalsIgnoreCase("dealer"))
	{
	    dealerCards.add(card5);
	    dealerTotal += temp;
	    playerCardImages.add(card5.getImage());
	    gui.updateCards(dealerCardImages, "dealer");
	    if(dealerTotal > 21)
	    {
		gui.bjGameOver("dealer");
		playerWins++;
	    }
	}
    }

    public void stand(String player)
    {
	if((21-dealerTotal) < (21-playerTotal))
	{
	    gui.bjGameOver("player");
	    dealerWins++;
	}
	if((21-playerTotal) < (21-dealerTotal))
	{
	    gui.bjGameOver("dealer");
	    playerWins++;
	}
    }

    public void split(String player)
    {
	return;
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
