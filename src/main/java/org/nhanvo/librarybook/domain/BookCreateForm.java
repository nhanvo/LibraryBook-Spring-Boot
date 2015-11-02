package org.nhanvo.librarybook.domain;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookCreateForm {
	
	@NotEmpty
	private String title = "";
	
	@NotEmpty
	private String author = "";
	
	@NotEmpty
	private String description = "";
	
	@NotEmpty	
	private String createdat;
	
	@NotEmpty 	
	private String updateat;
	
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

	public String getCreatedat() {
		return createdat;
	}

	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}

	public String getUpdateat() {
		return updateat;
	}

	public void setUpdateat(String updateat) {
		this.updateat = updateat;
	}
}
