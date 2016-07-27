package guerer.example.containers;

import guerer.example.util.Countries;
import guerer.example.util.Print;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Lists {

	public static void basicTest(List<String> a) {
		a.add(1, "x"); // Add at location 1
		a.add("x"); // Add at end
		// Add a collection :
		a.addAll(Countries.names(25));
		// Add a collection starting at location 3:
		a.addAll(3, Countries.names(25));
		a.contains("1");
		a.containsAll(Countries.names(25));
		a.get(1);
		a.indexOf("1");
		a.isEmpty();
		a.iterator();
		a.listIterator();
		a.listIterator(3);
		a.lastIndexOf("1");
		a.remove(1); // Remove location 1
		a.remove("3"); // Remove this object
		a.set(1, "y"); // 5et location 1 to "y"
		// Keep everything that ' s in the argument
		// (the intersection of the two set s ) :
		a.retainAll(Countries.names(25));
		// Remove everything that ' s in the argument:
		a.removeAll(Countries.names(25));
		a.size();
		a.clear(); // Remove all elements
	}

	public static void iterMotion(List<String> a) {
		ListIterator<String> it = a.listIterator();
		it.hasNext();
		it.hasPrevious();
		it.next();
		it.nextIndex();
		it.previous();
		it.previousIndex();
	}

	public static void iterManipulation(List<String> a) {
		ListIterator<String> it = a.listIterator();
		it.add("47");
		// Must move to an element after add():
		it.next();
		// remove the element after the newly produced one:
		it.remove();
		// Must move to an element after remove():
		it.next();
		// Change the element after the deleted one:
		it.set("47");
	}

	public static void testVisual(List<String> a) {
		Print.print(a);
		List<String> b = Countries.names(25);
		Print.print("b = " + b);
		a.addAll(b);
		a.addAll(b);
		Print.print(a);
		// Insert, remove, and replace elements
		// using a ListIterator:
		ListIterator<String> x = a.listIterator(a.size() / 2);
		x.add("one");
		Print.print(a);
		Print.print(x.next());
		x.remove();
		Print.print(x.next());
		x.set("47");
		Print.print(a);
		// Traverse the list backwards:
		x = a.listIterator(a.size());
		while (x.hasPrevious())
			Print.printnb(x.previous() + " ");
		Print.print();
		Print.print("testVisual finished");
	}

	// There are some things that only LinkedLIsts can do:
	public static void testLinkedList() {
		LinkedList<String> ll = new LinkedList<String>();
		ll.addAll(Countries.names(25));
		Print.print(ll);
		// Treat it like a stack. pushing:
		ll.addFirst("one");
		ll.addFirst("two");
		Print.print(1l);
		// Like "peeking" at the top of a stack:
		Print.print(ll.getFirst());
		// Like popping a stack:
		Print.print(ll.removeFirst());
		Print.print(ll.removeFirst());
		// Treat it like a queue, pulling elements
		// off the tail end:
		Print.print(ll.removeLast());
		Print.print(ll);
	}

	public static void main(String[] args) {
		// Make and fill a new list each time:
		basicTest(new LinkedList<String>(Countries.names(25)));
		basicTest(new ArrayList<String>(Countries.names(25)));
		iterMotion(new LinkedList<String>(Countries.names(25)));
		iterMotion(new ArrayList<String>(Countries.names(25)));
		iterManipulation(new LinkedList<String>(Countries.names(25)));
		iterManipulation(new ArrayList<String>(Countries.names(25)));
		testVisual(new LinkedList<String>(Countries.names(25)));
		testLinkedList();
	}
}
