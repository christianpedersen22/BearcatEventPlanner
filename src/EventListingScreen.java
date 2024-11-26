package com.bearcat.bearcatwebpage.src;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventListingScreen {

    private List<String> events;
    private JTextArea eventTextArea;
    private JComboBox<String> locationDropdown;
    private JTextField dateField;
    private JComboBox<String> categoryDropdown;

    public EventListingScreen() {
        // Sample events
        events = new ArrayList<>();
        events.add("11/25/24, UC Clifton, Cooking: Learn to bake cookies.");
        events.add("11/25/24, UC Blue Ash, Art: Painting workshop.");
        events.add("11/26/24, UC Clermont, Hiking: Trail walk.");
        events.add("11/27/24, UC Clifton, Hot Cocoa Health Org: Wellness meetup.");
        events.add("11/28/24, UC Blue Ash, Asian InterVarsity: Cultural event.");

        // Initialize frame
        JFrame frame = new JFrame("Bearcat Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        // Top panel with buttons
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 3));

        JLabel logoLabel = new JLabel("Logo Placeholder", SwingConstants.CENTER);
        topPanel.add(logoLabel);

        JLabel eventsAroundMeLabel = new JLabel("Events Around Me", SwingConstants.CENTER);
        topPanel.add(eventsAroundMeLabel);

        topPanel.add(new JLabel("")); // Placeholder for alignment

        JButton searchByDateButton = new JButton("Search by Date");
        topPanel.add(searchByDateButton);

        JButton searchByCategoryButton = new JButton("Search by Category");
        topPanel.add(searchByCategoryButton);

        JButton searchByLocationButton = new JButton("Search by Location");
        topPanel.add(searchByLocationButton);

        frame.add(topPanel, BorderLayout.NORTH);

        // Center panel for event listing
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        JLabel happeningTodayLabel = new JLabel("Happening Today", SwingConstants.CENTER);
        centerPanel.add(happeningTodayLabel, BorderLayout.NORTH);

        eventTextArea = new JTextArea();
        eventTextArea.setEditable(false);
        centerPanel.add(new JScrollPane(eventTextArea), BorderLayout.CENTER);

        frame.add(centerPanel, BorderLayout.CENTER);

        // Filter panel for search options
        JPanel filterPanel = new JPanel(new GridLayout(2, 3));
        filterPanel.setBorder(BorderFactory.createTitledBorder("Search Filters"));

        locationDropdown = new JComboBox<>(new String[]{"All Locations", "UC Clifton", "UC Blue Ash", "UC Clermont"});
        filterPanel.add(new JLabel("Location:"));
        filterPanel.add(locationDropdown);

        dateField = new JTextField("MM/DD/YY");
        filterPanel.add(new JLabel("Date:"));
        filterPanel.add(dateField);

        categoryDropdown = new JComboBox<>(new String[]{"All Categories", "Cooking", "Art", "Hiking", "Hot Cocoa Health Org", "Asian InterVarsity"});
        filterPanel.add(new JLabel("Category:"));
        filterPanel.add(categoryDropdown);

        frame.add(filterPanel, BorderLayout.SOUTH);

        // Add action listeners to filters
        locationDropdown.addActionListener(e -> updateEventTextArea());
        dateField.addActionListener(e -> updateEventTextArea());
        categoryDropdown.addActionListener(e -> updateEventTextArea());

        // Call updateEventTextArea AFTER initializing components
        updateEventTextArea();

        // Display the frame
        frame.setVisible(true);
    }

    // Update the event text area based on filters
    private void updateEventTextArea() {
        StringBuilder eventList = new StringBuilder();
        String selectedLocation = (String) locationDropdown.getSelectedItem();
        String selectedDate = dateField.getText().trim();
        String selectedCategory = (String) categoryDropdown.getSelectedItem();

        for (String event : events) {
            boolean matchesLocation = selectedLocation.equals("All Locations") || event.contains(selectedLocation);
            boolean matchesDate = selectedDate.isEmpty() || event.startsWith(selectedDate);
            boolean matchesCategory = selectedCategory.equals("All Categories") || event.contains(selectedCategory);

            if (matchesLocation && matchesDate && matchesCategory) {
                eventList.append(event).append("\n");
            }
        }

        eventTextArea.setText(eventList.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventListingScreen::new);
    }
}

