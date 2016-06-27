package com.coding.contacts.constants;

public enum Constants {

	DUPLICATE_CONTACT("contact_001", "Contact number is already exists."), INSUFFICIENT_INPPUT("contact_002",
			"Please provide at least 2 characters"), INVALID_CONTACT("contact_003", "Contact number is invalid.");

	private String errorDescription;
	private String errrCode;

	private Constants(String errorCode, String errorDescription) {
		this.errrCode = errorCode;
		this.errorDescription = errorDescription;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public String getErrrCode() {
		return errrCode;
	}

}
