package com.capgemini.librarymanagementsystem_hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="bookDetails")
@SequenceGenerator(name="seq3", initialValue=101, allocationSize=100)
public class BookDetails {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seq3")
	private int bookId;
	@Column
	private String bookName;
	@Column
	private String bookAuthor;
	@Column
	private String bookCategory;
	@Column
	private String bookPublisher;
	
	/*
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "books")
	private List<BookIssueDetails> issueDetails;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "books")
	private List<RequestDetails> requests;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "books")
	private List<BorrowedBooks> borrowed;
	
	*/
}
