package guerer.example;

import java.util.Stack;

/*
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.

 */

public class MaximalRectangle85 {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;

		int max = 0;
		int[] h = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				h[j] = matrix[i][j] == '0' ? 0 : h[j] + 1;
			}
			max = Math.max(max, largestRectangleArea(h));
		}
		return max;
	}

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
