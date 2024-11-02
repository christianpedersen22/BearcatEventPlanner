package com.bearcat.bearcatwebpage.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class EventListingScreen {

    private List<String> events; // all events list
    private List<String> categories; // used for searching by category
    private List<String> subCategories; // search even deeper through different categories. ie: Football > Flag Football
    private List<String> locations;

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
        JPanel topPanelCategories = new JPanel();
        topPanelCategories.setLayout(new GridLayout(2, 3));

        JLabel eventsAroundMeLabel = new JLabel("Select a Category", SwingConstants.CENTER);
        topPanelCategories.add(eventsAroundMeLabel);

        topPanelCategories.add(new JLabel(""));

        for (String category : categories) {
            topPanelCategories.add(new JButton(category));
        }

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
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
