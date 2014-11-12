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
    private boolean isPlayerStanding = false;
    private boolean isDealerStanding = false;
    private ArrayList dealerOriginalCards = new ArrayList();
    private ArrayList dealerOriginalImages = new ArrayList();
    // For splitting
    private ArrayList splitDeck1 = new ArrayList();
    private ArrayList splitDeck2 = new ArrayList();
    private int splitTotal1 = 0;
    private int splitTotal2 = 0;
    private ArrayList split1CardImages = new ArrayList();
    private ArrayList split2CardImages = new ArrayList();

    public void playBlackJack(GUI Gui) 
    {
	gui = Gui;
	Shoe shoe = new Shoe(gui);
	deck = shoe.getShuffledDeck();
	
	originalDeal();
	gui.updateCards(dealerOriginalCards, "dealero");
	gui.updateCards(playerCards, "player");
    }

    public boolean canSplit()
    {
	int[] temp = new int[2];
	
	for(int i = 0; i < 2; i ++)
	{
	    temp[i] =  ((Card)playerCards.get(i)).getValue().getValue();
	}
	if(temp[0] == temp[1])
	{
		return true;
	}
	else
	    return false;
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
	else if(player.equalsIgnoreCase("playero"))
	{
	    playerCardImages.addAll(newList);
	}
	else if(player.equalsIgnoreCase("dealero"))
	{
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

	dealerOriginalCards.add(card1);
	dealerOriginalCards.add(card2);
	dealerOriginalImages.add(card1.getImage());
	dealerOriginalImages.add(card2.getImage());
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

	if(canSplit() == true)
	{
	   gui.setSplitButtonVis(true);
	}

	while(dealerTotal <= 16)
	{
	    hit("dealer");
	}
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
	}
    }

    public void stand(String player)
    {
	if (player.equals("player")) 
	{
	    isPlayerStanding = true;
	    gui.updateCards(dealerCardImages, "dealer");
	    if(dealerTotal > 21)
	    {
		gui.bjGameOver("dealer");
	    }
	    else if(dealerTotal <= 21 && playerTotal < dealerTotal)
	    {
		gui.bjGameOver("player");
	    }
	    else if(dealerTotal == 21 && playerTotal == 21)
	    {
		gui.bjTie();
	    }
	}
	
	if(isPlayerStanding == true) 
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
    }

    public void split(String player)
    {
	splitDeck1.add(playerCards.get(0));
	splitDeck2.add(playerCards.get(1));
    }

    public void hitOnSplit(int deckNum) {
	// 1 - Left Deck   -- 2 - Right Deck
	Card card9 = (Card)deck.pop();
	Card card10 = (Card)deck.pop();
	int temp1 = card9.getValue().getValue();
	int temp2 = card10.getValue().getValue();
	
	if(deckNum == 1){
	    splitDeck1.add(card9);
	    splitTotal1 += temp1;
	    split1CardImages.add(card9.getImage());
	    gui.updateCards(split1CardImages, "player");
	    if(splitTotal1 > 21)
		{
		    gui.bjGameOver("player");
		    dealerWins++;
		}
	}
	if(deckNum == 2) {
	    splitDeck2.add(card10);
	    splitTotal2 += temp2;
	    split2CardImages.add(card10.getImage());
	    gui.updateCards(split2CardImages, "player");
	    if(splitTotal2 > 21)
		{
		    gui.bjGameOver("player");
		    dealerWins++;
		}
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
