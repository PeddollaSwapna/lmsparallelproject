package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.UserDetails;

public interface AdminUserService {
	boolean register(UserDetails user);
	UserDetails login(String email,String password);
	List<BookDetails> searchBookById(int bookId);
	List<BookDetails> searchBookByTitle(String bookName);
	List<BookDetails> searchBookByAuthor(String bookAuthor);
	List<BookDetails> getBooksInfo();
	boolean updatePassword(String email,String password,String newPassword,String role);

}
