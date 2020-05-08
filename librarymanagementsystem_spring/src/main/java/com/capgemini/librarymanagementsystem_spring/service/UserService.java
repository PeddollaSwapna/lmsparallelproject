package com.capgemini.librarymanagementsystem_spring.service;

import java.util.List;

import com.capgemini.librarymanagementsystem_spring.dto.BookBorrowedDetails;



public interface UserService {
	

	boolean request(int userId, int bookId);
	List<BookBorrowedDetails> borrowedBook(int userId);
	
	boolean returnBook(int bookId,int userId,String status);
	
	

}
