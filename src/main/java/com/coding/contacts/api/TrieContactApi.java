package com.coding.contacts.api;

import java.util.List;

import com.coding.model.Contact;

/**
 * This will add and search contact from Trie
 * 
 * @author raghunandangupta
 *
 */
public interface TrieContactApi {

	/**
	 * Adding search data to Trie.
	 * 
	 * @param preSufix
	 * @param modifiedContact
	 */
	public void add(String preSufix, Contact modifiedContact);

	/**
	 * Searching data from Trie
	 * 
	 * @param searchText
	 * @return
	 */
	public List<Contact> search(String searchText);
}
