package guerer.example.holding;

import guerer.example.util.Print;
import guerer.example.util.Range;

import java.util.PriorityQueue;
import java.util.Queue;


public class QueueTest {
	
	static class Test implements Comparable<Test> {
		double index = Math.random();

		public int compareTo(Test o) {
			return Double.compare(index, o.index);
		}
		
		@Override
		public String toString() {
			return "Test " + index;
		}
	}
	
	public static void main(String[] args) {
		Queue<Test> queue = new PriorityQueue<Test>();
		for(int i : Range.range(5)) {
			queue.offer(new Test());
		}
		while(queue.peek() != null) {
			Print.print(queue.poll());
		}
	}

}
