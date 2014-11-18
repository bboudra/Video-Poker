package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import videoPoker.Hand;
import videoPoker.Card;
import videoPoker.Rank;
import videoPoker.Suit;

/**
 * Handles the testing related to the qualifier class.
 * 
 * @author Benjamin Boudra
 * @version 1.0
 */
public class QualifierTest
{
Hand hand;
	public QualifierTest()
	{
		hand = new Hand();
	}

	@Test
	public void bubkisTest()
	{
		hand.setCard(0, new Card(Rank.DEUCE, Suit.CLUBS));
		hand.setCard(1, new Card(Rank.TREY, Suit.CLUBS));
		hand.setCard(2, new Card(Rank.SEVEN, Suit.SPADES));
		hand.setCard(3, new Card(Rank.JACK, Suit.HEARTS));
		hand.setCard(4, new Card(Rank.KING, Suit.DIAMONDS));
		hand.sort();
		hand = shuffleHand(hand);
		
		hand.show();
	}

	@Test
	public void lowPairTest()
	{
		hand.setCard(0, new Card(Rank.DEUCE, Suit.CLUBS));
		hand.setCard(1, new Card(Rank.TREY, Suit.CLUBS));
		hand.setCard(2, new Card(Rank.DEUCE, Suit.SPADES));
		hand.setCard(3, new Card(Rank.JACK, Suit.HEARTS));
		hand.setCard(4, new Card(Rank.KING, Suit.DIAMONDS));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void highPairTest()
	{
		hand.setCard(0, new Card(Rank.DEUCE, Suit.CLUBS));
		hand.setCard(1, new Card(Rank.TREY, Suit.CLUBS));
		hand.setCard(2, new Card(Rank.SEVEN, Suit.SPADES));
		hand.setCard(3, new Card(Rank.KING, Suit.HEARTS));
		hand.setCard(4, new Card(Rank.KING, Suit.DIAMONDS));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void twoPairTest()
	{
		hand.setCard(0, new Card(Rank.DEUCE, Suit.CLUBS));
		hand.setCard(1, new Card(Rank.TREY, Suit.CLUBS));
		hand.setCard(2, new Card(Rank.DEUCE, Suit.SPADES));
		hand.setCard(3, new Card(Rank.KING, Suit.HEARTS));
		hand.setCard(4, new Card(Rank.KING, Suit.DIAMONDS));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void threeKindTest()
	{
		hand.setCard(0, new Card(Rank.SEVEN, Suit.CLUBS));
		hand.setCard(1, new Card(Rank.TREY, Suit.CLUBS));
		hand.setCard(2, new Card(Rank.SEVEN, Suit.SPADES));
		hand.setCard(3, new Card(Rank.SEVEN, Suit.HEARTS));
		hand.setCard(4, new Card(Rank.KING, Suit.DIAMONDS));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void straightTest()
	{
		hand.setCard(0, new Card(Rank.FOUR, Suit.CLUBS));
		hand.setCard(1, new Card(Rank.FIVE, Suit.CLUBS));
		hand.setCard(2, new Card(Rank.SIX, Suit.SPADES));
		hand.setCard(3, new Card(Rank.SEVEN, Suit.HEARTS));
		hand.setCard(4, new Card(Rank.EIGHT, Suit.DIAMONDS));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void flushTest()
	{
		hand.setCard(0, new Card(Rank.FOUR, Suit.SPADES));
		hand.setCard(1, new Card(Rank.NINE, Suit.SPADES));
		hand.setCard(2, new Card(Rank.ACE, Suit.SPADES));
		hand.setCard(3, new Card(Rank.JACK, Suit.SPADES));
		hand.setCard(4, new Card(Rank.EIGHT, Suit.SPADES));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void fullHouseTest()
	{
		hand.setCard(0, new Card(Rank, Suit));
		hand.setCard(1, new Card(Rank, Suit));
		hand.setCard(2, new Card(Rank, Suit));
		hand.setCard(3, new Card(Rank, Suit));
		hand.setCard(4, new Card(Rank, Suit));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void fourKindTest()
	{
		hand.setCard(0, new Card(Rank, Suit));
		hand.setCard(1, new Card(Rank, Suit));
		hand.setCard(2, new Card(Rank, Suit));
		hand.setCard(3, new Card(Rank, Suit));
		hand.setCard(4, new Card(Rank, Suit));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void straightFlushTest()
	{
		hand.setCard(0, new Card(Rank, Suit));
		hand.setCard(1, new Card(Rank, Suit));
		hand.setCard(2, new Card(Rank, Suit));
		hand.setCard(3, new Card(Rank, Suit));
		hand.setCard(4, new Card(Rank, Suit));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void royalFlushTest()
	{
		hand.setCard(0, new Card(Rank, Suit));
		hand.setCard(1, new Card(Rank, Suit));
		hand.setCard(2, new Card(Rank, Suit));
		hand.setCard(3, new Card(Rank, Suit));
		hand.setCard(4, new Card(Rank, Suit));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void special1Test() // TODO
	{
		hand.setCard(0, new Card(Rank, Suit));
		hand.setCard(1, new Card(Rank, Suit));
		hand.setCard(2, new Card(Rank, Suit));
		hand.setCard(3, new Card(Rank, Suit));
		hand.setCard(4, new Card(Rank, Suit));
		hand.sort();
		hand = shuffleHand(hand);
	}

	@Test
	public void special2Test() // TODO
	{
		hand.setCard(0, new Card(Rank, Suit));
		hand.setCard(1, new Card(Rank, Suit));
		hand.setCard(2, new Card(Rank, Suit));
		hand.setCard(3, new Card(Rank, Suit));
		hand.setCard(4, new Card(Rank, Suit));
		hand.sort();
		hand = shuffleHand(hand);
	}

	/**
	 * Utility method to create different permutations of the same hand.
	 * 
	 * @param handUnshuffled
	 *            the hand about to be shuffled
	 * @return the shuffled hand
	 */
	public Hand shuffleHand(Hand handUnshuffled)
	{
		ArrayList<Card> handList = new ArrayList<Card>();
		for (int i = 0; i < 5; i++)
		{
			handList.add(handUnshuffled.getCard(i));
		}
		Collections.shuffle(handList);
		for (int i = 0; i < 5; i++)
		{
			handUnshuffled.setCard(i, handList.get(i));
		}
		Hand handShuffled = handUnshuffled;
		return handShuffled;
	}
}
