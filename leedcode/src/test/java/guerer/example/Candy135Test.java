package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class Candy135Test {

	@Test
	public void testCandy() {
		Candy135 c = new Candy135();
		assertEquals(3, c.candy(new int[]{2, 1}));
		assertEquals(4, c.candy(new int[]{1, 2, 2}));
	}

}
