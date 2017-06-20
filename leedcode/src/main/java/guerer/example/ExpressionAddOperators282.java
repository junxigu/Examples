package guerer.example;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */

public class ExpressionAddOperators282 {
	public List<String> addOperators(String num, int target) {
		List<String> r = new ArrayList<String>();
		if (num.length() != 0) {
			cal(num, num.length() - 1, target, new StringBuilder(), r, 1);
		}
		return r;
	}

	void cal(String num, int index, long target, StringBuilder path, List<String> r, long mul) {
		if (index < 0 && target == 0) {
			r.add(path.toString());
		}

		for (int i = index; i >= 0; i--) {
			String sub = num.substring(i, index + 1);
			if (i != index && num.substring(i, i + 1).equals("0")) {
				continue;
			}
			long n = Long.valueOf(sub) * mul;

			if (i == 0) {
				path.insert(0, sub);
				cal(num, -1, target - n, path, r, 1);
				path.delete(0, sub.length());
			} else {
				path.insert(0, sub).insert(0, "+");
				cal(num, i - 1, target - n, path, r, 1);

				path.delete(0, 1).insert(0, "-");
				cal(num, i - 1, n + target, path, r, 1);

				path.delete(0, 1).insert(0, "*");
				cal(num, i - 1, target, path, r, n);
				path.delete(0, sub.length() + 1);
			}
		}
	}
}
