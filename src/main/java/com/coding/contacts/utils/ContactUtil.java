package com.coding.contacts.utils;

import java.util.ArrayList;
import java.util.List;

import com.coding.contacts.api.impl.TrieContactImpl;
import com.coding.model.Contact;

public class ContactUtil {

	public static void insertIntoTrie(String inputString, Contact contact) {
		if (inputString != null && inputString.length() > 0)
			createPrefix(inputString, contact, false, new ArrayList<String>());

	}

	public static List<Contact> searchIntoTrie(String searchText) {
		return TrieContactImpl.getInstance().search(searchText);
	}

	private static void createPrefix(String inputString, Contact contact, boolean isPrefix, List<String> existingStrings) {
		for (int i = inputString.length(); i > 0; i--) {
			String subString = inputString.substring(0, i);
			if (isPrefix) {
				subString = inputString.substring(0, i - 1);
			} else {
				subString = inputString.substring(0, i);
			}
			if (subString.trim().length() > 0) {
				if (!existingStrings.contains(subString)) {
					TrieContactImpl.getInstance().add(subString, contact);
					existingStrings.add(subString);
				}
				if (isPrefix) {
					createSufix(subString, contact, true, existingStrings);
				} else {
					createSufix(subString, contact, true, existingStrings);
				}
			}
		}
	}

	private static void createSufix(String inputString, Contact contact, boolean isPrefix, List<String> existingStrings) {
		for (int i = 0; i < inputString.length() - 1; i++) {
			String subString = null;
			if (isPrefix) {
				subString = inputString.substring(i + 1, inputString.length());
			} else {
				subString = inputString.substring(i, inputString.length());
			}
			if (subString.trim().length() > 0) {
				if (!existingStrings.contains(subString)) {
					TrieContactImpl.getInstance().add(subString, contact);
					existingStrings.add(subString);
				}
				createPrefix(subString, contact, true, existingStrings);
			}
		}
	}
}
