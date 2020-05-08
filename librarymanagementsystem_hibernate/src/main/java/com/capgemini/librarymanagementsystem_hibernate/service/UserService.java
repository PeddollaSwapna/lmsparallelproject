package com.capgemini.librarymanagementsystem_hibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBookDetails;


public interface UserService {
	
	boolean request(int userId, int bookId);
	List<BorrowedBookDetails> borrowedBook(int userId);
	
	boolean returnBook(int bookId,int userId,String status);
	
}
