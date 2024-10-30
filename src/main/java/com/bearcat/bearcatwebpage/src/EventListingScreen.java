import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EventListingScreen {

    private List<String> events;
    private JTextArea eventListTextArea;

    public EventListingScreen() {
        events = new ArrayList<>();
        events.add("Event 1: Description of the event.");
        events.add("Event 2: Another interesting event.");
        events.add("Event 3: Yet another event happening today.");


        JFrame frame = new JFrame("Bearcat Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);


        frame.setLayout(new BorderLayout());


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


        frame.add(topPanel, BorderLayout.NORTH);


        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        //label for the event list, since the list can be filtered by date it should change depending on the
        // date filtered and not just be "happening today"
        //change the "date" to your filtered date variable from the searchByDateButton
        JLabel happeningOnDateLabel = new JLabel("Happening on:" + "date", SwingConstants.CENTER);
        centerPanel.add(happeningOnDateLabel, BorderLayout.NORTH);


        eventListTextArea = new JTextArea();
        updateEventListTextArea();
        eventListTextArea.setEditable(false);
        centerPanel.add(new JScrollPane(eventListTextArea), BorderLayout.CENTER);


        frame.add(centerPanel, BorderLayout.CENTER);


        frame.setVisible(true);
    }

    private void updateEventListTextArea() {
        StringBuilder eventList = new StringBuilder();
        for (String event : events) {
            eventList.append(event).append("\n");
        }
        eventListTextArea.setText(eventList.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EventListingScreen::new); 
    }
}
