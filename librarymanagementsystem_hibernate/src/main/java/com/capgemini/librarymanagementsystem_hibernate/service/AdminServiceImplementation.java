package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dao.AdminDAO;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.UserDetails;
import com.capgemini.librarymanagementsystem_hibernate.factory.LibraryFactory;

public class AdminServiceImplementation implements AdminService{
	private AdminDAO dao = LibraryFactory.getAdminsDao();

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
