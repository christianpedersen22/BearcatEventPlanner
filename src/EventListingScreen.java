import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class EventListingScreen {

    private List<Event> events;
    private JTextArea eventTextArea;
    private JSpinner dateSpinner;
    private JComboBox<String> categoryComboBox;
    private JTextField locationTextField;
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public EventListingScreen() {
        // Initialize events
        events = new ArrayList<>();
        events.add(new Event("Event 1", "Description of the event.", "2024-11-10", "Music", "Blue Ash"));
        events.add(new Event("Event 2", "Another interesting event.", "2024-11-11", "Sports", "Clermont"));
        events.add(new Event("Event 3", "Yet another event happening today.", "2024-11-10", "Technology", "Main Campus"));

        JFrame frame = new JFrame("Bearcat Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.setLayout(new BorderLayout());

        // Main panel with CardLayout to switch between different search panels
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        JPanel searchPanel = createSearchPanel();
        JPanel dateSearchPanel = createDateSearchPanel();
        JPanel categorySearchPanel = createCategorySearchPanel();
        JPanel locationSearchPanel = createLocationSearchPanel();
        JPanel createEventPanel = createCreateEventPanel(); // New panel for creating events

        mainPanel.add(searchPanel, "Search Panel");
        mainPanel.add(dateSearchPanel, "Date Search Panel");
        mainPanel.add(categorySearchPanel, "Category Search Panel");
        mainPanel.add(locationSearchPanel, "Location Search Panel");
        mainPanel.add(createEventPanel, "Create Event Panel"); // Adding the create event panel

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Create the initial search panel where the user can select a search option
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(5, 1)); // Increased row count to include new button

        JButton searchByDateButton = new JButton("Search by Date");
        searchByDateButton.addActionListener(e -> cardLayout.show(mainPanel, "Date Search Panel"));
        searchPanel.add(searchByDateButton);

        JButton searchByCategoryButton = new JButton("Search by Category");
        searchByCategoryButton.addActionListener(e -> cardLayout.show(mainPanel, "Category Search Panel"));
        searchPanel.add(searchByCategoryButton);

        JButton searchByLocationButton = new JButton("Search by Location");
        searchByLocationButton.addActionListener(e -> cardLayout.show(mainPanel, "Location Search Panel"));
        searchPanel.add(searchByLocationButton);

        // New button to open the create event panel
        JButton createEventButton = new JButton("Create Event");
        createEventButton.addActionListener(e -> cardLayout.show(mainPanel, "Create Event Panel"));
        searchPanel.add(createEventButton);

        return searchPanel;
    }

    // Create the Date Search Panel with DatePicker
    private JPanel createDateSearchPanel() {
        JPanel dateSearchPanel = new JPanel();
        dateSearchPanel.setLayout(new BorderLayout());

        JLabel dateLabel = new JLabel("Select Date:");
        dateSearchPanel.add(dateLabel, BorderLayout.NORTH);

        // Create a date picker using JSpinner
        SpinnerDateModel dateModel = new SpinnerDateModel();
        dateSpinner = new JSpinner(dateModel);
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));
        dateSearchPanel.add(dateSpinner, BorderLayout.CENTER);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchByDate());
        dateSearchPanel.add(searchButton, BorderLayout.SOUTH);

        // Back button to return to main panel
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Search Panel"));
        dateSearchPanel.add(backButton, BorderLayout.NORTH);

        return dateSearchPanel;
    }

    // Create the Category Search Panel with more categories
    private JPanel createCategorySearchPanel() {
        JPanel categorySearchPanel = new JPanel();
        categorySearchPanel.setLayout(new BorderLayout());

        JLabel categoryLabel = new JLabel("Select Category:");
        categorySearchPanel.add(categoryLabel, BorderLayout.NORTH);

        // Add more categories here
        categoryComboBox = new JComboBox<>(new String[] {
                "All Categories", "Music", "Sports", "Technology", "Art", "Health", "Food & Drink", "Business"
        });
        categorySearchPanel.add(categoryComboBox, BorderLayout.CENTER);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchByCategory());
        categorySearchPanel.add(searchButton, BorderLayout.SOUTH);

        // Back button to return to main panel
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Search Panel"));
        categorySearchPanel.add(backButton, BorderLayout.NORTH);

        return categorySearchPanel;
    }

    // Create the Location Search Panel with AutoComplete and UC locations
    private JPanel createLocationSearchPanel() {
        JPanel locationSearchPanel = new JPanel();
        locationSearchPanel.setLayout(new BorderLayout());

        JLabel locationLabel = new JLabel("Select Location:");
        locationSearchPanel.add(locationLabel, BorderLayout.NORTH);

        // Use a combo box with University of Cincinnati campuses
        JComboBox<String> locationComboBox = new JComboBox<>(new String[] {
                "Blue Ash", "Clermont", "Main Campus", "UC Uptown", "UC West", "UC East"
        });
        locationSearchPanel.add(locationComboBox, BorderLayout.CENTER);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchByLocation(locationComboBox.getSelectedItem().toString()));
        locationSearchPanel.add(searchButton, BorderLayout.SOUTH);

        // Back button to return to main panel
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Search Panel"));
        locationSearchPanel.add(backButton, BorderLayout.NORTH);

        return locationSearchPanel;
    }

    // Create the Create Event Panel
    private JPanel createCreateEventPanel() {
        JPanel createEventPanel = new JPanel();
        createEventPanel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Event Name:");
        JTextField nameTextField = new JTextField();
        createEventPanel.add(nameLabel);
        createEventPanel.add(nameTextField);

        JLabel dateLabel = new JLabel("Event Date (yyyy-MM-dd):");
        JTextField dateTextField = new JTextField();
        createEventPanel.add(dateLabel);
        createEventPanel.add(dateTextField);

        JLabel locationLabel = new JLabel("Event Location:");
        JTextField locationTextField = new JTextField();
        createEventPanel.add(locationLabel);
        createEventPanel.add(locationTextField);

        JLabel categoryLabel = new JLabel("Event Category:");
        JComboBox<String> categoryComboBox = new JComboBox<>(new String[]{
                "Music", "Sports", "Technology", "Art", "Health", "Food & Drink", "Business"
        });
        createEventPanel.add(categoryLabel);
        createEventPanel.add(categoryComboBox);

        // Button to create the event
        JButton createButton = new JButton("Create Event");
        createButton.addActionListener(e -> createEvent(nameTextField, dateTextField, locationTextField, categoryComboBox));
        createEventPanel.add(createButton);

        // Back button to return to search panel
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Search Panel"));
        createEventPanel.add(backButton);

        return createEventPanel;
    }

    // Method to create an event
    private void createEvent(JTextField nameTextField, JTextField dateTextField, JTextField locationTextField, JComboBox<String> categoryComboBox) {
        String name = nameTextField.getText();
        String date = dateTextField.getText();
        String location = locationTextField.getText();
        String category = (String) categoryComboBox.getSelectedItem();

        // Create a new event object and add it to the list
        Event newEvent = new Event(name, "Description of the event.", date, category, location);
        events.add(newEvent);

        JOptionPane.showMessageDialog(null, "Event created successfully!");

        // Return to the search panel
        cardLayout.show(mainPanel, "Search Panel");
    }

    // Search events by date
    private void searchByDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String selectedDate = sdf.format(dateSpinner.getValue());

        // Clear the event text area and display events that match the selected date
        eventTextArea.setText("");
        for (Event event : events) {
            if (event.date.equals(selectedDate)) {
                eventTextArea.append(event + "\n");
            }
        }
    }

    // Search events by category
    private void searchByCategory() {
        String selectedCategory = (String) categoryComboBox.getSelectedItem();

        // Clear the event text area and display events that match the selected category
        eventTextArea.setText("");
        for (Event event : events) {
            if (selectedCategory.equals("All Categories") || event.category.equals(selectedCategory)) {
                eventTextArea.append(event + "\n");
            }
        }
    }

    // Search events by location
    private void searchByLocation(String location) {
        // Clear the event text area and display events that match the selected location
        eventTextArea.setText("");
        for (Event event : events) {
            if (event.location.equals(location)) {
                eventTextArea.append(event + "\n");
            }
        }
    }

    public static void main(String[] args) {
        new EventListingScreen();
    }

    // Event class (Placeholder)
    class Event {
        String name;
        String description;
        String date;
        String category;
        String location;

        public Event(String name, String description, String date, String category, String location) {
            this.name = name;
            this.description = description;
            this.date = date;
            this.category = category;
            this.location = location;
        }

        @Override
        public String toString() {
            return "Event: " + name + " | Date: " + date + " | Category: " + category + " | Location: " + location;
        }
    }
}



