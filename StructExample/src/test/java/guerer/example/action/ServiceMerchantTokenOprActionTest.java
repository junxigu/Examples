package guerer.example.action;

import static org.junit.Assert.assertEquals;
import guerer.example.domain.ServiceMerchantToken;
import guerer.example.service.ServiceMerchantTokenService;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class ServiceMerchantTokenOprActionTest {

	protected ServiceMerchantTokenOprAction action;
	protected ServiceMerchantToken merchantToken;

	private void initMerchantToken() {
		merchantToken = new ServiceMerchantToken(1, "test", "password",
				"partnerId", "systemId", "certificatePath", "token", new Date());
	}

	protected void initAction() throws Exception {
		action = new ServiceMerchantTokenOprAction();
		action.setMerchantToken(merchantToken);
		action.setService(new ServiceMerchantTokenService());
	}

	@Before
	public void setUp() throws Exception {
		initMerchantToken();
		initAction();
	}

	private List<ServiceMerchantToken> pollTestMerchantTokens(
			List<ServiceMerchantToken> merchantTokens) throws IOException {
		List<ServiceMerchantToken> result = new ArrayList<ServiceMerchantToken>();
		for (ServiceMerchantToken merchantToken : merchantTokens) {
			if (merchantToken.getCertificate().equals("certificatePath")) {
				result.add(merchantToken);
			}
		}
		return result;
	}

	@Test
	public void testFetch() throws IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		assertEquals(action.fetch(), "success");
	}
	
	@Test
	public void testGetServiceMerchantIds() throws IOException {
		assertEquals(action.fetchMerchants(), "success");
	}
	
	@Test
	public void testGetCountryCodeIds() throws IOException {
		assertEquals(action.fetchCountryCodes(), "success");
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
		assertEquals(action.update(), "error");
	}

}
