package com.capgemini.librarymanagementsystem_spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem_spring.dto.BookBorrowedDetails;
import com.capgemini.librarymanagementsystem_spring.service.UserService;

public class UserServiceTest {
	@Autowired
	private UserService service;
	@Test
	public void testRequestValid() {
		boolean check = service.request(111111, 100000);
		Assertions.assertTrue(check);		
	}
	
	@Test
	public void testRequestInvalid() {
		boolean check = service.request(111111, 100002);
		Assertions.assertFalse(check);		
	}
	
	@Test
	public void testBorrowedBooksValid() {
		List<BookBorrowedDetails> info = service.borrowedBook(111111);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());
	}
	
	@Test
	public void testBorrowedBooksInvalid() {
		List<BookBorrowedDetails> info = service.borrowedBook(111111);
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(6, info.size());
	}
	
	@Test
	public void testReturnBookValid() {
		boolean check = service.returnBook(100000, 111111, "yes");
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testReturnBookInvalid() {
		boolean check = service.returnBook(100000, 111111, "yes");
		Assertions.assertFalse(check);
	}


}
