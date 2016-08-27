package guerer.example;

/*
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28 

 */
public class ExcelSheetColumnNumber {
	public static int titleToNumber(String s) {
		char[] strs = s.toLowerCase().toCharArray();
		int sum = 0;
		for(int i = 0; i < strs.length; i++) {
			sum *= 26;
			sum += (strs[i] - 'a') + 1;
		}
		return sum;
	}
}
