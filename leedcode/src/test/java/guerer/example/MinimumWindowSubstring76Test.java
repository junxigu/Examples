package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinimumWindowSubstring76Test {

	@Test
	public void testMinWindow() {
		MinimumWindowSubstring76 mws = new MinimumWindowSubstring76();
		assertEquals("BANC", mws.minWindow("ADOBECODEBANC", "ABC"));
		assertEquals("", mws.minWindow("ADOBEODEBAN", "ABC"));
		assertEquals("A", mws.minWindow("A", "A"));
		assertEquals("", mws.minWindow("A", "AB"));
		assertEquals("aa", mws.minWindow("aa", "aa"));
		assertEquals("", mws.minWindow("aa", "aaa"));
	}

}
