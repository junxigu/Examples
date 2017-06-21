package guerer.example;
/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 */

import java.util.Collections;
import java.util.TreeMap;

public class SlidingWindowMedian480 {
	public double[] medianSlidingWindow(int[] nums, int k) {
		if (k < 1 || nums == null || nums.length < k)
			return new double[0];

		double[] r = new double[nums.length - k + 1];
		TreeMap<Integer, Integer> minH = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> maxH = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		int minHSize = 0;
		int maxHSize = 0;

		for (int i = 0; i < k; i++) {
			if (minHSize == maxHSize) {
				if (minHSize > 0 && nums[i] > minH.firstKey()) {
					moveOver(minH, maxH);
					minH.put(nums[i], minH.getOrDefault(nums[i], 0) + 1);
				} else {
					maxH.put(nums[i], maxH.getOrDefault(nums[i], 0) + 1);
				}
				maxHSize++;
			} else if (minHSize < maxHSize) {
				if (nums[i] < maxH.firstKey()) {
					moveOver(maxH, minH);
					maxH.put(nums[i], maxH.getOrDefault(nums[i], 0) + 1);
				} else {
					minH.put(nums[i], minH.getOrDefault(nums[i], 0) + 1);
				}
				minHSize++;
			}
		}
		r[0] = (k & 1) == 0 ? ((double) minH.firstKey() + maxH.firstKey()) / 2 : maxH.firstKey();

		for (int i = k; i < nums.length; i++) {
			if (minH.containsKey(nums[i - k])) {
				minH.put(nums[i - k], minH.get(nums[i - k]) - 1);
				if (minH.get(nums[i - k]) == 0)
					minH.remove(nums[i - k]);
				minHSize--;
				if (nums[i] < maxH.firstKey()) {
					moveOver(maxH, minH);
					maxH.put(nums[i], maxH.getOrDefault(nums[i], 0) + 1);
				} else {
					minH.put(nums[i], minH.getOrDefault(nums[i], 0) + 1);
				}
				minHSize++;
			} else {
				maxH.put(nums[i - k], maxH.get(nums[i - k]) - 1);
				if (maxH.get(nums[i - k]) == 0)
					maxH.remove(nums[i - k]);
				if (minHSize > 0 && nums[i] > minH.firstKey()) {
					moveOver(minH, maxH);
					minH.put(nums[i], minH.getOrDefault(nums[i], 0) + 1);
				} else {
					maxH.put(nums[i], maxH.getOrDefault(nums[i], 0) + 1);
				}
			}
			r[i - k + 1] = (k & 1) == 0 ? ((double) minH.firstKey() + maxH.firstKey()) / 2 : maxH.firstKey();
		}
		return r;
	}

	void moveOver(TreeMap<Integer, Integer> s, TreeMap<Integer, Integer> t) {
		t.put(s.firstKey(), t.getOrDefault(s.firstKey(), 0) + 1);

		s.put(s.firstKey(), s.get(s.firstKey()) - 1);
		if (s.get(s.firstKey()) == 0)
			s.remove(s.firstKey());
	}

}
