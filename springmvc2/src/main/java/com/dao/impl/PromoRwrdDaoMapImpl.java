package com.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dao.PromoRwrdDao;
import com.domain.PromoRwrd;

public class PromoRwrdDaoMapImpl implements PromoRwrdDao {

	private Map<Long, PromoRwrd> promoRwrdMap = new HashMap<Long, PromoRwrd>();
	private long promoRwrdId = 1;

	public List<String> getPromoRwrd() throws IOException {
		List<String> list = new ArrayList<String>();
		for(PromoRwrd rwrd : promoRwrdMap.values()){
			list.add(rwrd.getRwrdCd());
		}
		return list;
	}

	public int insertPromoRwrd(PromoRwrd promoRwrd) throws IOException {
		promoRwrd.setId(promoRwrdId);
		promoRwrdMap.put(promoRwrdId++, promoRwrd);
		return 1;
	}

}
