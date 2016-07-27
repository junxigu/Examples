package guerer.example;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SignatureUtilTest {

	private String getCurrentTime() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	}
	
	@Test
	public void testGetSignature() throws Exception {
		String xmlString = "<ucms>"
				+ "<ucCustomer correlationId=\"GIFTONBOARD123456\">"
				+ "<ucAddCardRequest cuid=\"8a6a8f674d302fa0014d30307c080007\" customerId=\"24675\">"
				+ "<card isDefault=\"false\" accountType=\"GIFT\" cardType=\"ESSO\" nickName=\"GiftCard123456\" "
				+ "cardNumber=\"7042XXXXXXXXXXX9352\">"
				+ "<securityCode securityCode=\"1234\" />"
				+ "</card>"
				+ "<billingAddress zip=\"a1a1a1\" country=\"CA\" state=\"QC\" city=\"Mantrio\" addressLine2=\"First Avenue\" "
				+ "addressLine1=\"6855 " + "Pacific Street\" />"
				+ "</ucAddCardRequest>" + "</ucCustomer>" + "</ucms>";
		String alias = "4c8bP9oNJc1572cu885t0XWKbTTjsXMJ";
		String password = "THgIXNNmlPb6TESs9tf2GQ==";
		URL filePath = this.getClass().getResource("/test.jks");
		File file = new File(filePath.toURI());
		DESedeEncryption deSede = new DESedeEncryption();
		SignatureUtil signatureUtil = new SignatureUtil(deSede.decrypt(alias),
				deSede.decrypt(password), file.toString());
		System.out.println(signatureUtil.getSignature(xmlString, "1", getCurrentTime()));
	}

}
