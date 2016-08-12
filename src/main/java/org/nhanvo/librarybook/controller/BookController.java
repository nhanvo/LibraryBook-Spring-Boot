package org.nhanvo.librarybook.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.nhanvo.librarybook.domain.BookCreateForm;
import org.nhanvo.librarybook.domain.BookEditForm;
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

/**
 * 
 * @author nhanvo
 * Book controller class
 */
@Controller
public class BookController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private final BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
  // Mapping to model when user access url param /book/{id}
	@RequestMapping ("/book/{id}")
	public ModelAndView getBookPage(@PathVariable Long id) {
		return new ModelAndView(
					"book",
					"book",
					bookService
						.getBookById(id)
						.orElseThrow(() -> new NoSuchElementException(String.format("Book=%s not found", id))));
	}
	
	// Mapping to model when user access url param /book/{id}
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
	public String handleBookEditForm(@Valid @ModelAttribute("form")BookEditForm form, @PathVariable Long id, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
            // failed validation
            return "book_edit";
        }
        try {
            bookService.editBook(form, id);
        } catch (DataIntegrityViolationException e) {             
            return "book_edit";
        }
        // successful, redirect
        return "redirect:/books";
	}
		
	@RequestMapping(value={"/book/delete/{id}"})
	public String handleBookDeleteForm(@PathVariable Long id) {
		try {
			bookService.deleteBook(id);
        } catch (DataIntegrityViolationException e) {             
            return "redirect:/books";
        }
        // successful, redirect
        return "redirect:/books";
  }
}
