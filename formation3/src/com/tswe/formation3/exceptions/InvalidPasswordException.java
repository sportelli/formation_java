package com.tswe.formation3.exceptions;

public class InvalidPasswordException extends Exception {

	public InvalidPasswordException(){
		super();
	}
	
	public InvalidPasswordException(String message){
		super(message);
	}
	
}
