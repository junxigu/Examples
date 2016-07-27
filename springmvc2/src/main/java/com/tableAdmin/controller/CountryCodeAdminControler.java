package com.tableAdmin.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CountryCodeDao;
import com.daoFactory.DaoFactory;
import com.domain.CountryCode;

@RestController
@RequestMapping("/countryCodes")
public class CountryCodeAdminControler {

	private CountryCodeDao countryCodeDao;

	public CountryCodeAdminControler(DaoFactory daoFactory) {
		this.countryCodeDao = daoFactory.getCountryCodeDao();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CountryCode> fetchCountryCodes() throws IOException {
		return countryCodeDao.getCountryCodes();
	}

}
