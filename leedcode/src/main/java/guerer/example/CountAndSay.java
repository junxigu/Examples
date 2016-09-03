package guerer.example;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string. 
 */

public class CountAndSay {
	public String countAndSay(int n) {
		StringBuilder target = new StringBuilder();
		String ori = "1";
		for (int i = 0; i < n - 1; i++) {
			// clear buffer
			target.delete(0, target.length());
			int j = 0;
			while (j < ori.length()) {
				int k = j + 1;
				while (k < ori.length() && ori.charAt(j) == ori.charAt(k)) {
					k++;
				}
				target.append((k - j) + ori.substring(j, j + 1));
				j = k;
			}
			ori = target.toString();
		}
		return ori;
	}
}
