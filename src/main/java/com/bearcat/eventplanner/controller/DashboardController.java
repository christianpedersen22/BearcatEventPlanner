package com.bearcat.eventplanner.controller;

import com.bearcat.eventplanner.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {
    private List<Event> events = new ArrayList<>(); 

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("events", events); 
        return "dashboard"; 
    }

    @GetMapping("/create-event")
    public String createEventPage() {
        return "create-event";
    }

    @PostMapping("/create-event")
    public String createEvent(
            @RequestParam String title,
            @RequestParam String time,
            @RequestParam String date,
            @RequestParam String location,
            @RequestParam String description) {
        Event event = new Event(title, time, date, location, description);
        events.add(event);
        return "redirect:/dashboard";
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return events;
    }
}
