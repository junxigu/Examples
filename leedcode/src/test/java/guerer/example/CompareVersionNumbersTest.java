package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompareVersionNumbersTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompareVersion() {
		assertEquals(new CompareVersionNumbers().compareVersion("0.1", "1.1"),
			-1);
		assertEquals(new CompareVersionNumbers().compareVersion("1.1", "1.2"),
			-1);
		assertEquals(
			new CompareVersionNumbers().compareVersion("1.2", "13.37"), -1);
		assertEquals(new CompareVersionNumbers().compareVersion("01", "1"), 0);
		assertEquals(new CompareVersionNumbers().compareVersion("1.0", "1"), 0);
		assertEquals(new CompareVersionNumbers().compareVersion("4.9", "4.5"),
			1);
	}

}
