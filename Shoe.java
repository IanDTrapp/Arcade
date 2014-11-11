import java.util.Collections;
import java.util.Stack; 
import java.util.ArrayList;
import java.util.List;

public class Shoe 
{
    List<Card> shoe = new ArrayList<Card>();
    private GUI gui;

    public Shoe(GUI Gui) 
    {
	gui = Gui;
	for (int a = 0; a < gui.getNumDecks(); a++) 
	{
	    int count = 1;
	    // Creates a single deck of each card value and rank and shuffles it
	    
	    for (int i = 12; i >= 0; i--) 
	    {
		Value value = Value.values()[i];
		
		for (int j = 0; j < 4; j++) 
		{
		    Suit suit = Suit.values()[j];
		    // Creates a new card referencing the proper value, suit, and image associated
		    Card card = new Card(value, suit, "classic-cards/" + count + ".png");
		    shoe.add(card);
		  
		    count++;
		}
	    }
	}
    }
    
    public Stack getShuffledDeck() 
    {
	Collections.shuffle(shoe);
	Stack shuffled = new Stack();
	shuffled.addAll(shoe);
	return shuffled;
    }
}

