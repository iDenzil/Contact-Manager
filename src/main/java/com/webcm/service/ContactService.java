package com.webcm.service;

import java.util.List;

import com.webcm.entity.Contact;
import com.webcm.entity.Sex;
/**
 * Service layer interface for Contact entity
 * 
 * Implements the business logic between the controller and the DAO layer.
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version %I%, %G% 
 *
 */
public interface ContactService {
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
	 * Saves the attribute Contact into the databse
	 * 
	 * @param saveContact	The Contact object that needs to be saved
	 */
	public void saveContact(Contact saveContact);
	
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
