package guerer.example;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if (nums1.length == 0 || nums2.length == 0) {
			int[] notEmptyNums = nums1.length == 0 ? nums2 : nums1;
			int mid = notEmptyNums.length / 2;
			return notEmptyNums.length % 2 == 1 ? notEmptyNums[mid] : (double)(notEmptyNums[mid] + notEmptyNums[mid - 1]) / 2;
		}
		int[] sourceArr = nums1;
		int[] targetArr = nums2;
		int targetBegin = 0;
		int sourceBegin = 0;
		int sourceNums1 = 0;
		int sourceNums2 = 0;
		int target = (nums1.length + nums2.length) / 2;

		while (true) {
			int r = bSearch(targetArr, targetBegin, targetArr.length - 1, sourceArr[sourceBegin]);
			if (target <= r - targetBegin) {
				break;
			} else {
				target -= (r - targetBegin + 1);
				if (targetArr == nums1) {
					sourceNums1 = r + 1;
					sourceBegin = sourceNums1;
					targetBegin = sourceNums2;
					targetArr = nums2;
					sourceArr = nums1;
				} else {
					sourceNums2 = r + 1;
					sourceBegin = sourceNums2;
					targetBegin = sourceNums1;
					targetArr = nums1;
					sourceArr = nums2;
				}
			}
			if (sourceBegin >= sourceArr.length) {
				break;
			}
		}
		if ((nums1.length + nums2.length) % 2 == 1) {
			return targetArr[targetBegin + target];
		} else {
			if (target == 0) {
				return (double) (targetArr[targetBegin + target] + sourceArr[sourceBegin - 1]) / 2;
			} else {
				return (double) (targetArr[targetBegin + target] + targetArr[targetBegin + target - 1]) / 2;
			}
		}
	}

	private int bSearch(int[] targetArr, int targetBegin, int targetEnd, int x) {
		while (targetBegin <= targetEnd) {
			if (targetArr[(targetBegin + targetEnd) / 2] <= x) {
				targetBegin = (targetBegin + targetEnd) / 2 + 1;
			} else {
				targetEnd = (targetBegin + targetEnd) / 2 - 1;
			}
		}
		return targetEnd;
	}
}
