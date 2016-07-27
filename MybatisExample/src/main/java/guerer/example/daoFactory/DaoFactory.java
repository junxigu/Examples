package guerer.example.daoFactory;

import guerer.example.dao.PromoDao;
import guerer.example.dao.PromoRwrdDao;

public interface DaoFactory {

	PromoRwrdDao getPromoRwrdDao();

	PromoDao getPromoDao();

}
