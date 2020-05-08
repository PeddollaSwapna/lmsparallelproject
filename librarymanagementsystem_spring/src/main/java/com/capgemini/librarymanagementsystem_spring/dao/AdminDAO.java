package com.capgemini.librarymanagementsystem_spring.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem_spring.dto.BookDetails;
import com.capgemini.librarymanagementsystem_spring.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_spring.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_spring.dto.UserDetails;

public interface AdminDAO {
	boolean addBook(BookDetails book);
	boolean removeBook(int bookId);
	boolean updateBook(BookDetails book);
	boolean issueBook(int bookId,int userId);
	List<Integer> bookHistoryDetails(int userId);
	List<RequestDetails> showRequests();
	List<BookIssueDetails> showIssuedBooks();
	List<UserDetails> showUsers();
}
