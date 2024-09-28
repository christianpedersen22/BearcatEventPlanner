# University Event Manager UML Class Diagram

This document contains a UML class diagram for the University Event Manager.

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
