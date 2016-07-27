package guerer.example.service;

import guerer.example.domain.ServiceMerchant;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class ServiceMerchantService {

	public List<ServiceMerchant> fetch() throws IOException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		List<ServiceMerchant> tokens = new ArrayList<ServiceMerchant>();
		return tokens;
	}

	public int insert(ServiceMerchant merchant) throws IOException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		return 0;
	}

	public int delete(ServiceMerchant merchant) throws IOException {
		return 0;
	}

	public int update(ServiceMerchant merchant) throws IOException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		return 0;
	}

}