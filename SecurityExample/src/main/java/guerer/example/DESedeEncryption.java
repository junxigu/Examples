package guerer.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DESedeEncryption {

	private final static String UNICODE_FORMAT = "UTF8";
	private final static String DESEDE_ENCRYPTION_SCHEME = "DESede";
	private final static String ENCRYPTION_KEY = "exxon#PropsEnKey#23456781$";

	private Cipher cipher;
	private SecretKey key;

	public DESedeEncryption() throws Exception {
		this(ENCRYPTION_KEY);
	}

	public DESedeEncryption(String encryptionKey) throws Exception {
		cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
		key = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME)
				.generateSecret(
						new DESedeKeySpec(encryptionKey
								.getBytes(UNICODE_FORMAT)));
	}

	/**
	 * Method To Encrypt The String
	 * 
	 * @throws InvalidKeyException
	 * @throws UnsupportedEncodingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public String encrypt(String text) throws InvalidKeyException,
			UnsupportedEncodingException, IllegalBlockSizeException,
			BadPaddingException {
		text = text == null ? "" : text;
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return Base64.encodeBase64String(cipher.doFinal(text
				.getBytes(UNICODE_FORMAT)));
	}

	/**
	 * Method To Decrypt An Ecrypted String
	 * 
	 * @throws InvalidKeyException
	 * @throws IOException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public String decrypt(String text) throws InvalidKeyException, IOException,
			IllegalBlockSizeException, BadPaddingException {
		text = text == null ? "" : text;
		cipher.init(Cipher.DECRYPT_MODE, key);
		return bytes2String(cipher.doFinal(Base64.decodeBase64(text)));
	}

	/**
	 * Returns String From An Array Of Bytes
	 */
	private static String bytes2String(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}

}