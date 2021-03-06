package guerer.example;

import java.util.Arrays;

/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive41 {
	public int firstMissingPositive(int[] nums) {
		if(nums == null) return 1;
		
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			}
		}
		int i = 0;
		while (i < nums.length && nums[i] == i + 1) {
			i++;
		}
		return i + 1;
	}
}
