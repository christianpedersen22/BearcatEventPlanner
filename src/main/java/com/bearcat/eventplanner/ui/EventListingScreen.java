package com.bearcat.eventplanner.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventListingScreen {

    private List<String> events;
    private JTextArea eventTextArea;

    public EventListingScreen() {
        events = new ArrayList<>();
        events.add("Event 1: Description of the event.");
        events.add("Event 2: Another interesting event.");
        events.add("Event 3: Yet another event happening today.");


        JFrame eventListingFrame = new JFrame("Bearcat Event Planner");
        eventListingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        eventListingFrame.setSize(400, 400);


        eventListingFrame.setLayout(new BorderLayout());


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 3));


        JLabel logoLabel = new JLabel("Logo Placeholder", SwingConstants.CENTER);
        topPanel.add(logoLabel);


        JLabel eventsAroundMeLabel = new JLabel("Events Around Me", SwingConstants.CENTER);
        topPanel.add(eventsAroundMeLabel);


        topPanel.add(new JLabel(""));


        JButton searchByDateButton = new JButton("Search by Date");
        topPanel.add(searchByDateButton);

        JButton searchByCategoryButton = new JButton("Search by Category");
        topPanel.add(searchByCategoryButton);

        JButton searchByLocationButton = new JButton("Search by Location");
        topPanel.add(searchByLocationButton);


        eventListingFrame.add(topPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());


        JLabel happeningTodayLabel = new JLabel("Happening Today", SwingConstants.CENTER);
        centerPanel.add(happeningTodayLabel, BorderLayout.NORTH);


        eventTextArea = new JTextArea();
        updateEventTextArea();
        eventTextArea.setEditable(false);
        centerPanel.add(new JScrollPane(eventTextArea), BorderLayout.CENTER);


        eventListingFrame.add(centerPanel, BorderLayout.CENTER);


        eventListingFrame.setVisible(true);
    }

    private void updateEventTextArea() {
        StringBuilder eventList = new StringBuilder();
        for (String event : events) {
            eventList.append(event).append("\n");
        }
        eventTextArea.setText(eventList.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventListingScreen::new); 
    }
}
