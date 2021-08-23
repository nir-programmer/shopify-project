package org.nir.shopify.admin;

public class UserNotFoundException extends Exception 
{

	public UserNotFoundException(String message) {
		super(message);
	}

}