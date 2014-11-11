public class Card {
    private Suit suit;
    private Value value;

    public Card (Value value, Suit suit, String filePath) {
	this.value = value;
	this.suit = suit;
    }

    public Suit getSuit() {
	return suit;
    }

    public Value getValue() {
	return value;
    }

}