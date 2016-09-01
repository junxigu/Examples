package guerer.example;

/*
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
 */

public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int sum = 0;
		for(int i = n; i > 0; i = i / 5) {
			sum += i / 5;
		}
		return sum;
	}
}
