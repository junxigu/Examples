package guerer.example;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2

 */
public class FindMedianfromDataStream295 {
	private Queue<Integer> maxQ = new PriorityQueue<Integer>();
	private Queue<Integer> minQ = new PriorityQueue<Integer>(1, Comparator.reverseOrder());

	/** initialize your data structure here. */
	public FindMedianfromDataStream295() {

	}

	public void addNum(int num) {
		if (maxQ.size() > minQ.size()) {
			if (num > maxQ.peek()) {
				minQ.add(maxQ.poll());
				maxQ.add(num);
			} else {
				minQ.add(num);
			}
		} else if (maxQ.size() < minQ.size()) {
			if (num < minQ.peek()) {
				maxQ.add(minQ.poll());
				minQ.add(num);
			} else {
				maxQ.add(num);
			}
		} else {
			if ((maxQ.size() == 0 && minQ.size() == 0) || num < minQ.peek()) {
				minQ.add(num);
			} else {
				maxQ.add(num);
			}
		}
	}

	public double findMedian() {
		if (minQ.size() == 0 && 0 == maxQ.size())
			return 0;
		if (maxQ.size() > minQ.size())
			return maxQ.peek();
		if (minQ.size() > maxQ.size())
			return minQ.peek();
		return ((double) (maxQ.peek() + minQ.peek())) / 2;
	}
}
