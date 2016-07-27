package guerer.example.domain;

import java.util.Date;

public class Promo {

  private long id;

  private long displayTextTranslationId;

  private String promoName;

  private Date validStartDate;

  private Date validEndDate;

  private double promoThresholdAmount;

  private int promoAlertCount;

  private short promoStatusIndicator;

  private short promoSelectionIndicator;

  private Date creationTime;

  private Date updateTime;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getDisplayTextTranslationId() {
    return displayTextTranslationId;
  }

  public void setDisplayTextTranslationId(long displayTextTranslationId) {
    this.displayTextTranslationId = displayTextTranslationId;
  }

  public String getPromoName() {
    return promoName;
  }

  public void setPromoName(String promoName) {
    this.promoName = promoName;
  }

  public Date getValidStartDate() {
    return validStartDate;
  }

  public void setValidStartDate(Date validStartDate) {
    this.validStartDate = validStartDate;
  }

  public Date getValidEndDate() {
    return validEndDate;
  }

  public void setValidEndDate(Date validEndDate) {
    this.validEndDate = validEndDate;
  }

  public double getPromoThresholdAmount() {
    return promoThresholdAmount;
  }

  public void setPromoThresholdAmount(double promoThresholdAmount) {
    this.promoThresholdAmount = promoThresholdAmount;
  }

  public int getPromoAlertCount() {
    return promoAlertCount;
  }

  public void setPromoAlertCount(int promoAlertCount) {
    this.promoAlertCount = promoAlertCount;
  }

  public short getPromoStatusIndicator() {
    return promoStatusIndicator;
  }

  public void setPromoStatusIndicator(short promoStatusIndicator) {
    this.promoStatusIndicator = promoStatusIndicator;
  }

  public short getPromoSelectionIndicator() {
    return promoSelectionIndicator;
  }

  public void setPromoSelectionIndicator(short promoSelectionIndicator) {
    this.promoSelectionIndicator = promoSelectionIndicator;
  }

  public Date getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(Date creationTime) {
    this.creationTime = creationTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }


  public Promo(){

  }

  public Promo(Promo promo){
    id = promo.id;
    displayTextTranslationId = promo.displayTextTranslationId;
    promoName = promo.promoName;
    validStartDate = promo.validStartDate;
    validEndDate = promo.validEndDate;
    promoThresholdAmount = promo.promoThresholdAmount;
    promoAlertCount = promo.promoAlertCount;
    promoStatusIndicator = promo.promoStatusIndicator;
    promoSelectionIndicator = promo.promoSelectionIndicator;
    creationTime = promo.creationTime;
    updateTime = promo.updateTime;
  }

  public Promo( long displayTextTranslationId, String promoName,
                Date validStartDate, Date validEndDate,
                double promoThresholdAmount, int promoAlertCount,
                short promoStatusIndicator, short promoSelectionIndicator,
                Date creationTime, Date updateTime ){
    this.displayTextTranslationId = displayTextTranslationId;
    this.promoName = promoName;
    this.validStartDate = validStartDate;
    this.validEndDate = validEndDate;
    this.promoThresholdAmount = promoThresholdAmount;
    this.promoAlertCount = promoAlertCount;
    this.promoStatusIndicator = promoStatusIndicator;
    this.promoSelectionIndicator = promoSelectionIndicator;
    this.creationTime = creationTime;
    this.updateTime = updateTime;
  }
}
