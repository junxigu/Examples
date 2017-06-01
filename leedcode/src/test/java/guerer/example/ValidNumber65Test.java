package guerer.example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidNumber65Test {

	@Test
	public void testIsNumber() {
		ValidNumber65 v = new ValidNumber65();
		
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
	
	@Test
	public void testIsNumber2() {
		ValidNumber65 v = new ValidNumber65();
		
		assertTrue(v.isNumber2("0"));
		assertTrue(v.isNumber2(" 0.1 "));
		assertTrue(v.isNumber2("3."));
		assertTrue(v.isNumber2("2e10"));
		
		assertFalse(v.isNumber2("abc"));
		assertFalse(v.isNumber2("e9"));
		assertFalse(v.isNumber2("1 a"));
		assertFalse(v.isNumber2(" "));
	}

}
