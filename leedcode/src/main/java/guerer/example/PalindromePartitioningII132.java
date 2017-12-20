package guerer.example;

import java.util.LinkedHashSet;

public class PalindromePartitioningII132 {

	public int minCut(String s) {
		char[] c = s.toCharArray();
		int n = c.length;
		int[] cut = new int[n];
		boolean[][] pal = new boolean[n][n];

		for(int i = 0; i < pal.length; i++) {
			pal[i][i] = true;
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
//			for (int j = 0; j <= i; j++) {
//				if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
//					pal[j][i] = true;
//					min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
//				}
//			}
			if(c[0] == c[i] && (i < 2 || pal[1][i - 1])) {
				pal[0][i] = true;
				min = 0;
			} else {
				for (int j = 1; j <= i; j++) {
					if (c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
						pal[j][i] = true;
						min = Math.min(min, cut[j - 1] + 1);
					}
				}
			}
			cut[i] = min;
		}
		return cut[n - 1];
	}

	public int minCut1(String s) {
		int[][] r = new int[s.length()][s.length()];

		for (int k = 1; k <= s.length() - 1; k++) {
			for (int i = 0; i <= s.length() - 1 - k; i++) {
				int min = Integer.MAX_VALUE;
				if (s.charAt(i) == s.charAt(i + k) && ((k >= 2 && r[i + 1][i + k - 1] == 0) || (k == 1))) {
					min = 0;
				} else {
					for (int j = i; j < i + k; j++) {
						if (r[j + 1][i + k] == 0) {
							min = Math.min(r[i][j] + 1, min);
						}
					}
				}
				r[i][i + k] = min;
			}
		}
		return r[0][r.length - 1];
	}

	private boolean isPalindrome(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
