package org.fiveware.test.service.services.impl;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.fiveware.test.model.entity.Contact;
import org.fiveware.test.model.repository.ContactRepository;
import org.fiveware.test.service.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void createContact(Contact contact) throws Exception {
		if (this.contactExists(contact)) {
			LOGGER.debug("Contact already exists");
			throw new Exception("Contact already exists");
		}
		LOGGER.debug("Save contact contact: " + contact.toString());
		contactRepository.save(contact);

	}

	@Override
	public void deleteContact(Integer id) {
		LOGGER.debug("Deleting contact with id:" + id);
		contactRepository.delete(id);

	}

	@Override
	public void updateContact(Contact contact) throws Exception {
		Contact currentContact = this.getContactById(contact.getId());

		if (currentContact == null) {
			LOGGER.debug("Contact not exists");
			throw new Exception("Contact not exists");
		}

		currentContact.setFirstName(contact.getFirstName());
		currentContact.setLastName(contact.getLastName());
		contactRepository.save(currentContact);

	}

	@Override
	public List<Contact> listAllContact() {
		LOGGER.debug("Listing all contacts");
		return IteratorUtils.toList(contactRepository.findAll().iterator());
	}

	@Override
	public Contact getContactById(Integer id) {
		LOGGER.debug("Get contact with id" + id);
		return contactRepository.findOne(id);
		
	}

	@Override
	public boolean contactExists(Contact contact) {
		Contact exists = contactRepository.findByFirstNameAndLastNameAllIgnoringCase(contact.getFirstName(),
				contact.getLastName());
		return exists == null ? false : true;
	}

}
