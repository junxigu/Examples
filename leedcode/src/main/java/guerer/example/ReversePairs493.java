package guerer.example;

/*
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.
 */

public class ReversePairs493 {

	public int reversePairs(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;
		return merge(nums, 0, nums.length - 1);
	}

	private int merge(int[] nums, int b, int e) {
		if (b >= e)
			return 0;
		int mid = (b + e) / 2;
		int l = merge(nums, b, mid);
		int r = merge(nums, mid + 1, e);
		
		int count = 0;
		int[] copyL = new int[mid - b + 1];
		for (int i = b; i <= mid; i++) {
			copyL[i - b] = nums[i];
			count += e - binarySearch(nums[i], nums, mid + 1, e) + 1;
		}
		int i = 0, j = mid + 1, k = b;
		while (i < copyL.length && j <= e) {
			nums[k++] = copyL[i] < nums[j] ? nums[j++] : copyL[i++];
		}
		while (i < copyL.length) {
			nums[k++] = copyL[i++];
		}
		return count + l + r;
	}

	// find position i where that nums[i-1]*2 >= n, so from i to e that
	// nums[i..e]*2 < n
	private int binarySearch(int n, int[] nums, int b, int e) {
		int i = (b + e) / 2;
		while (b <= e) {
			if ((long)n > (long)nums[i] * 2) {
				e = i - 1;
			} else {
				b = i + 1;
			}
			i = (b + e) / 2;
		}
		return b;
	}
}
