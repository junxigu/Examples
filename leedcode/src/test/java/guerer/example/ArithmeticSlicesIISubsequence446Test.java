package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticSlicesIISubsequence446Test {

	@Test
	public void testNumberOfArithmeticSlices() {
		ArithmeticSlicesIISubsequence446 ass = new ArithmeticSlicesIISubsequence446();
		assertEquals(5, ass.numberOfArithmeticSlices(new int[]{2, 2, 2, 2}));
	}

}
