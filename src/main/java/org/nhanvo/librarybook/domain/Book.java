package org.nhanvo.librarybook.domain;
 
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private Long id;
	
	@Column(name="title", nullable = false)
	private String title;
	
	@Column(name="author", nullable = false)	
	private String author;
	
	@Column(name="description", nullable = false)	
	private String description;	
	
	@Column(name="createdat", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	@Column(name="updateat", nullable = false)	
	@Temporal(TemporalType.DATE)
	private Date updateAt;
	
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
}
