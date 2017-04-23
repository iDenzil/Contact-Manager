package com.webcm.dao;

import java.util.List;

import com.webcm.entity.City;

public interface CityDAO {
	
	public List<City> getCityList();

	public City getCity(long theId);

	public void saveCity(City saveCity);

	public void deleteCity(long theId);

}
