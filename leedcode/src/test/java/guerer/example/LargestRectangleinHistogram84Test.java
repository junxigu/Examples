package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class LargestRectangleinHistogram84Test {

	@Test
	public void testLargestRectangleArea() {
		LargestRectangleinHistogram84 lrh = new LargestRectangleinHistogram84();
		assertEquals(10, lrh.largestRectangleArea(new int[]{2,1,5,6,2,3}));
		assertEquals(2, lrh.largestRectangleArea(new int[]{2}));
	}

}
