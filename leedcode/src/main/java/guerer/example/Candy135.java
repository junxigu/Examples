package guerer.example;

/*
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */
public class Candy135 {
	public int candy(int[] ratings) {
		if (ratings.length < 2)
			return ratings.length;
		int i = 1;
		int count = 1;
		int curr = 1;
		while (i < ratings.length) {
			if (ratings[i] > ratings[i - 1]) {
				curr++;
				count += curr;
				i++;
			} else if(ratings[i] < ratings[i - 1]){
				int j = i;
				while (j < ratings.length && ratings[j] < ratings[j - 1]) {
					j++;
				}
				int tmp = 1;
				for (int k = j - 1; k >= i; k--) {
					count += tmp;
					tmp++;
				}
				count += Math.max(curr, tmp) - curr;
				i = j;
				curr = 1;
			} else {
				count += 1;
				curr = 1;
				i++;
			}
		}
		return count;
	}
}
