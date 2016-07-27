package guerer.example.daoFactory.impl;

import guerer.example.dao.PromoDao;
import guerer.example.dao.PromoRwrdDao;
import guerer.example.dao.impl.PromoDaoMapImpl;
import guerer.example.dao.impl.PromoRwrdDaoMapImpl;
import guerer.example.daoFactory.DaoFactory;

import java.io.IOException;

public class MapDaoFactory implements DaoFactory {

	private static MapDaoFactory factory;

	public static DaoFactory getFactory() throws IOException {
		if (factory == null) {
			factory = new MapDaoFactory();
		}
		return factory;
	}

	public PromoRwrdDao getPromoRwrdDao() {
		return new PromoRwrdDaoMapImpl();
	}

	public PromoDao getPromoDao() {
		return new PromoDaoMapImpl();
	}

}
