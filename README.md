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

  ## Technologies Used

- *Core Java*: For implementing the application logic and OOPs concepts.
- *JDBC (Java Database Connectivity)*: For connecting to and interacting with the PostgreSQL database.
- *PostgreSQL*: For storing and managing employee data.
- *Maven*: For project dependency management and building the project.

---

## Dependencies

The project uses the following dependencies:

- *PostgreSQL JDBC Driver*: For connecting to the PostgreSQL database.
  xml
  <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.6.0</version>
  </dependency>
  

---
## Technologies Used

- *Core Java*: For implementing the application logic and OOPs concepts.
- *JDBC (Java Database Connectivity)*: For connecting to and interacting with the PostgreSQL database.
- *PostgreSQL*: For storing and managing employee data.
- *Maven*: For project dependency management and building the project.

---

## Dependencies

The project uses the following dependencies:

- *PostgreSQL JDBC Driver*: For connecting to the PostgreSQL database.
 ```xml
  <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.6.0</version>
  </dependency>
  ```

---

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

## Contributing

Contributions are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (git checkout -b feature/YourFeatureName).
3. Commit your changes (git commit -m 'Add some feature').
4. Push to the branch (git push origin feature/YourFeatureName).
5. Open a pull request.

---

## Contact

For any questions or feedback, feel free to reach out:

- *Your Name* : Mohit Pachpande
- *Email*: mohitpachpande5@gmail.com  
- *GitHub*: [MohitPachpande](https://github.com/mohitpachpande5)

---

Enjoy using the *Donation Management System*! 🚀

---


