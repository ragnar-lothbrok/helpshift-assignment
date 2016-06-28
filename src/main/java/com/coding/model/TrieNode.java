package com.coding.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieNode {

	private HashMap<Character, TrieNode> children;
	private List<Contact> contactList;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		contactList = new ArrayList<Contact>();
	}

	public HashMap<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(HashMap<Character, TrieNode> children) {
		this.children = children;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

}
