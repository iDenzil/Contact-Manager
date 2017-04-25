package com.webcm.service;

import java.util.List;

import com.webcm.entity.City;
/**
 * Service layer interface for City entity
 * 
 * Implements the business logic between the controller and the DAO layer.
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version %I%, %G% 
 *
 */
public interface CityService {
	
	/**
	 * Retrieves all the City entries from the database in a List format
	 * 
	 * @return	The List of City objects.
	 */
	public List<City> getCityList();
	
	/**
	 * Retrieves specified City object from the database
	 * 
	 * @param theId	ID for the required City
	 * @return		The requested City object
	 */
	public City getCity(long theId);
	
	/**
	 * Saves the attribute City into the database
	 * 
	 * @param saveCity	The City object that needs to be saved
	 */
	public void saveCity(City saveCity);

	/**
	 * Removes the specified City entry from the database
	 * 
	 * @param theId	ID of the City object to be deleted
	 */
	public void deleteCity(long theId);

}


