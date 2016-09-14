package guerer.example;

/*
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 Update (2015-02-10):
 The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.

 spoilers alert... click to show requirements for atoi.
 Requirements for atoi:

 The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

 The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

 If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

 If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

 */
public class StringToInteger {
	public int myAtoi(String str) {
		char[] cs = str.trim().toCharArray();
		if (cs.length == 0) {
			return 0;
		}
		boolean neg = cs[0] == '-';
		boolean negMax = false;
		int i = cs[0] == '-' || cs[0] == '+' ? 1 : 0;
		int sum = 0;
		while (i < cs.length && cs[i] <= '9' && cs[i] >= '0') {
			if (Integer.MAX_VALUE / 10 < sum
					|| (neg && Integer.MAX_VALUE - cs[i] + '0' < sum * 10 - 1)
					|| (!neg && Integer.MAX_VALUE - cs[i] + '0' < sum * 10)) {
				return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			negMax = neg && ((Integer.MAX_VALUE - cs[i] + '0') == (sum * 10 - 1));
			sum = sum * 10 - (negMax ? 1 : 0) + cs[i] - '0';
			i++;
		}
		return neg ? (negMax ? Integer.MIN_VALUE : -sum) : sum;
	}
}
