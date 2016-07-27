package com.dao;

import java.io.IOException;
import java.util.List;

import com.domain.PromoRwrd;

public interface PromoRwrdDao {

	public List<String> getPromoRwrd() throws IOException;
	
	public int insertPromoRwrd(PromoRwrd promoRwrd) throws IOException;
	
}
