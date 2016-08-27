package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RomanToIntegerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRomanToInt() {
		assertEquals(RomanToInteger.romanToInt("III"), 3);
		assertEquals(RomanToInteger.romanToInt("VI"), 6);
		assertEquals(RomanToInteger.romanToInt("XIX"), 19);
		assertEquals(RomanToInteger.romanToInt("XX"), 20);
		assertEquals(RomanToInteger.romanToInt("XLV"), 45);
		assertEquals(RomanToInteger.romanToInt("MCMLXXX"), 1980);
	}

}
