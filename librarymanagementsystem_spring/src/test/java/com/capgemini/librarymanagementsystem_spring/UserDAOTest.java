package com.capgemini.librarymanagementsystem_spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem_spring.dao.UserDAO;
import com.capgemini.librarymanagementsystem_spring.dto.BookBorrowedDetails;

public class UserDAOTest {
	@Autowired
	private UserDAO dao;
	@Test
	public void testRequestValid() {
		boolean check = dao.request(111111, 100000);
		Assertions.assertTrue(check);		
	}
	
	@Test
	public void testRequestInvalid() {
		boolean check = dao.request(111111, 100002);
		Assertions.assertFalse(check);		
	}
	
	@Test
	public void testBorrowedBooksValid() {
		List<BookBorrowedDetails> info = dao.borrowedBook(111111);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());
	}
	
	@Test
	public void testBorrowedBooksInvalid() {
		List<BookBorrowedDetails> info = dao.borrowedBook(111111);
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(6, info.size());
	}
	
	@Test
	public void testReturnBookValid() {
		boolean check = dao.returnBook(100000, 111111, "yes");
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testReturnBookInvalid() {
		boolean check = dao.returnBook(100000, 111111, "yes");
		Assertions.assertFalse(check);
	}


}
