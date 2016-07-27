package com.dao.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.CountryCodeDao;
import com.dao.ServiceMerchantDao;
import com.domain.CountryCode;
import com.domain.ServiceMerchant;
import com.mapper.CountryCodeMppr;
import com.mapper.ServiceMerchantMppr;
import com.util.DBUtils;

public class CountryCodeDaoImpl implements CountryCodeDao {

	private SqlSession session;

	private CountryCodeMppr getMapper() throws IOException {
		session = DBUtils.getSqlSession();
		return (CountryCodeMppr) session
				.getMapper(CountryCodeMppr.class);
	}

	public List<CountryCode> getCountryCodes() throws IOException {
		List<CountryCode> ids = null;
		try {
			ids = getMapper().getCountryCodes();
		} finally {
			session.close();
		}
		return ids;
	}

}
