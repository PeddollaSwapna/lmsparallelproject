package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BookDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.RequestDetails;
import com.capgemini.librarymanagementsystemjdbc.dto.UserDetails;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemjdbc.utility.Utility;
import com.mysql.jdbc.Statement;

public class AdminDAOImplementation implements AdminDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	@Override
	public boolean addBook(BookDetails book) {
		conn=Utility.getConnection();
					try(PreparedStatement pstmt = conn.prepareStatement(QueryMapping.addBookQuery);) {
				pstmt.setInt(1, book.getBId());
				pstmt.setString(2, book.getBookName());
				pstmt.setString(3, book.getAuthor());
				pstmt.setString(4, book.getCategory());
				pstmt.setString(5, book.getPublisher());
				//pstmt.setInt(6, book.getCopies());
				int count = pstmt.executeUpdate();
				if(count!=0) {
					return true;
				} else {
					return false;
				}
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean removeBook(int bId) {
		conn=Utility.getConnection();
					try(PreparedStatement pstmt = conn.prepareStatement(QueryMapping.removeBookQuery);) {
				pstmt.setInt(1,bId);
				int count=pstmt.executeUpdate();
				if(count!=0) {
					return true;
				} else {
					return false;
				}
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean updateBook(BookDetails book) {
		conn=Utility.getConnection();
					try(PreparedStatement pstmt = conn.prepareStatement(QueryMapping.updateBookQuery);) {
				pstmt.setString(1,book.getBookName());
				pstmt.setInt(2,book.getBId());
				int count=pstmt.executeUpdate();
				if(count!=0) {
					return true;
				} else {
					return false;
				}
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean issueBook(int bId,int uId) {
		conn=Utility.getConnection();
					
					try(PreparedStatement pstmt = conn.prepareStatement(QueryMapping.issueBookQuery1);) {
						pstmt.setInt(1, uId);
						pstmt.setInt(2, bId);
						pstmt.setInt(3, uId);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							try(PreparedStatement pstmt1 = conn.prepareStatement(QueryMapping.issueBookQuery2);){
								pstmt1.setInt(1, bId);
								pstmt1.setInt(2, uId);
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
								Calendar cal = Calendar.getInstance();
								String issueDate = sdf.format(cal.getTime());
								pstmt1.setDate(3, java.sql.Date.valueOf(issueDate));
								cal.add(Calendar.DAY_OF_MONTH, 7);
								String returnDate = sdf.format(cal.getTime());
								pstmt.setDate(4, java.sql.Date.valueOf(returnDate));
								int count=pstmt1.executeUpdate();
								if(count != 0) {	
									try(PreparedStatement pstmt2 = conn.prepareStatement(QueryMapping.issueBookQuery3);){
										pstmt2.setInt(1, uId);
										pstmt2.setInt(2, bId);
										pstmt2.setInt(3, uId);
										int isBorrowed = pstmt2.executeUpdate();
										if(isBorrowed != 0) {
											return true;
										}else {
											return false;
										}
									}
								} else {
									throw new LMSException("Book Not issued");
								}					
							}
						} else {
							throw new LMSException("The respective user have not placed any request");
						}			
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	@Override
	public  List<BookIssueDetails> bookHistoryDetails(int uId) {
		conn=Utility.getConnection();
					try(PreparedStatement pstmt = conn.prepareStatement(QueryMapping.bookHistroyQuery);) {
				pstmt.setInt(1, uId);
				rs=pstmt.executeQuery();
				 List<BookIssueDetails> beans = new  ArrayList<BookIssueDetails>();
				while(rs.next()) {
					BookIssueDetails issueDetails = new BookIssueDetails();
					issueDetails.setUserId(rs.getInt("uId"));
					beans.add(issueDetails);
				} 
				return beans;
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	@Override
	public  List<RequestDetails> showRequests() {
		conn=Utility.getConnection();
		
					try(Statement stmt = (Statement)conn.createStatement();
					ResultSet rs = stmt.executeQuery(QueryMapping.showRequestsQuery);) {
						 List<RequestDetails> beans = new  ArrayList<RequestDetails>();
				while(rs.next()) {
					RequestDetails bean = new RequestDetails();
					bean.setuId(rs.getInt("uId"));
					bean.setFullName(rs.getString("fullName"));
					bean.setbId(rs.getInt("bId"));
					bean.setBookName(rs.getString("bookName"));
					beans.add(bean);
				}
				return beans;
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public  List<BookIssueDetails> showIssuedBooks() {
		conn=Utility.getConnection();
					try(Statement stmt = (Statement)conn.createStatement();
					ResultSet rs = stmt.executeQuery(QueryMapping.showIssuedBooksQuery);) {
						 List<BookIssueDetails> beans = new   ArrayList<BookIssueDetails>();
				while(rs.next()) {
					BookIssueDetails bean = new BookIssueDetails();
					bean.setBookId(rs.getInt("bookId"));
					bean.setUserId(rs.getInt("userId"));
					bean.setIssueDate(rs.getDate("issueDate"));
					bean.setReturnDate(rs.getDate("returnDate"));
					beans.add(bean);
				}
				return beans;
			
		} catch(Exception e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
			return null;
		}
	}


	@Override
	public List<UserDetails> showUsers() {
		conn=Utility.getConnection();
					try(Statement stmt = (Statement)conn.createStatement();
					ResultSet rs = stmt.executeQuery(QueryMapping.showUsersQuery);) {
						 List<UserDetails> beans = new  ArrayList<UserDetails>();
				while(rs.next()) {
					UserDetails bean = new UserDetails();
					bean.setuId(rs.getInt("uId"));
					bean.setFirstName(rs.getString("firstName"));
					bean.setLastName(rs.getString("lastName"));
					bean.setEmail(rs.getString("email"));
					bean.setPassword(rs.getString("password"));
					bean.setMobile(rs.getLong("mobile"));
					bean.setRole(rs.getString("role"));
					beans.add(bean);
				}
				return beans;
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

}
