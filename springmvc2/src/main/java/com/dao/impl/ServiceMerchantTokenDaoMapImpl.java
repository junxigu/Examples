package com.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.ServiceMerchantDao;
import com.dao.ServiceMerchantTokenDao;
import com.domain.ServiceMerchant;
import com.domain.ServiceMerchantToken;

public class ServiceMerchantTokenDaoMapImpl implements ServiceMerchantTokenDao {

	private static Map<Long, ServiceMerchantToken> serviceMerchantTokenMap = new HashMap<Long, ServiceMerchantToken>();
	private static long serviceMerchantTokenId = 1;

	public int deleteMerchantToken(long id) throws IOException {
		if (serviceMerchantTokenMap.containsKey(id)) {
			serviceMerchantTokenMap.remove(id);
			return 1;
		}
		return 0;
	}

	public int updateMerchantToken(ServiceMerchantToken merchantToken)
			throws IOException {
		long id = merchantToken.getId();
		if (serviceMerchantTokenMap.containsKey(id)) {
			serviceMerchantTokenMap.put(id, merchantToken);
			return 1;
		}
		return 0;
	}

	public List<ServiceMerchantToken> getMerchantTokens() throws IOException {
		List<ServiceMerchantToken> results = new ArrayList<ServiceMerchantToken>();
		for(ServiceMerchantToken token : serviceMerchantTokenMap.values()){
			results.add(new ServiceMerchantToken(token));
		}
		return results;
	}

	public int insertMerchantToken(ServiceMerchantToken merchant)
			throws IOException {
		merchant.setId(serviceMerchantTokenId);
		serviceMerchantTokenMap.put(serviceMerchantTokenId++, merchant);
		return 1;
	}

}
