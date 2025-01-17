# BearcatEventPlanner
Group 6 Final Project Enterprise App Dev

## To Run

```mvn exec:java -Dexec.mainClass="com.bearcat.eventplanner.App"```

Use this command in the root folder of the repo

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

## Json Schema

This is the schema we intend to output

### Event
> {
>  "type": "object",
> "properties": {
>     "id": {"type": "integer"},
>      "name": {"type": "string"},
>      "description": {"type": "string"},
>      "date": { "type": "string", "format": "date-time" },
>       "capacity": {"type:" "integer"},
>      "attendees": {
>          "type": "array",
>          "items": {"type": "integer"}
>      },
>      "organizer": {
>          "type": "object",
>         "properties": {
>             "id": {"type": "integer"},
>             "name": {"type": "string"}
>          }
>       }
>   },
   "required": ["id", "name", "date", "capacity", "organizer"]
> }

### User
> {
>  "type": "object",
>  "properties": {
>    "id": { "type": "integer" },
>    "name": { "type": "string" },
>    "email": { "type": "string", "format": "email" },
>    "role": { "type": "string", "enum": ["student", "staff"] }
>  },
>  "required": ["id", "name", "email", "role"]
> }

### Registration 
> {
> "type": "object",
> "properties": {
>   "eventId": { "type": "integer" },
>    "userId": { "type": "integer" },
>    "status": { "type": "string", "enum": ["registered", "waitlisted"] },
>    "registrationDate": { "type": "string", "format": "date-time" }
>  },
>  "required": ["eventId", "userId", "status"]
> }
>
> 
## Scrum Roles

Product Owner
* Responsible for defining and managing the product backlog (list of work items).
* Ensures that the team is working on the most valuable features.
* Works closely with stakeholders to define and prioritize product features.
* Acts as the voice of the customer, making sure the product meets user needs.

User: Pederscn Christain 

Scrum Master
* Serves as a coach or facilitator for the Scrum team.
* Helps the team follow Scrum practices and remove any impediments blocking progress.
* Ensures that the team adheres to Scrum principles and organizes the Scrum ceremonies (e.g., sprint planning, daily stand-ups, retrospectives).
*Helps improve team efficiency and collaboration.

User: Kaas Logan

Development Team
* A self-organizing, cross-functional group responsible for delivering the product increment at the end of each sprint.
* Typically includes developers, designers, testers, and other roles needed to build the product.
* Collaborates to achieve sprint goals and is accountable for the work delivered.

User: Doersam Kyle 

User: George Aaron

User: Rome David

User: Damron Drake


## University Event Manager UML Class Diagram

This document contains a UML class diagram for the University Event Manager.


User: Represents a generic user in the system with basic information such as userId, username, and email. It acts as the base class for specialized users.

Student: Inherits from User and includes additional fields like major and year to store student-specific information.

Organizer: A specialized user who manages events, with attributes like department and a list of eventsManaged.

Event: Stores details about a specific event including its eventId, title, date, location, description, and the organizerId to track which organizer is responsible for the event.

Registration: Tracks the registration of students for events, using registrationId, studentId, and eventId to link students and events.

Feedback: Allows users to provide feedback for an event, with fields like feedbackId, userId, eventId, and comments.

```mermaid
classDiagram
    class User {
        +int userId
        +string username
        +string email
    }

    class Student {
        +string major
        +int year
    }

    class Organizer {
        +string department
        +list eventsManaged
    }

    class Event {
        +int eventId
        +string title
        +date date
        +string location
        +string description
        +int organizerId
    }

    class Registration {
        +int registrationId
        +int studentId
        +int eventId
    }

    class Feedback {
        +int feedbackId
        +int userId
        +int eventId
        +string comments
    }

```

## Weekly Meeting Link (Every Sunday at 3pm)
[Meeting ](https://teams.microsoft.com/l/meetup-join/19%3ameeting_MzFhNDQxMGUtNzI0YS00YTVmLWFlODMtNTk0MzNkZjc3ZGM1%40thread.v2/0?context=%7b%22Tid%22%3a%22f5222e6c-5fc6-48eb-8f03-73db18203b63%22%2c%22Oid%22%3a%2205acd326-155f-4085-b0d1-9542f71eddda%22%7durl)

