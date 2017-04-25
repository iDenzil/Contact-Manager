package com.webcm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webcm.entity.City;
/**
 * DAO layer implementation for City entity
 * 
 * Implementation of the required methods for communication with the database and perfoming all the neccessary operations
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version %I%, %G% 
 *
 */
@Repository
public class CityDAOImpl implements CityDAO {

	/**
	 * Injects the session factory when needed. 
	 * 
	 * Sesssion factory is defined ni the hibernate configuration section of the dispatcher servlet
	 */
	@Autowired
	private SessionFactory sessionFactory; 
	
	/**
	 * Retrieves all the City entries from the database in a List format
	 * 
	 * Retrieves the current session, creates the query and puts the query result list in the return object, the City list.
	 */
	@Override
	public List<City> getCityList() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<City> theQuery = currentSession.createQuery("from City",City.class); 
		List<City> cityList = theQuery.getResultList();
		return cityList;
	}
	
	/**
	 * Retrieves specified City object from the database
	 * 
	 * Retrieves the current session and uses Hibernate get() method on the required class object using parameter ID to specify the object. 
	 */
	@Override
	public City getCity(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		City theCity = currentSession.get(City.class, theId);
		return theCity;
	}

	/**
	 * Saves the attribute City into the database
	 * 
	 *  Retrieves the current session and uses Hibernate saveOrUpdate() method on the parameter City object.
	 *  Both Save and Update on an object called by the controller are processed in this method.
	 *  Hibernate has implemented logic that checks for existing ID, if it exists Update is called, if not Save is called.
	 */
	@Override
	public void saveCity(City saveCity) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(saveCity); 
	}
	
	/**
	 * Removes the specified City entry from the database
	 * 
	 * Retrieves the current session, uses Hibernate get() method on the required class object to retrieve the object based on ID and finally removes the entry from the database.
	 *
	 */
	@Override
	public void deleteCity(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		City theCity = currentSession.get(City.class, theId);
		currentSession.delete(theCity);
	}
}
