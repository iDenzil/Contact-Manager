package com.webcm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webcm.entity.Country;

/**
 * DAO layer implementation for Country entity
 * 
 * Implementation of the required methods for communication with the database and perfoming all the neccessary operations
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0.1, 14.05.2017.
 *
 */
@Repository
public class CountryDAOImpl implements CountryDAO {

	/**
	 * Injects the session factory when needed. 
	 * 
	 * Sesssion factory is defined ni the hibernate configuration section of the dispatcher servlet
	 */
	@Autowired
	private SessionFactory sessionFactory; 
	
	/**
	 * Retrieves all the Country entries from the database in a List format
	 * 
	 * Retrieves the current session, creates the query and puts the query result list in the return object, the Country list.
	 */
	@Override
	public List<Country> getCountryList() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Country> theQuery = currentSession.createQuery("from Country",Country.class);
		List<Country> countryList = theQuery.getResultList();	
		return countryList;
	}

	/**
	 * Retrieves specified Country object from the database
	 * 
	 * Retrieves the current session and uses Hibernate get() method on the required class object using parameter ID to specify the object. 
	 */
	@Override
	public Country getCountry(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Country theCountry = currentSession.get(Country.class, theId);
		return theCountry;
	}

	/**
	 * Saves the attribute Country into the database
	 * 
	 *  Retrieves the current session and uses Hibernate saveOrUpdate() method on the parameter Country object.
	 *  Both Save and Update on an object called by the controller are processed in this method.
	 *  Hibernate has implemented logic that checks for existing ID, if it exists Update is called, if not Save is called.
	 */
	@Override
	public void saveCountry(Country newCountry) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.clear();												//required for updating. Validation check calls getCoutryList and creates double items in the session
		currentSession.saveOrUpdate(newCountry); 
	}

	/**
	 * Removes the specified Country entry from the database
	 * 
	 * Retrieves the current session, uses Hibernate get() method on the required class object to retrieve the object based on ID and finally removes the entry from the database.
	 *
	 */
	@Override
	public void deleteCountry(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Country theCountry = currentSession.get(Country.class, theId);
		currentSession.delete(theCountry);
	}

}
