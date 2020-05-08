package com.capgemini.librarymanagementsystem_spring;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem_spring.dao.AdminUserDAO;
import com.capgemini.librarymanagementsystem_spring.dto.BookDetails;
import com.capgemini.librarymanagementsystem_spring.dto.UserDetails;
import com.capgemini.librarymanagementsystem_spring.service.AdminUserService;
 
public class AdminUserDAOTest {
	@Autowired
	private AdminUserDAO dao;
	@Test
	public void testRegisterValid() {
		UserDetails bean = new UserDetails();
		bean.setuserId(100005);
		bean.setFirstName("Swapna");
		bean.setLastName("Reddy");
		bean.setEmail("swapna@gmail.com");
		bean.setPassword("Swapna@123");
		bean.setRole("admin");
		boolean check = dao.register(bean);
		Assertions.assertTrue(check);		
	}
	
	@Test
	public void testRegisterInvalid() {
		UserDetails bean = new UserDetails();
		bean.setuserId(100005);
		bean.setFirstName("Swapna");
		bean.setLastName("Reddy");
		bean.setEmail("swapna@gmail.com");
		bean.setPassword("Swapna@123");
		bean.setRole("admin");
		boolean check = dao.register(bean);
		Assertions.assertFalse(check);
	}

	@Test
	public void testLoginValid() {
		UserDetails info = dao.login("chinni@gmail.com", "chinni@123");
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testLoginInvalid() {
		UserDetails info = dao.login("chinni@gmail.com", "chinni123");
		Assertions.assertNull(info);
	}
	
	@Test
	public void testSearchBookByIdValid() {
		List<BookDetails> info = dao.searchBookById(101010);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());
		
	}
	
	@Test
	public void testSearchBookByIdInvalid() {
		List<BookDetails> info = dao.searchBookById(102010);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());		
	}
	
	@Test
	public void testSearchBookByTitleValid() {
		List<BookDetails> info = dao.searchBookByTitle("MM");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testSearchBookByTitleInvalid() {
		List<BookDetails> info = dao.searchBookByTitle("Maths");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());		
	}
	
	@Test
	public void testSearchBookByAuthorValid() {
		List<BookDetails> info = dao.searchBookByAuthor("sharma");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testSearchBookByAuthorInvalid() {
		List<BookDetails> info = dao.searchBookByAuthor("Jain");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());	
	}
	
	@Test
	public void testBooksInfoValid() {
		List<BookDetails> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
		Assertions.assertEquals(5, info.size());
	}
	
	@Test
	public void testBooksInfoInvalid() {
		List<BookDetails> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(6, info.size());
	}
	
	@Test
	public void testUpdatePasswordValid() {
		boolean check = dao.updatePassword(100005,"chinni@gmail.com", "chinni@123", "student");
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testUpdatePasswordInvalid() {
		boolean check = dao.updatePassword(100002,"chinni@gmail.com", "chinni@123","student");
		Assertions.assertFalse(check);
	}
	

}
