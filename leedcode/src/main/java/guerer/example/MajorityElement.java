package guerer.example;

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than [n/2] times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */

public class MajorityElement {
	public static int majorityElement(int[] nums) {
		int count = 1;
		int current = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(current != nums[i]) {
				if(count == 0) {
					count += 1;
					current = nums[i];
				} else {
					count -= 1;
				}
			} else {
				count++;
			}
		}
		return current;
	}

	public static int majorityElement1(int[] nums) {
		int middle = nums.length / 2;
		int b = 0;
		int e = nums.length - 1;
		int p = part(nums, b, e);
		while (p != middle) {
			if (p < middle) {
				b = p + 1;
			} else {
				e = p - 1;
			}
			p = part(nums, b, e);
		}
		return nums[p];
	}

	static int part(int[] nums, int b, int e) {
		int i = b;
		int j = b + 1;
		while (j <= e) {
			if (nums[j] < nums[b]) {
				i++;

				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
			j++;
		}

		int tmp = nums[i];
		nums[i] = nums[b];
		nums[b] = tmp;
		return i;
	}
}
