package guerer.example;

/*
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → false


 */
public class RegularExpressionMatching10 {

	public boolean isMatch(String s, String p) {
		char[] pc = p.toCharArray();
		boolean[][] r = new boolean[s.length() + 1][p.length() + 1];
		r[0][0] = true;
		for (int i = 1; i < p.length(); i += 2) {
			if (pc[i] != '*')
				break;
			r[0][i + 1] = true;
		}

		char[] c = s.toCharArray();
		for (int i = 1; i < r.length; i++) {
			for (int j = 1; j < r[i].length; j++) {
				if (pc[j - 1] == '.' || pc[j - 1] == c[i - 1]) {
					r[i][j] = r[i - 1][j - 1];
				} else if (pc[j - 1] == '*') {
					if ((pc[j - 2] == '.' || pc[j - 2] == c[i - 1])) {
						r[i][j] = r[i][j - 2] || r[i][j - 1] || r[i - 1][j];
					} else if (pc[j - 2] != c[i - 1]) {
						r[i][j] = r[i][j - 2];
					}
				}
			}
		}
		return r[s.length()][p.length()];
	}
}
