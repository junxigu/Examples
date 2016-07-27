package com.domain;

import java.util.Date;

public class CountryCode {

	private long id;

	private String regionCode;

	private String countryCode;

	private String countryDescription;

	private String crncyDescription;

	private Date creationTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryDescription() {
		return countryDescription;
	}

	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}

	public String getCrncyDescription() {
		return crncyDescription;
	}

	public void setCrncyDescription(String crncyDescription) {
		this.crncyDescription = crncyDescription;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}


}
