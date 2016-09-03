package guerer.example;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Character> map1 = new HashMap<Character, Character>();
		Map<Character, Character> map2 = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			Character msc = map1.get(sc);
			Character mtc = map2.get(tc);
			if (msc == null && mtc == null) {
				map1.put(sc, tc);
				map2.put(tc, sc);
			} else if (msc != null && msc.charValue() != tc) {
				return false;
			} else if (mtc != null && mtc.charValue() != sc) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new IsomorphicStrings().isIsomorphic("egg", "egg"));
		System.out.println(new IsomorphicStrings().isIsomorphic("foo", "bar"));
		System.out.println(new IsomorphicStrings().isIsomorphic("paper",
			"title"));
		System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));
	}
}
