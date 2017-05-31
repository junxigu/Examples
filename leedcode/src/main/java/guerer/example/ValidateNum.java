package guerer.example;

import java.util.HashMap;
import java.util.Map;

public class ValidateNum {

	Map<Integer, Map<String, Integer>> states = new HashMap<Integer, Map<String, Integer>>() {
		{
			put(1, new HashMap<String, Integer>() {
				{
					put("[0-9]", 2);
					put("[+-]", 3);
					put(".", 4);
				}
			});
			put(2, new HashMap<String, Integer>() {
				{
					put("[0-9]", 2);
					put("e", 6);
					put(".", 5);
				}
			});
			put(3, new HashMap<String, Integer>() {
				{
					put("[0-9]", 2);
					put(".", 4);
				}
			});
			put(4, new HashMap<String, Integer>() {
				{
					put("[0-9]", 7);
				}
			});
			put(5, new HashMap<String, Integer>() {
				{
					put("[0-9]", 7);
					put("e", 6);
				}
			});
			put(6, new HashMap<String, Integer>() {
				{
					put("[0-9]", 9);
					put("[+-]", 8);
				}
			});
			put(7, new HashMap<String, Integer>() {
				{
					put("[0-9]", 7);
					put("e", 6);
				}
			});
			put(8, new HashMap<String, Integer>() {
				{
					put("[0-9]", 9);
				}
			});
			put(9, new HashMap<String, Integer>() {
				{
					put("[0-9]", 9);
				}
			});
		}
	};

	public static void main(String[] args) {

	}

	public boolean isNumber(String s) {
		// trim s
		// for c in s to judge
		// is last state end?
		s = s.trim();
		Integer currState = 1;
		for (int i = 0; i < s.length(); i++) {
			// c in each case to change state, if wrong then return false
			char c = s.charAt(i);
			Map<String, Integer> state = states.get(currState);
			if (c <= '9' && c >= '0') {
				currState = state.get("[0-9]");
			} else if (c == '+' || c == '-') {
				currState = state.get("[+-]");
			} else if (c == '.') {
				currState = state.get(".");
			} else if (c == 'e') {
				currState = state.get("e");
			} else {
				return false;
			}
			if (currState == null) {
				return false;
			}
		}
		return currState == 2 || currState == 5 || currState == 7 || currState == 9;
	}

}
