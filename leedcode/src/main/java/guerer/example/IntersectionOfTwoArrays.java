package guerer.example;

/*
 *  Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:

 Each element in the result must be unique.
 The result can be in any order.

 */
public class IntersectionOfTwoArrays {

	public static int[] intersection(int[] nums1, int[] nums2) {
		int[] tmp = new int[nums1.length];
		int k = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (!exist(nums1[i], tmp, k) && exist(nums1[i], nums2, nums2.length)) {
				tmp[k++] = nums1[i];
			}
		}
		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			result[i] = tmp[i];
		}
		return result;
	}

	static boolean exist(int n, int[] nums, int bound) {
		for (int i = 0; i < bound; i++) {
			if (n == nums[i])
				return true;
		}
		return false;
	}
}
