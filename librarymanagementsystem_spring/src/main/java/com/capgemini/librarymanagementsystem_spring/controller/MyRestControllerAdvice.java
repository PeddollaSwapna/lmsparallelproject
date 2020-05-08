package com.capgemini.librarymanagementsystem_spring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.librarymanagementsystem_spring.dto.ResponseDetails;
import com.capgemini.librarymanagementsystem_spring.exception.LMSException;


@RestControllerAdvice
public class MyRestControllerAdvice {

	@ExceptionHandler
	public ResponseDetails myExceptionHandler(LMSException lmsException) {
		ResponseDetails response = new ResponseDetails();
		response.setError(true);
		response.setMessage(lmsException.getMessage());
		return response;
	}
}
