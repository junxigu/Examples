package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelfCrossing335Test {

	@Test
	public void test() {
		SelfCrossing335 sc = new SelfCrossing335();
		assertTrue(sc.isSelfCrossing(new int[]{1,1,2,1,1}));
		assertTrue(sc.isSelfCrossing(new int[]{2, 1, 1, 2}));
		assertTrue(sc.isSelfCrossing(new int[]{1, 1, 1, 1}));
		assertTrue(sc.isSelfCrossing(new int[]{1,1,2,2,1,1}));
		assertFalse(sc.isSelfCrossing(new int[]{1, 2, 3, 4}));
		assertFalse(sc.isSelfCrossing(new int[]{1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1}));
	}

}
