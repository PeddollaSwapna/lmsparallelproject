package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dto.BookDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.UserDetails;

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
