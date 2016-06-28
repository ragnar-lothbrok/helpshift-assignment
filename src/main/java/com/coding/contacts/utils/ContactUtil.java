package com.coding.contacts.utils;

import java.util.ArrayList;
import java.util.List;

import com.coding.contacts.api.impl.TrieContactImpl;
import com.coding.model.ModifiedContact;

public class ContactUtil {

	public static void insertIntoTrie(String inputString, ModifiedContact modifiedContact) {
		if (inputString != null && inputString.length() > 0)
			createPrefix(inputString, modifiedContact, false, new ArrayList<String>());

	}

	public static List<ModifiedContact> searchIntoTrie(String searchText) {
		return TrieContactImpl.getInstance().search(searchText);
	}

	private static void createPrefix(String inputString, ModifiedContact modifiedContact, boolean isPrefix, List<String> existingStrings) {
		for (int i = inputString.length(); i > 0; i--) {
			String subString = inputString.substring(0, i);
			if (isPrefix) {
				subString = inputString.substring(0, i - 1);
			} else {
				subString = inputString.substring(0, i);
			}
			if (subString.trim().length() > 0) {
				if (!existingStrings.contains(subString)) {
					TrieContactImpl.getInstance().add(subString, modifiedContact);
					existingStrings.add(subString);
				}
				if (isPrefix) {
					createSufix(subString, modifiedContact, true, existingStrings);
				} else {
					createSufix(subString, modifiedContact, true, existingStrings);
				}
			}
		}
	}

	private static void createSufix(String inputString, ModifiedContact modifiedContact, boolean isPrefix, List<String> existingStrings) {
		for (int i = 0; i < inputString.length() - 1; i++) {
			String subString = null;
			if (isPrefix) {
				subString = inputString.substring(i + 1, inputString.length());
			} else {
				subString = inputString.substring(i, inputString.length());
			}
			if (subString.trim().length() > 0) {
				if (!existingStrings.contains(subString)) {
					TrieContactImpl.getInstance().add(subString, modifiedContact);
					existingStrings.add(subString);
				}
				createPrefix(subString, modifiedContact, true, existingStrings);
			}
		}
	}
}
