package guerer.example;

import java.util.Stack;

public class LongestValidParentheses32 {
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0;
		int left = -1;
		char[] sc = s.toCharArray();

		for (int i = 0; i < sc.length; i++) {
			if (sc[i] == '(') {
				stack.push(i);
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
					if (stack.isEmpty()) {
						max = Math.max(max, i - left);
					} else {
						max = Math.max(max, i - stack.peek());
					}
				} else {
					left = i;
				}
			}
		}
		return max;
	}
}
