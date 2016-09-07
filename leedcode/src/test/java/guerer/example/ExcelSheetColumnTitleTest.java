package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExcelSheetColumnTitleTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToTitle() {
		assertEquals(new ExcelSheetColumnTitle().convertToTitle(1), "A");
		assertEquals(new ExcelSheetColumnTitle().convertToTitle(2), "B");
		assertEquals(new ExcelSheetColumnTitle().convertToTitle(3), "C");
		assertEquals(new ExcelSheetColumnTitle().convertToTitle(26), "Z");
		assertEquals(new ExcelSheetColumnTitle().convertToTitle(27), "AA");
		assertEquals(new ExcelSheetColumnTitle().convertToTitle(28), "AB");
		assertEquals(new ExcelSheetColumnTitle().convertToTitle(53), "BA");
	}

}
