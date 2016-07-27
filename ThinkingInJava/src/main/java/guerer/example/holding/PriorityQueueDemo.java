package guerer.example.holding;

import guerer.example.util.Print;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;

public class PriorityQueueDemo {

	public static void main(String[] args) {
		PriorityQueue<Integer> pqi = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++) {
			pqi.offer(rand.nextInt(i + 10));
		}
		QueueDemo.printQ(pqi);

		List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2,
				3, 9, 14, 18, 21, 23, 25);
		pqi = new PriorityQueue<Integer>(ints);
		QueueDemo.printQ(pqi);
		
		pqi = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
		pqi.addAll(ints);
		QueueDemo.printQ(pqi);
		
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(""));
		PriorityQueue<String> pqs = new PriorityQueue<String>(strings);
		QueueDemo.printQ(pqs);
		
		pqs = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
		pqs.addAll(strings);
		QueueDemo.printQ(pqs);
		
		Set<Character> charSet = new HashSet<Character>();
		for(char c : fact.toCharArray()){
			charSet.add(c);
		}
		PriorityQueue<Character> pqc = new PriorityQueue<Character>(charSet);
		QueueDemo.printQ(pqc);
	}

}
