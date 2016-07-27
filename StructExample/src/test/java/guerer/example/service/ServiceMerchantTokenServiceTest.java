package guerer.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import guerer.example.domain.ServiceMerchantToken;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ServiceMerchantTokenServiceTest {

	private ServiceMerchantTokenService service;
	private ServiceMerchantToken merchantToken;

	private void initMerchantToken() {
		merchantToken = new ServiceMerchantToken(1, "test", "password",
				"partnerId", "systemId", "certificatePath", "token", new Date());
	}

	private void initService() throws Exception {
		service = new ServiceMerchantTokenService();
	}


	@Before
	public void setUp() throws Exception {
		initMerchantToken();
		initService();
	}

	@Test
	public void testFetch() throws IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		ServiceMerchantToken temp1 = new ServiceMerchantToken(merchantToken);
		ServiceMerchantToken temp2 = new ServiceMerchantToken(merchantToken);
		temp2.setCountryCode(2);
		assertEquals(service.insert(temp1), 1);
		assertTrue(service.fetch().size() >= 0);
		assertEquals(service.insert(temp2), 1);
		assertTrue(service.fetch().size() >= 0);
		assertEquals(service.delete(temp1), 1);
		assertEquals(service.delete(temp2), 1);
	}

	@Test
	public void testInsert() throws IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
	}

	@Test
	public void testdelete() throws IOException {
	}

	@Test
	public void testUpdate() throws Exception {
	}

	@Test
	public void testGetMerchantIds() throws IOException {
		assertTrue(service.fetchMerchants().size() >= 0);
	}
	
}
