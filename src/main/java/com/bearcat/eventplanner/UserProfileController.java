package com.bearcat.eventplanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for the user profile page
 */
@Controller
public class UserProfileController {

    /**
     * Front-end endpoint used to access the root page of the application
     * @return String redirecting the user to the "/profile" endpoint
     */
    @RequestMapping("/")
    public String home() {
        return "redirect:/profile";  // Redirect root URL to /profile
    }

    /**
     * Front-end endpoint used to access the application's profile page
     * @param model Model used to pass data to the "profile" thymeleaf template
     * @return An instance of the "profile" thymeleaf template
     */
    @RequestMapping("/profile")
    public String profile(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        model.addAttribute("username", username);
        
        return "profile"; 
    }
}
