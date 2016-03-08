package org.fiveware.test.service.services;

import java.util.List;

import org.fiveware.test.model.entity.Contact;

public interface ContactService {
	
	void createContact(Contact contact) throws Exception;
	
	void deleteContact(Integer id);
	
	void updateContact(Contact contact) throws Exception ;
	
	List<Contact> listAllContact();
	
	Contact getContactById(Integer id);
	
	boolean contactExists(Contact contact);

}
