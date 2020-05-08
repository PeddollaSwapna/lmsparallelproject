package com.capgemini.librarymanagementsystem_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem_spring.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystem_spring.dto.BookDetails;
import com.capgemini.librarymanagementsystem_spring.dto.UserDetails;

@Service
public class AdminUserServiceImplementation implements AdminUserDAO{
@Autowired
private AdminUserDAO dao;

@Override
public boolean register(UserDetails user) {
	return dao.register(user);
}

@Override
public UserDetails login(String email, String password) {
	return dao.login(email, password);
}

@Override
public List<BookDetails> searchBookById(int bookId) {
	return dao.searchBookById(bookId);
}

@Override
public List<BookDetails> searchBookByTitle(String bookName) {
	return dao.searchBookByTitle(bookName);
}

@Override
public List<BookDetails> searchBookByAuthor(String bookAuthor) {
	return dao.searchBookByAuthor(bookAuthor);
}

@Override
public List<BookDetails> getBooksInfo() {
	return dao.getBooksInfo();
}

@Override
public boolean updatePassword(int id, String password, String newPassword, String role) {
	return dao.updatePassword(id, password, newPassword, role);
}


}
