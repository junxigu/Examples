package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstMissingPositive41Test {

	@Test
	public void testFirstMissingPositive() {
		FirstMissingPositive41 fmp = new FirstMissingPositive41();
		assertEquals(2, fmp.firstMissingPositive(new int[]{1, 1}));
		assertEquals(1, fmp.firstMissingPositive(new int[]{}));
		assertEquals(1, fmp.firstMissingPositive(new int[]{ -1 }));
		assertEquals(2, fmp.firstMissingPositive(new int[]{ -1, -1, 1, 3}));
		assertEquals(3, fmp.firstMissingPositive(new int[]{ -1, -1, 1, 2}));
		assertEquals(3, fmp.firstMissingPositive(new int[]{ -1, -1, 1, 1, 2}));
		assertEquals(1, fmp.firstMissingPositive(new int[]{ 2 }));
		assertEquals(3, fmp.firstMissingPositive(new int[]{ -1,4,2,1,9,10 }));
	}

}
