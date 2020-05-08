package com.capgemini.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.AdminServiceImplementation;

public class AdminServiceTest {
	private AdminService service=new AdminServiceImplementation();
	Book info=new Book();
	
	@Test
	public void testaddBook() {
		info.setBookId(12345);
		info.setBookName("javaprogramming");
		info.setAuthorName("jamesgosling");
		info.setBookCategory("java");
		info.setBookPublisher("sunmicrosystems");
		boolean status=service.addBook(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testregisterAdmin() {
		Admin adn=new Admin();
		adn.setAdminId(12345);
		adn.setName("sandy");
		adn.setEmail("sandy@gmail.com");
		adn.setPassword("Sandy@123");
		boolean status=service.registerAdmin(adn);
		Assertions.assertTrue(status);
	}
	@Test
	public void testRemoveBook() {
		info.setBookId(12345);
		info.setBookName("javaprogramming");
		info.setAuthorName("jamesgosling");
		info.setBookCategory("java");
		info.setBookPublisher("sunmicrosystems");
		boolean status=service.removeBook(12345);
		Assertions.assertTrue(status);
	}
	@Test
	public void testUpdateBook() {
		info.setBookId(11111);
		info.setBookName("java");
		info.setAuthorName("RsAgarwal");
		info.setBookCategory("aptitude");
		info.setBookPublisher("skpublications");
		boolean status=service.addBook(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testAuthenticateBook() {
		Admin status = service.loginAdmin("sandy@gmail.com", "Sandy@123");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testSearchByTitle() {
		ArrayList<Book> info = service.searchBookByTitle("javaprogramming");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByAuthor() {
		ArrayList<Book> info = service.searchBookByAuthor("RsAgarwal");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByCategory() {
		ArrayList<Book> info = service.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testGetBookInfo() {
		ArrayList<Book> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testShowUsers() {
		List<User> info = service.showUsers();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testShowRequests() {
		List<Request> info = service.showRequests();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testaddBook1() {
		info.setBookId(4567);
		info.setBookName("spring");
		info.setAuthorName("rahul");
		info.setBookCategory("java");
		info.setBookPublisher("postman");
		boolean status=service.addBook(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testregisterAdmin1() {
		Admin adn=new Admin();
		adn.setAdminId(12345);
		adn.setName("anusha");
		adn.setEmail("anusha@gmail.com");
		adn.setPassword("Anusha@123");
		boolean status=service.registerAdmin(adn);
		Assertions.assertTrue(status);
	}
	@Test
	public void testRemoveBook1() {
		info.setBookId(12345);
		info.setBookName("dbms");
		info.setAuthorName("apparao");
		info.setBookCategory("database");
		info.setBookPublisher("mysql");
		boolean status=service.removeBook(12345);
		Assertions.assertTrue(status);
	}
	@Test
	public void testUpdateBook1() {
		info.setBookId(11111);
		info.setBookName("physics");
		info.setAuthorName("rknarayan");
		info.setBookCategory("science");
		info.setBookPublisher("RkPublications");
		boolean status=service.addBook(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testAuthenticateBook1() {
		Admin status = service.loginAdmin("sandyY@gmail.com", "Sandy@123");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testSearchByTitle1() {
		ArrayList<Book> info = service.searchBookByTitle("dbms");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByAuthor1() {
		ArrayList<Book> info = service.searchBookByAuthor("rknarayan");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByCategory1() {
		ArrayList<Book> info = service.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testGetBookInfo1() {
		ArrayList<Book> info = service.getBooksInfo();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testShowUsers1() {
		List<User> info = service.showUsers();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testShowRequests1() {
		List<Request> info = service.showRequests();
		Assertions.assertNotNull(info);
	}

}
