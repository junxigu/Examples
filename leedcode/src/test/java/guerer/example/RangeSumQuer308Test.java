package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeSumQuer308Test {

	@Test
	public void test() {
		RangeSumQuer308 rsq = new RangeSumQuer308(
				new int[][] { new int[] { 3, 0, 1, 4, 2 }, new int[] { 5, 6, 3, 2, 1 }, new int[] { 1, 2, 0, 1, 5 },
						new int[] { 4, 1, 0, 1, 7 }, new int[] { 1, 0, 3, 0, 5 }, });

		assertEquals(8, rsq.sumRegion(2, 1, 4, 3));
		rsq.update(3, 2, 2);
		assertEquals(10, rsq.sumRegion(2, 1, 4, 3));
	}

}
