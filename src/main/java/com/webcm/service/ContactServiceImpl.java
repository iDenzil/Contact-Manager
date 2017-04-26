package com.webcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webcm.dao.ContactDAO;
import com.webcm.entity.Contact;
import com.webcm.entity.Sex;
/**
 * Service layer implementation for Contact entity
 * 
 * @author Ivor Šoš - <a href="mailto:ivor.sos@gmail.com">ivor.sos@gmail.com</a>
 * @version 1.0, 26.04.2017. 
 */
@Service
public class ContactServiceImpl implements ContactService {

	/**
	 * Injects the DAO layer
	 */
	@Autowired
	private ContactDAO contactDAO;

	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public List<Contact> getContacts() {
		return contactDAO.getContacts();
	}
	
	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public Contact getContact(long theId) {
		return contactDAO.getContact(theId);
	}

	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public void saveContact(Contact newContact) {
		contactDAO.saveContact(newContact);		
	}

	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public void deleteContact(long theId) {
		contactDAO.deleteContact(theId);
	}

	/**
	 * Delegates the request to the DAO layer
	 */
	@Override
	@Transactional
	public List<Sex> getSexList() {
		return contactDAO.getSexList();
	}

}
