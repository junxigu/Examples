package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MajorityElementTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(MajorityElement.part(new int[]{2, 3, 1}, 0, 2));
		System.out.println(MajorityElement.part(new int[]{2, 3, 3}, 0, 2));
		
		System.out.println(MajorityElement.majorityElement(new int[]{2, 3, 3}));
	}

}
