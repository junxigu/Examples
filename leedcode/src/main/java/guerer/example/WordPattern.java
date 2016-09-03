package guerer.example;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:

 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.

 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space. 

 */
public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		Map<Character, String> pm = new HashMap<Character, String>();
		Map<String, Character> sm = new HashMap<String, Character>();
		String[] strs = str.split(" ");
		if (strs.length != pattern.length()) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			String s = pm.get(pattern.charAt(i));
			Character c = sm.get(strs[i]);
			if (s == null && c == null) {
				sm.put(strs[i], pattern.charAt(i));
				pm.put(pattern.charAt(i), strs[i]);
			} else if (s != null && !s.equals(strs[i])) {
				return false;
			} else if (c != null && c.charValue() != pattern.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
