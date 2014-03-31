package simpletree.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import simpletree.model.MonthlyValue;

public class MonthlyValueTests {

	private MonthlyValue val1;
	private MonthlyValue val2;
	private MonthlyValue val3;
	
	@Before
	public void setUp() throws Exception {
		val1 = new MonthlyValue(0, 2013, 11, 1);
		val2 = new MonthlyValue(0, 2013, 8, 1);
		val3 = new MonthlyValue(0, 2013, 11, 1);
	}

	@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		assertTrue(val1.equals(val3));
	}

	@Test
	public void testMonthlyValue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMonth() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMonth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetYear() {
		assertTrue(val1.getYear() == 2013);
	}
	
	
	@Test
	public void testToString() {
		assertTrue(val1.toString().equals("NOVEMBER"));
		assertTrue(val2.toString().equals("AUGUST"));
	}

}
