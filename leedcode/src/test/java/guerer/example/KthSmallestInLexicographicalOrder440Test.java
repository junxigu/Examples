package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class KthSmallestInLexicographicalOrder440Test {

	@Test
	public void test() {
		KthSmallestInLexicographicalOrder440 k = new KthSmallestInLexicographicalOrder440();
		assertEquals(10, k.findKthNumber(13, 2));
		assertEquals(1, k.findKthNumber(1, 1));
		assertEquals(9, k.findKthNumber(100, 90));
	}

}
