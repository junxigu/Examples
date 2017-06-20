package guerer.example;

import java.util.Arrays;

public class ShortestPalindrome214 {
	public String shortestPalindrome1(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1, j = 0; i > j; i--) {
			if (s.charAt(i) != s.charAt(j)) {
				i += j;
				sb.append(s.charAt(i));
				j = 0;
			} else {
				j++;
			}
		}
		return sb.append(s).toString();
	}

	public String shortestPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse().insert(0, "#").insert(0, s);
		int[] r = coputePrefixForKMP(sb.toString());
		return new StringBuilder(s.substring(r[r.length - 1] + 1)).reverse().append(s).toString();
	}

	int[] coputePrefixForKMP(String p) {
		int[] r = new int[p.length()];
		if (r.length > 0) {
			int q = -1;
			r[0] = -1;
			for (int i = 1; i < p.length(); i++) {
				while (q >= 0 && p.charAt(i) != p.charAt(q + 1)) {
					q = r[q];
				}
				if (p.charAt(i) == p.charAt(q + 1)) {
					q++;
				}
				r[i] = q;
			}
		}
		return r;
	}
}
