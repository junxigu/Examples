package guerer.example;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
 */

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int n = 0;
		int tmp = x;
		while (tmp != 0) {
			tmp /= 10;
			n++;
		}
		int sum = 0;
		int len = n / 2;
		tmp = x;
		for (int i = 0; i < len; i++) {
			sum = sum * 10 + tmp % 10;
			tmp /= 10;
		}
		len = len + (n % 2 == 1 ? 1 : 0);
		tmp = x;
		for (int i = 0; i < len; i++) {
			tmp /= 10;
		}
		return tmp == sum;
	}

	public static void main(String[] args) {
		System.out.println(PalindromeNumber.isPalindrome(0));
		System.out.println(PalindromeNumber.isPalindrome(9));
		System.out.println(PalindromeNumber.isPalindrome(10));
		System.out.println(PalindromeNumber.isPalindrome(11));
		System.out.println(PalindromeNumber.isPalindrome(121));
		System.out.println(PalindromeNumber.isPalindrome(122));
		System.out.println(PalindromeNumber.isPalindrome(222));
		System.out.println(PalindromeNumber.isPalindrome(221));
	}
}
