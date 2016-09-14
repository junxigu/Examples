package guerer.example;

/*
 *  Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:

 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 */

public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		int xor = nums[0];
		for (int i = 1; i < nums.length; i++) {
			xor ^= nums[i];
		}
		int split = xor & (-xor);
		int xor1 = xor;
		int xor2 = xor;
		for (int i = 0; i < nums.length; i++) {
			if ((split & nums[i]) == 0) {
				xor1 ^= nums[i];
			} else {
				xor2 ^= nums[i];
			}
		}
		int[] result = new int[2];
		result[0] = xor1;
		result[1] = xor2;
		return result;
	}
}
