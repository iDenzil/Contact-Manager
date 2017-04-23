package com.webcm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webcm.entity.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory; //this is the sessionFactory defined in the hibernate configuration in dispatcher-servlet.xml
	
	@Override
	public List<Country> getCountryList() {
		Session currentSession = sessionFactory.getCurrentSession();// System.out.println("got session");
		Query<Country> theQuery = currentSession.createQuery("from Country",Country.class); //System.out.println("finished query");
		List<Country> countryList = theQuery.getResultList();// System.out.println("got result list");
		return countryList;
	}

	@Override
	public Country getCountry(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Country theCountry = currentSession.get(Country.class, theId);
		return theCountry;
	}

	@Override
	public void saveCountry(Country saveCountry) {
		Session currentSession = sessionFactory.getCurrentSession();System.out.println("Session gotten");
		currentSession.saveOrUpdate(saveCountry); System.out.println("saved or updated");
	}

	@Override
	public void deleteCountry(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Country theCountry = currentSession.get(Country.class, theId);
		currentSession.delete(theCountry);
	}

}
