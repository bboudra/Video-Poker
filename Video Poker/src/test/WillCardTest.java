package test;

/* CardTest.java */
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoPoker.Card;
import videoPoker.Rank;
import videoPoker.Suit;

import java.util.Iterator;
/**
 * The test class CardTest.
 *
 * @author  William Price
 * @version Cs390i - Intermediate Programming Fall 2014 - v11Nov
 */
public class WillCardTest 
{
    /**
     * Default constructor for test class CardTest
     */
    public WillCardTest()
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
    
    // Tests of class Card
 
    /**
     * Tests default constructor
     */
    @Test
    public void cardDefaultConstructorTest() {
        Card card = new Card();
        assertEquals("Queen of Hearts",card.toString());
    }
 
    /**
     * Tests constructor with Rank and Suit
     */
    @Test
    public void cardMatchranksuitConstructorTest() {
        Card card = new Card(Rank.ACE,Suit.SPADES);
        assertEquals("Ace of Spades",card.toString());
    }
 
    /**
     * Tests duplicating constructor, and overriden equals
     */
    @Test
    public void cardCardcopyConstructorTest() {
        Card card = new Card(Rank.DEUCE,Suit.DIAMONDS);
        Card newCard = new Card(card);
        assertEquals("Deuce of Diamonds",newCard.toString());
        assertTrue(card.equals(newCard));
    }
 
    /**
     * Tests constructor with cardID, and retrieve Rank/Suit
     */
    @Test
    public void cardIDConstructorTest() {
        assertEquals(Rank.TEN,Card.retrieveRank(35));
        assertEquals(Suit.DIAMONDS,Card.retrieveSuit(35));
        Card card = new Card( Card.generateCardID(Rank.TEN,Suit.DIAMONDS) );
        assertEquals("Ten of Diamonds",card.toString());
        assertEquals(Suit.DIAMONDS,card.suit());
        assertEquals(Rank.TEN,card.rank());
        assertEquals(35,card.cardID());
   }
 
    /**
     * Tests hashCode
     */
    @Test
    public void cardHashCodeTest() {
        Card card = new Card();
        Card cardCopy = card;
        int hashInt = card.hashCode();
        assertEquals(card.hashCode(),cardCopy.hashCode());
        assertEquals(hashInt,card.hashCode());
    }
}
