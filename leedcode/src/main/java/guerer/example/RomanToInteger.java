package guerer.example;

/*
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */

public class RomanToInteger {
	public static int romanToInt(String s) {
		char[] chars = s.toCharArray();
		int result = 0;
		int i = 0;
		while(i < chars.length) {
			if(i < chars.length - 1) {
				int t1 = get(chars[i]); 
				int t2 = get(chars[i+1]); 
				if(t1 < t2) {
					result = result + t2 - t1;
					i = i + 2;
				} else {
					result += t1;
					i++;
				}
			} else {
				result += get(chars[i]);
				i++;
			}
		}
		return result;
	}

	static int get(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'X':
			return 10;
		case 'C':
			return 100;
		case 'M':
			return 1000;
		case 'V':
			return 5;
		case 'L':
			return 50;
		case 'D':
			return 500;
		}
		return 0;
	}
}
