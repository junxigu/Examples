package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GuessNumberHigherOrLowerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertEquals(new GuessNumberHigherOrLower(6).guessNumber(10), 6);
		assertEquals(new GuessNumberHigherOrLower(6).guessNumber(8), 6);
		assertEquals(new GuessNumberHigherOrLower(6).guessNumber(7), 6);
		assertEquals(new GuessNumberHigherOrLower(6).guessNumber(6), 6);
		assertEquals(
			new GuessNumberHigherOrLower(1702766719).guessNumber(2126753390),
			1702766719);
	}

}
