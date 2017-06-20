package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class InterleavingString97Test {

	@Test
	public void testIsInterleave() {
		InterleavingString97 is = new InterleavingString97();
		assertTrue(is.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		assertTrue(is.isInterleave("aabcc", "", "aabcc"));
		assertTrue(is.isInterleave("", "", ""));
		assertFalse(is.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
		assertFalse(is.isInterleave("aabc", "dbbca", "aadbbbaccc"));
	}

}
