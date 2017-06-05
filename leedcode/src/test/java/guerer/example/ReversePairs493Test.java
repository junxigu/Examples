package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReversePairs493Test {

	@Test
	public void testReversePairs() {
		ReversePairs493 rp = new ReversePairs493();
		
		assertEquals(2, rp.reversePairs(new int[]{1,3,2,3,1}));
		assertEquals(3, rp.reversePairs(new int[]{2,4,3,5,1}));
		assertEquals(0, rp.reversePairs(new int[]{2}));
		assertEquals(0, rp.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
		assertEquals(9, rp.reversePairs(new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647}));
	}

}
