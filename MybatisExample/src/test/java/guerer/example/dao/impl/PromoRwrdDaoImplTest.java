package guerer.example.dao.impl;

import guerer.example.util.DBUtils;

import java.io.IOException;

import org.junit.Before;

public class PromoRwrdDaoImplTest extends PromoRwrdDaoMapImplTest {

	@Override
	@Before
	public void setUp() throws IOException {
		DBUtils.initSqlSessionFactory();
		dao = new PromoRwrdDaoImpl();
	}
}
