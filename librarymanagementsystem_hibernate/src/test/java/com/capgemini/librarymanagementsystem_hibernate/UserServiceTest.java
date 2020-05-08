package com.capgemini.librarymanagementsystem_hibernate;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBookDetails;
import com.capgemini.librarymanagementsystem_hibernate.service.UserService;
import com.capgemini.librarymanagementsystem_hibernate.service.UserServiceImplementation;

public class UserServiceTest {
	private UserService service = new UserServiceImplementation();
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
		List<BorrowedBookDetails> info = service.borrowedBook(111111);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());
	}
	
	@Test
	public void testBorrowedBooksInvalid() {
		List<BorrowedBookDetails> info = service.borrowedBook(111111);
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
