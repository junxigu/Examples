package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReverseIntegerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReverse() {
		assertEquals(new ReverseInteger().reverse(123), 321);
		assertEquals(new ReverseInteger().reverse(-123), -321);
		assertEquals(new ReverseInteger().reverse(1534236469), 0);
	}

}
