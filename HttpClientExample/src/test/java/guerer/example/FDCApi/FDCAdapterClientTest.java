package guerer.example.FDCApi;

import org.junit.Test;

public class FDCAdapterClientTest {

	@Test
	public void testLogin() throws Exception {
		FDCAdapterClient client = new FDCAdapterClient();
		client.login();
	}

}
