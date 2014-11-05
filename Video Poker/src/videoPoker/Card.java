package videoPoker;

/**
 * Objects represent cards in a typical
 * deck of playing cards.
 *
 * @author Ben Boudra and Jody Paul
 * @version 1 
 */
public class Card {
	Rank rank;
	Suit suit;
	
    /**
     * Card constructor for the Queen of Hearts.
     */
    public Card() {
        this(Rank.QUEEN, Suit.HEARTS);
    }

    /**
     * Card constructor.
     * @param cardRank the rank for this card
     * @param cardSuit the suit for this card
     */
    public Card(final Rank cardRank, final Suit cardSuit) {
    	rank = cardRank;
    	suit = cardSuit;
    }

    /**
     * Card copy constructor.
     * @param card the card to be copied
     */
    public Card(final Card card) {
        this(card.rank, card.suit);
    }

    /**
     * Card constructor from card ID.
     * @param cardid the ID of the card to construct
     */
    public Card(final int cardid) {
        this(retrieveRank(cardid), retrieveSuit(cardid));
    }

    /**
     * Utility to generate an integer card ID.
     * <PRE>cardID = (cardSuit.ordinal() * Rank.values().length)) + cardRank.ordinal()</PRE>
     * @param cardRank the rank of the card
     * @param cardSuit the suit of the card
     * @return the cardID associated with the given rank and suit
     */
    public static int generateCardID(final Rank cardRank, final Suit cardSuit) {
        int cardID = cardSuit.ordinal() * Rank.values().length;
        cardID += cardRank.ordinal();
        return cardID;
    }

    /**
     * Utility to retrieve rank from an integer card ID.
     * @param cardid the card ID to process
     * @return the rank associated with the given card ID
     */
    public static Rank retrieveRank(final int cardid) {
        return null; // INCOMPLETE
    }

    /**
     * Utility to retrieve suit from an integer card ID.
     * @param cardid the card ID to process
     * @return the suit associated with the given card ID
     */
    public static Suit retrieveSuit(final int cardid) {
        return null; // INCOMPLETE
    }

    /**
     * Access the rank of this card.
     * @return the rank of this card
     */
    public final Rank rank() {
    	return this.rank;
    }

    /**
     * Access the suit of this card.
     * @return the suit of this card
     */
    public final Suit suit() {
    	return this.suit;
    }

    /**
     * Access the ID of this card.
     * @return the ID of this card
     */
    public final int cardID() {
    	return Card.generateCardID(this.rank, this.suit);
    }

    /**
     * Render this card as commonly used phrase:
     *   <i>rank</i> of <i>suit</i>.
     * Examples: "Five of Diamonds", "King of Hearts"
     * @return common name of this card
     */
    @Override
    public final String toString() {
        return this.rank + " of " + this.suit;
    }

    /**
     * Overridden equals method;
     *   both rank and suit must be the same.
     * @param obj the object to compare with this card
     */
    @Override
    public final boolean equals(final Object obj) {
    	Card c = (Card) obj;
    	boolean rankCompare = this.rank.equals(c.rank);
    	boolean suitCompare = this.suit.equals(c.suit);
    	if(rankCompare == true && suitCompare == true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    @Override
    /**
     * 
     *@return the hashCode;
     */
    public final int hashCode() {
        return 17; // INCOMPLETE
    }

    /**
     * Internal testing.
     * INCOMPLETE.
     * @param args ignored
     */
    public static void main(final String[] args) {
//        Card c = new Card();
//        System.out.println(c);
//        Card d = new Card(c);
//        System.out.println(d + " == " + c + " --> " + (d == c));
//        System.out.println(d + ".equals(" + c + ") --> " + d.equals(c));
    		System.out.print(Card.generateCardID(Rank.KING, Suit.HEARTS));
    		
    }
}