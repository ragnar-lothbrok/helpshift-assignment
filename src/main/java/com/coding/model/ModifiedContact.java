package com.coding.model;

public class ModifiedContact extends Contact {

	private static final long serialVersionUID = 1L;

	private Integer weight;

	public ModifiedContact(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
