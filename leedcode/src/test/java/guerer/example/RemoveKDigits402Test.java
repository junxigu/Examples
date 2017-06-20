package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveKDigits402Test {

	@Test
	public void testRemoveKdigits() {
		RemoveKDigits402 rkd = new RemoveKDigits402();
		assertEquals("1219", rkd.removeKdigits("1432219", 3));
		assertEquals("200", rkd.removeKdigits("10200", 1));
		assertEquals("0", rkd.removeKdigits("10", 2));
		assertEquals("0", rkd.removeKdigits("10", 1));
		assertEquals("0", rkd.removeKdigits("1234567890", 9));
	}

}
