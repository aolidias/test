package org.fiveware.test.model;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.fiveware.test.model.config.ModelTestApplicationConfig;
import org.fiveware.test.model.entity.Contact;
import org.fiveware.test.model.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ModelTestApplicationConfig.class)
public class ContactRepositoryTest {

	@Autowired
	ContactRepository contactRepository;
	

	@Test
	public void testInsert() {
		Contact contact = new Contact("Aline", "Dias");
		contact.setFavoriteMonth("May");
		contact.setSingle(true);
		contact.setSex("Male");
		contact = contactRepository.save(contact);
		Iterable<Contact> result = contactRepository.findAll();
		List<Contact> listContact = IteratorUtils.toList(result.iterator());
		Assert.assertEquals(listContact.size(), 1);

	}


}
