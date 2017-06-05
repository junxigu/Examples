package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class WildcardMatching44Test {

	@Test
	public void testIsMatch() {
		WildcardMatching44 wm = new WildcardMatching44();
		
		assertFalse(wm.isMatch("aa","a"));
		assertFalse(wm.isMatch("aaa","aa"));
		assertFalse(wm.isMatch("aab","c*a*b"));
		
		assertTrue(wm.isMatch("aa","aa"));
		assertTrue(wm.isMatch("aa","*"));
		assertTrue(wm.isMatch("aa","a*"));
		assertTrue(wm.isMatch("ab","?*"));
		assertTrue(wm.isMatch("","*"));
	}

}
