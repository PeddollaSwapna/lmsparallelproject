package com.capgemini.librarymanagementsystem_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem_spring.dao.AdminDAO;
import com.capgemini.librarymanagementsystem_spring.dto.BookDetails;
import com.capgemini.librarymanagementsystem_spring.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_spring.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_spring.dto.UserDetails;

@Service
public class AdminServiceImplementation implements AdminService{
@Autowired
private AdminDAO dao;

@Override
public boolean addBook(BookDetails book) {
	return dao.addBook(book);	
}

@Override
public boolean removeBook(int bookId) {
	return dao.removeBook(bookId);
}

@Override
public boolean updateBook(BookDetails book) {
	return dao.updateBook(book);
}

@Override
public boolean issueBook(int bookId, int userId) {
	return dao.issueBook(bookId, userId);
}

@Override
public List<Integer> bookHistoryDetails(int userId) {
	return dao.bookHistoryDetails(userId);
}

@Override
public List<RequestDetails> showRequests() {
	return dao.showRequests();
}

@Override
public List<BookIssueDetails> showIssuedBooks() {
	return dao.showIssuedBooks();
}

@Override
public List<UserDetails> showUsers() {
	return dao.showUsers();
}

}
