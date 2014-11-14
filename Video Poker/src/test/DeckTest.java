package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import videoPoker.Card;
import videoPoker.Deck;
import videoPoker.Rank;
import videoPoker.Suit;

/***
 * the deck test class, contains various tests of the Deck methods.
 * 
 * @author Benjamin Boudra
 * @version 1.0
 *
 */
public class DeckTest
{
	Deck deck;

	/**
	 * constructor for deck test, initializes the default deck
	 */
	public DeckTest()
	{
		deck = new Deck();
	}

	/**
	 * Default Deck Constructor Test, tests to see that the constructor builds a
	 * deck according to a specific order
	 */
	@Test
	public void testDeck()
	{
		assertTrue(defaultDeckCompleteAndInOrder(new Deck()));
	}

	/**
	 * deck copy constructor tests, tests to see that the copied deck is a
	 * replica of the first one.
	 */
	@Test
	public void testDeckDeck()
	{
		Deck deck2 = new Deck(deck);
		assertTrue(deckEqual(deck, deck2));
		deck.shuffle();
		deck2 = new Deck(deck);
		assertTrue(deckEqual(deck, deck2));

	}

	/**
	 * A test of the <code>size</code> method, tests to see that the size
	 * originally set two 52, and gets reduced when the deck deals a hand to the
	 * user.
	 */
	@Test
	public void testSize()
	{
		assertEquals(52, deck.size());
		deck.deal();
		assertEquals(51, deck.size());
	}

	/**
	 * A test of the <code>getCard</code> method. checks to see if the deck
	 * returnes the specified card.
	 */
	@Test
	public void testGetCard()
	{
		Card testCard = new Card(Rank.ACE, Suit.HEARTS);
		assertEquals(testCard, deck.getCard(0));
		testCard = new Card(Rank.KING, Suit.SPADES);
		assertEquals(testCard, deck.getCard(51));
		testCard = new Card(Rank.SEVEN, Suit.CLUBS);
		assertEquals(testCard, deck.getCard(19));
	}

	/**
	 * A test of the <code>setCard</code> method. checks to see if the sets the
	 * card in the specified location and then checks to see fit the card at
	 * that location is swapped to the first card's location.
	 */
	@Test
	public void testSetCard()
	{
		Card card = deck.getCard(27);
		Card card2 = deck.getCard(13);
		Card cardSwitched = deck.setCard(13, card);
		assertTrue(cardSwitched.equals(deck.getCard(13)));
		assertTrue(card.equals(deck.getCard(13)));
		assertTrue(card2.equals(deck.getCard(27)));
	}

	/***
	 * a test of the <code>iterator</code> method, checks to see if the iterator
	 * that is returned is an iterator over the correct deck.
	 */
	@Test
	public void testIterator()
	{
		Iterator deckIterator = deck.iterator();
		int i = 0;
		while (deckIterator.hasNext())
		{
			deck.getCard(i).equals(deckIterator.next());
			i++;
		}
	}

	/**
	 * A test of the <code> deal</code> method, checks to see if the card in the
	 * first location is removed and returned to the caller.
	 */
	@Test
	public void testDeal()
	{
		deck.shuffle();
		int currentCardCount = 52;
		for (int i = 0; i < 5; i++)
		{

			Card cardToDeal = deck.getCard(0);
			Card cardDealt = deck.deal();
			currentCardCount--;
			assertEquals(cardToDeal, cardDealt);
			assertEquals(currentCardCount, deck.size());
			assertFalse(deckContains(cardDealt, deck));
		}
	}

	/**
	 * A test of the <code>shuffle</code> method, checks to see if the deck is
	 * shuffled.
	 */
	@Test
	public void testShuffle()
	{
		Deck deck2 = new Deck(deck);
		deck2.shuffle();
		assertFalse(deckEqual(deck, deck2));
		assertTrue(containsSameStuff(deck, deck2));

	}

	/**
	 * a utility method that determines if two decks are equal.
	 * 
	 * @param deck1
	 * @param deck2
	 * @return whether they are equal
	 */
	private boolean deckEqual(Deck deck1, Deck deck2)
	{
		for (int i = 0; i < deck1.size(); i++)
		{
			if (!(deck1.getCard(i).equals(deck2.getCard(i))))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * a utility method to see if the default deck is generated correctly.
	 * 
	 * @param deck
	 * @return <code>true</code> or <code>false</code> depending on whether the
	 *         deck is generated correctly
	 */
	private boolean defaultDeckCompleteAndInOrder(Deck deck)
	{
		int deckLocation = 0;
		for (Suit s : Suit.values())
		{
			for (Rank r : Rank.values())
			{

				if (!(new Card(r, s).equals(deck.getCard(deckLocation))))
				{
					return false;
				}
				deckLocation++;
			}
		}
		return true;
	}

	/**
	 * A utility method that determines if a deck contains a specified card.
	 * 
	 * @param card
	 * @param deck1
	 * @return whether the deck contains the card.
	 */
	private boolean deckContains(Card card, Deck deck1)
	{
		Iterator iterate = deck1.iterator();
		while (iterate.hasNext())
		{
			if (card.equals(iterate.next()))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * A utility method that checks two decks to see if they contain the same
	 * cards.
	 * 
	 * @param deck
	 * @param deck2
	 * @return <code>true</code> or <code>false</code> depending on whether or
	 *         not the decks contain the same cards
	 */
	private boolean containsSameStuff(Deck deck, Deck deck2)
	{
		for (int i = 0; i < deck.size(); i++)
		{
			if (!(deckContains(deck.getCard(i), deck2)))
			{
				return false;
			}
		}
		for (int i = 0; i < deck2.size(); i++)
		{
			if (!(deckContains(deck2.getCard(i), deck)))
			{
				return false;
			}
		}
		return true;
	}
}
