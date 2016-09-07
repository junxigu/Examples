package guerer.example;

/*
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321 
 */
public class ReverseInteger {
	public int reverse(int x) {
		if (x == Integer.MIN_VALUE) {
			return 0;
		}
		boolean neg = x < 0;
		int result = 0;
		x = Math.abs(x);
		while (x != 0) {
			if (result > Integer.MAX_VALUE / 10) {
				return 0;
			}
			result = result * 10 + (x % 10);
			x /= 10;
		}
		return neg ? -result : result;
	}
}
