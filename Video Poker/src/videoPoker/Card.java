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
    	return findRank(cardid);
    }

    /**
     * Utility to retrieve suit from an integer card ID.
     * @param cardid the card ID to process
     * @return the suit associated with the given card ID
     */
    public static Suit retrieveSuit(final int cardid) {
    	try
    	{
    	return findSuit(cardid);
    	}
    	catch(IndexOutOfBoundsException e)
    	{
    		return null;
    	}
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

    /**
     * Generates a hashCode using the currend card's <code>cardID</code>.
     *@return the hashCode;
     */
    @Override
    public final int hashCode() {
    	Integer hashValue = this.cardID();
    	return hashValue.hashCode();
    }
    
    	/**
	 * utility method to find the rank of a specific card whose identity is determined by its cardID
	 * @param cardID
	 * @return the rank of that card
	 */
	private static Rank findRank(int cardID)
	{
		if (cardID > 51 || cardID < 0)
		{
			throw new IndexOutOfBoundsException("This card ID is not within the valid range of id's");
		}
		while (cardID > 12)
		{
			cardID -= 13;
		}
		if (cardID == 0)
		{
			return Rank.ACE;
		} else if (cardID == 1)
		{
			return Rank.DEUCE;
		} else if (cardID == 2)
		{
			return Rank.TREY;
		} else if (cardID == 3)
		{
			return Rank.FOUR;
		} else if (cardID == 4)
		{
			return Rank.FIVE;
		} else if (cardID == 5)
		{
			return Rank.SIX;
		} else if (cardID == 6)
		{
			return Rank.SEVEN;
		} else if (cardID == 7)
		{
			return Rank.EIGHT;
		} else if (cardID == 8)
		{
			return Rank.NINE;
		} else if (cardID == 9)
		{
			return Rank.TEN;
		} else if (cardID == 10)
		{
			return Rank.JACK;
		} else if (cardID == 11)
		{
			return Rank.QUEEN;
		} else 
		{
			return Rank.KING;
		}
	}
	
		/**
	 * utility method to find and return the suit of a specific card as determined by its cardID
	 * @param cardID
	 * @return the suit of that card
	 */
	private static Suit findSuit(int cardID)
	{
		if (cardID >= 0 && cardID < 13)
		{
			return Suit.HEARTS;
		} else if (cardID >= 13 && cardID < 26)
		{
			return Suit.CLUBS;
		} else if (cardID >= 26 && cardID < 39)
		{
			return Suit.DIAMONDS;
		} else if (cardID >= 39 && cardID < 52)
		{
			return Suit.SPADES;
		} else
		{
			throw new IndexOutOfBoundsException("This cardID is not within the valid range of ID's");
		}
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
    		//System.out.print(Card.generateCardID(Rank.KING, Suit.HEARTS));
    	Card card1 = new Card(Rank.FIVE,Suit.HEARTS);
    	System.out.println(card1.cardID());
    	Card card2 = new Card(Rank.DEUCE,Suit.HEARTS);
    	System.out.println(card2.cardID());
    	Card card3 = new Card(Rank.DEUCE,Suit.DIAMONDS);
    	System.out.println(card3.cardID());
    	Card card4 = new Card(Rank.TEN, Suit.CLUBS);
    	System.out.println(card4.cardID());
    	Card card5 = new Card(Rank.KING, Suit.CLUBS);
    	System.out.println(card5.cardID());
    }
}