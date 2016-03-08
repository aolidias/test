package org.fiveware.test.web.controller;


import java.util.List;

import org.fiveware.test.model.entity.Contact;
import org.fiveware.test.service.services.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactController.class);
	
	 @RequestMapping(value = "/api/v1/contact", method = RequestMethod.GET)
	    public ResponseEntity<List<Contact>> listAllContacts() {
	        List<Contact> contacts = contactService.listAllContact();
	        if(contacts.isEmpty()){
	        	LOGGER.debug("No contact found");
	            return new ResponseEntity<List<Contact>>(HttpStatus.NO_CONTENT);
	        }
	        return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
	    }
	     
	    @RequestMapping(value = "/api/v1/contact/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<Contact> getContact(@PathVariable("id") Integer id) {
	    	LOGGER.debug("Fetching Contact with id " + id);
	        Contact contact = contactService.getContactById(id);
	        if (contact == null) {
	        	LOGGER.debug("Contact with id " + id + " not found");
	            return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	    }
	 
	    @RequestMapping(value = "/api/v1/contact/", method = RequestMethod.POST)
	    public ResponseEntity<Void> createContact(@RequestBody Contact contact, UriComponentsBuilder ucBuilder) throws Exception {
	    	LOGGER.debug("Creating Contact " + contact.getFirstName());
	 
	        contactService.createContact(contact);
	 
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/api/v1/contact/{id}").buildAndExpand(contact.getId()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	     
	    @RequestMapping(value = "/api/v1/contact/{id}", method = RequestMethod.PUT)
	    public ResponseEntity<Contact> updateContact(@PathVariable("id") Integer id, @RequestBody Contact contact) throws Exception {
	    	LOGGER.debug("Updating Contact " + id);
	         
	        contactService.updateContact(contact);
	        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	    }
	 
	     
	    @RequestMapping(value = "/api/v1/contact/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<Contact> deleteContact(@PathVariable("id") Integer id) {
	    	LOGGER.debug("Fetching & Deleting Contact with id " + id);
	 
	        contactService.deleteContact(id);
	        return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
	    }
	 

}
