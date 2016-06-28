package com.coding.contacts.api.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.coding.contacts.api.TrieContactApi;
import com.coding.model.Contact;
import com.coding.model.TrieNode;

public class TrieContactImpl implements TrieContactApi {

	TrieNode trieNode = new TrieNode();

	private TrieContactImpl() {

	}

	private static class SingletonFactory {
		private static final TrieContactApi INSTANCE = new TrieContactImpl();
	}

	public static TrieContactApi getInstance() {
		return SingletonFactory.INSTANCE;
	}

	public void add(String preSufix, Contact contact) {
		TrieNode tempTrieNode = trieNode;
		if (preSufix != null && preSufix.trim().length() > 0) {
			preSufix = preSufix.toLowerCase();
			for (int i = 0; i < preSufix.length(); i++) {
				if (tempTrieNode.getChildren().get(preSufix.charAt(i)) == null) {
					TrieNode newTrieNode = new TrieNode();
					tempTrieNode.getChildren().put(preSufix.charAt(i), newTrieNode);
					tempTrieNode = newTrieNode;
				} else {
					tempTrieNode = tempTrieNode.getChildren().get(preSufix.charAt(i));
				}
				if (i == preSufix.length() - 1 && !tempTrieNode.getContactList().contains(contact)) {
					tempTrieNode.getContactList().add(contact);
				}

			}
		}
	}

	/**
	 * This will convert search text to lower case and search in Trie
	 */
	public List<Contact> search(String searchText) {
		TrieNode tempTrieNode = trieNode;
		if (tempTrieNode == null || searchText == null || searchText.trim().length() == 0) {
			return Collections.emptyList();
		}
		searchText = searchText.toLowerCase();
		for (int i = 0; i < searchText.length(); i++) {
			if (tempTrieNode.getChildren().get(searchText.charAt(i)) != null) {
				tempTrieNode = tempTrieNode.getChildren().get(searchText.charAt(i));
			} else {
				tempTrieNode = null;
				break;
			}
		}
		return (tempTrieNode != null ? tempTrieNode.getContactList() : new ArrayList<Contact>(0));
	}

}
