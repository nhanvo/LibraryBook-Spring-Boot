package org.nhanvo.librarybook.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class BookEditForm {
	// Title of book
		@NotEmpty
		private String title = "";
		
		// Author of book
		@NotEmpty
		private String author = "";
		
		// Description of book
		@NotEmpty
		private String description = "";
		
		// Date created of book
		@NotEmpty	
		private String createdat;
		
		// Data updated of book
		@NotEmpty 	
		private String updateat;
		
		//=========================================================================
		// Get and Set functions
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
		//=========================================================================
}
