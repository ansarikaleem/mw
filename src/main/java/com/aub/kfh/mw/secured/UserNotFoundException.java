package com.aub.kfh.mw.secured;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String string) {
		System.out.println("Exception: " + string);
	}

}
