package com.webcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webcm.dao.CityDAO;
import com.webcm.entity.City;

/**
 * Service layer implementation for City entity
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version %I%, %G% 
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
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public void saveCity(City saveCity) {
		cityDAO.saveCity(saveCity);		
	}
	
	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public void deleteCity(long theId) {
		cityDAO.deleteCity(theId);
	}
}
