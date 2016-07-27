package guerer.example.generics;

import java.util.ArrayList;
import java.util.List;

public class UnboundedWildcardsl {
	static List list1;
	static List<?> list2;
	static List<? extends Object> list3;

	static void assignl(List list) {
		list1 = list;
		list2 = list;
		// list3 = list; // Warning: unchecked conversion
		// Found: List , Required: List<? extends Object>
	}

	static void assign2(List<?> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}

	static void assign3(List<? extends Object> list) {
		list1 = list;
		list2 = list;
		list3 = list;
	}

	public static void main(String[] args) {
		assignl(new ArrayList());
		assign2(new ArrayList());
		assign3(new ArrayList()); // Update after SE5

		assignl(new ArrayList<String>());
		assign2(new ArrayList<String>());
		assign3(new ArrayList<String>());
		// Both forms are acceptable as List<?>:
		List<?> wildList = new ArrayList();
		wildList = new ArrayList<String>();
		assignl(wildList);
		assign2(wildList);
		assign3(wildList);
	}
}