package guerer.example;

/*
 *  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);

 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". 
 */

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows < 2) {
			return s;
		}
		StringBuilder[] results = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			results[i] = new StringBuilder();
		}
		for (int i = 0, j = 0, d = 1; i < s.length(); i++) {
			results[j].append(s.charAt(i));
			d = j == numRows - 1 ? -1 : j == 0 ? 1 : d;
			j += d;
		}
		for (int i = 1; i < numRows; i++) {
			results[0].append(results[i].toString());
		}
		return results[0].toString();
	}
}
