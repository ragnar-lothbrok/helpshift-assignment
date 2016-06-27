package com.coding.contacts.exceptions;

import com.coding.contacts.constants.Constants;

/**
 * This class will be used to throw any exception if we get while performing
 * adding/searching contacts.
 * 
 * @author raghunandangupta
 *
 */
public class ContactException extends Exception {

	private static final long serialVersionUID = -8411950055365919467L;

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	public ContactException(Constants constants) {
		super(constants.getErrrCode()+":"+constants.getErrorDescription());
	}
}
