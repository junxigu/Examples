package com.daoFactory.impl;

import java.io.IOException;

import com.dao.CountryCodeDao;
import com.dao.PromoRwrdDao;
import com.dao.ServiceMerchantDao;
import com.dao.ServiceMerchantTokenDao;
import com.dao.impl.CountryCodeDaoMapImpl;
import com.dao.impl.PromoRwrdDaoMapImpl;
import com.dao.impl.ServiceMerchantDaoMapImpl;
import com.dao.impl.ServiceMerchantTokenDaoMapImpl;
import com.daoFactory.DaoFactory;

public class MapDaoFactory implements DaoFactory{

	private static MapDaoFactory factory;
	
	public ServiceMerchantDao getServiceMerchantDao() {
		return new ServiceMerchantDaoMapImpl();
	}

	public ServiceMerchantTokenDao getServiceMerchantTokenDao() {
		return new ServiceMerchantTokenDaoMapImpl();
	}

	public static DaoFactory getFactory() throws IOException{
		if(factory == null){
			factory = new MapDaoFactory();
		}
		return factory;
	}

	public CountryCodeDao getCountryCodeDao() {
		return new CountryCodeDaoMapImpl();
	}

	public PromoRwrdDao getPromoRwrdDao() {
		return new PromoRwrdDaoMapImpl();
	}
}
