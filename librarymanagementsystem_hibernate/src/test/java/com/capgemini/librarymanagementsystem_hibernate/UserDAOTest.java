package com.capgemini.librarymanagementsystem_hibernate;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAO;
import com.capgemini.librarymanagementsystem_hibernate.dao.UserDAOImplementation;
import com.capgemini.librarymanagementsystem_hibernate.dto.BorrowedBookDetails;

public class UserDAOTest {
	
	private UserDAO dao = new UserDAOImplementation();
	
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
		List<BorrowedBookDetails> info = dao.borrowedBook(111111);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());
	}
	
	@Test
	public void testBorrowedBooksInvalid() {
		List<BorrowedBookDetails> info = dao.borrowedBook(111111);
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
