package guerer.example.action;

import guerer.example.domain.ServiceMerchant;
import guerer.example.domain.ServiceMerchantToken;
import guerer.example.service.ServiceMerchantTokenService;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import jxl.biff.CountryCode;

import com.opensymphony.xwork2.ActionSupport;

public class ServiceMerchantTokenOprAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private ServiceMerchantToken merchantToken = new ServiceMerchantToken();

	private List<ServiceMerchantToken> merchantTokens;
	
	private List<ServiceMerchant> merchants;
	
	private List<CountryCode> countryCodes;
	
	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public List<CountryCode> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<CountryCode> countryCodes) {
		this.countryCodes = countryCodes;
	}

	public List<ServiceMerchant> getMerchants() {
		return merchants;
	}

	public void setMerchants(List<ServiceMerchant> merchants) {
		this.merchants = merchants;
	}

	private ServiceMerchantTokenService service;

	public void setService(ServiceMerchantTokenService service) {
		this.service = service;
	}

	public List<ServiceMerchantToken> getMerchantTokens() {
		return merchantTokens;
	}

	public void setMerchantTokens(List<ServiceMerchantToken> merchantTokens) {
		this.merchantTokens = merchantTokens;
	}

	public ServiceMerchantToken getMerchantToken() {
		return merchantToken;
	}

	public void setMerchantToken(ServiceMerchantToken merchantToken) {
		this.merchantToken = merchantToken;
	}

	public String insert() throws IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		return service.insert(merchantToken) == 1 ? SUCCESS : ERROR;
	}

	public String delete() throws IOException {
		return service.delete(merchantToken) > 0 ? SUCCESS : ERROR;
	}

	public String update() throws IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		return service.update(merchantToken) > 0 ? SUCCESS : ERROR;
	}

	public String fetch() throws IOException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		merchantTokens = service.fetch();
		return merchantTokens.size() >= 0 ? SUCCESS : ERROR;
	}
	
	public String fetchMerchants() throws IOException {
		merchants = service.fetchMerchants();
		return merchants.size() >= 0 ? SUCCESS : ERROR;
	}
	
	public String fetchCountryCodes() throws IOException {
		countryCodes = service.fetchCountryCodes();
		return countryCodes.size() >= 0 ? SUCCESS : ERROR;
	}

	public ServiceMerchantTokenOprAction() throws Exception {
		super();
		service = new ServiceMerchantTokenService();
	}
}
