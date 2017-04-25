package com.webcm.service;

import java.util.List;

import com.webcm.entity.Country;
/**
 * Service layer interface for Country entity
 * 
 * Implements the business logic between the controller and the DAO layer.
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version %I%, %G% 
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
	 * Saves the attribute Country into the database
	 * 
	 * @param saveCountry	The Country object that needs to be saved
	 */
	public void saveCountry(Country saveCountry);
	
	/**
	 * Removes the specified Country entry from the database
	 * 
	 * @param theId	ID of the Country object to be deleted
	 */
	public void deleteCountry(long theId);

}


