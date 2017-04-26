package com.webcm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webcm.entity.Contact;
import com.webcm.entity.Sex;

/**
 * DAO layer implementation for Contact entity
 * 
 * Implementation of the required methods for communication with the database and perfoming all the neccessary operations
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0, 26.04.2017. 
 *
 */
@Repository
public class ContactDAOImpl implements ContactDAO {

	/**
	 * Injects the session factory when needed. 
	 * 
	 * Sesssion factory is defined ni the hibernate configuration section of the dispatcher servlet
	 */
	@Autowired
	private SessionFactory sessionFactory; 
	
	/**
	 * Retrieves all the Contact entries from the database in a List format
	 * 
	 * Retrieves the current session, creates the query and puts the query result list in the return object, the Contact list.
	 */
	@Override
	public List<Contact> getContacts() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Contact> theQuery = currentSession.createQuery("from Contact order by lastName",Contact.class);
		List<Contact> contacts = theQuery.getResultList();
		return contacts;
	}

	/**
	 * Retrieves specified Contact object from the database
	 * 
	 * Retrieves the current session and uses Hibernate get() method on the required class object using parameter ID to specify the object. 
	 */
	@Override
	public Contact getContact(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Contact theContact = currentSession.get(Contact.class, theId);
		return theContact;
	}

	/**
	 * Saves the attribute Contact into the database
	 * 
	 *  Retrieves the current session and uses Hibernate saveOrUpdate() method on the parameter Contact object.
	 *  Both Save and Update on an object called by the controller are processed in this method.
	 *  Hibernate has implemented logic that checks for existing ID, if it exists Update is called, if not Save is called.
	 */
	@Override
	public void saveContact(Contact newContact) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(newContact);
	}

	/**
	 * Removes the specified Contact entry from the database
	 * 
	 * Retrieves the current session, uses Hibernate get() method on the required class object to retrieve the object based on ID and finally removes the entry from the database.
	 *
	 */
	@Override
	public void deleteContact(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Contact theContact = currentSession.get(Contact.class, theId);
		currentSession.delete(theContact);
	}

	/**
	 * Retrieves all the Sex entries from the database in a List format
	 * 
	 * Retrieves the current session, creates the query and puts the query result list in the return object, the Sex list.
	 */
	@Override
	public List<Sex> getSexList() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Sex> theQuery = currentSession.createQuery("from Sex",Sex.class); 
		List<Sex> sexList = theQuery.getResultList();
		return sexList;
	}

}
