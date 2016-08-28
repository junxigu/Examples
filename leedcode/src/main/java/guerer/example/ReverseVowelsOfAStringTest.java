package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseVowelsOfAStringTest {

	@Test
	public void testReverseVowels() {
		assertEquals(ReverseVowelsOfAString.reverseVowels("hello"), "holle");
		assertEquals(ReverseVowelsOfAString.reverseVowels("leetcode"), "leotcede");
	}

}
