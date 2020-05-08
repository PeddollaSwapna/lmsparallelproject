package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBookDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.UserDetails;
import com.capgemini.librarymanagementsystem_hibernate.factory.LibraryFactory;

public class UserServiceImplementation implements UserService {
	private UserDAO dao = LibraryFactory.getUserDao();
	
	@Override
	public boolean request(int userId, int bookId) {
		return dao.request(userId, bookId);
	}

	@Override
	public List<BorrowedBookDetails> borrowedBook(int userId) {
		return dao.borrowedBook(userId);
	}

	

	

	@Override
	public boolean returnBook(int bookId, int userId, String status) {
		return dao.returnBook(bookId, userId, status);
	}

	

	

		
	

}
