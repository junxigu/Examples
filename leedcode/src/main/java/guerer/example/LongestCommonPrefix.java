package guerer.example;

/*
 * Write a function to find the longest common prefix string amongst an array of strings. 
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		int minLen = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			minLen = Math.min(minLen, strs[i].length());
		}
		if (minLen == Integer.MAX_VALUE) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		boolean eq = true;
		for (int i = 0; i < minLen && eq; i++) {
			for (int j = 0; j < strs.length - 1; j++) {
				if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
					eq = false;
					break;
				}
			}
			if (eq) {
				sb.append(strs[0].charAt(i));
			}
		}
		return sb.toString();
	}
}
