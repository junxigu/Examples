package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class NimGameTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanWinNim() {
		assertTrue(new NimGame().canWinNim(3));
		assertTrue(new NimGame().canWinNim(2));
		assertTrue(new NimGame().canWinNim(1));
		assertFalse(new NimGame().canWinNim(4));
		assertTrue(new NimGame().canWinNim(5));
		assertTrue(new NimGame().canWinNim(6));
		assertTrue(new NimGame().canWinNim(7));
		assertFalse(new NimGame().canWinNim(8));
	}

}
