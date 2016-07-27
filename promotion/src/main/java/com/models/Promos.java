package com.models;

import java.math.BigDecimal;
import java.util.Date;

public class Promos {
	
	private long id;
	
	private Date vldStrtDt;
	
	private Date vldEndDt;
	
	private String promoDesc;
	
	private String promoMsg;
	
	private BigDecimal promoThsldAmt;
	
	private int promoAlrtCnt;
	
	private int promoStatInd;
	
	private Date creatTms;
	
	private Date updtTms;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getVldStrtDt() {
		return vldStrtDt;
	}

	public void setVldStrtDt(Date vldStrtDt) {
		this.vldStrtDt = vldStrtDt;
	}

	public Date getVldEndDt() {
		return vldEndDt;
	}

	public void setVldEndDt(Date vldEndDt) {
		this.vldEndDt = vldEndDt;
	}

	public String getPromoDesc() {
		return promoDesc;
	}

	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}

	public String getPromoMsg() {
		return promoMsg;
	}

	public void setPromoMsg(String promoMsg) {
		this.promoMsg = promoMsg;
	}

	public BigDecimal getPromoThsldAmt() {
		return promoThsldAmt;
	}

	public void setPromoThsldAmt(BigDecimal promoThsldAmt) {
		this.promoThsldAmt = promoThsldAmt;
	}

	public int getPromoAlrtCnt() {
		return promoAlrtCnt;
	}

	public void setPromoAlrtCnt(int promoAlrtCnt) {
		this.promoAlrtCnt = promoAlrtCnt;
	}

	public int getPromoStatInd() {
		return promoStatInd;
	}

	public void setPromoStatInd(int promoStatInd) {
		this.promoStatInd = promoStatInd;
	}

	public Date getCreatTms() {
		return creatTms;
	}

	public void setCreatTms(Date creatTms) {
		this.creatTms = creatTms;
	}

	public Date getUpdtTms() {
		return updtTms;
	}

	public void setUpdtTms(Date updtTms) {
		this.updtTms = updtTms;
	}
}
