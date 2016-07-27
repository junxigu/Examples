package com.daoFactory.impl;

import java.io.IOException;

import com.Constants;
import com.dao.CountryCodeDao;
import com.dao.PromoRwrdDao;
import com.dao.ServiceMerchantDao;
import com.dao.ServiceMerchantTokenDao;
import com.dao.impl.CountryCodeDaoImpl;
import com.dao.impl.PromoRwrdDaoImpl;
import com.dao.impl.ServiceMerchantDaoImpl;
import com.dao.impl.ServiceMerchantTokenDaoImpl;
import com.daoFactory.DaoFactory;
import com.util.DBUtils;

public class MapperDaoFactory implements DaoFactory{

	private static MapperDaoFactory factory;
	
	public MapperDaoFactory() throws IOException{
		DBUtils.initSqlSessionFactory(Constants.JDBC_CONFIG);
	}
	
	public ServiceMerchantDao getServiceMerchantDao() {
		return new ServiceMerchantDaoImpl();
	}

	public ServiceMerchantTokenDao getServiceMerchantTokenDao() {
		return new ServiceMerchantTokenDaoImpl();
	}

	public static DaoFactory getFactory() throws IOException{
		if(factory == null){
			factory = new MapperDaoFactory();
		}
		return factory;
	}

	public CountryCodeDao getCountryCodeDao() {
		return new CountryCodeDaoImpl();
	}

	public PromoRwrdDao getPromoRwrdDao() {
		return new PromoRwrdDaoImpl();
	}
}
