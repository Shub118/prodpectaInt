package com.shubham.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EntryException.class)
	public ResponseEntity<ErrorDetails> eehandler(EntryException ee,WebRequest req){ 
		
		return new ResponseEntity<>(new ErrorDetails(ee.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> ehandler(Exception e,WebRequest req){ 
		
		return new ResponseEntity<>(new ErrorDetails(e.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> nhfhandler(NoHandlerFoundException nhe,WebRequest req){ 
		
		return new ResponseEntity<>(new ErrorDetails("No url handler with this link please check url",req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> manhandler(MethodArgumentNotValidException mane,WebRequest req){ 
		
		return new ResponseEntity<>(new ErrorDetails(mane.getMessage(),req.getDescription(false),LocalDateTime.now()),HttpStatus.BAD_REQUEST);
	}
}
