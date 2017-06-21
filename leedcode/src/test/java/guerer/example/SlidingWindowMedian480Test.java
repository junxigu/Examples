package guerer.example;

import java.util.Arrays;

import org.junit.Test;

public class SlidingWindowMedian480Test {

	@Test
	public void testMedianSlidingWindow() {
		SlidingWindowMedian480 swm = new SlidingWindowMedian480();
		System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[] { 1, 3 }, 3)));
		System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[] { 1, 3 }, 1)));
		System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[] { 1, 3, -1 }, 3)));
		System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[] { 1, 1, 1 }, 3)));
		System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[] { 2, 1, 3 }, 2)));
		System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[] { 2147483647,2147483647 }, 2)));
		System.out.println(Arrays.toString(swm.medianSlidingWindow(new int[] { 5,5,8,1,4,7,1,3,8,4 }, 8)));
	}

}
