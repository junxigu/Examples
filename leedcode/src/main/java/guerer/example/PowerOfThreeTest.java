package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PowerOfThreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsPowerOfThree() {
		assertTrue(PowerOfThree.isPowerOfThree(27));
	}

}
