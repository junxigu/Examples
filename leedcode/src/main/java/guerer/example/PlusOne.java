package guerer.example;

/*
 * Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
		int t = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i] = (digits[i] + t) % 10;
			t = digits[i] == 0 && t == 1 ? 1 : 0;
		}
		int[] result = new int[t == 1 ? digits.length + 1 : digits.length];
		for (int i = digits.length - 1, j = result.length - 1; i >= 0; i--, j--) {
			result[j] = digits[i];
		}
		result[0] = t == 1 ? 1 : result[0];
		return result;
	}
}
