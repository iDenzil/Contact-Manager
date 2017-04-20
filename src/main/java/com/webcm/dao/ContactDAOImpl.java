package com.webcm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webcm.entity.Contact;
import com.webcm.entity.Sex;

@Repository
public class ContactDAOImpl implements ContactDAO {

	// inject session factory
	@Autowired
	private SessionFactory sessionFactory; //this is the sessionFactory defined in the hibernate configuration in dispatcher-servlet.xml
	
	@Override
	public List<Contact> getContacts() {
		
		//get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();// System.out.println("got session");
		//create query
		Query<Contact> theQuery = currentSession.createQuery
									("from Contact order by lastName",Contact.class); //System.out.println("finished query");
		// execute query
		List<Contact> contacts = theQuery.getResultList();// System.out.println("got result list");
		//return the result
		return contacts;
	}

	@Override
	public void saveContact(Contact saveContact) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		// save contact
		currentSession.saveOrUpdate(saveContact);
	}

	@Override
	public Contact getContact(long theId) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		//get the contact based on ID from DB
		Contact theContact = currentSession.get(Contact.class, theId);
		// save contact
		return theContact;
	}

	@Override
	public void deleteContact(long theId) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		//retrieve the contact using ID
		Contact theContact = currentSession.get(Contact.class, theId);
		//delete the contact
		currentSession.delete(theContact);
	}

	@Override
	public void doTest() {}/*
		// obrisati
		long theId=1;
		Session currentSession = sessionFactory.getCurrentSession(); System.out.println("Got the session");
		Sex s = currentSession.get(Sex.class, theId);
		
		Contact testContact = new Contact("8Test", "8Brisanja", "8Phone2", "8Email2", 1, 1);  System.out.println("Kreiro testContact");
		currentSession.save(testContact);  System.out.println("Save kontakta u bazu");
		
	}*/
/*
	@Override
	public Sex getSex(long theId) {
		// get current session
		Session currentSession = sessionFactory.getCurrentSession();
		//get the contact based on ID from DB
		Sex theSex = currentSession.get(Sex.class, theId);
		// save contact
		return theSex;
	}
*/
	@Override
	public List<Sex> getSexAll() {
		//get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();// System.out.println("got session");
		//create query
		Query<Sex> theQuery = currentSession.createQuery
									("from Sex",Sex.class); //System.out.println("finished query");
		// execute query
		List<Sex> sexAll = theQuery.getResultList();// System.out.println("got result list");
		//return the result
		return sexAll;
	}

}
