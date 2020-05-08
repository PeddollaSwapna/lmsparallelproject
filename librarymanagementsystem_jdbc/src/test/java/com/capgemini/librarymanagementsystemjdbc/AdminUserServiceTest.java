package com.capgemini.librarymanagementsystemjdbc;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dto.BookDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.UserDetails;
import com.capgemini.librarymanagementsystemjdbc.service.AdminUserService;
import com.capgemini.librarymanagementsystemjdbc.service.AdminUserServiceImplementation;

public class AdminUserServiceTest {
	private AdminUserService service = new AdminUserServiceImplementation();

	@Test
	public void testRegisterValid() {
		UserDetails bean = new UserDetails();
		bean.setuId(100005);
		bean.setFirstName("Swapna");
		bean.setLastName("Reddy");
		bean.setEmail("swapna@gmail.com");
		bean.setPassword("Swapna@123");
		bean.setRole("student");
		boolean check = service.register(bean);
		Assertions.assertTrue(check);		
	}
	
	@Test
	public void testRegisterInvalid() {
		UserDetails bean = new UserDetails();
		bean.setuId(100005);
		bean.setFirstName("Swapna");
		bean.setLastName("Reddy");
		bean.setEmail("swapna@gmail.com");
		bean.setPassword("Swapna@123");
		bean.setRole("student");
		boolean check = service.register(bean);
		Assertions.assertFalse(check);
	}

	@Test
	public void testLoginValid() {
		UserDetails info = service.login("chinni@gmail.com", "chinni@123");
		Assertions.assertNotNull(info);
	}
	
	@Test
	public void testLoginInvalid() {
		UserDetails info = service.login("chinni@gmail.com", "chinni123");
		Assertions.assertNull(info);
	}
	
	@Test
	public void testSearchBookByIdValid() {
		List<BookDetails> info = service.searchBookById(101010);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());
		
	}
	
	@Test
	public void testSearchBookByIdInvalid() {
		List<BookDetails> info = service.searchBookById(102010);
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());		
	}
	
	@Test
	public void testSearchBookByTitleValid() {
		List<BookDetails> info = service.searchBookByTitle("MM");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testSearchBookByTitleInvalid() {
		List<BookDetails> info = service.searchBookByTitle("Maths");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());		
	}
	
	@Test
	public void testSearchBookByAuthorValid() {
		List<BookDetails> info = service.searchBookByAuthor("sharma");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(1, info.size());		
	}
	
	@Test
	public void testSearchBookByAuthorInvalid() {
		List<BookDetails> info = service.searchBookByAuthor("Jain");
		Assertions.assertNotNull(info);
		Assertions.assertEquals(0, info.size());	
	}
	
	@Test
	public void testBooksInfoValid() {
		List<BookDetails> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
		Assertions.assertEquals(5, info.size());
	}
	
	@Test
	public void testBooksInfoInvalid() {
		List<BookDetails> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
		Assertions.assertNotEquals(6, info.size());
	}
	
	@Test
	public void testUpdatePasswordValid() {
		boolean check = service.updatePassword("chinni@gmail.com", "chinni@123", "Admin@123", "admin");
		Assertions.assertTrue(check);
	}
	
	@Test
	public void testUpdatePasswordInvalid() {
		boolean check = service.updatePassword("chinni@gmail.com", "chinni@123", "Admin@123", "student");
		Assertions.assertFalse(check);
	}
	
}
