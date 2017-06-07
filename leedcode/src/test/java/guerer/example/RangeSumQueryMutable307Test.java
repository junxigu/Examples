package guerer.example;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class RangeSumQueryMutable307Test {

//	@Ignore
	@Test
	public void test() {
		RangeSumQueryMutable307 rsqm = new RangeSumQueryMutable307(new int[] { 1, 3, 5 });

		assertEquals(9, rsqm.sumRange(0, 2));
		rsqm.update(1, 2);
		assertEquals(8, rsqm.sumRange(0, 2));
	}

	@Test
	public void test2() {
		RangeSumQueryMutable307 rsqm = new RangeSumQueryMutable307(
				new int[] { -28, -39, 53, 65, 11, -56, -65, -39, -43, 97 });

		assertEquals(-121, rsqm.sumRange(5, 6));
		rsqm.update(9, 27);
		assertEquals(118, rsqm.sumRange(2, 3));
		assertEquals(-104, rsqm.sumRange(6, 7));
		rsqm.update(1, -82);
		rsqm.update(3, -72);
		assertEquals(-221, rsqm.sumRange(3, 7));
		assertEquals(-293, rsqm.sumRange(1, 8));
		rsqm.update(5, 13);
		rsqm.update(4, -67);
	}

}
