package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllOoneDataStructure432Test {

	@Test
	public void test1() {
		AllOoneDataStructure432 obj = new AllOoneDataStructure432();
		obj.inc("1");
		obj.dec("2");
		assertEquals("1", obj.getMaxKey());
		assertEquals("1", obj.getMinKey());
	}
	
	@Test
	public void test2() {
		AllOoneDataStructure432 obj = new AllOoneDataStructure432();
		obj.inc("1");
		obj.inc("2");
		obj.inc("2");
		assertEquals("2", obj.getMaxKey());
		assertEquals("1", obj.getMinKey());
	}
	
	@Test
	public void test3() {
		AllOoneDataStructure432 obj = new AllOoneDataStructure432();
		obj.inc("1");
		obj.inc("1");
		obj.inc("2");
		obj.inc("2");
		obj.dec("2");
		assertEquals("1", obj.getMaxKey());
		assertEquals("2", obj.getMinKey());
	}

}
