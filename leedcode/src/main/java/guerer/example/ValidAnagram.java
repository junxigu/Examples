package guerer.example;

/*
 * Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */

public class ValidAnagram {
	public static boolean isAnagram(String s, String t) {
		int[] count1 = getCount(s.toLowerCase());
		int[] count2 = getCount(t.toLowerCase());
		for (int i = 0; i < 26; i++) {
			if (count1[i] != count2[i]) {
				return false;
			}
		}
		return true;
	}
	
	static int[] getCount(String str) {
		int[] count = new int[26];
		for (char c : str.toCharArray()) {
			count[c - 'a']++;
		}
		return count;
	}
}
