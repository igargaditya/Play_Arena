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




## Login Menu
- If you try to Log in without valid credentials, it will ask for valid details

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/LoginMenu/1.png?raw=true" width="600" />

- SignUp with new Email-id

&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/igargaditya/Play_Arena/blob/main/LoginMenu/2.png?raw=true" width="600"/>

- SignUp with Existing Email-id

&nbsp;&nbsp;&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/LoginMenu/3.png?raw=true" width="600"/>
- Logout

&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://github.com/igargaditya/Play_Arena/blob/main/LoginMenu/4.png?raw=true" width="600"/>

## Main Menu
&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/MainMenu/Main.png?raw=true" width="600" />

1. Book a Turf

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/MainMenu/1.png?raw=true" width="600" />

2. Show Reservations

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/MainMenu/2.png?raw=true" width="800" />

3. See all Available Turfs

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/MainMenu/3.png?raw=true" width="800" />

4. Filter Turf by prices

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/MainMenu/4.png?raw=true" width="800" />

5. Update Reservation

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/MainMenu/5.png?raw=true" width="800" />

6. Delete Reservation

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/MainMenu/6.png?raw=true" width="800" />

7. Log out

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/MainMenu/7.png?raw=true" width="800" />


## Exception Handling

### Login Menu
- If the input is not a number or is outside the range (1–3), the system prompts the user to enter a valid option again.
- If the login credentials do not match any existing user, an "Invalid Credentials" message is displayed, and the user is asked to retry.
- During sign-up, if the entered email ID already exists, the system notifies the user and prompts them to try a different email or log in instead.

### Main Menu

1. Book a turf
- If the contact number is not exactly 10 digits, the system loops until a valid number is entered.
- If the Turf ID is not an integer, the user is prompted to re-enter it.
- If the number of bookings is not an integer, the system asks the user to re-enter it.
- If the Turf ID does not exist in the database, the booking is not processed, and the user is informed.

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/ExceptionHandling/1.png?raw=true" width="800" />

- If Both Turf ID and Bookings are valid, and Availability of Turf is more , then Booking is made and availability of turf is decreased by number of bookings.

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/ExceptionHandling/1.1.png?raw=true" width="800" />

2. Filter Turf By Prices
- If the lower price input is not a valid number (NaN), the system repeatedly prompts for a valid value.
- If the upper price input is not a valid number (NaN), the system repeatedly prompts for a valid value.
- If the lower price is greater than the upper price, the system displays: Lower Range is Larger than Upper Range!! and asks the user to re-enter the values.

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/ExceptionHandling/2.png?raw=true" width="800" />

3. Update Reservation
- If the entered Reservation ID is invalid (does not exist) or is not a valid number, the system exits the update process, returns to the main menu, and prompts the user to try again.
- When updating the contact number, if the input is not exactly 10 digits, the system repeatedly prompts the user until a valid number is entered.

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/ExceptionHandling/3.png?raw=true" width="800" />

4. Delete Reservation
- If the entered Reservation ID is invalid (does not exist) or is not a valid number, the system cancels the delete process, returns to the main menu, and prompts the user to try again.
- If it is valid then the availability of the turf with that cancelled bookings is increased by the number of bookings deleted

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/ExceptionHandling/4.png?raw=true" width="800" />

- The Turf with ID = 5 has availability 7 and when a reservation which had 3 bookings were cancelled then the availability of turf increase by 3 

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/ExceptionHandling/5.png?raw=true" width="800" />

&nbsp;&nbsp; <img src="https://github.com/igargaditya/Play_Arena/blob/main/ExceptionHandling/6.png?raw=true" width="800" />




