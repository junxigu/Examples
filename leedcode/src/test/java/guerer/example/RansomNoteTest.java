package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RansomNoteTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstruct() {
		assertFalse(RansomNote.canConstruct("a", "b"));
		assertFalse(RansomNote.canConstruct("aa", "ab"));
		assertTrue(RansomNote.canConstruct("aa", "aab"));
	}

}
