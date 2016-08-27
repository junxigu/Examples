package guerer.example;

/*
 *  Given an integer, write a function to determine if it is a power of three.

 Follow up:
 Could you do it without using any loop / recursion? 
 */
public class PowerOfThree {
	public static boolean isPowerOfThree(int n) {
		return (n > 0 && 1162261467 % n == 0);
	}
	
	public static boolean isPowerOfThree2(int n) {
		return (n > 0 && (int)(Math.log10(n) / Math.log10(3)) - Math.log10(n) / Math.log10(3) == 0);
	}

	public static boolean isPowerOfThree1(int n) {
		while (n > 0 && n % 3 == 0) {
			n = n / 3;
		}
		return n == 1;
	}

}
