package com.coding.contacts.api.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.coding.contacts.api.TrieContactApi;
import com.coding.model.ModifiedContact;
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

	public void add(String preSufix, ModifiedContact modifiedContact) {
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
				if (i == preSufix.length() - 1 && !tempTrieNode.getContactList().contains(modifiedContact)) {
					tempTrieNode.getContactList().add(modifiedContact);
				}

			}
		}
	}

	/**
	 * This will convert search text to lower case and search in Trie
	 */
	public List<ModifiedContact> search(String searchText) {
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
		return (tempTrieNode != null ? tempTrieNode.getContactList() : new ArrayList<ModifiedContact>(0));
	}

}
