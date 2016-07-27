package guerer.example.domain;

import java.util.Date;

public class ServiceMerchant {

	private long id;

	private String name1;

	private String name2;

	private String address1;

	private String address2;

	private String city;

	private String state;

	private String postalCode;

	private String businessPhone;

	private Date creationTime;

	private Date updateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
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

	public ServiceMerchant() {
		this.name1 = "First Data Corporation";
		this.name2 = "";
		this.address1 = "5565 Glenridge Connector NE";
		this.address2 = "Suite 2000";
		this.city = "Atlanta";
		this.state = "GA";
		this.postalCode = "30342";
		this.businessPhone = "+1 404-890-2300";
		this.creationTime = new Date();
	}

}
