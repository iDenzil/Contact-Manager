package com.webcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webcm.dao.CountryDAO;
import com.webcm.entity.Country;

/**
 * Service layer implementation for Country entity
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version %I%, %G% 
 * 
 */
@Service
public class CountryServiceImpl implements CountryService {

	/**
	 * Injects the DAO layer.
	 */
	@Autowired
	private CountryDAO countryDAO;
	
	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public List<Country> getCountryList() {
		return countryDAO.getCountryList();
	}
	
	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public Country getCountry(long theId) {
		return countryDAO.getCountry(theId);
	}
	
	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public void saveCountry(Country saveCountry) {
		countryDAO.saveCountry(saveCountry);		
	}
	
	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public void deleteCountry(long theId) {
		countryDAO.deleteCountry(theId);
	}

}
