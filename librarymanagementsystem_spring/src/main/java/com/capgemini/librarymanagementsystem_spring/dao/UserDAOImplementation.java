package com.capgemini.librarymanagementsystem_spring.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem_spring.dto.BookBorrowedDetails;
import com.capgemini.librarymanagementsystem_spring.dto.BookDetails;
import com.capgemini.librarymanagementsystem_spring.dto.BookIssueDetails;
import com.capgemini.librarymanagementsystem_spring.dto.RequestDetails;
import com.capgemini.librarymanagementsystem_spring.exception.LMSException;
@Repository
public class UserDAOImplementation implements UserDAO{
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;
	@PersistenceUnit
	private EntityManagerFactory factory ;
	@Override
		public List<BookBorrowedDetails> borrowedBook(int userId) {
			try{
				manager = factory.createEntityManager();
				String jpql = "select b from BookBorrowedDetails b where b.userId=:userId";
				TypedQuery<BookBorrowedDetails> query = manager.createQuery(jpql,BookBorrowedDetails.class);
				query.setParameter("userId", userId);
				List<BookBorrowedDetails> recordList = query.getResultList();
				return recordList; 
			}catch (Exception e) {
				System.err.println(e.getMessage());
				return null;
			}
		}

		@Override
		public boolean request(int userId, int bookId) {
			int count=0;
			try {
				manager = factory.createEntityManager();
				transaction = manager.getTransaction();
				String jpql = "select b from BookDetails b where b.bookId=:bookId";
				TypedQuery<BookDetails> query = manager.createQuery(jpql,BookDetails.class);
				query.setParameter("bookId", bookId);
				List rs = query.getResultList();
				if(rs != null) {
					String jpql1 = "select b from BookBorrowedDetails b where b.userId=:uId and b.bookId=:bookId";
					TypedQuery<BookBorrowedDetails> query1 = (TypedQuery<BookBorrowedDetails>) manager.createQuery(jpql1,BookBorrowedDetails.class);
					query1.setParameter("userId", userId);
					query1.setParameter("bookId", bookId);
					List rs1 = query1.getResultList();
					if( rs1.isEmpty() || rs1==null ) {
						String jpql2 = "select b from BookIssueDetails b where b.userId=:userId";
						TypedQuery<BookIssueDetails> query2 = (TypedQuery<BookIssueDetails>) manager.createQuery(jpql2,BookIssueDetails.class);
						query2.setParameter("userId", userId);
						List<BookIssueDetails> rs2 = query2.getResultList();
						for(BookIssueDetails p : rs2) {
							noOfBooks = count++;
						}
						if(noOfBooks<3) {
							Query bookName = manager.createQuery("select b.bookName from BookDetails b where b.bookId=:bookId");
							bookName.setParameter("bookId", bookId);
							List book = bookName.getResultList();
							Query email = manager.createQuery("select u.email from UserDetails u where u.userId=:user_Id");
							email.setParameter("user_Id", userId);
							List userEmail = email.getResultList();
							transaction.begin();
							RequestDetails request = new RequestDetails();
							request.setuserId(userId);
							request.setBookId(bookId);
							request.setEmail(userEmail.get(0).toString());
							request.setBookName(book.get(0).toString());
							manager.persist(request);
							transaction.commit();
							return true;

						}else {
							throw new LMSException("You have crossed the book limit");
						}
					}else {
						throw new LMSException("You have already borrowed the requested book");
					}
				}else {
					throw new LMSException("The book with requested id is not present");
				}

			} catch (Exception e) {
				System.err.println(e.getMessage());
				return false;
			} 
		}

		@Override
		public boolean returnBook(int bookId, int userId, String status) {
			try{
				manager = factory.createEntityManager();
				transaction = manager.getTransaction();
				String jpql = "select b from BookDetails b where b.bookId=:bookId";
				TypedQuery<BookDetails> query = manager.createQuery(jpql,BookDetails.class);
				query.setParameter("bookId", bookId);
				BookDetails rs = query.getSingleResult();
				if(rs != null) {
					String jpql1 = "select b from BookIssueBean b where b.bookId=:bookId and b.userId=:userId ";
					TypedQuery<BookIssueDetails> query1 = manager.createQuery(jpql1,BookIssueDetails.class);
					query1.setParameter("bookId", bookId);
					query1.setParameter("userId", userId);
					BookIssueDetails rs1 = query1.getSingleResult();
					if(rs1 != null) {
						Date issueDate = rs1.getIssueDate();
						Calendar cal = Calendar.getInstance();
						Date returnDate = cal.getTime();
						long difference = issueDate.getTime() - returnDate.getTime();
						float daysBetween = (difference / (1000*60*60*24));
						if(daysBetween>7.0) {
							float fine = daysBetween*5;
							System.out.println("The user has to pay the fine of the respective book of Rs:"+fine);
							if(status=="yes") {
								transaction.begin();
								manager.remove(rs1);
								transaction.commit();


								transaction.begin();
								String jpql3 = "select b from BookBorrowedDetails b  where b.bookId=:bookId and b.userId=:userId";
								Query query3 = manager.createQuery(jpql3);
								query3.setParameter("bookId", bookId);
								query3.setParameter("userId", userId);
								BookBorrowedDetails bbb = (BookBorrowedDetails) query3.getSingleResult();
								manager.remove(bbb);
								transaction.commit();

								transaction.begin();
								String jpql4 = "select r from RequestDetails r where r.bookId=:bookId and r.userId=:userId";
								Query query4 = manager.createQuery(jpql4);
								query4.setParameter("bookId", bookId);
								query4.setParameter("userId", userId);
								RequestDetails rdb = (RequestDetails) query4.getSingleResult();
								manager.remove(rdb);
								transaction.commit();
								return true;
							}else {
								throw new LMSException("The User has to pay fine for delaying book return");
							}
						}else {
							transaction.begin();
							manager.remove(rs1);
							transaction.commit();


							transaction.begin();
							String jpql3 = "select b from BookBorrowedDetails b  where b.bookId=:bookId and b.userId=:userId";
							Query query3 = manager.createQuery(jpql3);
							query3.setParameter("bookId", bookId);
							query3.setParameter("userId", userId);
							BookBorrowedDetails bbb = (BookBorrowedDetails) query3.getSingleResult();
							manager.remove(bbb);
							transaction.commit();

							transaction.begin();
							String jpql4 = "select r from RequestDetails r where r.bookId=:bookId and r.userId=:userId";
							Query query4 = manager.createQuery(jpql4);
							query4.setParameter("bookId", bookId);
							query4.setParameter("userId", userId);
							RequestDetails rdb = (RequestDetails)query4.getSingleResult();	
							manager.remove(rdb);
							transaction.commit();
							return true;
						}

					}else {
						throw new LMSException("This respective user hasn't borrowed any book");
					}
				}else {
					throw new LMSException("book doesnt exist");
				}

			}catch (Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
		}


}
