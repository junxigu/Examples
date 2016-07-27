package guerer.example.domain;

import java.util.Date;

public class ServiceMerchantToken {

	private long id;

	private long serviceMerchantId;

	private long countryCode;

	private String alias;

	private String password;

	private String partnerId;

	private String systemId;

	private String certificate;
	
	private String description;

	private Date creationTime;

	private Date updateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getServiceMerchantId() {
		return serviceMerchantId;
	}

	public void setServiceMerchantId(long serviceMerchantId) {
		this.serviceMerchantId = serviceMerchantId;
	}

	public long getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(long countryCode) {
		this.countryCode = countryCode;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServiceMerchantToken(){
		
	}
	
	public ServiceMerchantToken(ServiceMerchantToken token){
		id = token.id;
		serviceMerchantId = token.serviceMerchantId;
		countryCode = token.countryCode;
		alias = token.alias;
		password = token.password;
		partnerId = token.partnerId;
		systemId = token.systemId;
		certificate = token.certificate;
		description = token.description;
		creationTime = token.creationTime;
		updateTime = token.updateTime;
	}

	public ServiceMerchantToken(long countryCode,
			String alias, String password, String partnerId, String systemId,
			String certificate, String description, Date creationTime) {
		this.countryCode = countryCode;
		this.alias = alias;
		this.password = password;
		this.partnerId = partnerId;
		this.systemId = systemId;
		this.certificate = certificate;
		this.description = description;
		this.creationTime = creationTime;
	}
}
