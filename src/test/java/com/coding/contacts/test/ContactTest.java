package com.coding.contacts.test;

import java.util.List;

import org.junit.Test;

import com.coding.contacts.api.impl.ContactServiceImpl;
import com.coding.contacts.exceptions.ContactException;
import com.coding.model.Contact;

/**
 * Various Test cases handled
 * @author raghunandangupta
 *
 */
public class ContactTest {

	static {
		try {
			ContactServiceImpl.getInstance().addContact("Chris", "morris");
			ContactServiceImpl.getInstance().addContact("Ben", "morrision");
			ContactServiceImpl.getInstance().addContact("morris", "chris");
			ContactServiceImpl.getInstance().addContact("Chris", "");
			ContactServiceImpl.getInstance().addContact("Chris", "homes");
		} catch (ContactException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void search1() {
		String searchText = "chris";
		System.out.println("inside search1==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact("chris");
		if (searchedContactList.size() == 0) {
			System.out.println("No Matches Found");
		} else {
			for (Contact modifiedContact : searchedContactList) {
				System.out
						.println(modifiedContact.getFirstName() + " " + (modifiedContact.getLastName() == null ? "" : modifiedContact.getLastName()));
			}
		}
	}

	@Test
	public void search3() {
		String searchText = "morris";
		System.out.println("inside search3==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact(searchText);
		if (searchedContactList.size() == 0) {
			System.out.println("No Matches Found");
		} else {
			for (Contact modifiedContact : searchedContactList) {
				System.out
						.println(modifiedContact.getFirstName() + " " + (modifiedContact.getLastName() == null ? "" : modifiedContact.getLastName()));
			}
		}
	}

	@Test
	public void search2() {
		String searchText = "chriss";
		System.out.println("inside search2==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact(searchText);
		if (searchedContactList.size() == 0) {
			System.out.println("No Matches Found");
		} else {
			for (Contact modifiedContact : searchedContactList) {
				System.out
						.println(modifiedContact.getFirstName() + " " + (modifiedContact.getLastName() == null ? "" : modifiedContact.getLastName()));
			}
		}
	}

	@Test
	public void search4() {
		String searchText = "ris";
		System.out.println("inside search2==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact(searchText);
		if (searchedContactList.size() == 0) {
			System.out.println("No Matches Found");
		} else {
			for (Contact modifiedContact : searchedContactList) {
				System.out
						.println(modifiedContact.getFirstName() + " " + (modifiedContact.getLastName() == null ? "" : modifiedContact.getLastName()));
			}
		}
	}
}
