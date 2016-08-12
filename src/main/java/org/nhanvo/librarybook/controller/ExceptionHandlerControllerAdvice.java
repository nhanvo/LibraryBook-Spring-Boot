package org.nhanvo.librarybook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

/**
 * 
 * @author nhanvo
 * Exception handler controller class
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	/**
	 *  Throw exception no such element
	 * @param e Exception 
	 * @return Error message 
	 */
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoSuchElementException(NoSuchElementException e) {
        return e.getMessage();
    }

}
