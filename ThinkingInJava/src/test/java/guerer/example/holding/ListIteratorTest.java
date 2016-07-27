package guerer.example.holding;

import guerer.example.util.CollectionData;
import guerer.example.util.Generator;
import guerer.example.util.Print;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

	public static void main(String[] args) {
		List<Integer> list1 = CollectionData.list(new Generator<Integer>() {
			int count = 0;
			public Integer next() {
				return count++;
			}
			
		}, 5);
		
		List<Integer> list2 = new ArrayList<Integer>(list1);
		ListIterator<Integer> iterator = list1.listIterator();
		while(iterator.hasNext()) {
			iterator.next();
		}
		while(iterator.hasPrevious()) {
			list2.add(iterator.previous());
		}
		Print.print(list2);
	}

}
