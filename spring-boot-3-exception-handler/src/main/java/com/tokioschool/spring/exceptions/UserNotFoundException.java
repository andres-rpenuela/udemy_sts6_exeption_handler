package com.tokioschool.spring.exceptions;

public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(Throwable e) {
		super(e);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
