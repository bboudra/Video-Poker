package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ CardTest.class, DeckTest.class, HandTest.class, PayoutTableTest.class,
		WillCardTest.class, WillDeckTest.class, WillHandTest.class,
		WillPayoutTableTest.class })
public class AllTests
{

}
