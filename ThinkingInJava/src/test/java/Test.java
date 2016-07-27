import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

interface Test1 {
	void f1();
}

class Test2<T> {

}

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		System.out.println(list);
		ListIterator<Integer> it = list.listIterator();
		it.add(1);
		System.out.println(it.previous());
	}

}
