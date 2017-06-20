package guerer.example;

public class DivideTwoIntegers29 {
	public int divide(int divisor, int dividend) {
		if (dividend == 0 || (divisor == Integer.MIN_VALUE && dividend == -1))
			return Integer.MAX_VALUE;
		if (dividend == Integer.MIN_VALUE) {
			return divisor == Integer.MIN_VALUE ? 1 : 0;
		}
		if (dividend == 1)
			return divisor;
		if (dividend == -1)
			return -divisor;

		int overflow = 0;
		if (divisor == Integer.MIN_VALUE) {
			overflow = 1;
			divisor += 1;
		}

		boolean pos = (divisor < 0 && dividend < 0) || (divisor > 0 && dividend > 0);
		divisor = Math.abs(divisor);
		dividend = Math.abs(dividend);
		int count = 0;
		while (divisor >= dividend) {
			int i = dividend;
			int j = 1;
			while ((0x40000000 & i) == 0 && (i << 1) <= divisor) {
				i <<= 1;
				j <<= 1;
			}
			count += j;
			divisor -= i;
		}
		count += (divisor + overflow) == dividend ? 1 : 0;
		return pos ? count : -count;
	}

}
