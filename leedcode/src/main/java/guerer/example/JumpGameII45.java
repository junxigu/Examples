package guerer.example;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.


 */
public class JumpGameII45 {
	public int jump(int[] nums) {
		int maxReach = nums[0];
		int edge = 0;
		int minstep = 0;

		for (int i = 1; i < nums.length; i++) {
			if (i > edge) {
				minstep += 1;
				edge = maxReach;
				if (edge > nums.length - 1)
					return minstep;
			}
			maxReach = Math.max(maxReach, nums[i] + i);
		}
		return minstep;
	}
}
