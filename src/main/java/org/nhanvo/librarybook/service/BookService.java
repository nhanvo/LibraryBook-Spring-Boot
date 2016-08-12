package org.nhanvo.librarybook.service;

import java.util.Collection;
import java.util.Optional;

import org.nhanvo.librarybook.domain.Book;
import org.nhanvo.librarybook.domain.BookCreateForm;
import org.nhanvo.librarybook.domain.BookEditForm;

/**
 * 
 * @author nhanvo
 * Book service interface
 */
public interface BookService {
	/**
	 * Get book by Id
	 * @param id Input id
	 * @return Return book object found
	 */
	Optional<Book> getBookById(long id);
	
	/**
	 * Get book by author
	 * @param author Author name
	 * @return Return book object found
	 */
	Optional<Book> getBookByAuthor(String author);
	
	/**
	 * Get all books
	 * @return List books object found
	 */
	Collection<Book> getAllBooks();
	
	/**
	 * Create new book
	 * @param form Book create form
	 * @return Book created
	 */
	Book create(BookCreateForm form);
	
	/**
	 * Edit information of book
	 * @param form Book Edit form
	 * @param id Id of book edited
	 * @return Book edited
	 */
	Book editBook(BookEditForm form, Long id);
	
	/**
	 * Delete book
	 * @param id Id of book need delete
	 * @return Book deleted
	 */
	Boolean deleteBook(Long id);
}
