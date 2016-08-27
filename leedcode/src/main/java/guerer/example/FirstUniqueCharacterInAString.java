package guerer.example;

/*
 *  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

 Examples:

 s = "leetcode"
 return 0.

 s = "loveleetcode",
 return 2.

 Note: You may assume the string contain only lowercase letters. 
 */
public class FirstUniqueCharacterInAString {
	public static int firstUniqChar(String s) {
		s = s.toLowerCase();
		int[] count = getCount(s);
		for(char c : s.toCharArray()) {
			if(count[c - 'a'] == 1) {
				return s.indexOf(c);
			}
		}
		return -1;
	}
	
	static int[] getCount(String str) {
		int[] count = new int[26];
		for (char c : str.toCharArray()) {
			count[c - 'a']++;
		}
		return count;
	}
}
