package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FirstBadVersionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFirstBadVersion() {
		assertEquals(new FirstBadVersion().firstBadVersion(3), 2);
		assertEquals(new FirstBadVersion().firstBadVersion(4), 3);
	}

}
