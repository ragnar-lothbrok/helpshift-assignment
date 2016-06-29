package com.coding.contacts.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.coding.contacts.api.impl.ContactServiceImpl;
import com.coding.contacts.exceptions.ContactException;
import com.coding.model.Contact;

/**
 * Various Test cases handled
 * 
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
			ContactServiceImpl.getInstance().addContact("Chris", "Ben");
		} catch (ContactException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void search1() {
		String searchText = "chris";
		System.out.println("inside search1==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact("chris");
		assertEquals("Chris", searchedContactList.get(0).getFirstName());
	}

	@Test
	public void search3() {
		String searchText = "morris";
		System.out.println("inside search3==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact(searchText);
		assertEquals("morris", searchedContactList.get(0).getFirstName());
	}

	@Test
	public void search2() {
		String searchText = "chriss";
		System.out.println("inside search2==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact(searchText);
		assertEquals(0, searchedContactList.size());
	}

	@Test
	public void search4() {
		String searchText = "ris";
		System.out.println("inside search4==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact(searchText);
		assertEquals("Chris", searchedContactList.get(0).getFirstName());
	}

	@Test
	public void search5() {
		String searchText = "c";
		System.out.println("inside search5==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact(searchText);
		assertEquals("Chris", searchedContactList.get(0).getFirstName());
	}

	@Test
	public void search6() {
		String searchText = "m";
		System.out.println("inside search5==== Search Text : " + searchText);
		List<Contact> searchedContactList = ContactServiceImpl.getInstance().serachContact(searchText);
		assertEquals("morris", searchedContactList.get(0).getFirstName());
	}
}
