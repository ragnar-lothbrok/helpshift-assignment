package com.coding.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieNode {

	private HashMap<Character, TrieNode> children;
	private List<ModifiedContact> contactList;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		contactList = new ArrayList<ModifiedContact>();
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

	public List<ModifiedContact> getContactList() {
		return contactList;
	}

	public void setContactList(List<ModifiedContact> contactList) {
		this.contactList = contactList;
	}

}
