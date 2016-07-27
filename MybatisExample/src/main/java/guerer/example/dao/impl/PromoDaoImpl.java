package guerer.example.dao.impl;

import guerer.example.dao.PromoDao;
import guerer.example.domain.Promo;
import guerer.example.mapper.PromoMppr;
import guerer.example.util.DBUtils;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class PromoDaoImpl implements PromoDao {

	private SqlSession session;

	public int insertPromo(Promo promo) throws IOException {
		int count = 0;
		try {
			count = getMapper().insertPromo(promo);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

	private PromoMppr getMapper() throws IOException {
		session = DBUtils.getSqlSession();
		return (PromoMppr) session.getMapper(PromoMppr.class);
	}

	public List<Promo> getPromos() throws IOException {
		List<Promo> promos = null;
		try {
			promos = getMapper().getPromo();
		} finally {
			session.close();
		}
		return promos;
	}

	public List<Promo> getPromos(long displayTextTranslationId)
			throws IOException {
		List<Promo> promos = null;
		try {
			promos = getMapper().getPromoUsingTextId(displayTextTranslationId);
		} finally {
			session.close();
		}
		return promos;
	}

	public int deletePromo(long id) throws IOException {
		int count = 0;
		try {
			count = getMapper().deletePromo(id);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

	public int updatePromo(Promo promo) throws IOException {
		int count = 0;
		try {
			count = getMapper().updatePromo(promo);
			session.commit();
		} finally {
			session.close();
		}
		return count;
	}

}
