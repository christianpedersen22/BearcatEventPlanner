package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("events", "Today's Events");
                return "dashboard"; //dashboard.html
    }
}
