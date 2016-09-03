package guerer.example;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WordPatternTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testWordPattern() {
		assertTrue(new WordPattern().wordPattern("abba", "dog cat cat dog"));
		assertFalse(new WordPattern().wordPattern("abba", "dog cat cat fish"));
		assertFalse(new WordPattern().wordPattern("aaaa", "dog cat cat dog"));
		assertFalse(new WordPattern().wordPattern("abba", "dog dog dog dog"));
	}

}
