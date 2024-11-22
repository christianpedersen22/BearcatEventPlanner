package com.bearcat.eventplanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String login() {
        return "login";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // login.html
    }
}
