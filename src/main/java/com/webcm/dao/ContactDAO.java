package com.webcm.dao;

import java.util.List;

import com.webcm.entity.Contact;
import com.webcm.entity.Sex;

/**
 * DAO layer interface for Contact entity
 * 
 * Communicates with the database and performs required operations on the database 
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0, 26.04.2017. 
 *
 */
public interface ContactDAO {
	
	/**
	 * Retrieves all the Contact entries from the database in a List format
	 * 
	 * @return	The List of Contact objects.
	 */
	public List<Contact> getContacts();

	/**
	 * Retrieves specified Contact object from the database
	 * 
	 * @param theId	ID for the required Contact
	 * @return		The requested Contact object
	 */
	public Contact getContact(long theId);
	
	/**
	 * Saves the attribute Contact into the database
	 * 
	 * @param newContact	The Contact object that needs to be saved
	 */
	public void saveContact(Contact newContact);
	
	/**
	 * Removes the specified Contact entry from the database
	 * 
	 * @param theId	ID of the Contact object to be deleted
	 */
	public void deleteContact(long theId);

	/**
	 * Retrieves all the Sex entries from the database in a List format
	 * 
	 * @return	The List of Sex objects
	 */
	public List<Sex> getSexList();

}
