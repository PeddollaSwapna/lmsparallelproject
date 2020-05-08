package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BorrowedBooks;
import com.capgemini.librarymanagementsystemjdbc.exception.LMSException;
import com.capgemini.librarymanagementsystemjdbc.utility.Utility;
import com.mysql.jdbc.Statement;

public class UserDAOImplementation implements UserDAO{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt = null;

	

	@Override
	public boolean request(int uId,int bId) {
			conn=Utility.getConnection();
					try(PreparedStatement pstmt = conn.prepareStatement(QueryMapping.requestQuery1);){
						pstmt.setInt(1, uId);
						pstmt.setInt(2, bId);
						pstmt.setInt(3, uId);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							int isBookExists = rs.getInt("uId");
							if(isBookExists==0) {
								try(PreparedStatement pstmt1 = conn.prepareStatement(QueryMapping.requestQuery2);) {
									pstmt1.setInt(1, uId);
									rs=pstmt1.executeQuery();
									if(rs.next()) {
										int noOfBooksBorrowed = rs.getInt("uId");
										if(noOfBooksBorrowed<3) {
											try(PreparedStatement pstmt2 = conn.prepareStatement(QueryMapping.requestQuery3);){
												pstmt2.setInt(1,uId);
												pstmt2.setInt(2, uId);
												pstmt2.setInt(3, uId);
												pstmt2.setInt(4, bId);
												pstmt2.setInt(5, bId);
												int count = pstmt2.executeUpdate();
												if(count != 0) {
													return true;
												}else {
													return false;
												}
											}				 
										}else {
											throw new LMSException("no Of books limit has crossed");
										}
									}else {
										throw new LMSException("no of books limit has crossed");
									}		
								}				
							}else{
								throw new LMSException("You have already borrowed the requested book");
							}		
						}else {
							throw new LMSException("You have already borrowed the requested book");
						}		
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	@Override
	public boolean returnBook(int bId,int uId,String status) {
		conn=Utility.getConnection();
					
					try(PreparedStatement pstmt = conn.prepareStatement(QueryMapping.returnBookQuery1);){
						pstmt.setInt(1, bId);
						pstmt.setInt(2, uId);
						rs = pstmt.executeQuery();
						if(rs.next()) {
							Date issueDate = rs.getDate("issueDate");
							Calendar cal=Calendar.getInstance();
							Date returnDate = cal.getTime();
							long difference = issueDate.getTime() - returnDate.getTime();
							float daysBetween = (difference / (1000*60*60*24));
							if(daysBetween>7) {
								float fine = daysBetween*5;
								System.out.println("The user has to pay the fine of the respective book of Rs:"+fine);
								if(status=="yes") {
									try(PreparedStatement pstmt1 = conn.prepareStatement(QueryMapping.returnBookQuery2);) {
										pstmt1.setInt(1,bId);
										pstmt1.setInt(2,uId);
										int count =  pstmt1.executeUpdate();
										if(count != 0) {
											try(PreparedStatement pstmt2 = conn.prepareStatement(QueryMapping.returnBookQuery3);) {
												pstmt2.setInt(1, bId);
												pstmt2.setInt(2, uId);
												int isReturned = pstmt2.executeUpdate();
												if(isReturned != 0 ) {
													try(PreparedStatement pstmt3 = conn.prepareStatement(QueryMapping.returnBookQuery4);){
														pstmt3.setInt(1, bId);
														pstmt3.setInt(2, uId);
														int isRequestDeleted = pstmt3.executeUpdate();
														if(isRequestDeleted != 0) {
															return true;
														}else {
															return false;
														}
													}
												}else {
													return false;
												}
											}
										} else {
											return false;
										}
									}
								} else {
									throw new LMSException("The User has to pay fine for delaying book return");
								}
							}else {
								try(PreparedStatement pstmt1 = conn.prepareStatement(QueryMapping.returnBookQuery2);) {
									pstmt1.setInt(1,bId);
									pstmt1.setInt(2,uId);
									int count =  pstmt1.executeUpdate();
									if(count != 0) {
										try(PreparedStatement pstmt2 = conn.prepareStatement(QueryMapping.returnBookQuery3);) {
											pstmt2.setInt(1, bId);
											pstmt2.setInt(2, uId);
											int isReturned = pstmt2.executeUpdate();
											if(isReturned != 0 ) {
												try(PreparedStatement pstmt3 = conn.prepareStatement(QueryMapping.returnBookQuery4);){
													pstmt3.setInt(1, bId);
													pstmt3.setInt(2, uId);
													int isRequestDeleted = pstmt3.executeUpdate();
													if(isRequestDeleted != 0) {
														return true;
													}else {
														return false;
													}
												}
											}else {
												return false;
											}
										}
									} else {
										return false;
									}
								}
							}
						}else {
							throw new LMSException("This respective user hasn't borrowed any book");
						}

		} catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<BorrowedBooks> borrowedBook(int uId) {
		conn=Utility.getConnection();
					try(PreparedStatement pstmt = conn.prepareStatement(QueryMapping.borrowedBookQuery);) {
				pstmt.setInt(1, uId);
				rs=pstmt.executeQuery();
				 ArrayList<BorrowedBooks> beans = new  ArrayList<BorrowedBooks>();
				while(rs.next()) {
					BorrowedBooks listOfbooksBorrowed = new BorrowedBooks();
					listOfbooksBorrowed.setuId(rs.getInt("uId"));
					listOfbooksBorrowed.setbId(rs.getInt("bId"));
					listOfbooksBorrowed.setEmail(rs.getString("email"));
					beans.add(listOfbooksBorrowed);
				} 
				return beans;
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

}
