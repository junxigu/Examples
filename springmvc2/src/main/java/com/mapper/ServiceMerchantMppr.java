package com.mapper;

import java.util.List;

import com.domain.ServiceMerchant;

public interface ServiceMerchantMppr {

	public List<Long> getServiceMerchantIds();
	
	public List<ServiceMerchant> getServiceMerchant();

	public int insertServiceMerchant(ServiceMerchant merchant);

	public int deleteServiceMerchant(long id);

	public int updateServiceMerchant(ServiceMerchant merchant);

}