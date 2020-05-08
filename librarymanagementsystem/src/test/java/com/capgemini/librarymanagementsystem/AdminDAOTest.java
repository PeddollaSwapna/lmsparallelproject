package com.capgemini.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dao.AdminDAOImplementation;
import com.capgemini.librarymanagementsystem.dto.Admin;
import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.Request;
import com.capgemini.librarymanagementsystem.dto.User;

public class AdminDAOTest {

	private AdminDAO dao=new AdminDAOImplementation();
	Book info=new Book();
	
	@Test
	public void testaddBook() {
		info.setBookId(12345);
		info.setBookName("javacolle");
		info.setAuthorName("jamesgosling");
		info.setBookCategory("java");
		info.setBookPublisher("sunmicrosystems");
		boolean status=dao.addBook(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testregisterAdmin() {
		Admin adn=new Admin();
		adn.setAdminId(12345);
		adn.setName("sandy");
		adn.setEmail("sandy@gmail.com");
		adn.setPassword("Sandy@123");
		boolean status=dao.registerAdmin(adn);
		Assertions.assertTrue(status);
	}
	@Test
	public void testRemoveBook() {
		info.setBookId(12345);
		info.setBookName("javacolle");
		info.setAuthorName("jamesgosling");
		info.setBookCategory("java");
		info.setBookPublisher("sunmicrosystems");
		boolean status=dao.removeBook(12345);
		Assertions.assertTrue(status);
	}
	@Test
	public void testUpdateBook() {
		info.setBookId(11111);
		info.setBookName("javajdbc");
		info.setAuthorName("RsAgarwal");
		info.setBookCategory("aptitude");
		info.setBookPublisher("skpublications");
		boolean status=dao.addBook(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testAuthenticateBook() {
		Admin status = dao.loginAdmin("sandy@gmail.com", "Sandy@123");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testSearchByTitle() {
		ArrayList<Book> info = dao.searchBookByTitle("javajdbc");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByAuthor() {
		ArrayList<Book> info = dao.searchBookByAuthor("RsAgarwal");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByCategory() {
		ArrayList<Book> info = dao.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testGetBookInfo() {
		ArrayList<Book> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testShowUsers() {
		List<User> info = dao.showUsers();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testShowRequests() {
		List<Request> info = dao.showRequests();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testaddBook1() {
		info.setBookId(4567);
		info.setBookName("spring");
		info.setAuthorName("rahul");
		info.setBookCategory("java");
		info.setBookPublisher("postman");
		boolean status=dao.addBook(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testregisterAdmin1() {
		Admin adn=new Admin();
		adn.setAdminId(12345);
		adn.setName("anusha");
		adn.setEmail("anusha@gmail.com");
		adn.setPassword("Anusha@123");
		boolean status=dao.registerAdmin(adn);
		Assertions.assertTrue(status);
	}
	@Test
	public void testRemoveBook1() {
		info.setBookId(12345);
		info.setBookName("dbms");
		info.setAuthorName("apparao");
		info.setBookCategory("database");
		info.setBookPublisher("mysql");
		boolean status=dao.removeBook(12345);
		Assertions.assertTrue(status);
	}
	@Test
	public void testUpdateBook1() {
		info.setBookId(11111);
		info.setBookName("physics");
		info.setAuthorName("rknarayan");
		info.setBookCategory("science");
		info.setBookPublisher("RkPublications");
		boolean status=dao.addBook(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testAuthenticateBook1() {
		Admin status = dao.loginAdmin("sandyY@gmail.com", "Sandy@123");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testSearchByTitle1() {
		ArrayList<Book> info = dao.searchBookByTitle("dbms");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByAuthor1() {
		ArrayList<Book> info = dao.searchBookByAuthor("rknarayan");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByCategory1() {
		ArrayList<Book> info = dao.searchBookByCategory("aptitude");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testGetBookInfo1() {
		ArrayList<Book> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testShowUsers1() {
		List<User> info = dao.showUsers();
		Assertions.assertNotNull(info);
	}
	@Test
	public void testShowRequests1() {
		List<Request> info = dao.showRequests();
		Assertions.assertNotNull(info);
	}
}
