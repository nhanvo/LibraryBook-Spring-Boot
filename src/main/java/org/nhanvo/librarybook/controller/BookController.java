package org.nhanvo.librarybook.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.nhanvo.librarybook.domain.Book;
import org.nhanvo.librarybook.domain.BookCreateForm;
import org.nhanvo.librarybook.domain.UserCreateForm;
import org.nhanvo.librarybook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.research.ws.wadl.Request;

import io.undertow.attribute.RequestMethodAttribute;

@Controller
public class BookController {
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping ("/book/{id}")
	public ModelAndView getBookPage(@PathVariable Long id) {
		return new ModelAndView(
					"book",
					"book",
					bookService
						.getBookById(id)
							.orElseThrow(() -> new NoSuchElementException(String.format("Book=%s not found", id))));
	}
	
	
	@RequestMapping(value = "/book/create", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage() {
		return new ModelAndView("book_create", "form", new BookCreateForm());
	}
	
	@RequestMapping(value = "/book/create", method = RequestMethod.POST)
    public String handleBookCreateForm(@Valid @ModelAttribute("form") BookCreateForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // failed validation
            return "book_create";
        }
        try {
            bookService.create(form);
        } catch (DataIntegrityViolationException e) {
            return "book_create";
        }
        // ok, redirect
        return "redirect:/books";
    }
	
	@RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
	public ModelAndView getUserEditPage(@PathVariable Long id) {
		return new ModelAndView("book_edit", 
								"book", 
								bookService
									.getBookById(id)
										.orElseThrow(() -> new NoSuchElementException(String.format("Book=%s not found", id))));
	}
	
	@RequestMapping(value = "/book/edit/{id}", method = RequestMethod.POST)
	public String handleBookEditForm(@Valid @ModelAttribute("form")BookCreateForm form, @PathVariable Long id, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            // failed validation
            return "book_edit";
        }
        try {
            bookService.editBook(form, id);
        } catch (DataIntegrityViolationException e) {             
            return "book_edit";
        }
        // ok, redirect
        return "redirect:/books";
	}
}
