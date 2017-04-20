package com.webcm.dao;

import java.util.List;

import com.webcm.entity.Contact;
import com.webcm.entity.Sex;

public interface ContactDAO {
	
	public List<Contact> getContacts();

	public void saveContact(Contact saveContact);

	public Contact getContact(long theId);

	public void deleteContact(long theId);

	public void doTest();//obrisati

	//public Sex getSex(long theId);

	public List<Sex> getSexAll();
}
