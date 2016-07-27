package com.dao.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.ServiceMerchantDao;
import com.domain.ServiceMerchant;
import com.mapper.ServiceMerchantMppr;
import com.util.DBUtils;

public class ServiceMerchantDaoImpl implements ServiceMerchantDao {

	private SqlSession session;

	public int insertMerchant(ServiceMerchant merchant) throws IOException {
		int count = 0;
		try {
			count = getMapper().insertServiceMerchant(merchant);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

	private ServiceMerchantMppr getMapper() throws IOException {
		session = DBUtils.getSqlSession();
		return (ServiceMerchantMppr) session
				.getMapper(ServiceMerchantMppr.class);
	}

	public List<ServiceMerchant> getMerchants() throws IOException {
		List<ServiceMerchant> merchants = null;
		try {
			merchants = getMapper().getServiceMerchant();
		} finally {
			session.close();
		}
		return merchants;
	}

	public int deleteMerchant(long id) throws IOException {
		int count = 0;
		try {
			count = getMapper().deleteServiceMerchant(id);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

	public int updateMerchant(ServiceMerchant merchant) throws IOException {
		int count = 0;
		try {
			count = getMapper().updateServiceMerchant(merchant);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

	public List<Long> getIds() throws IOException {
		List<Long> ids = null;
		try {
			ids = getMapper().getServiceMerchantIds();
		} finally {
			session.close();
		}
		return ids;
	}

}
