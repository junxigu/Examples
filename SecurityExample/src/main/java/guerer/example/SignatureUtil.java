package guerer.example;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;

import org.apache.commons.codec.binary.Base64;

public class SignatureUtil {

	private final static String CHARSET = "UTF-8";
	private final static String DIGEST_ALGORITHM = "SHA1";
	private final static String SIGNATURE_ALGORITHM = "SHA1withRSA";

	private PrivateKey key;

	public SignatureUtil(String jksAliayas, String jksPassword, String keystorePath)
			throws Exception {
		FileInputStream keystoreFIS = new FileInputStream(keystorePath);
		try {
			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
			keystore.load(keystoreFIS, jksPassword.toCharArray());
			key = (PrivateKey) keystore.getKey(jksAliayas,
					jksPassword.toCharArray());
		} finally{
			keystoreFIS.close();
		}
	}

	private String encodeRequestContent(String request)
			throws NoSuchAlgorithmException {
		return Base64.encodeBase64String(MessageDigest.getInstance(
				DIGEST_ALGORITHM).digest(request.getBytes()));
	}

	private String generateSignature(String signString)
			throws Exception {
		Signature signer = Signature.getInstance(SIGNATURE_ALGORITHM);
		signer.initSign(key);
		signer.update(signString.getBytes(CHARSET));
		return Base64.encodeBase64String(signer.sign());
	}

	public String getSignature(String request, String userId,
			String timeStamp) throws Exception {
		String signString = encodeRequestContent(request) + ":" + userId
				+ ":" + timeStamp;
		return generateSignature(signString);
	}

}