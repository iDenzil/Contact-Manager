package com.webcm.service;

import java.util.List;

import com.webcm.entity.Country;

public interface CountryService {

	public List<Country> getCountryList();
	
	public Country getCountry(long theId);
	
	public void saveCountry(Country saveCountry);

	public void deleteCountry(long theId);

}


