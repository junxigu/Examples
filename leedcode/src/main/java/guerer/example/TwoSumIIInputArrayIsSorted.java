package guerer.example;

/*
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2 
 */

public class TwoSumIIInputArrayIsSorted {
	public int[] twoSum(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length - 1;

		while (target != numbers[i] + numbers[j]) {
			if (target < numbers[i] + numbers[j]) {
				j--;
			} else {
				i++;
			}
		}
		int[] results = new int[2];
		results[0] = i + 1;
		results[1] = j + 1;
		return results;
	}
}
