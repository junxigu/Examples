package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class SlidingWindowMaximum239Test {

	@Test
	public void testMaxSlidingWindow() {
		SlidingWindowMaximum239 swm = new SlidingWindowMaximum239();
		
		assertArrayEquals(new int[] { 1 }, swm.maxSlidingWindow(new int[] { 1 }, 1));
		assertArrayEquals(new int[] { 1, 2 }, swm.maxSlidingWindow(new int[] { 1, 2 }, 1));
		assertArrayEquals(new int[] { 1, -1 }, swm.maxSlidingWindow(new int[] { 1, -1 }, 1));
		assertArrayEquals(new int[] { 2, 3 }, swm.maxSlidingWindow(new int[] { 1, 2, 3 }, 2));
		assertArrayEquals(new int[] { 3, 3, 5, 5, 6, 7 }, swm.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
	}

}
