package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class DivideTwoIntegers29Test {

	@Test
	public void testDivide() {
		DivideTwoIntegers29 dti = new DivideTwoIntegers29();
		assertEquals(0, dti.divide(0, 1));
		assertEquals(Integer.MAX_VALUE, dti.divide(1, 0));
		assertEquals(Integer.MAX_VALUE, dti.divide(Integer.MIN_VALUE, -1));
		assertEquals(Integer.MAX_VALUE / 2, dti.divide(Integer.MAX_VALUE, 2));
		assertEquals(2, dti.divide(4, 2));
		assertEquals(2, dti.divide(-4, -2));
		assertEquals(4, dti.divide(4, 1));
		assertEquals(1, dti.divide(3, 2));
		assertEquals(-1, dti.divide(-3, 2));
		assertEquals(-4, dti.divide(-4, 1));
		assertEquals(-2, dti.divide(-4, 2));
		assertEquals(1, dti.divide(2, 2));
		assertEquals(-1, dti.divide(2, -2));
		assertEquals(0, dti.divide(-1010369383, -2147483648));
	}

}
