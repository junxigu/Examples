package com.domain;

public class UploadResult{
	
	private int formatErrNum;
	
	private int existedNum;
	
	private int succNum;

	public int getExistedNum() {
		return existedNum;
	}

	public void setExistedNum(int existedNum) {
		this.existedNum = existedNum;
	}

	public int getFormatErrNum() {
		return formatErrNum;
	}

	public void setFormatErrNum(int formatErrNum) {
		this.formatErrNum = formatErrNum;
	}

	public int getSuccNum() {
		return succNum;
	}

	public void setSuccNum(int succNum) {
		this.succNum = succNum;
	}
	
	public String toString(){
		return formatErrNum + " " + succNum + " " + existedNum;
	}
}
