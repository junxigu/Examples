package guerer.example;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class AddDigitsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddDigits() {
		assertEquals(AddDigits.addDigits(38), 2);
		assertEquals(AddDigits.addDigits(10), 1);
		assertEquals(AddDigits.addDigits(9), 9);
	}

}
