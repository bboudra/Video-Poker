/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import videoPoker.Card;
import videoPoker.Deck;
import videoPoker.Hand;
import videoPoker.Rank;
import videoPoker.Suit;

/**
 * @author Benjamin Boudra
 * @version 1.0
 *
 */
public class HandTest
{
	Hand hand;
	Deck deckShuffled;
	Card card;
	Hand decodedHand;
	Deck deckUnshuffled;
	Hand standardTestHand;

	/**
	 * sets up all of the assignments before the class runs.
	 */
	@Before
	public void setup()
	{
		hand = new Hand();
		deckUnshuffled = new Deck();
		deckShuffled = new Deck(deckUnshuffled);
		deckShuffled.shuffle();
		decodedHand = new Hand(862815373);
		standardTestHand = buildStandardTestHand();
	}

	/**
	 * Test for hand's <code>hashCode</code> method that determines whether two
	 * of the same hand generate the same hashCode.
	 */
	@Test
	public void testHashCode()
	{
		Hand hand1 = new Hand();
		Hand hand2 = new Hand();
		assertEquals(hand1.hashCode(), hand2.hashCode());
	}

	/**
	 * Test test of the <code>Hand</code> constructor to determine whether or
	 * not the default constructor and the constructor that takes in a deck work correctly
	 */
	@Test
	public void testHand()
	{
		Hand handToTest = new Hand(deckUnshuffled);
		handEqualityTest(handToTest, hand);
	}
	
	/**
	 * a test of the copy constructor.
	 */
	@Test
	public void testCopyConstructor()
	{
		Hand handCopy = new Hand(hand);
		handEqualityTest(handCopy, hand);
	}

	/**
	 * Test method for hand constructor and encode method
	 */
	@Test
	public void testHandLongAndEncode()
	{
		Hand longHand = new Hand(862815373);
		assertEquals(862815373, longHand.encode());
		Hand secondDecodedHand = new Hand(862815373);
		assertTrue(handEqualityTest(longHand, decodedHand));
	}

	/**
	 * Test method for iterator
	 */
	@Test
	public void testIterator()
	{
		Iterator<Card> handIterator = hand.iterator();
		int locationCount = 0;
		while(handIterator.hasNext())
		{
			assertEquals(hand.getCard(locationCount), handIterator.next());
			locationCount++;
		}
	}

	/**
	 * Test method for equalsObject
	 */
	@Test
	public void testEqualsObject()
	{
		assertTrue(handEqualityTest(new Hand(862815373), decodedHand));
	}

	/**
	 * Test method for getCard
	 */
	@Test
	public void testGetCard()
	{
		assertEquals(new Card(Rank.FIVE,Suit.HEARTS), hand.getCard(4));
	}

	/**
	 * Test method for setCard
	 */
	@Test
	public void testSetCard()
	{
		Card assertCard = hand.getCard(2);
		Card swappedCard = hand.getCard(4);
		hand.setCard(4, assertCard);
		assertEquals(assertCard, hand.getCard(4));
		assertEquals(swappedCard, hand.getCard(2));
		
	}

	/**
	 * Test method for size
	 */
	@Test
	public void testGetSize()
	{
		assertEquals(5, Hand.getSize());
	}

	/**
	 * Test method for <code>sort</code>
	 */
	@Test
	public void testSort()
	{
		for(int i = 0; i < Hand.getSize()-1; i++)
		{
			if(!(hand.getCard(i).rank().ordinal() <= hand.getCard(i +1).rank().ordinal()))
			{
				fail();
			}
		}
	}
	
	/**
	 * utility method to determine characteristics of hand.
	 * @param hand1 
	 * @param hand2
	 * @return whether or not the hands are equal.
	 */
	public static boolean handEqualityTest(Hand hand1, Hand hand2)
	{
		if (hand1.getSize() != hand2.getSize() || hand1.getSize() == 0 || hand2.getSize() == 0)
		{
			return false;
		}
		else
		{
			for(int i = 0; i < hand1.getSize(); i++)
			{
				if(!(hand1.getCard(i).equals(hand2.getCard(i))))
				{
					return false;
				}
			}
			return true;
		
		}
	}
	
	public Hand buildStandardTestHand()
	{
		Deck deck = new Deck();
		deck.shuffle();
		Hand standardHand = new Hand(deck);
		return standardHand;
	}

}
