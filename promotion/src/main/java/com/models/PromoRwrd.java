package com.models;

import java.math.BigDecimal;
import java.util.Date;

public class PromoRwrd {
	
	private long id;
	
	private long userSelectedPromosId;
	
	private String rwrdCd;
	
	private Date rwrdDt;
	
	private BigDecimal rwrdAmt;
	
	private String rwrdSerial;
	
	private int rwrdThrsld;
	
	private Date creatTms;
	
	private Date updtTms;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserSelectedPromosId() {
		return userSelectedPromosId;
	}

	public void setUserSelectedPromosId(long userSelectedPromosId) {
		this.userSelectedPromosId = userSelectedPromosId;
	}

	public String getRwrdCd() {
		return rwrdCd;
	}

	public void setRwrdCd(String rwrdCd) {
		this.rwrdCd = rwrdCd;
	}

	public Date getRwrdDt() {
		return rwrdDt;
	}

	public void setRwrdDt(Date rwrdDt) {
		this.rwrdDt = rwrdDt;
	}

	public BigDecimal getRwrdAmt() {
		return rwrdAmt;
	}

	public void setRwrdAmt(BigDecimal rwrdAmt) {
		this.rwrdAmt = rwrdAmt;
	}

	public String getRwrdSerial() {
		return rwrdSerial;
	}

	public void setRwrdSerial(String rwrdSerial) {
		this.rwrdSerial = rwrdSerial;
	}

	public int getRwrdThrsld() {
		return rwrdThrsld;
	}

	public void setRwrdThrsld(int rwrdThrsld) {
		this.rwrdThrsld = rwrdThrsld;
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
