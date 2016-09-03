package guerer.example;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '(':
			case '[':
			case '{':
				stack.push(s.charAt(i));
				break;
			case ')':
				if (stack.empty() || stack.pop().charValue() != '(') {
					return false;
				}
				break;
			case ']':
				if (stack.empty() || stack.pop().charValue() != '[') {
					return false;
				}
				break;
			case '}':
				if (stack.empty() || stack.pop().charValue() != '{') {
					return false;
				}
				break;
			default:
				return false;
			}
		}
		return stack.empty();
	}
}
