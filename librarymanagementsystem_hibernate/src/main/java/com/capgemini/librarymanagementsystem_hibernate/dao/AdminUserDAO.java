package com.capgemini.librarymanagementsystem_hibernate.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem_hibernate.dto.BookDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.UserDetails;


public interface AdminUserDAO {
	boolean register(UserDetails user);
	UserDetails login(String email,String password);
	List<BookDetails> searchBookById(int bookId);
	List<BookDetails> searchBookByTitle(String bookName);
	List<BookDetails> searchBookByAuthor(String bookAuthor);
	List<BookDetails> getBooksInfo();
	boolean updatePassword(String email,String password,String newPassword,String role);

}
