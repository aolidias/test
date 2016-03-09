package org.fiveware.test.model.repository;

import org.fiveware.test.model.entity.Contact;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for Contact
 * @author aolidias
 *
 */
public interface ContactRepository extends CrudRepository<Contact, Integer> {
	
	Contact findByFirstNameAndLastNameAllIgnoringCase(String firstName, String lastName);
}