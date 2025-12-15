Airline Management System

Overview

This is a Java Swing-based Airline Management System project.
It allows users to manage flights, customers, and bookings through a simple GUI interface.
The project integrates with MySQL for storing flight and customer information.

Features

User authentication (Login module)

Flight information display (FlightInfo module)

Customer management (AddCustomer module)

Flight booking system (BookFlight module)

Database connection using Conn.java


Modules & Folder Structure

AirlineManagementSystem/
│
├─ src/                 # Contains all Java source files
│   ├─ Login.java
│   ├─ Home.java
│   ├─ FlightInfo.java
│   ├─ AddCustomer.java
│   ├─ BookFlight.java
│   └─ Conn.java
│
├─ .gitignore           # Ignores unnecessary files/folders
└─ README.md            # Project documentation

How to Run

1. Open the project in VS Code or Eclipse.


2. Ensure JDK 23 or higher is installed.


3. Ensure MySQL server is running and database is set up.


4. Compile all .java files in src/:

javac *.java


5. Run the project by executing the main class (Login.java):

java Login



Author

A.Tharunesh 

SRMIST