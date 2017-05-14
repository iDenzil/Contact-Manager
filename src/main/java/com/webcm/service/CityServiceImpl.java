package com.webcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webcm.dao.CityDAO;
import com.webcm.dao.ContactDAO;
import com.webcm.entity.City;
import com.webcm.entity.Contact;

/**
 * Service layer implementation for City entity
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0.1, 14.05.2017. 
 *
 */
@Service
public class CityServiceImpl implements CityService {

	/**
	 * Injects the DAO layer.
	 */
	@Autowired
	private CityDAO cityDAO;
	

	/**
	 * Injects the Contact DAO.
	 * 
	 * Required for validation before calling Delete method
	 */
	@Autowired
	private ContactDAO contactDAO;

	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public List<City> getCityList() {
		return cityDAO.getCityList();
	}

	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public City getCity(long theId) {
		return cityDAO.getCity(theId);
	}
	
	/**
	 * Checks for existing name and saves the city.
	 * 
	 * Compares the parameter object with all existing database objects.
	 * If it exists, returns TRUE, else delegates the Save request to the DAO layer.
	 */
	@Override
	@Transactional
	public Boolean saveCity(City newCity) {
		List<City> listCities = getCityList();	//pulls the database content for comparing
		Boolean cityExists = false; 			//assume the entry doesn't exist
		
		for (City database: listCities){		//loops the database content
			cityExists=newCity.equals(database);//compares each entry with new entry
			if (cityExists) return cityExists;	//if exists -> exit save method, return true statement
		}
		cityDAO.saveCity(newCity);				//delegate Save to DAO layer
		return cityExists;						//return the statement, confirm the save method was called
	}

		/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public Boolean deleteCity(long theId) {
		List<Contact> listContacts = contactDAO.getContacts();					//pulls the database content for comparing
		
		for (Contact database: listContacts){									//loops the database content
			if (database.getAddress().getCity().getId() == theId) return true;	//if a reference exists -> exit delete method, return true statement
		}																
		cityDAO.deleteCity(theId);												//delegate Delete to DAO layer
		return false;															//return false statement, confirm the delete method was called
	}
}
