package org.nhanvo.librarybook.controller;

import org.nhanvo.librarybook.domain.UserCreateForm;
import org.nhanvo.librarybook.domain.validator.UserCreateFormValidator;
import org.nhanvo.librarybook.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.NoSuchElementException;
/**
 * 
 * @author nhanvo
 * User controller class
 */
@Controller
public class UserController {
	// Define logger
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    // User service
    private final UserService userService;
    // Form validator
    private final UserCreateFormValidator userCreateFormValidator;

    /**
     * Constructor
     * @param userService User service
     * @param userCreateFormValidator User create form validator
     */
    @Autowired
    public UserController(UserService userService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    /**
     * Init binder
     * @param binder Web data binder
     */
    @InitBinder("form")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }
    
    /**
     * Mapping to http://localhost:8080/user/{id}
     * @param id Id of user
     * @return Model and View of user got by id
     */
    @PreAuthorize("@currentUserServiceImpl.canAccessUser(principal, #id)")
    @RequestMapping("/user/{id}")
    public ModelAndView getUserPage(@PathVariable Long id) {
        LOGGER.debug("Getting user page for user={}", id);
        return new ModelAndView("user", "user", userService.getUserById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("User=%s not found", id))));
    }

    /**
     * Mapping to http://localhost:8080/user/create
     * @return Model and view of user create page
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/create", method = RequestMethod.GET)
    public ModelAndView getUserCreatePage() {
        LOGGER.debug("Getting user create form");
        return new ModelAndView("user_create", "form", new UserCreateForm());
    }

    /**
     * Submit from http://localhost:8080/user/create
     * @param form Form create 
     * @param bindingResult Binding result
     * @return
     */
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("form") UserCreateForm form, BindingResult bindingResult) {
    	// If binding error
        if (bindingResult.hasErrors()) {
            return "user_create";
        }
        
        // submit new user
        try {
            userService.create(form);
        } catch (DataIntegrityViolationException e) {
           bindingResult.reject("email.exists", "Email already exists");
            return "user_create";
        }
        
        // Successful, redirect to users page
        return "redirect:/users";
    }

}
