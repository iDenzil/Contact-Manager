package com.webcm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webcm.entity.City;

@Repository
public class CityDAOImpl implements CityDAO {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory; //this is the sessionFactory defined in the hibernate configuration in dispatcher-servlet.xml
	
	@Override
	public List<City> getCityList() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<City> theQuery = currentSession.createQuery("from City",City.class); 
		List<City> cityList = theQuery.getResultList();
		return cityList;
	}

	@Override
	public City getCity(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		City theCity = currentSession.get(City.class, theId);
		return theCity;
	}


	@Override
	public void saveCity(City saveCity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(saveCity); 
	}

	@Override
	public void deleteCity(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		City theCity = currentSession.get(City.class, theId);
		currentSession.delete(theCity);
	}
}
