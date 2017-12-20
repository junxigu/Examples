package guerer.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonnegativeIntegerswithoutConsecutiveOnes600Test {

	@Test
	public void testFindIntegers() {
		NonnegativeIntegerswithoutConsecutiveOnes600 nic = new NonnegativeIntegerswithoutConsecutiveOnes600();
		assertEquals(1, nic.findIntegers(0));
		assertEquals(2, nic.findIntegers(1));
		assertEquals(3, nic.findIntegers(2));
		assertEquals(3, nic.findIntegers(3));
		assertEquals(4, nic.findIntegers(4));
		assertEquals(5, nic.findIntegers(5));
	}

}
