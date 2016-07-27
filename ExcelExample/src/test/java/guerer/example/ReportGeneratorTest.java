package guerer.example;

import org.junit.Before;
import org.junit.Test;

public class ReportGeneratorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGenerateReport() {
		(new ReportGenerator()).generateReport();
	}

}
