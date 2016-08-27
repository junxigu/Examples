package guerer.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExcelSheetColumnNumberTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTitleToNumber() {
		assertEquals(ExcelSheetColumnNumber.titleToNumber("A"), 1);
		assertEquals(ExcelSheetColumnNumber.titleToNumber("b"), 2);
		assertEquals(ExcelSheetColumnNumber.titleToNumber("c"), 3);
		assertEquals(ExcelSheetColumnNumber.titleToNumber("z"), 26);
		assertEquals(ExcelSheetColumnNumber.titleToNumber("Aa"), 27);
		assertEquals(ExcelSheetColumnNumber.titleToNumber("Ab"), 28);
	}

}
