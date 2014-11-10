package arcade;

import java.util.Collections;
import java.util.Stack<E>; 

public class Shoe {
    Stack shoe = new Stack<Card>;

    public Shoe() {
	for (a = 0; a < numDecks; a++) {
	    // Creates a single deck of each card value and rank and shuffles it
	    for (int i = 0; i < 13; i++) {
		Value value = Value.values()[i];
		
		for (int j = 0; j < 4; j++) {
		    Card card = new Card(value, Suit.values()[j]);
		    System.out.println(this.value + " of " + this.Suit.values[j]);
		    this.shoe.push(card);
		}
	    }
	}
	    // Applies the shuffle routine found in Collections API
	Collections.shuffle(shoe);
    }
}