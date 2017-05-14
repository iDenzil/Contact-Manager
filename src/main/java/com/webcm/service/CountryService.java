package com.webcm.service;

import java.util.List;

import com.webcm.entity.Country;
/**
 * Service layer interface for Country entity
 * 
 * Implements the business logic between the controller and the DAO layer.
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0.1, 14.05.2017. 
 *
 */
public interface CountryService {

	/**
	 * Retrieves all the Country entries from the database in a List format
	 * 
	 * @return	The List of Country objects.
	 */
	public List<Country> getCountryList();
	
	/**
	 * Retrieves specified Country object from the database
	 * 
	 * @param theId	ID for the required Country
	 * @return		The requested Country object
	 */
	public Country getCountry(long theId);
	
	/**
	 * Compares to the other entries in the database and saves the object.
	 * 
	 * @param newCountry	The Country object that needs to be saved
	 * @return				Boolean statement - if there is match to a country in the database
	 */
	public Boolean saveCountry(Country newCountry);
	
	/**
	 * Removes the specified Country entry from the database
	 * 
	 * @param theId	ID of the Country object to be deleted
	 * @return False if object was deleted, true otherwise
	 */
	public Boolean deleteCountry(long theId);

}


