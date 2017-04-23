package com.webcm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webcm.dao.ContactDAO;
import com.webcm.entity.Contact;
import com.webcm.entity.Sex;

@Service
public class ContactServiceImpl implements ContactService {

	//need to inject DAO
	@Autowired
	private ContactDAO contactDAO;

	
	@Override
	@Transactional
	public List<Contact> getContacts() {
		return contactDAO.getContacts();
	}


	@Override
	@Transactional
	public void saveContact(Contact saveContact) {
		contactDAO.saveContact(saveContact);		
	}

	@Override
	@Transactional
	public Contact getContact(long theId) {
		return contactDAO.getContact(theId);
	}


	@Override
	@Transactional
	public void deleteContact(long theId) {
		contactDAO.deleteContact(theId);
	}


	@Override
	@Transactional
	public void doTest() {
		// obrisati
		contactDAO.doTest();
	}
/*
	@Override
	@Transactional
	public Sex getSex(long theId) {
		return contactDAO.getSex(theId);
	}
*/

	@Override
	@Transactional
	public List<Sex> getSexList() {
		return contactDAO.getSexList();
	}

}
