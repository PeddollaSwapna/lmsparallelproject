package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.UserDetails;

public interface AdminService {
	boolean addBook(BookDetails book);
	boolean removeBook(int bId);
	boolean updateBook(BookDetails book);
	boolean issueBook(int bId,int uId);
	List<BookIssueDetails> bookHistoryDetails(int uId);
	List<RequestDetails> showRequests();
	List<BookIssueDetails> showIssuedBooks();
	List<UserDetails> showUsers();


}
