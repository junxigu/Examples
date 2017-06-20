package guerer.example;

import java.util.Arrays;

/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString97 {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length())
			return false;

		boolean[][] r = new boolean[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < s1.length(); i++) {
			r[i][s2.length()] = s1.substring(i).equals(s3.substring(s2.length() + i));
		}
		for (int i = 0; i < s2.length(); i++) {
			r[s1.length()][i] = s2.substring(i).equals(s3.substring(s1.length() + i));
		}
		r[s1.length()][s2.length()] = true;

		for (int i = s1.length() - 1; i >= 0; i--) {
			int k = i + s2.length() - 1;
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k))
					r[i][j] = false;
				else if (s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k))
					r[i][j] = r[i + 1][j] || r[i][j + 1];
				else if (s1.charAt(i) == s3.charAt(k))
					r[i][j] = r[i + 1][j];
				else
					r[i][j] = r[i][j + 1];
				k--;
			}
		}
		return r[0][0];
	}
}
