package com.capgemini.librarymanagementsystem_hibernate.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.librarymanagementsystem_hibernate.exception.LMSException;


public class Validation {
	
	public boolean validatedId(int id) throws LMSException {
		String idRegEx = "[0-9]{1}[0-9]{3}" ;
		boolean result = false;
		if (Pattern.matches(idRegEx, String.valueOf(id))) {
			result = true;
		} else {
			throw new LMSException("Invalid Id! Id should contain atleast 4 digits");
		}
		return result;
	}
		
	public boolean validatedName(String name) throws LMSException {
		String nameRegEx = "^(?=.{3,20}$)(?![.-])(?!.*[.]{2})[a-zA-Z.-]+(?<![_.-])";
	//	String nameRegEx = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$" ;
		boolean result = false;
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new LMSException("Invalid Name! Name should have atleast 3 characters");
		}
		return result;
	}
		
	public boolean validatedMobile(long mobile) throws LMSException {
		String mobileRegEx = "(0/91)?[6-9][0-9]{9}" ;
		boolean result = false;
		if (Pattern.matches(mobileRegEx, String.valueOf(mobile))) {
			result = true;
		} else {
			throw new LMSException("Enter a mobile number whose length is 10 digits and should start with 6,7,8,9 digits only");
		}
		return result;
	}
		
	public boolean validatedEmail(String email) throws LMSException {
		//String emailRegEx = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		String emailRegEx = "^[a-z0-9](\\.?[a-z0-9]){5,}@g(oogle)?mail\\.(com|org)";
		boolean result = false;
		Pattern pattern = Pattern.compile(emailRegEx);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			result = true;
		} else {
			throw new LMSException("Enter proper email such that it should consist of numbers and alphabets");
		}
		return result;
	}
		
	public boolean validatedPassword(String password) throws LMSException {
		String passwordRegEx = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})" ;
		boolean result = false;
		if (Pattern.matches(passwordRegEx, String.valueOf(password))) { 
			result = true;
		} else {
			throw new LMSException("Password should contain atleast 8 characters ,one uppercase,one lowercase,one symbol"); 
		}
		return result;
	}
}