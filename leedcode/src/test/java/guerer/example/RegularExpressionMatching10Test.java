package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegularExpressionMatching10Test {

	@Test
	public void testIsMatch() {
		RegularExpressionMatching10 rem = new RegularExpressionMatching10();
		assertTrue(rem.isMatch("aa","aa"));
		assertTrue(rem.isMatch("aa","a*"));
		assertTrue(rem.isMatch("aa",".*"));
		assertTrue(rem.isMatch("ab",".*"));
		assertTrue(rem.isMatch("baabbbaccbccacacc","c*..b*a*a.*a..*c"));
		
		assertFalse(rem.isMatch("aa","a"));
		assertFalse(rem.isMatch("aaa","aa"));
		assertTrue(rem.isMatch("aab","c*a*b"));
	}

}
