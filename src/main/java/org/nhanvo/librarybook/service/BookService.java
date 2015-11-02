package org.nhanvo.librarybook.service;

import java.util.Collection;
import java.util.Optional;

import org.nhanvo.librarybook.domain.Book;
import org.nhanvo.librarybook.domain.BookCreateForm;

public interface BookService {
	Optional<Book> getBookById(long id);
	Optional<Book> getBookByAuthor(String author);
	Collection<Book> getAllBooks();
	
	Book create(BookCreateForm form);
	Book editBook(BookCreateForm form, Long id);
	Boolean deleteBook(Long id);
}
