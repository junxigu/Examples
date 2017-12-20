package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScrambleString87Test {

	@Test
	public void testIsScramble() {
		ScrambleString87 ss = new ScrambleString87();
		assertFalse(ss.isScramble("", ""));
		assertFalse(ss.isScramble("a", "b"));
		assertFalse(ss.isScramble("ab", "b"));
		assertFalse(ss.isScramble("ab", "aa"));
		
		assertTrue(ss.isScramble("a", "a"));
		assertTrue(ss.isScramble("abc", "abc"));
		assertTrue(ss.isScramble("abcd", "acbd"));
		assertTrue(ss.isScramble("bacd", "abcd"));
		assertTrue(ss.isScramble("abcd", "adcb"));
	}

}
