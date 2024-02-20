package com.library.management.exception;
/**
 * @author Debasish Padhy
 *
 */
public class DataNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message){
		super(message);
	}

}
