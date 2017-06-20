package guerer.example;

import java.util.Stack;

public class BasicCalculator224 {
	public int calculate(String s) {
		char[] sc = s.toCharArray();
		Stack<Integer> d = new Stack<Integer>();
		Stack<Character> opr = new Stack<Character>();
		int i = 0;
		while (i < sc.length) {
			if (sc[i] == '(' || sc[i] == '+' || sc[i] == '-') {
				opr.push(sc[i]);
			} else if (sc[i] == ')') {
				opr.pop();
				cal(d, opr);
			} else if (sc[i] <= '9' && '0' <= sc[i]) {
				int n = 0;
				while (i < sc.length && sc[i] <= '9' && '0' <= sc[i]) {
					n = n * 10 + sc[i] - '0';
					i++;
				}
				i--;
				d.push(n);
				cal(d, opr);
			}
			i++;
		}
		return d.pop();
	}

	void cal(Stack<Integer> d, Stack<Character> opr) {
		if (opr.isEmpty())
			return;
		char c = opr.peek();
		if (c == '+' || c == '-') {
			int d2 = d.pop();
			int d1 = d.pop();
			d.push(opr.pop() == '+' ? d1 + d2 : d1 - d2);
		}
	}

}
