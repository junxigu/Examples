package guerer.example;

/*
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
public class RemoveKDigits402 {
	public String removeKdigits1(String num, int k) {
		if (k == num.length())
			return "0";
		if (k == 0)
			return num;

		StringBuilder sb = new StringBuilder(num);
		int count = 0, i = 0;
		while (count < k) {
			if (i == sb.length() - 1 || sb.charAt(i) > sb.charAt(i + 1)) {
				sb.deleteCharAt(i);
				count++;
				i -= i > 0 ? 1 : 0;
			} else {
				i++;
			}
		}
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

	public String removeKdigits(String num, int k) {
		if (k == num.length())
			return "0";
		if (k == 0)
			return num;

		int i = 0, j = 0;
		char[] ans = new char[num.length() - k];
		char[] ch = num.toCharArray();
		while (i < ch.length) {
			while (j > 0 && k > i - j && ans[j - 1] > ch[i]) {
				j--;
			}
			if (j < ans.length)
				ans[j++] = ch[i];
			i++;
		}

		StringBuilder r = new StringBuilder();
		r.append(ans);
		while (r.length() > 1 && r.charAt(0) == '0')
			r.deleteCharAt(0);
		return r.toString();
	}
}
