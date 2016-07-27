package guerer.example.containers;

import guerer.example.util.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Utilities {

	static List<String> list = Arrays.asList("one Two three Four five six one"
			.split(" "));

	public static void main(String[] args) {
		Print.print(list);
		Print.print("'listl disjoint (Four)?: "
				+ Collections.disjoint(list, Collections.singletonList("Four")));
		Print.print("max: " + Collections.max(list));
		Print.print("min: " + Collections.min(list));
		Print.print("max w/ comparator: "
				+ Collections.max(list, String.CASE_INSENSITIVE_ORDER));
		Print.print("min w/ comparator: "
				+ Collections.min(list, String.CASE_INSENSITIVE_ORDER));
		List<String> sublist = Arrays.asList("Four five six".split(" "));
		Print.print("index0fSubList: "
				+ Collections.indexOfSubList(list, sublist));
		Print.print("lastIndex0fSubList: "
				+ Collections.lastIndexOfSubList(list, sublist));
		Collections.replaceAll(list, "one", "Yo");
		Print.print("rep1aceAll: " + list);
		Collections.reverse(list);
		Print.print("reverse: " + list);
		Collections.rotate(list, 3);
		Print.print("rotate: " + list);
		List<String> source = Arrays.asList("in the matrix".split(" "));
		Collections.copy(list, source);
		Print.print("copy: " + list);
		Collections.swap(list, 0, list.size() - 1);
		Print.print("swap: " + list);
		Collections.shuffle(list, new Random(47));
		Print.print("shuff1ed: " + list);
		Collections.fill(list, "pop");
		Print.print("fil1: " + list);
		Print.print("frequency of 'pop' : "
				+ Collections.frequency(list, "pop"));
		List<String> dups = Collections.nCopies(3, "snap");
		Print.print("dups: " + dups);
		Print.print("'list' disjoint 'dups'?: "
				+ Collections.disjoint(list, dups));
		// Getting an old-style Enumeration:
		Enumeration<String> e = Collections.enumeration(dups);
		Vector<String> v = new Vector<String>();
		while (e.hasMoreElements())
			v.addElement(e.nextElement());
		// Converting an old-style Vector
		// to a list via an Enumeration:
		ArrayList<String> arrayList = Collections.list(v.elements());
		Print.print("arrayList: " + arrayList);
	}

}
