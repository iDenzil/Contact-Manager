package com.webcm.dao;

import java.util.List;

import com.webcm.entity.City;
/**
 * DAO layer interface for City entity
 * 
 * Communicates with the database and performs required operations on the database 
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0, 26.04.2017. 
 *
 */
public interface CityDAO {

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
	 * @param newCity	The City object that needs to be saved
	 */
	public void saveCity(City newCity);

	/**
	 * Removes the specified City entry from the database
	 * 
	 * @param theId	ID of the City object to be deleted
	 */
	public void deleteCity(long theId);

}
