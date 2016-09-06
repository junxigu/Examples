package guerer.example;

/*
 * Given an integer array nums, find the sum of the elements between indices i and j (i ¡Ü j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {

	int[] sums;

	public RangeSumQueryImmutable(int[] nums) {
		sums = new int[nums.length];
		for (int i = 1; i < sums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}
	}

	public int sumRange(int i, int j) {
		if (i > j || i < 0 || j >= sums.length)
			return 0;
		return i == 0 ? sums[j] : (sums[j] - sums[i - 1]);
	}
}
