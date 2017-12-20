package guerer.example;

/*
 * Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".

On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.

You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.

Example:

Input:
s1="acb", n1=4
s2="ab", n2=2

Return:
2
 */

public class CountTheRepetitions466 {
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		int s1i = 0;
		int s2i = 0;
		Map<Integer, List<Integer>> match = new HashMap<Integer, List<Integer>>();
		int r = 0;
		int delCountS1 = 0, delCountS2 = 0;

		// find the start repetition of s2 in s1, n1
		while (s1i < s1.length() * n1) {
			int i = s1i % s1.length();
			int j = s2i % s2.length();
			if (s1.charAt(i) == s2.charAt(j)) {
				if (j == 0) {
					if (match.containsKey(i)) {
						r = s2i / s2.length();
						delCountS1 = (s1i - match.get(i).get(0)) / s1.length();
						delCountS2 = (s2i - match.get(i).get(1)) / s2.length();
						break;
					} else {
						List<Integer> l = new ArrayList<Integer>();
						l.add(s1i);
						l.add(s2i);
						match.put(i, l);
					}
				}
				s2i++;
			}
			s1i++;
		}
		if (s1i == s1.length() * n1) {
			return s2i / s2.length() / n2;
		}
		int rep = (s1.length() * n1 - s1i) / (s1.length() * delCountS1);
		r += rep * delCountS2;
		s1i += s1.length() * rep * delCountS1;
		s2i = 0;
		while (s1i < s1.length() * n1) {
			int i = s1i % s1.length();
			int j = s2i % s2.length();
			if (s1.charAt(i) == s2.charAt(j)) {
				if (j == s2.length() - 1) {
					r++;
				}
				s2i++;
			}
			s1i++;
		}
		return r / n2;
	}
}
