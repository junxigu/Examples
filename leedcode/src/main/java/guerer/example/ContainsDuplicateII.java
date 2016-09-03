package guerer.example;

import java.util.HashSet;
import java.util.Set;

/*
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k. 
 */

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (k <= 0) {
			return false;
		}
		Set<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < k + 1 && i < nums.length; i++) {
			if (!s.contains(nums[i])) {
				s.add(nums[i]);
			} else {
				return true;
			}
		}

		for (int i = k + 1; i < nums.length; i++) {
			s.remove(nums[i - k - 1]);
			if (s.contains(nums[i])) {
				return true;
			} else {
				s.add(nums[i]);
			}
		}
		return false;
	}
}
