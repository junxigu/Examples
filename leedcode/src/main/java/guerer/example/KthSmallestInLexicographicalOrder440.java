package guerer.example;

import java.util.Arrays;

public class KthSmallestInLexicographicalOrder440 {

	public int findKthNumberBack(int n, int k) {
		int[] nums = new int[10];
		Arrays.fill(nums, -1);
		nums[0] = 1;

		int end = 0;
		for (int i = n, limit = 9; i > limit; i -= limit, limit *= 10) {
			end++;
		}

		int num = 0;
		for (int i = 0, j = 0; j >= 0 && end >= 0 && i < k; i++) {
			nums[j]++;
			num++;
			if (i + 1 < k) { // if side effect would affect the main change of
								// while, need to add condition to make no
								// change for the last result
				if (j == end) {
					if (num == n) {
						end--;
					}
					if (j > 0 && (num == n || nums[j] == 9)) {
						do {
							nums[j] = -1;
							j--;
							num /= 10;
						} while (j > 0 && nums[j] == 9);
					}
				} else {
					j++;
					num = num * 10 - 1;
				}
			}
		}
		return num;
	}

	public int findKthNumber(int n, int k) {
		int curr = 1;
		k = k - 1;
		while (k > 0) {
			int steps = calSteps(n, curr, curr + 1);
			if (steps <= k) {
				curr += 1;
				k -= steps;
			} else {
				curr *= 10;
				k -= 1;
			}
		}
		return curr;
	}

	// use long in case of overflow
	public int calSteps(int n, long n1, long n2) {
		int steps = 0;
		while (n1 <= n) {
			steps += Math.min(n + 1, n2) - n1;
			n1 *= 10;
			n2 *= 10;
		}
		return steps;
	}
}
