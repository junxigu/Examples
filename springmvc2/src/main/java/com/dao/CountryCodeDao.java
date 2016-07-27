package com.dao;

import java.io.IOException;
import java.util.List;

import com.domain.CountryCode;

public interface CountryCodeDao {

	public List<CountryCode> getCountryCodes() throws IOException;
	
}
