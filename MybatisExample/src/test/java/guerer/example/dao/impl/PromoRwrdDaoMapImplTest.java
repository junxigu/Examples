package guerer.example.dao.impl;

import static org.junit.Assert.assertTrue;
import guerer.example.dao.PromoRwrdDao;
import guerer.example.domain.PromoRwrd;

import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PromoRwrdDaoMapImplTest {

	protected PromoRwrdDao dao;

	private int insertTestPromoRwrd() throws IOException {
		PromoRwrd promoRwrd = new PromoRwrd();
		promoRwrd.setRwrdCd("test");
		return dao.insertPromoRwrd(promoRwrd);
	}

	@Before
	public void setUp() throws IOException {
		dao = new PromoRwrdDaoMapImpl();
	}

	@Test
	public void testInsertPromoRwrd() throws IOException {
		int oriSize = dao.getPromoRwrd().size();
		assertTrue(insertTestPromoRwrd() == 1);
		assertTrue(oriSize == dao.getPromoRwrd().size() - 1);
	}

	@Test
	public void testGetPromoRwrd() throws IOException {
		assertTrue(dao.getPromoRwrd().size() >= 0);
	}

}
