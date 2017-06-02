package guerer.example;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class MaxPointsOnALine149Test {

	@Ignore
	@Test
	public void testMaxPoints() {
		MaxPointsOnALine149 moal = new MaxPointsOnALine149();
		assertEquals(moal.maxPoints(new Point[] { new Point(0, 1), new Point(1, 1) }), 2);
		assertEquals(moal.maxPoints(new Point[] { new Point(0, 1), new Point(1, 1), new Point(2, 1) }), 3);
		assertEquals(moal.maxPoints(new Point[] { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) }), 3);
		assertEquals(moal.maxPoints2(new Point[] { new Point(2, 3), new Point(3, 3), new Point(-5, 3)}), 3);
		assertEquals(moal.maxPoints2(new Point[] { new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151)}), 2);
	}
	@Ignore
	@Test
	public void testMaxPoints2() {
		MaxPointsOnALine149 moal = new MaxPointsOnALine149();
		assertEquals(moal.maxPoints2(new Point[] { new Point(0, 1), new Point(1, 1) }), 2);
		assertEquals(moal.maxPoints2(new Point[] { new Point(0, 1), new Point(1, 1), new Point(2, 1) }), 3);
		assertEquals(moal.maxPoints2(new Point[] { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) }), 3);
		assertEquals(moal.maxPoints2(new Point[] { new Point(2, 3), new Point(3, 3), new Point(-5, 3)}), 3);
		assertEquals(moal.maxPoints2(new Point[] { new Point(0, 0), new Point(94911151, 94911150), new Point(94911152, 94911151)}), 2);
	}
	
	@Ignore
	@Test
	public void testGcds() {
		MaxPointsOnALine149 moal = new MaxPointsOnALine149();
		assertEquals(moal.gcd(6, 4), 2);
		assertEquals(moal.gcd(4, 1), 1);
		assertEquals(moal.gcd(3, 2), 1);
	}

}
