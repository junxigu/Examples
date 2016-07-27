package guerer.example.daoFactory.impl;

import guerer.example.dao.PromoDao;
import guerer.example.dao.PromoRwrdDao;
import guerer.example.dao.impl.PromoDaoImpl;
import guerer.example.dao.impl.PromoRwrdDaoImpl;
import guerer.example.daoFactory.DaoFactory;

import java.io.IOException;

public class MapperDaoFactory implements DaoFactory {

	private static MapperDaoFactory factory;

	public static DaoFactory getFactory() throws IOException {
		if (factory == null) {
			factory = new MapperDaoFactory();
		}
		return factory;
	}

	public PromoRwrdDao getPromoRwrdDao() {
		return new PromoRwrdDaoImpl();
	}

	public PromoDao getPromoDao() {
		return new PromoDaoImpl();
	}

}
