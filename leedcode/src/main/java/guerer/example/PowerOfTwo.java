package guerer.example;

public class PowerOfTwo {
	public static boolean isPowerOfTwo(int n) {
		return n > 0
				&& ((Integer.MAX_VALUE - (Integer.MAX_VALUE >>> 1)) % n == 0);
	}
}
