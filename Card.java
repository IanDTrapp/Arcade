package arcade;

public class Card {
    private Suit suit;
    private Value value;

    public Card (Value value, Suit suit) {
	this.Value = value;
	this.Suit = suit;
    }

    public Suit getSuit() {
	return suit;
    }

    public Value getValue() {
	return value;
    }

}