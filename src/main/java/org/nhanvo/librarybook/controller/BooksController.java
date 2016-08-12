package org.nhanvo.librarybook.controller;

import org.nhanvo.librarybook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author nhanvo
 * Books controller class
 */
@Controller
public class BooksController {
	private final BookService bookService;
	
	/**
	 * Constructor
	 * @param bookService Book service
	 */
	@Autowired
	public BooksController(BookService bookService) {
		this.bookService  = bookService;
	}
	
	/**
	 * Mapping http://localhost:8080/books
	 * @return Model and view of all books
	 */
	@RequestMapping("/books")
	public ModelAndView getBooksPage() {
		return new ModelAndView("books", "books", bookService.getAllBooks());
	}
}
