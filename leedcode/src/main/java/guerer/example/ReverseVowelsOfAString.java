package guerer.example;

/*
 * Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".

 */

public class ReverseVowelsOfAString {
	public static String reverseVowels(String s) {
		char[] chars = s.toCharArray();
		for (int b = 0, e = s.length() - 1; b < e;) {
			if (isVowel(chars[b]) && isVowel(chars[e])) {
				char t = chars[b];
				chars[b] = chars[e];
				chars[e] = t;
				b++;
				e--;
			} else if (isVowel(chars[b])) {
				e--;
			} else if (isVowel(chars[e])) {
				b++;
			} else {
				b++;
				e--;
			}
		}
		return String.valueOf(chars);
	}

	static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}

}
