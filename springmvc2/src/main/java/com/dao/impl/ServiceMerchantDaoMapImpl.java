package com.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.ServiceMerchantDao;
import com.domain.ServiceMerchant;

public class ServiceMerchantDaoMapImpl implements ServiceMerchantDao {

	private static Map<Long, ServiceMerchant> serviceMerchantMap = new HashMap<Long, ServiceMerchant>();
	private long serviceMerchantId = 1;

	public int insertMerchant(ServiceMerchant merchant) throws IOException {
		merchant.setId(serviceMerchantId);
		serviceMerchantMap.put(serviceMerchantId++, merchant);
		return 1;
	}

	public List<ServiceMerchant> getMerchants() throws IOException {
		return new ArrayList<ServiceMerchant>(serviceMerchantMap.values());
	}

	public int deleteMerchant(long id) throws IOException {
		if (serviceMerchantMap.containsKey(id)) {
			serviceMerchantMap.remove(id);
			return 1;
		}
		return 0;
	}

	public int updateMerchant(ServiceMerchant merchant) throws IOException {
		long id = merchant.getId();
		if(serviceMerchantMap.containsKey(id)){
			serviceMerchantMap.put(id, merchant);
			return 1;
		}
		return 0;
	}

	public List<Long> getIds() throws IOException {
		List<Long> ids = new ArrayList<Long>();
		for(ServiceMerchant merchant : serviceMerchantMap.values()){
			ids.add(merchant.getId());
		}
		return ids;
	}

}
