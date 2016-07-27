package com.dao.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.ServiceMerchantTokenDao;
import com.domain.ServiceMerchantToken;
import com.mapper.ServiceMerchantTokenMppr;
import com.util.DBUtils;

public class ServiceMerchantTokenDaoImpl implements ServiceMerchantTokenDao {

	private SqlSession session;

	public int insertMerchantToken(ServiceMerchantToken merchantToken)
			throws IOException {
		int count = 0;
		try{
			count = getMapper().insertServiceMerchantToken(merchantToken);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

	private ServiceMerchantTokenMppr getMapper() throws IOException {
		session = DBUtils.getSqlSession();
		return (ServiceMerchantTokenMppr) session
				.getMapper(ServiceMerchantTokenMppr.class);
	}

	public List<ServiceMerchantToken> getMerchantTokens() throws IOException {
		List<ServiceMerchantToken> merchantTokens = null;
		try{
			merchantTokens = getMapper().getServiceMerchantToken();
		} finally {
			session.close();
		}
		return merchantTokens;
	}

	public int deleteMerchantToken(long id) throws IOException {
		int count = 0;
		try{
			count = getMapper().deleteServiceMerchantToken(id);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

	public int updateMerchantToken(ServiceMerchantToken merchantToken)
			throws IOException {
		int count = 0;
		try{
			count = getMapper().updateServiceMerchantToken(merchantToken);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

}
