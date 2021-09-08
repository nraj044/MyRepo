package com.example.demo.Exceptions;

public class APIException extends RuntimeException{
	
	public APIException()
	{
		
	}
	
	public APIException(String msg)
	{
		super(msg);
	}

}
