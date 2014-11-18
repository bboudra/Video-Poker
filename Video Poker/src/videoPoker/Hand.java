package videoPoker;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A poker hand made of cards.
 * 
 * @author Dr. Jody Paul and Benjamin Boudra
 * @version 1
 */
public class Hand implements Iterable<Card>
{
	/** The number of cards in the hand. */
	static final int HAND_SIZE = 5;

	/** Encoding constant to use six bits per card. */
	static final int ENCODER = 64;

	/** Cards in this hand. */
	private List<Card> handList = new ArrayList<Card>();

	/**
	 * Constructs a hand from a default deck of cards.
	 */
	public Hand()
	{
		this(new Deck());
	}

	/**
	 * Hand copy constructor. Shallow copy: uses references to the original
	 * cards.
	 * 
	 * @param orig
	 *            the hand to be copied
	 */
	public Hand(final Hand orig)
	{
		for (Card c : orig)
		{
			handList.add(c);
		}
	}

	/**
	 * Creates a new hand from the beginning of a deck.
	 * 
	 * @param fromDeck
	 *            the deck from which to draw cards
	 */
	public Hand(final Deck fromDeck)
	{
		for (int i = 0; i < 5; i++)
		{
			handList.add(fromDeck.getCard(i));
		}
	}

	/**
	 * Creates a new hand given a deck and a starting position within that deck.
	 * 
	 * @param fromDeck
	 *            the deck from which to draw cards
	 * @param start
	 *            the starting index of cards in the deck
	 */
	public Hand(final Deck fromDeck, final int start)
	{
		int finish = start + 5;
		int iterator = start;
		while (iterator < finish)
		{
			handList.add(fromDeck.getCard(iterator));
			iterator++;
		}
	}

	/**
	 * Creates a new hand given a hand encoding.
	 * 
	 * @param encoding
	 *            the encoding of the desired hand
	 */
	public Hand(final long encoding)
	{
		Long l = encoding;
		int[] cardIDSet = decoder(encoding);
		for (int i = 0; i < cardIDSet.length; i++)
		{
			Card card = new Card(cardIDSet[i]);
			handList.add(card);
		}
	}
	/**
	 * Returns and iterator of the cards to the user.
	 * @return the card iterator
	 */
	@Override
	public final Iterator<Card> iterator()
	{
		Iterator<Card> cardIterator = handList.iterator();
		return cardIterator;
	}

	/**
	 * Compares two objects to see if they are equal.
	 * @param obj the hand being tested against the current hand.
	 * @return <code>true</code> if equal <code>false</code> if not.
	 */
	@Override
	public final boolean equals(final Object obj)
	{
		Hand test = (Hand) obj;
		if (equalityTest(this, test))
		{
			return true;
		} else
		{
			return false;
		}
	}
	
	/**
	 * Generates a hash code from the hand.
	 * @return the hash code.
	 */
	@Override
	public final int hashCode()
	{
		int hashValue = 0;
		for (int i = 0; i < handList.size(); i++)
		{
			hashValue +=handList.get(i).hashCode();
		}
		return hashValue;
	}

	/**
	 * Retrieves the card at a given position within this hand.
	 * <p>
	 * <b>Precondition: </b> <CODE>0 &le; which &le; HAND_SIZE</CODE>
	 * </p>
	 * 
	 * @param which
	 *            the index of the desired card
	 * @return the card at the specified index or at index 0 if precondition is
	 *         not met
	 */
	public final Card getCard(final int which)
	{
		return handList.get(which);
	}

	/**
	 * Sets a specified card of this hand.
	 * <p>
	 * <b>Precondition: </b> <CODE>0 &le; which &le; HAND_SIZE</CODE>
	 * </p>
	 * 
	 * @param which
	 *            the index of the card to change
	 * @param newCard
	 *            the card to be placed at the specified index
	 */
	public final void setCard(final int which, final Card newCard)
	{
			handList.set(which, newCard);
	}

	/**
	 * Returns the number of cards that make up a hand.
	 * 
	 * @return the size of a hand
	 */
	public static int getSize()
	{
		return HAND_SIZE;
	}

	/**
	 * Sorts this hand by ascending card rank; ignores suit.
	 */
	public final void sort()
	{
		bubbleSortRank();
	}

