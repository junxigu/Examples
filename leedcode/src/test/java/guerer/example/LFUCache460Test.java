package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class LFUCache460Test {

	@Test
	public void test() {
		LFUCache460 cache = new LFUCache460(2);

		cache.put(1, 1);
		cache.put(2, 2);
		assertEquals(1, cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		assertEquals(-1, cache.get(2)); // returns -1
		assertEquals(3, cache.get(3)); // returns 3
		cache.put(4, 4); // evicts key 1.
		assertEquals(-1, cache.get(1)); // returns -1
		assertEquals(3, cache.get(3)); // returns 3
		assertEquals(4, cache.get(4)); // returns 4
	}
	
	@Test
	public void test2() {
		LFUCache460 cache = new LFUCache460(0);
		
		cache.put(0, 0);
		assertEquals(-1, cache.get(0)); // returns 1
	}

}
