package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class FindMedianfromDataStream295Test {

	@Test
	public void test() {
		FindMedianfromDataStream295 fmfds = new FindMedianfromDataStream295();
		fmfds.addNum(1);
		fmfds.addNum(2);
		assertEquals(1.5, fmfds.findMedian(), 0.00001);
		fmfds.addNum(3);
		assertEquals(2, fmfds.findMedian(), 0.00001);
	}
	
	@Test
	public void test1() {
		FindMedianfromDataStream295 fmfds = new FindMedianfromDataStream295();
		assertEquals(0, fmfds.findMedian(), 0.00001);
		fmfds.addNum(1);
		assertEquals(1, fmfds.findMedian(), 0.00001);
		fmfds.addNum(2);
		assertEquals(1.5, fmfds.findMedian(), 0.00001);
		fmfds.addNum(3);
		assertEquals(2, fmfds.findMedian(), 0.00001);
		fmfds.addNum(4);
		assertEquals(2.5, fmfds.findMedian(), 0.00001);
	}

}
