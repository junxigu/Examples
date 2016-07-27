package com.dao;

import java.io.IOException;
import java.util.List;

import com.domain.ServiceMerchantToken;

public interface ServiceMerchantTokenDao {

	public List<ServiceMerchantToken> getMerchantTokens() throws IOException;
	
	public int insertMerchantToken(ServiceMerchantToken merchant) throws IOException;
	
	public int deleteMerchantToken(long id) throws IOException;
	
	public int updateMerchantToken(ServiceMerchantToken merchant) throws IOException;
	
}
