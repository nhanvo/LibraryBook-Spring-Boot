package org.nhanvo.librarybook.domain;
 
import java.util.Date;

import javax.persistence.*;
/**
 * 
 * @author nhanvo
 * Book POJO class, mapping data to object from database by Hibernate
 */
@Entity
@Table(name = "book")
public class Book {
	// Automatic generate
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
	
	// Title of book
	@Column(name="title", nullable = false)
	private String title;
	
	// Author of book
	@Column(name="author", nullable = false)	
	private String author;
	
	// Description of book
	@Column(name="description", nullable = false)	
	private String description;	
	
	// Date created of book
	@Column(name="createdat", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	// Date updated of book
	@Column(name="updateat", nullable = false)	
	@Temporal(TemporalType.DATE)
	private Date updateAt;
	
	//=========================================================================
	// Get and Set function
	//=========================================================================
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}	
	//=========================================================================
}
