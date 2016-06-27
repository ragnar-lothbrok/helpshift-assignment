package com.coding.contacts.api;

import java.util.List;

import com.coding.contacts.exceptions.ContactException;
import com.coding.model.Contact;

public interface ContactService {

	public void addContact(String firstName, String lastName) throws ContactException;

	public List<Contact> serachContact(String searchText);

}
