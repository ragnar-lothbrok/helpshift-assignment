package com.coding.model;

import java.io.Serializable;

/**
 * This class will return search response.
 * 
 * @author raghunandangupta
 *
 */
public class SearchContactResponse implements Serializable, Comparable<SearchContactResponse> {

	private static final long serialVersionUID = 5192977624556428552L;
	private Contact contact;
	private Integer weight = 0;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	/**
	 * Method will arrange contact in decreasing order of the weights
	 */
	public int compareTo(SearchContactResponse o) {
		return this.getWeight().compareTo(o.getWeight());
	}

}
