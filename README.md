# JDBC Donation Management System

## Introduction
This project is a simple **Donation Management System** implemented using **Java and PostgreSQL**. It allows users to create a database, add donation event types, insert donor records, update donation amounts, retrieve records, and delete events.

## Features
- Create a new database.
- Create a new donation event (table).
- Insert new donor records.
- Update existing donor records.
- Retrieve and display all donor records.
- Delete donation event tables.

## Prerequisites
Before running the project, ensure you have the following installed:
- Java (JDK 8 or later)
- PostgreSQL (with correct database configurations)
- PostgreSQL JDBC Driver

## Database Configuration
The project connects to PostgreSQL using the following details:
- **Host:** `localhost`
- **Port:** `2004`
- **Username:** `postgres`
- **Password:** `*********`

If your PostgreSQL runs on a different port or has different credentials, update the following in the `JDBC_Project1` class:
```java
private static final String DB_URL = "jdbc:postgresql://localhost:5432/";
private static final String USER = "postgres";
private static final String PASSWORD = "*******";
```

## How to Run
1. Clone or download the project.
2. Open the project in any Java IDE (Eclipse, IntelliJ, or NetBeans).
3. Ensure PostgreSQL is running.
4. Run the `JDBC_Project1.java` file.

## Usage
- The program starts by prompting whether you are a **New** or **Existing** user.
- If **New**, you can create a new event and add donation records.
- If **Existing**, you can manage existing donations.
- Follow the on-screen instructions to perform CRUD operations.

## Example Operations
### Create a New Event
```
Enter the donation type Event name (e.g., ganesh_chaturthi, holi, republic_day):
ganesh_chaturthi
```
### Insert a Donation Record
```
Enter Donor ID: 1
Enter Donor Name: John Doe
Enter Donation Amount: 500.00
```
### Retrieve All Donations
```
||Donor id: 1 || Donor Name: John Doe || Donation amount: 500.00 ||
```


