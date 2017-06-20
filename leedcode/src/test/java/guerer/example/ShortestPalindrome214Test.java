package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShortestPalindrome214Test {

	@Test
	public void testShortestPalindrome() {
		ShortestPalindrome214 sp = new ShortestPalindrome214();
		assertEquals("aaacecaaa", sp.shortestPalindrome("aacecaaa"));
		assertEquals("dcbabcd", sp.shortestPalindrome("abcd"));
		assertEquals("", sp.shortestPalindrome(""));
		assertEquals("a", sp.shortestPalindrome("a"));
	}

}
