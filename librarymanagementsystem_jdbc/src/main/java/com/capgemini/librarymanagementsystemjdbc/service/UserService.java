package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooks;

public interface UserService {
	
	boolean request(int uId, int bId);
	List<BorrowedBooks> borrowedBook(int uId);
	
	boolean returnBook(int bId,int uId,String status);
	
}
