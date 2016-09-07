package guerer.example;

/*
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB 
 */

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (n != 0) {
			n = n - 1;
			sb.append((char) ('A' + (n % 26)));
			n /= 26;
		}
		return sb.reverse().toString();
	}
}
