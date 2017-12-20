package guerer.example;
/*
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:
Given n = 13,
Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 */

public class NumberofDigitOne233 {
	public int countDigitOne(int n) {
		int r = 0;
		for(long i = 1; i <= n; i *= 10) {
			long a = n / i, b = n % i;
			r+=(a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
		}
		return r;
	}

}
