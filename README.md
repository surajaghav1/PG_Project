# PG Management System

## Project Description
The **PG Management System** is a **desktop-based software application** designed to simplify the management of Paying Guest (PG) accommodations. This software helps PG owners or admins to efficiently manage customer data, room allocation, bed allocation, payment transactions, and room status.

## Features

### Customer Management
- Add new customer details
- Search customer by name, contact number, or room number
- Update customer information
- Delete customer records

### Room and Bed Management
- Add new rooms and beds
- Allocate separate beds to each customer
- Update room status (Occupied/Vacant)
- View room and bed availability

### Payment Management
- Track customer payments
- View payment history
- Payment methods:
  - Offline Payment
  - Online Payment (Displays QR Code for payment)

### Search Functionality
- Search customers by name, room number, or mobile number
- Filter rooms by status (Occupied or Vacant)

### Reports
- View customer payment history
- View room allocation details

## Technologies Used
- Java (Swing Framework)
- MySQL (Database)
- JDBC (Database Connectivity)

## Project Screenshots

THE BOYS PG HOSTEL <br><img src="https://github.com/surajaghav1/PG_Project/blob/main/PG_Management/images/PG_boys.jpg" width="400">  <br> <br>

<strong> Luxiourious Rooms Available </strong> <br><br>
<img src="https://github.com/surajaghav1/PG_Project/blob/main/PG_Management/images/Room_1.jpeg" width="400" height="400" >
<img src="https://github.com/surajaghav1/PG_Project/blob/main/PG_Management/images/Room_2.jpeg" width="400" height="400" >   <br><br>
<img src="https://github.com/surajaghav1/PG_Project/blob/main/PG_Management/images/Room_3_sharing.jpeg" width="400" height="400">
<img src="https://github.com/surajaghav1/PG_Project/blob/main/PG_Management/images/Room_4_sharing.jpeg" width="400" height="400">


## Installation Guide
1. Install **Java JDK 11 or above**.
2. Install **MySQL Server**.
3. Import the database using the provided SQL script.
4. Run the application using the `Home_page.java` file.

## Database Configuration
Update the following details in the `Connection.java` file:
```java
String url = "jdbc:mysql://localhost:3306/pg_management";
String username = "root";
String password = "your_password";
```

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/surajaghav1/PG_Project.git
   ```
2. Open the project in **NetBeans** or **Eclipse** or **Intellij IDEA**
3. Configure the database.
4. Run the project.

## Contributors
- Suraj Aghav (https://github.com/surajaghav1)

## License
This project is licensed under the [MIT License](LICENSE).

