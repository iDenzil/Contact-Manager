package com.webcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webcm.dao.CountryDAO;
import com.webcm.entity.Country;


@Service
public class CountryServiceImpl implements CountryService {

	//need to inject DAO
	@Autowired
	private CountryDAO countryDAO;

	@Override
	@Transactional
	public List<Country> getCountryList() {
		return countryDAO.getCountryList();
	}

	@Override
	@Transactional
	public Country getCountry(long theId) {
		return countryDAO.getCountry(theId);
	}

	@Override
	@Transactional
	public void saveCountry(Country saveCountry) {
		countryDAO.saveCountry(saveCountry);		
	}

	@Override
	@Transactional
	public void deleteCountry(long theId) {
		countryDAO.deleteCountry(theId);
	}

}
