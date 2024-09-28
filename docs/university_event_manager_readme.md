# University Event Manager UML Class Diagram

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
