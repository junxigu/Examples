package guerer.example;

/*
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?

 */
public class PowerOfFour {
	public boolean isPowerOfFour(int num) {
		int tmp = Integer.MAX_VALUE - (Integer.MAX_VALUE >>> 1);
		while (tmp != 0 && tmp != num) {
			tmp >>>= 2;
		}
		return tmp == num && num != 0;
	}
}
