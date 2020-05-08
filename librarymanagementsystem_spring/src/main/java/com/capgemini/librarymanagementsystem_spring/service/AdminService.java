package com.capgemini.librarymanagementsystem_spring.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_spring.dto.BookDetails;
import com.capgemini.librarymanagementsystem_spring.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_spring.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_spring.dto.UserDetails;

public interface AdminService {
	boolean addBook(BookDetails book);
	boolean removeBook(int bookId);
	boolean updateBook(BookDetails book);
	boolean issueBook(int bookId,int userId);
	List<Integer> bookHistoryDetails(int userId);
	List<RequestDetails> showRequests();
	List<BookIssueDetails> showIssuedBooks();
	List<UserDetails> showUsers();
}
