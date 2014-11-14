package test;

/* PayoutTableTest.java */

import java.util.Map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import videoPoker.PayoutTable;
import videoPoker.Quality;

import java.util.Iterator;
/**
 * The test class PayoutTableTest.
 *
 * @author  William Price
 * @version Cs390i - Intermediate Programming Fall 2014 - v11Nov
 */
public class WillPayoutTableTest
{
    /**
     * Default constructor for test class PayoutTableTest
     */
    public WillPayoutTableTest()
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
 
    /**
     * Tests for default constructor, getPayout
     */
    @Test
    public void PayoutTableDefaultTest() {
       PayoutTable pt = new PayoutTable();
       try{
           int payout = pt.getPayout(Quality.FULLHOUSE);
           assertEquals(null,payout);
           payout = pt.getPayout(Quality.ROYALFLUSH);
           assertEquals(null,payout);
        } catch(NullPointerException npe) {}
    }
 
    /**
     * Test for PayoutTable copy, standard 8-5, put/getPayout
     */
    @Test
    public void PayoutTableCopyPutGetTest() {
        PayoutTable pt = new PayoutTable(PayoutTable.payoutTable85());
        int payout = pt.getPayout(Quality.FLUSH);
        assertEquals(5,payout);
        pt.putPayout(Quality.FLUSH,42);
        payout = pt.getPayout(Quality.FLUSH);
        assertEquals(42,payout);
    }   
 
    /**
     * Test for constructor from arrays
     */
    @Test
    public void PayoutTableRankSuitConstructorTest() {
        Quality[] quality = {Quality.TWOPAIR,
                             Quality.FULLHOUSE,
                             Quality.ROYALFLUSH};
        int[] payouts = {5,10,1};
        PayoutTable pt = new PayoutTable(quality,payouts);
        assertEquals(10,pt.getPayout(Quality.FULLHOUSE));
    }
 
    /**
     * Test for table returning map
     */
    @Test
    public void PayoutTableMapTest() {
        PayoutTable pt = new PayoutTable();
        Map<Quality,Integer> map = pt.table();
        assertTrue(map.isEmpty());
        pt = new PayoutTable(PayoutTable.payoutTable85());
        map = pt.table();
        assertTrue( !(map.isEmpty()) );
    }
}
