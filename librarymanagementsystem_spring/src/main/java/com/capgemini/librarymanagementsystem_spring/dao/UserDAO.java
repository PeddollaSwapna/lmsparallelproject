package com.capgemini.librarymanagementsystem_spring.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem_spring.dto.BookBorrowedDetails;



public interface UserDAO {
	
	
	boolean request(int userId, int bookId);
	List<BookBorrowedDetails> borrowedBook(int userId);
	
	boolean returnBook(int bookId,int userId,String status);
	
	

	

}
	