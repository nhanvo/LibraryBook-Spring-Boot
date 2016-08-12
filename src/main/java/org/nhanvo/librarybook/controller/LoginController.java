package org.nhanvo.librarybook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * 
 * @author nhanvo
 * Login controller class
 */
@Controller
public class LoginController {
	// Define logger
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * Mapping to http://localhost:8080/login
     * @param error Request parameter error
     * @return Model and View of login page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        LOGGER.debug("Getting login page, error={}", error);
        return new ModelAndView("login", "error", error);
    }

}
