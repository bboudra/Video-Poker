package test;

import static org.junit.Assert.*;

import org.junit.Test;





import java.util.Map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoPoker.Card;
import videoPoker.Deck;

import java.util.Iterator;
/**
 * The test class DeckTest.
 *
 * @author  William Price
 * @version Cs390i - Intermediate Programming Fall 2014 - v11Nov
 */
public class WillDeckTest
{
    /**
     * Default constructor for test class DeckTest
     */
    public WillDeckTest()
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
    
    // Tests for class Deck
 
    /**
     * Test for default constructor, and getCard
     */
    @Test
    public void defaultDeckTest() {
        Deck deck = new Deck();
        assertEquals("Ace of Hearts",deck.getCard(0).toString());
    }
 
    /**
     * Test for copy constructor, shuffle method, getCard
     */
    @Test
    public void deckShuffleTest() {
        Deck deck = new Deck();
        deck.shuffle(); 
        Deck newDeck = new Deck(deck);
        assertEquals(deck.getCard(0),newDeck.getCard(0));
        assertEquals(deck.getCard(7),newDeck.getCard(7));
        assertEquals(deck.getCard(13),newDeck.getCard(13));
        assertEquals(deck.getCard(21),newDeck.getCard(21));
        assertEquals(deck.getCard(32),newDeck.getCard(32));
        assertEquals(deck.getCard(41),newDeck.getCard(41));
        assertEquals(deck.getCard(51),newDeck.getCard(51));
    }    
    
    /**
     * Test for set card, get card
     */
    @Test
    public void deckSetCardTest() {
        Deck deck = new Deck();
        Card card = new Card();
        assertEquals("King of Spades",deck.getCard(51).toString());
        Card returnCard = deck.setCard(51,card);
        assertEquals("Queen of Hearts",deck.getCard(51).toString());
        assertEquals("King of Spades",deck.getCard(11).toString());
    }
    
    
    /**
     * Test for deal, size, showAll
     */
    @Test
    public void deckDealSizeTest() {
        Deck deck = new Deck();
        assertEquals(52,deck.size());
        deck.deal();
        deck.deal();
        deck.deal();
        assertEquals(49,deck.size());
        for(int i=0; i<45; i++) {
            deck.deal();    
        }
        assertEquals("Ten of Spades   Jack of Spades   " + 
                     "Queen of Spades   King of Spades   ",
                     deck.showAll());
    }
    
    /**
     *  Test for iterator
     */
    @Test
    public void deckIterator() {
        Deck deck = new Deck();
        Iterator<Card> iter = deck.iterator();
        assertEquals("Ace of Hearts",iter.next().toString());
        assertEquals("Deuce of Hearts",iter.next().toString());
        assertEquals("Trey of Hearts",iter.next().toString());
    }
}
