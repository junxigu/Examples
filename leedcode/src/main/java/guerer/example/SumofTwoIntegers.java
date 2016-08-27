package guerer.example;

/*
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

 Example:
 Given a = 1 and b = 2, return 3. 

 */
public class SumofTwoIntegers {

	public static int getSum(int a, int b) {
		while ((a & b) != 0) {
			int temp = a ^ b;
			b = (a & b) << 1;
			a = temp;
		}
		return a ^ b;
	}

}
