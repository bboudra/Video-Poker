package test;

import java.util.Arrays;
import java.util.Collection;

import videoPoker.Card;
import videoPoker.Rank;
import videoPoker.Suit;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CardTest
{
	private Card cardBeingTested;

	public CardTest(Card cardToTest)
	{
		cardBeingTested = cardToTest;
	}

	@Parameters
	public static Collection<Object[]> data()
	{
		return Arrays.asList(new Object[][]
		{
		{ new Card() },
		{ new Card(Rank.JACK, Suit.DIAMONDS) },
		{ new Card(Rank.DEUCE, Suit.HEARTS) },
		{ new Card(Rank.ACE, Suit.SPADES) },
		{ new Card(Rank.KING, Suit.CLUBS) } });
	}

	@Test
	public void testHashCode()
	{
		Card card = new Card(this.cardBeingTested.rank(), this.cardBeingTested.suit());
		assertEquals(card.hashCode(),cardBeingTested.hashCode());
	}

	@Test
	public void testCard()
	{
		Card cardToTestAgainst = new Card(cardBeingTested.rank(),
				cardBeingTested.suit());
		assertTrue(cardToTestAgainst.suit().equals(cardBeingTested.suit()));
		assertTrue(cardToTestAgainst.rank().equals(cardBeingTested.rank()));
	}

	@Test
	public void testGenerateCardID()
	{
		Card cardToTestAgainst = new Card(cardBeingTested.rank(),
				cardBeingTested.suit());
		int cardID = cardToTestAgainst.suit().ordinal() * Rank.values().length;
		cardID += cardToTestAgainst.rank().ordinal();
		assertEquals(
				cardID,
				Card.generateCardID(cardBeingTested.rank(),
						cardBeingTested.suit()));
	}

	@Test
	public void testRetrieveRank()
	{
		int testCardID = Card.generateCardID(cardBeingTested.rank(), cardBeingTested.suit());
		assertEquals(cardBeingTested.rank(), findRank(testCardID));
	}

	@Test
	public void testRetrieveSuit()
	{
		int testCardID = Card.generateCardID(this.cardBeingTested.rank(), this.cardBeingTested.suit());
		assertEquals(this.cardBeingTested.suit(), findSuit(testCardID));
	}

	@Test
	public void testRank()
	{
		Card cardTest = new Card(Rank.DEUCE, Suit.CLUBS);
		Card cardTest2 = new Card();
		assertEquals(Rank.DEUCE, cardTest.rank());
		assertEquals(Rank.QUEEN, cardTest2.rank());

		Card cardToTestAgainst = new Card(cardBeingTested.rank(),
				cardBeingTested.suit());
		assertTrue(cardToTestAgainst.rank().equals(cardBeingTested.rank()));
	}

	@Test
	public void testSuit()
	{
		Card cardTest = new Card(Rank.DEUCE, Suit.CLUBS);
		Card cardTest2 = new Card();
		assertEquals(Suit.CLUBS, cardTest.suit());
		assertEquals(Suit.HEARTS, cardTest2.suit());

		Card cardToTestAgainst = new Card(cardBeingTested.rank(),
				cardBeingTested.suit());
		assertTrue(cardToTestAgainst.suit().equals(cardBeingTested.suit()));
	}

	@Test
	public void testCardID()
	{
		assertEquals(Card.generateCardID(cardBeingTested.rank(),cardBeingTested.suit()), cardBeingTested.cardID());
	}

	@Test
	public void testEqualsObject()
	{
		Card card = new Card(Rank.ACE,Suit.HEARTS);
		Card cardTwo = new Card(this.cardBeingTested.rank(),this.cardBeingTested.suit());
		assertTrue(this.cardBeingTested.equals(cardTwo));
		assertFalse(this.cardBeingTested.equals(card));
		assertTrue(equals(cardTwo));
		assertFalse(equals(card));
	}

	/**
	 * utility method to find the rank of a specific card whose identity is determined by its cardID
	 * @param cardID
	 * @return the rank of that card
	 */
	public Rank findRank(int cardID)
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
	public Suit findSuit(int cardID)
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
     * equals method
     *   both rank and suit must be the same.
     * @param obj the object to compare with this card
     */
	public boolean equals(final Object obj) {
    	Card c = (Card) obj;
    	boolean rankCompare = this.cardBeingTested.rank().equals(c.rank());
    	boolean suitCompare = this.cardBeingTested.suit().equals(c.suit());
    	if(rankCompare == true && suitCompare == true)
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}
