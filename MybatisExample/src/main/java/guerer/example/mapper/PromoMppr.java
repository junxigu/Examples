package guerer.example.mapper;

import guerer.example.domain.Promo;

import java.util.List;

public interface PromoMppr {

  public List<Promo> getPromo();

  public List<Promo> getPromoUsingTextId(long displayTextTranslationId);

  public int insertPromo(Promo promo);

  public int deletePromo(long id);

  public int updatePromo(Promo promo);
}
