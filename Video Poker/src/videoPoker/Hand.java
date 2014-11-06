package videoPoker;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * A poker hand made of cards.
 * @author Dr. Jody Paul
 * @version Intermediate Programming (0)
 */
public class Hand implements Iterable<Card> {
    /** The number of cards in the hand. */
    static final int HAND_SIZE = 5;

    /** Encoding constant to use six bits per card. */
    static final int ENCODER = 64;

    /** Cards in this hand. */
    private List<Card> handList = new ArrayList<Card>();

    /**
     * Constructs a hand from a default deck of cards.
     */
    public Hand() {
        this(new Deck());
    }

    /**
     * Hand copy constructor.
     * Shallow copy: uses references to the original cards.
     * @param orig the hand to be copied
     */
    public Hand(final Hand orig) {
	// INCOMPLETE
    }

    /**
     * Creates a new hand from the beginning of a deck.
     * @param fromDeck the deck from which to draw cards
     */
    public Hand(final Deck fromDeck) {
	// INCOMPLETE
    }

    /**
     * Creates a new hand given a deck and a starting position
     *     within that deck.
     * @param fromDeck the deck from which to draw cards
     * @param start the starting index of cards in the deck
     */
    public Hand(final Deck fromDeck, final int start) {
    	while(start > 0)
    	{
    		handList.add(fromDeck.deal());
    		start--;
    	}
    }

    /**
     * Creates a new hand given a hand encoding.
     * @param encoding the encoding of the desired hand
     */
    public Hand(final long encoding) {
	// INCOMPLETE
    }

    @Override
    public final Iterator<Card> iterator() {
        return null; // INCOMPLETE
    }

    @Override
    public final boolean equals(final Object obj) {
	return false; // INCOMPLETE
    }

    @Override
    public final int hashCode() {
        return 0; // INCOMPLETE
    }

    /**
     * Retrieves the card at a given position within this hand.
     * <p><b>Precondition: </b>
     *     <CODE>0 &le; which &le; HAND_SIZE</CODE></p>
     * @param which the index of the desired card
     * @return the card at the specified index
     *         or at index 0 if precondition is not met
     */
    public final Card getCard(final int which) {
	return null; // INCOMPLETE
    }

    /**
     * Sets a specified card of this hand.
     * <p><b>Precondition: </b>
     *     <CODE>0 &le; which &le; HAND_SIZE</CODE></p>
     * @param which the index of the card to change
     * @param newCard the card to be placed at the specified index
     */
    public final void setCard(final int which, final Card newCard) {
	// INCOMPLETE
    }

    /**
     * Returns the number of cards that make up a hand.
     * @return the size of a hand
     */
    public static int getSize() {
        return HAND_SIZE;
    }

    /**
     * Sorts this hand by ascending card rank; ignores suit.
     */
    public final void sort() {
	// INCOMPLETE
    }

    /**
     * Encode this hand as a long integer.
     * <p>&sum; cardID[i] * ENCODER<SUP>i</SUP> ,&nbsp;  &forall;i &#8717; 0 &le; i &lt; HAND_SIZE</p>
     * @return the encoding of this hand
     */
    public final long encode() {
        return 0L; // INCOMPLETE
    }

    @Override
    public final String toString() {
        return ""; // INCOMPLETE
    }

    /**
     * Display a visual representation of this hand on System.out.
     */
    public final void show() {
        show(HAND_SIZE);
    }

    /**
     * Display a visual representation of the
     *      first cards of this hand on System.out.
     * @param count the number of cards to show
     */
    public final void show(final int count) {
	// INCOMPLETE
    }

    /** Arbitrary hand index for internal testing. */
    private static final int TEST_START_INDEX = 19;
    /**
     * Internal unit testing.
     * INCOMPLETE
     * @param args ignored
     */
    public static void main(final String[] args) {
        Hand localHand = new Hand(new Deck());
        localHand.show();
        System.out.println("  Hand encoding: " + localHand.encode());
        localHand = new Hand(new Deck(), TEST_START_INDEX);
        localHand.show();
        System.out.println("  Hand encoding: " + localHand.encode());
    }
}