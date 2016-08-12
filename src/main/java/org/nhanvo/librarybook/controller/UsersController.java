package org.nhanvo.librarybook.controller;

import org.nhanvo.librarybook.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author nhanvo
 * Users controller
 */
@Controller
public class UsersController {
	// define logger
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    
    // User service
    private final UserService userService;

    /**
     * Constructor
     * @param userService
     */
    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Mapping to http://localhost:8080/users 
     * @return Model and view of users page
     */
    @RequestMapping("/users")
    public ModelAndView getUsersPage() {
        LOGGER.debug("Getting users page");
        return new ModelAndView("users", "users", userService.getAllUsers());
    }


}
