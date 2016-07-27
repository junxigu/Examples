package com.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dao.PromoRwrdDao;
import com.domain.PromoRwrd;
import com.mapper.PromoRwrdMppr;
import com.util.DBUtils;

public class PromoRwrdDaoImpl implements PromoRwrdDao {

	private SqlSession session;

	private PromoRwrdMppr getMapper() throws IOException {
		session = DBUtils.getSqlSession();
		return (PromoRwrdMppr) session.getMapper(PromoRwrdMppr.class);
	}

	public List<String> getPromoRwrd() throws IOException {
		List<String> codes = null;
		try {
			codes = getMapper().getPromoRwrd();
		} finally {
			session.close();
		}
		return codes;
	}

	public int insertPromoRwrd(PromoRwrd promoRwrd) throws IOException {
		int count = 0;
		try {
			count = getMapper().insertPromoRwrd(promoRwrd);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

}
