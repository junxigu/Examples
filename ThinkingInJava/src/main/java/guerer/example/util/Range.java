package guerer.example.util;

import java.util.Arrays;

public class Range {

	public static int[] range(int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = i;
		}
		return result;
	}

	public static int[] range(int start, int end) {
		int length = end - start;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = start + i;
		}
		return result;
	}

	public static int[] range(int start, int end, int step) {
		int length = (end - start - 1) / step;
		length = length > 0 ? length + 1 : 1;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = start + i * step;
		}
		return result;
	}

	public static void main(String[] args) {
		Print.print(Arrays.toString(range(3)));
		Print.print(Arrays.toString(range(3, 7)));
		Print.print(Arrays.toString(range(3, 10, 4)));
	}
}
