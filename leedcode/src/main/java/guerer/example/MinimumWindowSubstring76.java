package guerer.example;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 */
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		Map<Character, Integer> currMap = new HashMap<Character, Integer>();
		String r = "";

		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (!map.containsKey(c))
				map.put(c, 0);
			map.put(c, map.get(c) + 1);
		}

		int min = Integer.MAX_VALUE;
		for (int b = 0, e = 0, count = t.length(); e < s.length(); e++) {
			char c = s.charAt(e);
			if (map.containsKey(c)) {
				if (!currMap.containsKey(c))
					currMap.put(c, 0);
				currMap.put(c, currMap.get(c) + 1);
				if (currMap.get(c) <= map.get(c)) {
					count--;
					if (count == 0) {
						while (!map.containsKey(s.charAt(b)) || currMap.get(s.charAt(b)) > map.get(s.charAt(b))) {
							if (map.containsKey(s.charAt(b))) {
								currMap.put(s.charAt(b), currMap.get(s.charAt(b)) - 1);
							}
							b++;
						}
						if (min > e - b + 1) {
							min = e - b + 1;
							r = s.substring(b, e + 1);
						}
						currMap.put(s.charAt(b), currMap.get(s.charAt(b)) - 1);
						b++;
						count++;
					}
				}
			}
		}
		return r;
	}
}
