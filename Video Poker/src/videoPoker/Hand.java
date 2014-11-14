package videoPoker;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A poker hand made of cards.
 * 
 * @author Dr. Jody Paul
 * @version Intermediate Programming (0)
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

	@Override
	public final Iterator<Card> iterator()
	{
		Iterator<Card> cardIterator = handList.iterator();
		return cardIterator;
	}

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

	@Override
	public final int hashCode()
	{
		int hashValue = 0;
		for (int i = 0; i < handList.size(); i++)
		{
			Integer current = handList.get(i).cardID();
			hashValue += current.hashCode();
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
		int loc = getCardLocation(newCard);
		if (loc == -1)
		{
			Exception e = new Exception(
					"the specified object is not in the list");
			e.printStackTrace();
		} else
		{
			Card cardToSwapWithNewCard = handList.get(which);
			handList.set(which, newCard);
			handList.set(loc, cardToSwapWithNewCard);
		}
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
		long encoding;
		for(int i = 0; i < handList.size(); i++)
		{
			handList.get(i).cardID() * Math.pow(arg0, arg1)
		}
	}

	@Override
	public final String toString()
	{
		return ""; // INCOMPLETE
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
		Hand hand = new Hand(862815373);
	}

	private int[] decoder(Long encoding)
	{
		int[] decodedIDs = new int[5];
		String str = Long.toBinaryString(encoding);
		for (int i = 0; i < 5; i++)
		{
			int location = i * 5;
			int endLocation = location + 5;
			String id = str.substring(location, endLocation);
			int base = 2;
			decodedIDs[i] = Integer.parseInt(id, base);
		}
		return decodedIDs;
	}

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
					handList.set(d, handList.get(d + 1));
				}
			}
		}
	}
}