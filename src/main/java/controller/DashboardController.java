package controller;

import com.bearcat.eventplanner.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {
    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("events", "Today's Events");
                return "dashboard"; //dashboard.html
    }
    private List<Event> events = new ArrayList<>();

    //create a new event
    @PostMapping("/create")
    public Event createEvent(@RequestBody Event event){
        events.add(event);
        return event; //return newly created event
    }

    //get list of all events
    @GetMapping("/events")
    public List<Event> getEvents(){
        return events;
    }
}
