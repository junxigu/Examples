package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberofDigitOne233Test {

	@Test
	public void testCountDigitOne() {
		NumberofDigitOne233 ndo = new NumberofDigitOne233();
		assertEquals(0, ndo.countDigitOne(0));
		assertEquals(1, ndo.countDigitOne(1));
		assertEquals(1, ndo.countDigitOne(9));
		assertEquals(5, ndo.countDigitOne(13));
		assertEquals(11, ndo.countDigitOne(19));
		assertEquals(12, ndo.countDigitOne(23));
	}

}