	/**
	 * Encode this hand as a long integer.
	 * <p>
	 * &sum; cardID[i] * ENCODER<SUP>i</SUP> ,&nbsp; &forall;i &#8717; 0 &le; i
	 * &lt; HAND_SIZE
	 * </p>
	 * 
	 * @return the encoding of this hand
	 */
	public final long encode()
	{
		long encoding = 0;
		for(int i = 0; i < handList.size(); i++)
		{
			encoding += handList.get(i).cardID() * Math.pow(64, i);
		}
		
		return encoding;
	}
	/**
	 * renders the hand as a string.
	 * 
	 * @return the hand as a string.
	 */
	@Override
	public final String toString()
	{
		StringBuilder sB = new StringBuilder();
		for(Card c: handList)
		{
			sB.append(c.toString() + "   ");
		}
		String handString = sB.toString();
		return handString;
	}

	/**
	 * Display a visual representation of this hand on System.out.
	 */
	public final void show()
	{
		show(HAND_SIZE);
	}

	/**
	 * Display a visual representation of the first cards of this hand on
	 * System.out.
	 * 
	 * @param count
	 *            the number of cards to show
	 */
	public final void show(final int count)
	{
		for(int i = 0; i < count; i ++)
		{
			Card c = handList.get(i);
			System.out.println(c.rank()+ "of" + c.suit());
		}
	}

	/** Arbitrary hand index for internal testing. */
	private static final int TEST_START_INDEX = 19;

//	/**
//	 * Internal unit testing. INCOMPLETE
//	 * 
//	 * @param args
//	 *            ignored
//	 */
//	public static void main(final String[] args)
//	{
//		Hand localHand = new Hand(new Deck());
//		localHand.show();
//		System.out.println("  Hand encoding: " + localHand.encode());
//		localHand = new Hand(new Deck(), TEST_START_INDEX);
//		localHand.show();
//		System.out.println("  Hand encoding: " + localHand.encode());
//	}
	public static void main(String[] args)
	{
		Hand hand = new Hand(425308228);
	}

	/**
	 * decodes the encoded hand and returns the hand as a set of cardID's to the caller.
	 * @param encoding the encoded hand
	 * @return the decoded hand
	 */
	private int[] decoder(Long encoding)
	{
		int[] decodedIDs = new int[5];
		String str = Long.toBinaryString(encoding);
		StringBuilder strB = new StringBuilder(str);
		str = strB.reverse().toString();
		for (int i = 0; i < 5; i++)
		{
			int location = i * 6;
			int endLocation = location + 6;
			String id;
			if(endLocation < str.length())
			{
			id = str.substring(location, endLocation);
			StringBuilder idB = new StringBuilder(id);
			id = idB.reverse().toString();
			}
			else
			{
			id = str.substring(location, str.length());
			StringBuilder idB = new StringBuilder(id);
			id = idB.reverse().toString();
			}
			int base = 2;
			
			decodedIDs[i] = Integer.parseInt(id, base);
			
		}
		return decodedIDs;
	}
	/**
	 * checks to see if the two hands are equal.
	 * @param hand1 the first hand being compared
	 * @param hand2 the second hand being compared
	 * @return true if they are equal, false if they are not.
	 */
	private boolean equalityTest(Hand hand1, Hand hand2)
	{
		boolean equality = true;
		for (int i = 0; i < this.HAND_SIZE; i++)
		{
			if (!(hand1.getCard(i).equals(hand2.getCard(i))))
			{
				equality = false;
			}
		}
		return equality;
	}
	/**
	 * finds the location of a card within the hand.
	 * @param cardToGet the card whose location we are trying to find.
	 * @return the location of the card
	 */
	private int getCardLocation(Card cardToGet)
	{
		for (int i = 0; i < handList.size(); i++)
		{
			Card checkCard = handList.get(i);
			if (cardToGet.equals(checkCard))
			{
				return i;
			}
		}
		return -1;
	}

	/**
	 * A Method that performs a bubble sort on the current hand to order it by rank.
	 */
	private void bubbleSortRank()
	{
		int c;
		int d;
		for (c = 0; c < (handList.size() - 1); c++)
		{
			for (d = 0; d < handList.size() - c - 1; d++)
			{
				if (handList.get(d).rank.ordinal() > handList.get(d + 1).rank
						.ordinal()) /* For descending order use < */
				{
					this.setCard(d, handList.get(d+1));
				}
			}
		}
	}
}