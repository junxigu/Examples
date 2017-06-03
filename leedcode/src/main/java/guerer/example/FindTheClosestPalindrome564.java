package guerer.example;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.

The 'closest' is defined as absolute difference minimized between two integers.

Example 1:
Input: "123"
Output: "121"
Note:
The input n is a positive integer represented by string, whose length will not exceed 18.
If there is a tie, return the smaller one as answer.
 */

public class FindTheClosestPalindrome564 {

	public String nearestPalindromic(String n) {
		String reverse = new StringBuilder(n).reverse().toString();
		String upperPalindrom = null;
		String downerPalindrom = null;
		// if n is not palindrome
		if (!n.equals(reverse)) {
			// copy right from left -> r
			int mid = (n.length() + 1) / 2;
			String palind = n.substring(0, mid) + reverse.substring(mid);
			// if r larger than n
			if (palind.compareTo(n) > 0) {
				// upper = r
				upperPalindrom = palind;
			}
			// else
			else {
				// downer = r
				downerPalindrom = palind;
			}
		}
		if (downerPalindrom == null) {
			downerPalindrom = findNextNearestDownerPalindrom(n);
		}
		if (upperPalindrom == null) {
			upperPalindrom = findNextNearestUpperPalindrom(n);
		}

		// downer != null ? upper + downer - 2 * n) > 0 ? downer : upper : upper
		if (downerPalindrom.length() == 0 || (Long.valueOf(upperPalindrom) - Long.valueOf(n) - Long.valueOf(n)
				+ Long.valueOf(downerPalindrom)) < 0)
			return upperPalindrom;
		else
			return downerPalindrom;
	}

	public String findNextNearestDownerPalindrom(String n) {
		if(n.equals("0")) return "";
		if(n.equals("1")) return "0";
		
		int mid = (n.length() + 1) / 2;
		char[] right = n.substring(mid).toCharArray();
		long leftVal = Long.valueOf(n.substring(0, mid)) - 1;
		char[] left = leftVal > 0 ? String.valueOf(leftVal).toCharArray() : new char[0];
		
		if(left.length < right.length) {
			right[0] = '9';
		}
		reverseCopy(left, right);
		
		return new String(left) + new String(right);
	}
	
	public void reverseCopy(char[] left, char[] right) {
		int len = Math.min(left.length, right.length);
		for(int i = right.length - 1; len > 0; i--, len--) {
			right[i] = left[right.length - 1 - i];
		}
	}
	
	public String findNextNearestUpperPalindrom(String n) {
		int mid = (n.length() + 1) / 2;
		long leftVal = Long.valueOf(n.substring(0, mid)) + 1;
		char[] left = String.valueOf(leftVal).toCharArray();
		char[] right = n.substring(mid).toCharArray();
		
		n = new String(left) + new String(right);
		mid = (n.length() + 1) / 2;
		left = n.substring(0, mid).toCharArray();
		right = n.substring(mid).toCharArray();
		reverseCopy(left, right);
		return new String(left) + new String(right);
	}

}
