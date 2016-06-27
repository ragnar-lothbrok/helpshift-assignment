package com.coding.contacts.api.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.coding.contacts.api.ContactService;
import com.coding.contacts.constants.Constants;
import com.coding.contacts.exceptions.ContactException;
import com.coding.model.Contact;

public class ContactServiceImpl implements ContactService {

	/**
	 * For persistent we can use MySQL or Mongo Database but here I am assuming
	 * we already have that. Also for execution of the program you won't be
	 * needing anything except JVM.
	 */
	private List<Contact> contactList = null;

	/**
	 * Will not be created from outside the class. This is service class so
	 * don't need to have multiple instances.
	 */
	private ContactServiceImpl() {
		/**
		 * This is already thread safe.
		 */
		contactList = new CopyOnWriteArrayList<Contact>();
	}

	/**
	 * Inner static class is added to avoid multithreading related issue.
	 * 
	 * @return
	 */
	private static class SingletonFactory {
		private static final ContactService INSTANCE = new ContactServiceImpl();
	}

	public static ContactService getInstance() {
		return SingletonFactory.INSTANCE;
	}

	public void addContact(String firstName, String lastName) throws ContactException {
		ContactException exception = null;

		firstName = (firstName != null && firstName.trim().length() == 0) ? null : firstName;
		lastName = (lastName != null && lastName.trim().length() == 0) ? null : lastName;
		if ((firstName == null && lastName == null) || (firstName.trim().length() == 0 && lastName.trim().length() == 0)) {
			exception = new ContactException(Constants.DUPLICATE_CONTACT);
		}
		if (exception == null) {
			Contact contact = new Contact(firstName, lastName);
			if (!contactList.contains(contact)) {
				contactList.add(contact);
				return;
			}
			exception = new ContactException(Constants.INVALID_CONTACT);
		}
		if (exception != null) {
			throw exception;
		}
	}

	public List<Contact> serachContact(String searchText) {
		return null;
	}

}
