package com.webcm.service;

import java.util.List;

import com.webcm.entity.City;

public interface CityService {

	public List<City> getCityList();
	
	public City getCity(long theId);
	
	public void saveCity(City saveCity);

	public void deleteCity(long theId);

}


