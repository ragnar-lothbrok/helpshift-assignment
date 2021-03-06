package com.coding.contacts.api.impl;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.coding.contacts.api.ContactService;
import com.coding.contacts.constants.Constants;
import com.coding.contacts.exceptions.ContactException;
import com.coding.contacts.utils.ContactUtil;
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
			exception = new ContactException(Constants.INVALID_CONTACT);
		}
		if (exception == null) {
			Contact contact = new Contact(firstName, lastName);
			if (!contactList.contains(contact)) {
				contactList.add(contact);
				ContactUtil.insertIntoTrie(firstName, contact);
				ContactUtil.insertIntoTrie(lastName, contact);
				return;
			}
			exception = new ContactException(Constants.DUPLICATE_CONTACT);
		}
		if (exception != null) {
			throw exception;
		}
	}

	public List<Contact> serachContact(final String searchText) {
		List<Contact> contactList = ContactUtil.searchIntoTrie(searchText);
		
		/**
		 * Here we are comparing relative distance from the search text.
		 * if equals we are returning small length contact first.
		 */
		contactList.sort(new Comparator<Contact>() {
			public int compare(Contact o1, Contact o2) {
				String firstCompleteName = o1.getFirstName() + (o1.getLastName() == null ? "" : " " + o1.getLastName());
				String secondCompleteName = o2.getFirstName() + (o2.getLastName() == null ? "" : " " + o2.getLastName());
				firstCompleteName = firstCompleteName.toLowerCase();
				secondCompleteName = secondCompleteName.toLowerCase();
				Integer num1 = firstCompleteName.indexOf(searchText);
				Integer num2 = secondCompleteName.indexOf(searchText);
				if (num1 == num2) {
					if (firstCompleteName.length() > secondCompleteName.length())
						return 1;
					else
						return -1;
				}
				return (num1.compareTo(num2));
			}
		});
		return contactList;
	}

}
