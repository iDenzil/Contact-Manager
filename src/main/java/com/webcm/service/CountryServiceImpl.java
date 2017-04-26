package com.webcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webcm.dao.CityDAO;
import com.webcm.dao.CountryDAO;
import com.webcm.entity.City;
import com.webcm.entity.Country;

/**
 * Service layer implementation for Country entity
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0, 26.04.2017. 
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
	 * Injects the City DAO.
	 * 
	 * Required for validation before calling Delete method
	 */
	@Autowired
	private CityDAO cityDAO;
	
	
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
	 * Compares to the other entries in the database and saves the object.
	 * 
	 * Compares the parameter object with all existing database objects.
	 * If a similiarity exists, returns TRUE, else delegates the Save request to the DAO layer.
	 */
	@Override
	@Transactional
	public Boolean saveCountry(Country newCountry) {
		List<Country> listCountries = getCountryList(); //pulls the database content for comparing
		Boolean countryExists = false; 					//assume the entry doesn't exist
		
		for (Country database: listCountries){			//loops the database content
			countryExists=newCountry.compare(database);	//compares each entry with new entry
			if (countryExists) return countryExists;	//if exists -> exit save method, return true statement
		}
		countryDAO.saveCountry(newCountry);				//delegate Save to DAO layer
		return countryExists;							//return the statement, confirm the save method was called
	}
	
	/**
	 * Verifies existing references and delegates to DAO layer.
	 * 
	 * Compares the parameter object with all existing database objects.
	 * If a reference exists, returns TRUE, else delegates the Delete request to the DAO layer.
	 */
	@Override
	@Transactional
	public Boolean deleteCountry(long theId) {
		List<City> listCities = cityDAO.getCityList();					//pulls the database content for comparing
		
		for (City database: listCities){								//loops the database content
			if (database.getCountry().getId() == theId) return true;	//if a reference exists -> exit delete method, return true statement
		}																
		countryDAO.deleteCountry(theId);								//delegate Delete to DAO layer
		return false;													//return the statement, confirm the delete method was called
	}

}
