package com.dao;

import java.io.IOException;
import java.util.List;

import com.domain.ServiceMerchant;

public interface ServiceMerchantDao {

	public List<Long> getIds() throws IOException;
	
	public List<ServiceMerchant> getMerchants() throws IOException;
	
	public int insertMerchant(ServiceMerchant merchant) throws IOException;
	
	public int deleteMerchant(long id) throws IOException;
	
	public int updateMerchant(ServiceMerchant merchant) throws IOException;
	
}
