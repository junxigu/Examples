package guerer.example.dao;

import guerer.example.domain.Promo;

import java.io.IOException;
import java.util.List;

public interface PromoDao {

  public List<Promo> getPromos() throws IOException;

  public List<Promo> getPromos(long displayTextTranslationId) throws IOException;

  public int insertPromo(Promo promo) throws IOException;

  public int deletePromo(long id) throws IOException;

  public int updatePromo(Promo promo) throws IOException;

}
