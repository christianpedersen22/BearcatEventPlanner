package com.bearcat.eventplanner;

import com.bearcat.bearcatwebpage.src.EventListingScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventListingScreenTest {

    private EventListingScreen eventListingScreen;

    @BeforeEach
    void setUp() {
        eventListingScreen = new EventListingScreen();
    }

    @Test
    void testUpdateEventTextArea() {
        JTextArea eventTextArea = eventListingScreen.getEventTextArea();
        List<String> events = eventListingScreen.getEvents();

        StringBuilder expectedText = new StringBuilder();
        for (String event : events) {
            expectedText.append(event).append("\n");
        }

        assertEquals(expectedText.toString(), eventTextArea.getText());
    }
}
