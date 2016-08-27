package guerer.example;

import java.util.HashMap;
import java.util.Map;

/*
 *  Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:

 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 Follow up:

 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once? only can count by map

 */
public class IntersectionofTwoArraysII {
	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();

		for (int i : nums1) {
			Integer tmp = map1.get(i);
			map1.put(i, tmp == null ? 1 : tmp + 1);
		}
		for (int i : nums2) {
			Integer tmp = map2.get(i);
			map2.put(i, tmp == null ? 1 : tmp + 1);
		}

		int[] result = new int[nums1.length];
		int k = 0;
		for (Integer i : map1.keySet()) {
			Integer tmp = map2.get(i);
			int count = Math.min(map1.get(i), tmp == null ? 0 : tmp);
			for (int j = 0; j < count; j++) {
				result[k++] = i;
			}
		}
		int[] r = new int[k];
		for(int i = 0; i < k; i++) {
			r[i] = result[i];
		}
		return r;
	}
}
