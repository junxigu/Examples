package com.daoFactory;

import com.dao.CountryCodeDao;
import com.dao.PromoRwrdDao;
import com.dao.ServiceMerchantDao;
import com.dao.ServiceMerchantTokenDao;

public interface DaoFactory {

	ServiceMerchantDao getServiceMerchantDao();
	
	ServiceMerchantTokenDao getServiceMerchantTokenDao();
	
	CountryCodeDao getCountryCodeDao();
	
	PromoRwrdDao getPromoRwrdDao();
}
