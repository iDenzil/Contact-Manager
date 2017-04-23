package com.webcm.dao;

import java.util.List;

import com.webcm.entity.Country;

public interface CountryDAO {
	
	public List<Country> getCountryList();

	public Country getCountry(long theId);

	public void saveCountry(Country saveCountry);

	public void deleteCountry(long theId);

}
