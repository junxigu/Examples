package com.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESedeEncryption {

	private final String UNICODE_FORMAT = "UTF8";
	private final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	private final String ENCRYPTION_KEY = "exxon#PropsEnKey#23456781$";

	private Cipher cipher;
	private SecretKey key;

	public DESedeEncryption() throws Exception {
		cipher = Cipher.getInstance(DESEDE_ENCRYPTION_SCHEME);
		key = SecretKeyFactory.getInstance(DESEDE_ENCRYPTION_SCHEME)
				.generateSecret(
						new DESedeKeySpec(ENCRYPTION_KEY
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
		text = text == null ?  "" : text;
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return new BASE64Encoder().encode(cipher.doFinal(text
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
		text = text == null ?  "" : text;
		cipher.init(Cipher.DECRYPT_MODE, key);
		return bytes2String(cipher.doFinal(new BASE64Decoder()
				.decodeBuffer(text)));
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