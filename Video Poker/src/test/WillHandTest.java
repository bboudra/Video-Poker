package test;


import java.util.Map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoPoker.Deck;
import videoPoker.Hand;
import videoPoker.Card;
import videoPoker.Rank;
import videoPoker.Suit;

import java.util.Iterator;
/**
 * The test class HandTest.
 *
 * @author  William Price   
 * @version Cs390i - Intermediate Programming Fall 2014 - v11Nov
 */

public class WillHandTest
{
    /**
     * Default constructor for test class HandTest
     */
    public WillHandTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    // Tests for Hand Class
    
    /**
     * Tests for default Hand constructor
     */
    @Test
    public void HandDefaultConstructorTest() {
        Hand hand = new Hand();
        assertEquals("Ace of Hearts   Deuce of Hearts   " + 
                     "Trey of Hearts   Four of Hearts   " +
                     "Five of Hearts   ",hand.toString());
    }
    
    /**
     * Tests for Hand from Deck
     */
    @Test
    public void HandFromDeckTest() {
        Deck deck = new Deck();
        deck.setCard(0, new Card(Rank.DEUCE,Suit.CLUBS));
        deck.setCard(1, new Card(Rank.SIX,Suit.CLUBS));
        deck.setCard(2, new Card(Rank.SEVEN,Suit.SPADES));
        deck.setCard(3, new Card(Rank.EIGHT,Suit.HEARTS));
        deck.setCard(4, new Card(Rank.JACK,Suit.DIAMONDS));
        Hand hand = new Hand(deck);
        assertEquals("Deuce of Clubs   Six of Clubs   Seven of Spades   " +
                     "Eight of Hearts   Jack of Diamonds   ",hand.toString());
    }
    
    /**
     * Tests for Hand from Hand duplicate Constructor
     */
    @Test
    public void HandDuplicateConstructorTest() {
        Deck deck = new Deck();
        Hand handone = new Hand(deck);
        Hand handtwo = new Hand(handone);
        assertEquals(handone.toString(),handtwo.toString());
    }
 
    /**
     * Test for Sort, constructor from spot in deck
     */
    @Test
    public void HandSortTest() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck, 11);
        assertEquals("Queen of Hearts   King of Hearts   " +
                     "Ace of Clubs   Deuce of Clubs   " +
                     "Trey of Clubs   ", hand.toString());
        hand.sort();
        assertEquals("Ace of Clubs   Deuce of Clubs   " +
                     "Trey of Clubs   Queen of Hearts   " +
                     "King of Hearts   ", hand.toString());
    }
 
    /**
     * Tests for encode, constructor from encoded hand, and equals method
     */
    @Test
    public void HandEncodingDecodingTest() {
        Deck deck = new Deck();
        Hand firsthand = new Hand(deck);
        Hand copyhand = new Hand(firsthand.encode());
        assertTrue(firsthand.equals(copyhand));
    }
 
    /**
     * Tests for setCard, getCard
     */
    @Test
    public void HandSetGetCardTest() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);
        Card cardone = new Card(Rank.NINE,Suit.CLUBS);
        hand.setCard(0,cardone);
        Card cardtwo = hand.getCard(0);
        assertEquals(cardone.toString(), cardtwo.toString());
    }
 
    /**
     * Tests for hashcode
     */
    @Test
    public void HandHashcodeTest() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);
        Hand handCopy = hand;
        int hashInt = hand.hashCode();
        assertEquals(hand.hashCode(),handCopy.hashCode());
        assertEquals(hashInt,hand.hashCode());
    }
 
    /**
     * Test for size
     */
    @Test
    public void HandSizeTest() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);
        assertEquals(5,hand.getSize());
    }
 
    /**
     * Test for equals and encoding
     */
    @Test
    public void HandEqualsEncodingTest() {
        Long encoding=84947073L; // A-5, Hearts
        Hand hand = new Hand(encoding);
        hand.sort();
        Card card = new Card(Rank.DEUCE,Suit.HEARTS);
        assertTrue(card.equals(hand.getCard(0))); 
    }
 
    /**
     * Test for Iterator
     */
    @Test
    public void HandIteratorTest() {
        Deck deck = new Deck();
        Hand hand = new Hand(deck);
        Card card = new Card(Rank.FOUR, Suit.HEARTS);
        Iterator<Card> iter = hand.iterator();
        iter.next();
        iter.next();
        iter.next();
        assertEquals(card.toString(),iter.next().toString());
    }
    
    
}
