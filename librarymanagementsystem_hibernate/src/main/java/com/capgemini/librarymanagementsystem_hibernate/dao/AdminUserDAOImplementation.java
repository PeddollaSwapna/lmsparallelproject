package com.capgemini.librarymanagementsystem_hibernate.dao;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystem_hibernate.dto.BookDetails;
import com.capgemini.librarymanagementsystem_hibernate.dto.UserDetails;
import com.capgemini.librarymanagementsystem_hibernate.exception.LMSException;

public class AdminUserDAOImplementation implements AdminUserDAO {
	EntityManagerFactory factory = null;
	EntityManager manager = null;
	EntityTransaction transaction = null;
	int noOfBooks;


	@Override
	public boolean register(UserDetails user) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(user);
			transaction.commit();
			return true;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public UserDetails login(String email, String password) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql="select u from UserDetails u where u.email=:email and u.password=:password";
			TypedQuery<UserDetails> query = manager.createQuery(jpql,UserDetails.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UserDetails bean = query.getSingleResult();
			return bean;
		}catch(Exception e){
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookDetails> searchBookById(int bookId) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookDetails b where b.bId=:bId";
			TypedQuery<BookDetails> query = manager.createQuery(jpql,BookDetails.class);
			query.setParameter("bookId", bookId);
			List<BookDetails> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookDetails> searchBookByTitle(String bookName) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookDetails b where b.bookName=:bookName";
			TypedQuery<BookDetails> query = manager.createQuery(jpql,BookDetails.class);
			query.setParameter("bookName", bookName);
			List<BookDetails> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<BookDetails> searchBookByAuthor(String author) {
		try{
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select b from BookDetails b where b.bookAuthor=:bookAuthor";
			TypedQuery<BookDetails> query = manager.createQuery(jpql,BookDetails.class);
			query.setParameter("author", author);
			List<BookDetails> recordList = query.getResultList();
			return recordList; 
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			manager.close();
			factory.close();
		}
	}
	@Override
	public List<BookDetails> getBooksInfo() {
		factory = Persistence.createEntityManagerFactory("TestPersistence");
		manager = factory.createEntityManager();
		String jpql = "select b from BookDetails b";
		TypedQuery<BookDetails> query = manager.createQuery(jpql,BookDetails.class);
		List<BookDetails> recordList = query.getResultList();
		manager.close();
		factory.close();
		return recordList;
	}
	

	@Override
	public boolean updatePassword(String email, String password, String newPassword, String role) {
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "select u from UserDetails u where u.email=:email and u.role=:role and u.password=:password";
			TypedQuery<UserDetails> query = manager.createQuery(jpql,UserDetails.class);
			query.setParameter("email", email);
			query.setParameter("role", role);
			query.setParameter("password", password);
			UserDetails rs = query.getSingleResult();
			if(rs != null) {
				UserDetails record = manager.find(UserDetails.class,email);
				record.setPassword(newPassword);
				transaction.commit();
				return true;			
			}else {
				throw new LMSException("User doesnt exist");
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}


}
