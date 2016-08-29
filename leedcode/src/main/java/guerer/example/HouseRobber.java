package guerer.example;

/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		} else if (nums.length == 3) {
			return Math.max(nums[0] + nums[2], nums[1]);
		}
		int[] selectedRobs = new int[nums.length];
		selectedRobs[0] = nums[0];
		selectedRobs[1] = nums[1];
		selectedRobs[2] = Math.max(nums[0] + nums[2], nums[1]);
		for (int i = 3; i < nums.length; i++) {
			selectedRobs[i] = Math
					.max(selectedRobs[i - 2], selectedRobs[i - 3]) + nums[i];
		}
		return Math.max(selectedRobs[nums.length - 1],
			selectedRobs[nums.length - 2]);
	}

	public int rob1(int[] nums) {
		if (nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		} else {
			return Math.max(selectedRob(nums, nums.length - 1),
				selectedRob(nums, nums.length - 2));
		}
	}

	static int selectedRob(int[] nums, int n) {
		if (n == 0) {
			return nums[0];
		} else if (n == 1) {
			return nums[1];
		} else if (n == 2) {
			return nums[0] + nums[2];
		} else {
			return Math.max(selectedRob(nums, n - 2), selectedRob(nums, n - 3))
					+ nums[n];
		}
	}
}
