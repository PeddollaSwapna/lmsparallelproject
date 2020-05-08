package com.capgemini.librarymanagementsystem_spring.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem_spring.dto.BookDetails;
import com.capgemini.librarymanagementsystem_spring.dto.UserDetails;

public interface AdminUserDAO {
	boolean register(UserDetails user);
	UserDetails login(String email,String password);
	List<BookDetails> searchBookById(int bookId);
	List<BookDetails> searchBookByTitle(String bookName);
	List<BookDetails> searchBookByAuthor(String bookAuthor);
	List<BookDetails> getBooksInfo();
	boolean updatePassword(int id,String password,String newPassword,String role);

}
