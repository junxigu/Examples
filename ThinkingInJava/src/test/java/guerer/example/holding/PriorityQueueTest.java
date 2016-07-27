package guerer.example.holding;

import guerer.example.util.Print;
import guerer.example.util.Range;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		Random rand = new Random();
		for(int i : Range.range(5)) {
			queue.offer(rand.nextInt());
		}
		while(queue.peek() != null) {
			Print.print(queue.poll());
		}
	}
}
