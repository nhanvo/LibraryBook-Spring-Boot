package org.nhanvo.librarybook.controller;

import org.nhanvo.librarybook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BooksController {
	private final BookService bookService;
	
	@Autowired
	public BooksController(BookService bookService) {
		this.bookService  = bookService;
	}
	
	@RequestMapping("/books")
	public ModelAndView getBooksPage() {
		return new ModelAndView("books", "books", bookService.getAllBooks());
	}
}
