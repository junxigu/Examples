package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringToIntegerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMyAtoi() {
		assertEquals(new StringToInteger().myAtoi("   1234   "), 1234);
		assertEquals(new StringToInteger().myAtoi("   1234asdf  "), 1234);
		assertEquals(new StringToInteger().myAtoi("   -1234asdf  "), -1234);
		assertEquals(new StringToInteger().myAtoi("   +1234asdf  "), 1234);
		assertEquals(new StringToInteger().myAtoi("   2147483647aasdf  "),
			Integer.MAX_VALUE);
		assertEquals(new StringToInteger().myAtoi("   +2147483648  "), Integer.MAX_VALUE);
		assertEquals(new StringToInteger().myAtoi("   -2147483648  "),
			Integer.MIN_VALUE);
		assertEquals(new StringToInteger().myAtoi("   -2147483647  "),
			-2147483647);
		assertEquals(new StringToInteger().myAtoi("   -2147483649  "), Integer.MIN_VALUE);
	}

}
