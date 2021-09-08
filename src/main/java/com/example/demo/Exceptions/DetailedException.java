package com.example.demo.Exceptions;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.Controllers.FriendController;

@ControllerAdvice
public class DetailedException {
	
	Logger logger=LoggerFactory.getLogger(DetailedException.class);
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception,WebRequest request)
	{
		logger.error("Resource Not Found Exception");
		ExceptionDetails ex=new ExceptionDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(ex,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> handleException(APIException exception,WebRequest request)
	{
		logger.error("API Exception");
		ExceptionDetails ex=new ExceptionDetails(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customValidationException(MethodArgumentNotValidException exception)
	{
		logger.warn("Validation Error");
		ExceptionDetails ex=new ExceptionDetails(new Date(),"Validation Error",exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(ex,HttpStatus.BAD_REQUEST);
	}
	
	
}
