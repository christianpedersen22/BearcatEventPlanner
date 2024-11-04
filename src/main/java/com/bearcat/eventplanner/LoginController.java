package com.bearcat.eventplanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for the login page
 */
@Controller
public class LoginController {
    /**
     * Front-end endpoint used to access the application's login page
     * @return An instance of the "login" thymeleaf template
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
