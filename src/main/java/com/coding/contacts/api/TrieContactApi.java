package com.coding.contacts.api;

import java.util.List;

import com.coding.model.ModifiedContact;

public interface TrieContactApi {

	public void add(String preSufix, ModifiedContact modifiedContact);
	public List<ModifiedContact> search(String searchText);
}
