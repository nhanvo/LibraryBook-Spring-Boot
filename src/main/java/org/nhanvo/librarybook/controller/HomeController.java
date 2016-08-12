package org.nhanvo.librarybook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author nhanvo
 * Home controller class
 */
@Controller
public class HomeController {
	// Define logger
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    /**
     * Mapping to http://localhost:8080/
     * @return Home page
     */
    @RequestMapping("/")
    public String getHomePage() {
        LOGGER.debug("Getting home page");
        return "home";
    }

}
