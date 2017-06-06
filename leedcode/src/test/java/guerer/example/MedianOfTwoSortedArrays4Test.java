package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class MedianOfTwoSortedArrays4Test {

	@Test
	public void testFindMedianSortedArrays() {
		MedianOfTwoSortedArrays4 mtsa = new MedianOfTwoSortedArrays4();
		assertEquals(2.0, mtsa.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }), 0.000001);
		assertEquals(2.5, mtsa.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }), 0.000001);
		assertEquals(1, mtsa.findMedianSortedArrays(new int[] {}, new int[] { 1 }), 0.000001);
		assertEquals(1, mtsa.findMedianSortedArrays(new int[] { 1 }, new int[] { 1 }), 0.000001);
		assertEquals(2, mtsa.findMedianSortedArrays(new int[] { 1, 2, 3 }, new int[] { 1, 2, 2 }), 0.000001);
	}

}
