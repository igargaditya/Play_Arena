## Turf Reservation Application
- A Java + MySQL-based console application to manage turf reservations.
- Users can sign up, log in, book turfs, view reservations, and manage turf details.
- Built with JDBC for database connectivity.

### Features
- User Authentication
- Reservation Management
- Database Operations

### Technologies Used
- Java (JDK 8+)
- JDBC (Java Database Connectivity)
- MySQL Database
- Console-based UI (Java Scanner)

### SCHEMAS

1. User Detail Schema for Storing Email and Password of a User
   ```
   CREATE TABLE userDetail (
   emailId VARCHAR(255) PRIMARY KEY,
   password VARCHAR(255) NOT NULL
   );
   ```

2. Turf Detail Schema for Storing Turf Information
   ```
   CREATE TABLE turfDetail (
       turfId INT AUTO_INCREMENT PRIMARY KEY,
       turfName VARCHAR(255) NOT NULL,
       turfCapacity INT NOT NULL,
       turfAvailable INT NOT NULL,
       turfLocation VARCHAR(255) NOT NULL,
       perPersonPrice INT NOT NULL
   );
   ```

3. Reservation Schema for Strong all the Turf Reservation
   ```
   CREATE TABLE reservations (
       rId INT AUTO_INCREMENT PRIMARY KEY,
       emailId VARCHAR(255) NOT NULL,
       guestName VARCHAR(255) NOT NULL,
       contactNo BIGINT NOT NULL,
       turfId INT NOT NULL,
       totalBookings INT NOT NULL,
       reservationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
       FOREIGN KEY (turfId) REFERENCES turfDetail(turfId) ON DELETE CASCADE,
       FOREIGN KEY (emailId) REFERENCES userDetail(emailId) ON DELETE CASCADE
   );
   ```

![alt text](https://github.com/igargaditya/Play_Arena/blob/main/src/ErDiag.png?raw=true)


### How to Run
- Install Java JDK and MySQL Server
- Create database
```
  CREATE DATABASE PlayArena;
  USE PlayArena;
```
- Create the tables (see schema above)
- Add MySQL JDBC driver (mysql-connector-j.jar) to your project
- Configure database credentials in Main.java
   ```
  private static final String url = "jdbc:mysql://127.0.0.1:3306/PlayArena";
  private static final String username = "root";
  private static final String password = "your_password";
  ```
  
- Compile and run
   ```
   javac Main.java
   java Main
  ```
  
### Main Menu Options 
- Login 
- Signup
- Exit 

### After Login:
- Book Reservation
- Show My Reservations
- Show All Turfs 
- Show Turfs By Price Range 
- Update Reservation
- Delete Reservation
- Logout

### Sample Insert for Turfs

  ```
        INSERT INTO turfDetail (turfName, turfCapacity, turfAvailable, turfLocation, perPersonPrice) VALUES
        ('PavilionSportsBox', 14, 10, 'Sector 56', 320),
        ('ClayGrounds', 20, 19, 'Phase 3', 220),
        ('FreehitArena', 18, 9, 'Sushant Lok', 350),
        ('Hozyo', 30, 25, 'HudaMetro', 120);
  ```


### ScreenShots 

### Login Menu
- If you try to Login without valid credentials, it will ask for valid details

  &nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/LoginMenu/1.png?raw=true" width="400" />

- SignUp with new Id

  &nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/igargaditya/Play_Arena/blob/main/LoginMenu/2.png?raw=true" width="400"/>
- SignUp with Existing Id

&nbsp;&nbsp;&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/LoginMenu/3.png?raw=true" width="400"/>
- Logout

&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/igargaditya/Play_Arena/blob/main/LoginMenu/4.png?raw=true" width="400"/>
