package com.tableAdmin.controller;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.domain.ServiceMerchantToken;
import com.tableAdmin.service.ServiceMerchantTokenAdminService;

@RestController
@RequestMapping("/merchantServiceTokens")
public class ServiceMerchantTokenAdminController {

	private ServiceMerchantTokenAdminService service;

	public ServiceMerchantTokenAdminController(
			ServiceMerchantTokenAdminService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ServiceMerchantToken> fetchCollection() throws InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		return service.fetch();
	}

//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public ServiceMerchantToken modelFetch(@PathVariable long id) {
//		return null;
//	}

	@RequestMapping(method = RequestMethod.POST)
	public ServiceMerchantToken modelCreate(
			@RequestBody ServiceMerchantToken token)
			throws InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, IOException {
		return service.insert(token);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ServiceMerchantToken modelUpdate(
			@RequestBody ServiceMerchantToken token, @PathVariable long id)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
		return service.update(token);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ServiceMerchantToken modelDelete(@PathVariable long id)
			throws IOException {
		ServiceMerchantToken token = new ServiceMerchantToken();
		token.setId(id);
		return service.delete(token);
	}

}