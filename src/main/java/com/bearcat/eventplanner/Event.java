package com.bearcat.eventplanner;

public class Event {
    private String title;
    private String time;
    public String date;
    private String location;
    private String description;

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getTime() {return time;}
    public void setTime(String time) {this.time = time;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
}
