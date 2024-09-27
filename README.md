# BearcatEventPlanner
Group 6 Final Project Enterprise App Dev

## Introduction
The University of Cincinnati Event Planner allows university staff to create, manage, and promote events, while students can easily browse, register, and track their participation. This system provides a streamlined interface for event creation, registration, and tracking, integrating features such as calendar syncing and notifications. Users can interact with the platform through a simple UI or programmatically via RESTful service endpoints, making event management accessible and efficient for both organizers and participants.

## Storyboard

Attached is a link to the [storyboard](docs/Storyboard.pdf)

## Requirements

* As a UC Staff Member, I want to create an event, so that I can share the event with students and manage it through the platform.

    * **Given** the staff member has logged into the system with valid credentials

    * **When** the staff member fills in all required event details and clicks "Create Event"

    * **Then** the system will save the event and display it in the list of upcoming events

    * **Given** the staff member attempts to create an event with missing or invalid details

    * **When** the staff member submits the form

    * **Then** the system will display error messages for the missing or incorrect fields and prevent the event from being created

* As a student, I want to register for an event, so that I can track my participation and attend the event.

    * **Given** the student is logged into the system and browsing available events

    * **When** the student selects an event and clicks "Register"
    
    * **Then** the system will confirm their registration and update the event’s attendee list

    * **Given** the student tries to register for a full event

    * **When** the student attempts registration

    * **Then** the system will display a message saying the event is at capacity and offer an option to join a waitlist (if its an option).

* As a student, I want to sync registered events with my personal calendar, so that I can easily manage my schedule.

    * **Given** the student is registered for an event

    * **When** they click the "Sync to Calendar" button

    * **Then** the system will directly sync with Outlook calendar

    * **Given** the sync request fails (e.g., due to a network issue)

    * **When** the student tries to sync the event

    * **Then** Then the system will display an error message and prompt the user to try again

*  As a UC Staff Member, I want to send event reminders to registered participants, so that they are remined of their upcoming events.

    * **Given** the event is approaching

    * **When** the system checks the event status

    * **Then** it will automatically send reminder emails or push notifications to all registered participants



