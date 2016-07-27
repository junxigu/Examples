package com.models;

import java.util.Date;

public class UserSelectedPromos {
	
	private long id;
	
	private long userLogonId;
	
	private Date vldStrtTms;
	
	private Date vldEndTms;
	
	private String ccTxt;
	
	private int pntAvail;
	
	private Date creatTms;
	
	private Date updtTms;
	
	private int rowStatInd;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserLogonId() {
		return userLogonId;
	}

	public void setUserLogonId(long userLogonId) {
		this.userLogonId = userLogonId;
	}

	public Date getVldStrtTms() {
		return vldStrtTms;
	}

	public void setVldStrtTms(Date vldStrtTms) {
		this.vldStrtTms = vldStrtTms;
	}

	public Date getVldEndTms() {
		return vldEndTms;
	}

	public void setVldEndTms(Date vldEndTms) {
		this.vldEndTms = vldEndTms;
	}

	public String getCcTxt() {
		return ccTxt;
	}

	public void setCcTxt(String ccTxt) {
		this.ccTxt = ccTxt;
	}

	public int getPntAvail() {
		return pntAvail;
	}

	public void setPntAvail(int pntAvail) {
		this.pntAvail = pntAvail;
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

	public int getRowStatInd() {
		return rowStatInd;
	}

	public void setRowStatInd(int rowStatInd) {
		this.rowStatInd = rowStatInd;
	}
}
