package guerer.example.dao.impl;

import guerer.example.dao.PromoDao;
import guerer.example.domain.Promo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromoDaoMapImpl implements PromoDao {

	private static Map<Long, Promo> promoMap = new HashMap<Long, Promo>();
	private long promoId = 1;

	public int insertPromo(Promo promo) throws IOException {
		promo.setId(promoId);
		promoMap.put(promoId++, promo);
		return 1;
	}

	public int updatePromo(Promo promo) throws IOException {
		long id = promo.getId();
		if (promoMap.containsKey(id)) {
			promoMap.put(id, promo);
			return 1;
		}
		return 0;
	}

	public List<Promo> getPromos() throws IOException {
		return new ArrayList<Promo>(promoMap.values());
	}

	public List<Promo> getPromos(long displayTextTranslationId)
			throws IOException {
		return new ArrayList<Promo>(promoMap.values());
	}

	public int deletePromo(long id) throws IOException {
		if (promoMap.containsKey(id)) {
			promoMap.remove(id);
			return 1;
		}
		return 0;
	}

}
