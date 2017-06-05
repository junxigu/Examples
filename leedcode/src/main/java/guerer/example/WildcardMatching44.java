package guerer.example;

/*
 * Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 */

public class WildcardMatching44 {
	public boolean isMatch(String s, String p) {
		if (p.length() == 0)
			return s.length() == 0;

		boolean[] result = null;
		boolean[] pre = new boolean[p.length()];
		char[] sc = s.toCharArray();
		char[] pc = p.toCharArray();

		// init curr for empty char: sc[-1]
		pre[0] = pc[0] == '*';
		for (int i = 1; i < pc.length; i++) {
			pre[i] = pc[i] == '*' && pre[i - 1];
		}
		result = pre;
		for (int i = 0; i < sc.length; i++) {
			result = new boolean[p.length()];
			if(i == 0) {
				result[0] = pc[0] == '*' || pc[0] == '?' || pc[0] == sc[i];
			} else {
				result[0] = pc[0] == '*';
			}
			for (int j = 1; j < pc.length; j++) {
				if (pc[j] == '*') {
					result[j] = pre[j] || result[j - 1];
				} else if (pc[j] == '?' || pc[j] == sc[i]) {
					result[j] = pre[j - 1];
				} else {
					result[j] = false;
				}
			}
			pre = result;
		}
		return result[p.length() - 1];
	}
}
