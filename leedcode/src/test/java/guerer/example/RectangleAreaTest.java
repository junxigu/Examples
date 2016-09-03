package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RectangleAreaTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		assertFalse(new RectangleArea().isOverlap(-2, -2, 2, 2, 3, 3, 4, 4));
		// assertEquals(new RectangleArea().computeArea(-3, 0, 3, 4, 0, -1, 9,
		// 2),
		// 6);
		// assertEquals(new RectangleArea().computeArea(0, 0, 4, 4, 1, 1, 3, 3),
		// 4);
		// assertEquals(new RectangleArea().computeArea(0, 0, 4, 4, -1, -1, 3,
		// 3),
		// 9);
		assertEquals(new RectangleArea().computeArea(0, 0, 0, 0, -1, -1, 1, 1),
			4);
		assertEquals(new RectangleArea().computeArea(-2, -2, 2, 2, 3, 3, 4, 4),
			17);
	}

}
