package arcade;

import java.util.Collections;
import java.util.Stack<E>; 

public class Shoe {
    Stack shoe = new Stack<Card>;

    public Shoe() {
	for (a = 0; a < numDecks; a++) {
	    int count = 1;
	    // Creates a single deck of each card value and rank and shuffles it
	    for (int i = 0; i < 4; i++) {
		Suit suit = Suit.values()[i];
		
		for (int j = 0; j < 13; j++) {
		    // Creates a new card referencing the proper value, suit, and image associated
		    Card card = new Card(Values.values()[j], suit, "classic-cards/" + count + ".png");
		    System.out.println(this.Value.values[j] + " of " + this.suit);

		    this.shoe.push(card);
		    count++;
		}
	    }
	    // Applies the shuffle routine found in Collections API
	    Collections.shuffle(shoe);
	}
    }
}

