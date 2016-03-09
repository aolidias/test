package org.fiveware.test.service.services;

import java.util.List;

import org.fiveware.test.model.entity.Contact;

/**
 * 
 * Interface to provides methods for Contact Service
 * @author aolidias
 *
 */
public interface ContactService {
	
	/**
	 * Method to create contact
	 * @param @Contact
	 * @throws Exception
	 */
	void createContact(Contact contact) throws Exception;
	
	/**
	 * Method to delete contact
	 * @param id
	 */
	void deleteContact(Integer id);
	
	/**
	 * Method to delete contact
	 * @param contact
	 * @throws Exception
	 */
	void updateContact(Contact contact) throws Exception ;
	
	/**
	 * Method to list all contacts
	 * @return @Contact
	 */
	List<Contact> listAllContact();
	
	/**
	 * Method to get contact by id
	 * @param id
	 * @return @Contact
	 */
	Contact getContactById(Integer id);
	
	/**
	 * Method to verify if contact exists
	 * @param @Contact
	 * @return boolean
	 */
	boolean contactExists(Contact contact);

}
