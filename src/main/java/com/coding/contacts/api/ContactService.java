package com.coding.contacts.api;

import java.util.List;

import com.coding.contacts.exceptions.ContactException;
import com.coding.model.Contact;

/**
 * This service will add and search contact.
 * @author raghunandangupta
 *
 */
public interface ContactService {

	/**
	 * Adding contact to contact list.
	 * @param firstName
	 * @param lastName
	 * @throws ContactException
	 */
	public void addContact(String firstName, String lastName) throws ContactException;

	/**
	 * Searching data from contact List
	 * @param searchText
	 * @return
	 */
	public List<Contact> serachContact(String searchText);

}
