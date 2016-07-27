package guerer.example.dao;

import guerer.example.domain.PromoRwrd;

import java.io.IOException;
import java.util.List;

public interface PromoRwrdDao {

	public List<String> getPromoRwrd() throws IOException;
	
	public int insertPromoRwrd(PromoRwrd promoRwrd) throws IOException;
	
}
