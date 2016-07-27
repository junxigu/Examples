package com.tableAdmin.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ServiceMerchantDao;
import com.daoFactory.DaoFactory;
import com.domain.ServiceMerchant;

@RestController
@RequestMapping("/merchantServices")
public class ServiceMerchantAdminControler {

	private ServiceMerchantDao merchantDao;

	public ServiceMerchantAdminControler(DaoFactory daoFactory) {
		this.merchantDao = daoFactory.getServiceMerchantDao();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ServiceMerchant> fetchMerchants() throws IOException {
		return merchantDao.getMerchants();
	}

}
