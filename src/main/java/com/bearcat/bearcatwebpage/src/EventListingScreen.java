package com.bearcat.bearcatwebpage.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class EventListingScreen {

    // Logging
    private static final Logger logger = LogManager.getLogger("events");

    // Lists
    private List<String> events; // all events list
    private List<String> categories; // used for searching by category
    private List<String> subCategories; // search even deeper through different categories. ie: Football > Flag Football
    private List<String> locations;

    // Text Areas
    private JTextArea eventTextArea;
    private JTextArea locationsTextArea;

    public EventListingScreen() {
        events = new ArrayList<>();
        events.add("Event 1: Description of the event.");
        events.add("Event 2: Another interesting event.");
        events.add("Event 3: Yet another event happening today.");

        categories = new ArrayList<>();
        categories.add("Football");
        categories.add("Basketball");
        categories.add("Baseball");
        categories.add("Tennis");
        categories.add("Golf");

        subCategories = new ArrayList<>();
        subCategories.add("Flag Football");
        subCategories.add("Kiwanis Basketball");
        subCategories.add("Baseball Tryouts");
        subCategories.add("Club Tennis Practice");
        subCategories.add("Golf Practice");

        locations = new ArrayList<>();
        locations.add("UC Football Field");
        locations.add("UC Basketball Center");
        locations.add("UC Baseball Field");
        locations.add("UC Tennis Courts");
        locations.add("Ivy Hills Country Club");


        JFrame frameHome = new JFrame("Bearcat Event Planner");
        frameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameHome.setSize(500, 400);

        frameHome.setLayout(new BorderLayout());

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

        frameHome.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        JLabel happeningTodayLabel = new JLabel("Happening Today", SwingConstants.CENTER);
        centerPanel.add(happeningTodayLabel, BorderLayout.NORTH);

        eventTextArea = new JTextArea();
        updateEventTextArea();
        eventTextArea.setEditable(false);
        centerPanel.add(new JScrollPane(eventTextArea), BorderLayout.CENTER);

        frameHome.add(centerPanel, BorderLayout.CENTER);

        frameHome.setVisible(true);
    }


    // navigating on button click
    private void OnClickHandlerSBC(WindowAdapter windowAdapter) {
        // implement a way for the user to click the
        // deep search buttons to open new panels / frames
        // to show different categories
        //
        // add subcategories to list for an even deeper search
        // for the user in finding specifically hard to find events

    }


    private void updateEventTextArea() {
        logger.info("Reading events...");
        StringBuilder eventList = new StringBuilder();
        for (String event : events) {
            eventList.append(event).append("\n");
        }

        eventTextArea.setText(eventList.toString());

        logger.info("New event added.");
        logger.info("Event reading complete.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventListingScreen::new);
    }
}
