package com.mapper;

import java.util.List;

import com.domain.ServiceMerchantToken;

public interface ServiceMerchantTokenMppr {

	public List<ServiceMerchantToken> getServiceMerchantToken();
	
	public int insertServiceMerchantToken(ServiceMerchantToken token);
	
	public int deleteServiceMerchantToken(long id);
	
	public int updateServiceMerchantToken(ServiceMerchantToken token);
	
}
