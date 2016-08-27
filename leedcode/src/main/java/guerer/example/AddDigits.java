package guerer.example;

/*
 *  Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime? 
 */

public class AddDigits {
	static public int addDigits(int num) {
		return num < 10 ? num : num % 9;
	}
	
	static public int addDigits2(int num) {
		while (num >= 10) {
			int tmp = 0;
			for (int i = num; i > 0; i /= 10) {
				tmp += i % 10;
			}
			num = tmp;
		}
		return num;
	}
}
