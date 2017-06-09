package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddAndSearchWord211Test {

	@Test
	public void test() {
		AddAndSearchWord211 obj = new AddAndSearchWord211();
		obj.addWord("bad");
		obj.addWord("dad");
		obj.addWord("mad");
		assertFalse(obj.search("pad"));
		assertTrue(obj.search("bad"));
		assertTrue(obj.search(".ad"));
		assertTrue(obj.search("b.."));
	}

}
