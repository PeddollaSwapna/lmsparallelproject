package com.capgemini.librarymanagementsystemjdbc;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dto.BookDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.UserDetails;
import com.capgemini.librarymanagementsystemjdbc.service.AdminService;
import com.capgemini.librarymanagementsystemjdbc.service.AdminServiceImplementation;

public class AdminServiceTest {
private AdminService service = new AdminServiceImplementation();
	
@Test
public void testAddBookValid() {
	BookDetails bean = new BookDetails();
	bean.setBId(100000);
	bean.setBookName("Java");
	bean.setAuthor("James");
	bean.setCategory("Programing");
	bean.setPublisher("Arihent");
	boolean check = service.addBook(bean);
	Assertions.assertTrue(check);
}
@Test
public void testAddBookInvalid() {
	BookDetails bean = new BookDetails();
	bean.setBId(100000);
	bean.setBookName("Java");
	bean.setAuthor("James");
	bean.setCategory("Programing");
	bean.setPublisher("Arihent");
	boolean check = service.addBook(bean);
	Assertions.assertFalse(check);	
} 

@Test
public void testRemoveBookValid() {
	boolean check = service.removeBook(100000);
	Assertions.assertTrue(check);
}

@Test
public void testRemoveBookInvalid() {
	boolean check = service.removeBook(100001);
	Assertions.assertFalse(check);
}

@Test
public void testUpdateBookValid() {
	BookDetails book = new BookDetails();
	book.setBId(100000);
	book.setBookName("Maths");
	boolean check = service.updateBook(book);
	Assertions.assertTrue(check);
}

@Test
public void testUpdateBookInvalid() {
	BookDetails book = new BookDetails();
	book.setBId(100002);
	book.setBookName("Maths");
	boolean check = service.updateBook(book);
	Assertions.assertFalse(check);
}

@Test
public void testIssueBookValid() {
	boolean check = service.issueBook(100000, 111111);
	Assertions.assertTrue(check);
}

@Test
public void testIssueBookInvalid() {
	boolean check = service.issueBook(100002, 111111);
	Assertions.assertFalse(check);
}

@Test
public void testBookHistoryDetailsValid() {
	List<BookIssueDetails> info = service.bookHistoryDetails(111111);
	Assertions.assertNotNull(info);
	Assertions.assertEquals(1, info.size());		
}

@Test
public void testBookHistoryDetailsInvalid() {
	List<BookIssueDetails> info = service.bookHistoryDetails(111112);
	Assertions.assertNotNull(info);
	Assertions.assertNotEquals(0, info.size());		
}

@Test
public void testShowRequestsValid() {
	List<RequestDetails> info = service.showRequests();
	Assertions.assertNotNull(info);
	Assertions.assertEquals(1, info.size());		
}

@Test
public void testShowRequestsInvalid() {
	List<RequestDetails> info = service.showRequests();
	Assertions.assertNotNull(info);
	Assertions.assertNotEquals(2, info.size());		
}

@Test
public void testShowIssuedBooksValid() {
	List<BookIssueDetails> info = service.showIssuedBooks();
	Assertions.assertNotNull(info);
	Assertions.assertEquals(1, info.size());		
}

@Test
public void testShowIssuedBooksInvalid() {
	List<BookIssueDetails> info = service.showIssuedBooks();
	Assertions.assertNotNull(info);
	Assertions.assertNotEquals(2, info.size());		
}

@Test
public void testShowUsersValid() {
	List<UserDetails> info = service.showUsers();
	Assertions.assertNotNull(info);
	Assertions.assertEquals(4, info.size());		
}

@Test
public void testShowUsersInvalid() {
	List<UserDetails> info = service.showUsers();
	Assertions.assertNotNull(info);
	Assertions.assertNotEquals(2, info.size());		
}

}
