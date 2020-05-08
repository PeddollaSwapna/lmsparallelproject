package com.capgemini.librarymanagementsystem;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dto.Book;
import com.capgemini.librarymanagementsystem.dto.User;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.service.UserServiceImplementation;

public class UserServiceTest {
	private UserService dao=new UserServiceImplementation();
	Book info=new Book();
	
	@Test
	public void testRegisterStudent() {
		User info=new User();
		info.setId(1122);
		info.setName("jaanu");
		info.setPhone(765898533);
		info.setEmail("jaanu@gmail.com");
		info.setPassword("Jaanu@123");
		boolean status=dao.registerUser(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testAuthenticateBook() {
		User status = dao.loginUser("jaanu@gmail.com", "Jaanu@123");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testSearchByTitle() {
		ArrayList<Book> info = dao.searchBookByTitle("javaprogramming");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByAuthor() {
		ArrayList<Book> info = dao.searchBookByAuthor("rknarayan");
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
	/*
	 * @Test public void testRequest() { BookRequestInfo info = dao. }
	 */
	@Test
	public void testRegisterStudent1() {
		User info=new User();
		info.setId(1212);
		info.setName("rajkumar");
		info.setPhone(987456321);
		info.setEmail("rajkumar@gmail.com");
		info.setPassword("Rajkumar@123");
		boolean status=dao.registerUser(info);
		Assertions.assertTrue(status);
	}
	@Test
	public void testAuthenticateBook1() {
		User status = dao.loginUser("rajkumar@gmail.com", "Rajkumar@123");
		Assertions.assertNotNull(status);
	}
	@Test
	public void testSearchByTitle1() {
		ArrayList<Book> info = dao.searchBookByTitle("java");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByAuthor1() {
		ArrayList<Book> info = dao.searchBookByAuthor("kalyan");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testSearchByCategory1() {
		ArrayList<Book> info = dao.searchBookByCategory("maths");
		Assertions.assertNotNull(info);
	}
	@Test
	public void testGetBookInfo1() {
		ArrayList<Book> info = dao.getBooksInfo();
		Assertions.assertNotNull(info);
	}

}
