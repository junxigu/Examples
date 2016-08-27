package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstUniqueCharacterInAStringTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFirstUniqChar() {
		assertEquals(FirstUniqueCharacterInAString.firstUniqChar("leetcode"), 0);
		assertEquals(FirstUniqueCharacterInAString.firstUniqChar("loveleetcode"), 2);
		assertEquals(FirstUniqueCharacterInAString.firstUniqChar("cc"), -1);
	}

}
