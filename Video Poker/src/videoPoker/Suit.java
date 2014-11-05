package videoPoker;

/**
 * Enumeration class for the suits of cards.
 *
 * @author Dr. Jody Paul
 * @version Intermediate Programming (0)
 */
public enum Suit {
    HEARTS ("Hearts"),
    CLUBS ("Clubs"),
    DIAMONDS ("Diamonds"),
    SPADES ("Spades");

    /** The common name of this suit. */
    private final String suitName;

    /**
     * Constructor for Suit.
     * @param name the display name for this suit
     */
    Suit(final String name) {
        this.suitName = name;
    }

    /**
     * Provides an integer value for this suit.
     * @return the integer value corresponding to this suit
     */
    public int value() {
        return this.ordinal();
    }

    @Override
    public String toString() {
        return this.suitName;
    }
    
}
