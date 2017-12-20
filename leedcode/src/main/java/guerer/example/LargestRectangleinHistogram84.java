package guerer.example;

import java.util.Stack;

/*
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
 */

public class LargestRectangleinHistogram84 {
	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Stack<Integer> s = new Stack<Integer>();
		int i = 0;
		while (i < heights.length) {
			if (s.isEmpty() || heights[s.peek()] < heights[i]) {
				s.push(i++);
			} else {
				int tp = s.peek();
				s.pop();
				int tmp = heights[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
				maxArea = Math.max(maxArea, tmp);
			}
		}

		while (!s.isEmpty()) {
			int tp = s.peek();
			s.pop();
			int tmp = heights[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
			maxArea = Math.max(maxArea, tmp);
		}
		return maxArea;
	}
}
