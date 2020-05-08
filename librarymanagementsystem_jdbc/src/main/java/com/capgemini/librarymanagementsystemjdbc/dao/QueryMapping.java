package com.capgemini.librarymanagementsystemjdbc.dao;

public interface QueryMapping {

	 String registerQuery = "insert into users values(?,?,?,?,?,?,?)";
	
	String loginQuery = "select * from users where email=? and password=?";
	
	String addBookQuery = "insert into bookbean values(?,?,?,?,?)";
	
	String removeBookQuery = "delete from bookbean where bid=?";
	
	String updateBookQuery = "update bookbean set bookname=? where bid=?";
	
	String issueBookQuery1 = "select * from request_details where uid=? and bid=? and email=(select email from users where uid=?)";
	
	String issueBookQuery2 = "insert into book_issue_details values(?,?,?,?)";
	
	String issueBookQuery3 = "Insert into borrowed_books values(?,?,(select * from borrowed_books where uid=?))";
	
	String requestQuery1 = "select count(*) as uid from borrowed_books where uid=? and bid=? and email=(select email from users where uid=?)";
	
	String requestQuery2 = "select count(*) as uid from book_issue_details where uid=?";
	
	String requestQuery3= "insert into request_details values(?,(select concat(firstname,'_',lastname) from users where uid=?)\"\r\n" + 
								"+ \"(select email from users where uid=?),?,(select bookname from bookbean where bid=?))";
	
	String titleQuery = "select * from bookbean where bookname=?";
	
	String authorQuery = "select * from bookbean where author=?";
	
	String getAllBooksQuery = "select * from bookbean";
	
	String bookHistroyQuery = "select count(*) as uid from book_issue_details where uid=?";
	
	String borrowedBookQuery = "select * from borrowed_books where uid=?";
	
	String searchIdQuery = "select * from bookbean where bid=?";
	
	String returnBookQuery1 = "select * from book_issue_details where bid=? and uid=?";
	
	String returnBookQuery2 = "delete from book_issue_details where bid=? and uid=?";
	
	String returnBookQuery3 = "delete from borrowed_books where bid=? and uid=?";
	
	String returnBookQuery4 = "delete from request_deatils where bid=? and uid=?";
	
	String showRequestsQuery = "select * from request_details";
	
	String showIssuedBooksQuery = "select * from book_issue_details";
	
	String showUsersQuery = "select * from users";
	
	String updatePasswordQuery1 = "select * from users where email=? and role=?";
	
	String updatePasswordQuery2 = "update users set password=? where email=? and password=?";
		

}
