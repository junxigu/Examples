package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidateNumTest {

	@Test
	public void testIsNumber() {
		ValidateNum v = new ValidateNum();
		
		assertTrue(v.isNumber("1."));
		assertTrue(v.isNumber(".3"));
		assertTrue(v.isNumber("1e3"));
		assertTrue(v.isNumber("-1e3"));
		assertTrue(v.isNumber(" 1.0 "));
		
		assertFalse(v.isNumber("asdf"));
		assertFalse(v.isNumber("e9"));
		assertFalse(v.isNumber("."));
		assertFalse(v.isNumber("1 a"));
		assertFalse(v.isNumber("-e58 "));
	}

}
