package com.lt.exception;

public class ParentKeyNotFoundException extends Exception {
	public String getMessage() {
		return "No such student found";
	}

	
	ParentKeyNotFoundException(String message){
		super(message);
	}
}
