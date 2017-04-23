package com.webcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webcm.dao.CityDAO;
import com.webcm.entity.City;


@Service
public class CityServiceImpl implements CityService {

	//need to inject DAO
	@Autowired
	private CityDAO cityDAO;

	@Override
	@Transactional
	public List<City> getCityList() {
		return cityDAO.getCityList();
	}

	@Override
	@Transactional
	public City getCity(long theId) {
		return cityDAO.getCity(theId);
	}

	@Override
	@Transactional
	public void saveCity(City saveCity) {
		cityDAO.saveCity(saveCity);		
	}

	@Override
	@Transactional
	public void deleteCity(long theId) {
		cityDAO.deleteCity(theId);
	}

}
