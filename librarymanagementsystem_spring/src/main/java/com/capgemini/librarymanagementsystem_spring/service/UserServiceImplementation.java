package com.capgemini.librarymanagementsystem_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem_spring.dao.UserDAO;
import com.capgemini.librarymanagementsystem_spring.dto.BookBorrowedDetails;
import com.capgemini.librarymanagementsystem_spring.dto.BookDetails;
import com.capgemini.librarymanagementsystem_spring.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_spring.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_spring.dto.UserDetails;
@Service
public class UserServiceImplementation implements UserService{
	@Autowired
	private UserDAO dao;
	

	@Override
	public boolean request(int userId, int bookId) {
		return dao.request(userId, bookId);
	}

	@Override
	public List<BookBorrowedDetails> borrowedBook(int userId) {
		return dao.borrowedBook(userId);
	}

	
	@Override
	public boolean returnBook(int bookId, int userId, String status) {
		return dao.returnBook(bookId, userId, status);
	}

	

	
	
}
