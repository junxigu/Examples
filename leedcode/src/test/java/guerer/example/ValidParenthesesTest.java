package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ValidParenthesesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIsValid() {
		assertTrue(new ValidParentheses().isValid("()"));
		assertTrue(new ValidParentheses().isValid("()[]{}"));
		assertFalse(new ValidParentheses().isValid("(]"));
		assertFalse(new ValidParentheses().isValid("([)]"));
		assertFalse(new ValidParentheses().isValid("("));
	}

}
