import java.util.Collections;
import java.util.Stack; 
import java.util.ArrayList;
import java.util.List;

public class Shoe {
    List<Card> shoe = new ArrayList<Card>();

    public Shoe() {
	GUI gui = new GUI();
	for (int a = 0; a < gui.getNumDecks(); a++) {
	    int count = 1;
	    // Creates a single deck of each card value and rank and shuffles it
	    for (int i = 0; i < 4; i++) {
		Suit suit = Suit.values()[i];
		
		for (int j = 0; j < 13; j++) {
		    Value value = Value.values()[j];
		    // Creates a new card referencing the proper value, suit, and image associated
		    Card card = new Card(value, suit, "classic-cards/" + count + ".png");
		    System.out.println(value + " of " + suit);
		    System.out.println("Test");
		    count++;
		}
	    }
	}
    }
    
    public Stack getShuffledDeck() {
	Collections.shuffle(shoe);
	Stack shuffled = new Stack();
	shuffled.addAll(shoe);
	return shuffled;
    }
}

