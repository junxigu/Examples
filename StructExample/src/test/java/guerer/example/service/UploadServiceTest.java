package guerer.example.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class UploadServiceTest {

	protected UploadService service;

	@Before
	public void seTup() throws Exception {
		service = new UploadService();
	}

	@Test
	public void testParseAndUploadExcel() throws IOException,
			URISyntaxException {
		URL filePath = this.getClass().getResource("/testFile.csv");
		assertEquals(service.parseAndUploadExcel(new File(filePath.toURI()))
				.toString(), "0 1 0");
	}

}
