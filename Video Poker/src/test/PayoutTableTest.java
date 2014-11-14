package test;

import static org.junit.Assert.*;

import java.util.EnumMap;

import org.junit.Test;

import videoPoker.PayoutTable;
import videoPoker.Quality;

/**
 * 
 * @author Benjamin Boudra
 * @version 1.0
 */
public class PayoutTableTest
{
	/**
	 * a Test of the payoutTable85 and the default constructor.
	 */
	@Test
	public void testPayoutTable85()
	{
		PayoutTable pt = new PayoutTable();
		pt.putPayout(Quality.BUPKIS, 0);
		pt.putPayout(Quality.LOWPAIR, 0);
		pt.putPayout(Quality.HIGHPAIR, 1);
		pt.putPayout(Quality.TWOPAIR, 2);
		pt.putPayout(Quality.THREEKIND, 3);
		pt.putPayout(Quality.STRAIGHT, 4);
		pt.putPayout(Quality.FLUSH, 5);
		pt.putPayout(Quality.FULLHOUSE, 8);
		pt.putPayout(Quality.FOURKIND, 25);
		pt.putPayout(Quality.STRAIGHTFLUSH, 50);
		pt.putPayout(Quality.ROYALFLUSH, 250);
		pt.putPayout(Quality.SPECIAL1, 25);
		pt.putPayout(Quality.SPECIAL2, 25);

		PayoutTable pt2 = PayoutTable.payoutTable85();
		assertTrue(pt.getPayout(Quality.BUPKIS) == pt2.getPayout(Quality.BUPKIS));
		assertTrue(pt.getPayout(Quality.LOWPAIR) == pt2.getPayout(Quality.LOWPAIR));
		assertTrue(pt.getPayout(Quality.HIGHPAIR) == pt2.getPayout(Quality.HIGHPAIR));
		assertTrue(pt.getPayout(Quality.TWOPAIR) == pt2.getPayout(Quality.TWOPAIR));
		assertTrue(pt.getPayout(Quality.THREEKIND) == pt2.getPayout(Quality.THREEKIND));
		assertTrue(pt.getPayout(Quality.STRAIGHT) == pt2.getPayout(Quality.STRAIGHT));
		assertTrue(pt.getPayout(Quality.FLUSH) == pt2.getPayout(Quality.FLUSH));
		assertTrue(pt.getPayout(Quality.FULLHOUSE) == pt2.getPayout(Quality.FULLHOUSE));
		assertTrue(pt.getPayout(Quality.FOURKIND) == pt2.getPayout(Quality.FOURKIND));
		assertTrue(pt.getPayout(Quality.STRAIGHTFLUSH) == pt2.getPayout(Quality.STRAIGHTFLUSH));
		assertTrue(pt.getPayout(Quality.ROYALFLUSH) == pt2.getPayout(Quality.ROYALFLUSH));
		assertTrue(pt.getPayout(Quality.SPECIAL1) == pt2.getPayout(Quality.SPECIAL1));
		assertTrue(pt.getPayout(Quality.SPECIAL2) == pt2.getPayout(Quality.SPECIAL2));
		
	}

	/**
	 * A test of the payoutTable quality and and integer array constructor.
	 */
	@Test
	public void testPayoutTableQualityArrayIntArray()
	{
		Quality[] qual = new Quality[3];
		qual[0] = Quality.BUPKIS;
		qual[1] = Quality.LOWPAIR;
		qual[2] = Quality.HIGHPAIR;
		int[] payDay = new int[3];
		payDay[0] = 2;
		payDay[1] = 5;
		payDay[2] = 20;

		PayoutTable pt = new PayoutTable();
		pt.putPayout(Quality.BUPKIS, 2);
		pt.putPayout(Quality.LOWPAIR, 5);
		pt.putPayout(Quality.HIGHPAIR, 20);

		PayoutTable pt2 = new PayoutTable(qual, payDay);
		assertTrue(pt.getPayout(Quality.BUPKIS) == pt2.getPayout(Quality.BUPKIS));
		assertTrue(pt.getPayout(Quality.LOWPAIR) ==pt2.getPayout(Quality.LOWPAIR));
		assertTrue(pt.getPayout(Quality.HIGHPAIR) == pt2.getPayout(Quality.HIGHPAIR));

	}

	/**
	 * test of the putPayout method to see if the payout gets entered into the
	 * payoutTable Correctly.
	 */
	@Test
	public void testPutPayout()
	{
		PayoutTable pt = new PayoutTable();
		pt.putPayout(Quality.THREEKIND, 5);
		assertEquals(5 , pt.getPayout(Quality.THREEKIND));
	}

	/**
	 * Test of the table class that creates a map out of the payouts using the
	 * qualities as the keys.
	 */
	@Test
	public void testTable()
	{
		EnumMap<Quality, Integer> map = new EnumMap<Quality, Integer>(
				Quality.class);
		map.put(Quality.BUPKIS, 0);
		map.put(Quality.LOWPAIR, 1);
		map.put(Quality.HIGHPAIR, 2);

		PayoutTable pt = new PayoutTable();
		pt.putPayout(Quality.BUPKIS, 0);
		pt.putPayout(Quality.LOWPAIR, 1);
		pt.putPayout(Quality.HIGHPAIR, 2);
		assertEquals(map, pt.table());
	}
}
