package com.capgemini.librarymanagementsystem_spring.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDetails {
	
	private boolean error;
	private String message;
	
	private UserDetails userDetails;
	private BookDetails bookDetails;
	private BookIssueDetails bookIssueDetails;
	private BookBorrowedDetails bookBorrowedDetails;
	private RequestDetails requestDetails;
	
	private List<UserDetails> userDetails1;
	private List<BookDetails> bookDetails1;
	private List<BookIssueDetails> bookIssueDetails1;
	private List<BookBorrowedDetails> bookBorrowedDetails1;
	private List<RequestDetails> requestDetails1;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	public BookDetails getBookDetails() {
		return bookDetails;
	}
	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}
	public BookIssueDetails getBookIssueDetails() {
		return bookIssueDetails;
	}
	public void setBookIssueDetails(BookIssueDetails bookIssueDetails) {
		this.bookIssueDetails = bookIssueDetails;
	}
	public BookBorrowedDetails getBookBorrowedDetails() {
		return bookBorrowedDetails;
	}
	public void setBookBorrowedDetails(BookBorrowedDetails bookBorrowedDetails) {
		this.bookBorrowedDetails = bookBorrowedDetails;
	}
	public RequestDetails getRequestDetails() {
		return requestDetails;
	}
	public void setRequestDetails(RequestDetails requestDetails) {
		this.requestDetails = requestDetails;
	}
	public List<UserDetails> getUserDetails1() {
		return userDetails1;
	}
	public void setUserDetails1(List<UserDetails> userDetails1) {
		this.userDetails1 = userDetails1;
	}
	public List<BookDetails> getBookDetails1() {
		return bookDetails1;
	}
	public void setBookDetails1(List<BookDetails> bookDetails1) {
		this.bookDetails1 = bookDetails1;
	}
	public List<BookIssueDetails> getBookIssueDetails1() {
		return bookIssueDetails1;
	}
	public void setBookIssueDetails1(List<BookIssueDetails> bookIssueDetails1) {
		this.bookIssueDetails1 = bookIssueDetails1;
	}
	public List<BookBorrowedDetails> getBookBorrowedDetails1() {
		return bookBorrowedDetails1;
	}
	public void setBookBorrowedDetails1(List<BookBorrowedDetails> bookBorrowedDetails1) {
		this.bookBorrowedDetails1 = bookBorrowedDetails1;
	}
	public List<RequestDetails> getRequestDetails1() {
		return requestDetails1;
	}
	public void setRequestDetails1(List<RequestDetails> requestDetails1) {
		this.requestDetails1 = requestDetails1;
	}
	
	
	
	
}