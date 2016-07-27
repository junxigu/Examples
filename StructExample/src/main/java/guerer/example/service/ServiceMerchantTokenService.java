package guerer.example.service;

import guerer.example.domain.ServiceMerchant;
import guerer.example.domain.ServiceMerchantToken;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import jxl.biff.CountryCode;

public class ServiceMerchantTokenService {

	public List<ServiceMerchantToken> fetch() throws IOException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		List<ServiceMerchantToken> tokens = new ArrayList<ServiceMerchantToken>();
		return tokens;
	}

	public int insert(ServiceMerchantToken merchantToken) throws IOException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		return 0;
	}

	public int delete(ServiceMerchantToken merchantToken) throws IOException {
		return 0;
	}

	public int update(ServiceMerchantToken merchantToken) throws IOException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		return 0;
	}

	public List<ServiceMerchant> fetchMerchants() throws IOException{
		return new ArrayList<ServiceMerchant>();
	}

	public List<CountryCode> fetchCountryCodes() {
		return new ArrayList<CountryCode>();
	}
	
}
