public class Event {
    private String name;
    private String description;
    private String date;
    private String category;
    private String location;

    // Constructor
    public Event(String name, String description, String date, String category, String location) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.category = category;
        this.location = location;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Event Name: " + name + "\nDescription: " + description + "\nDate: " + date + "\nCategory: " + category + "\nLocation: " + location;
    }
}

