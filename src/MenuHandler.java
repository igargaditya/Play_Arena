import jdk.jshell.execution.Util;

import java.sql.Connection;
import java.util.Scanner;

public class MenuHandler {

    public static void showMenu(Connection connection, Scanner scanner, String email) {

        while(true){
            System.out.println("Main Menu");
            System.out.println("1. Book a Turf");
            System.out.println("2. Show Reservations");
            System.out.println("3. Show all Available Turfs ");
            System.out.println("4. Filter Turfs By Prices ");
            System.out.println("5. Update Reservation ");
            System.out.println("6. Delete Reservation ");
            System.out.println("7. LOGOUT");
            System.out.print("Choose an Option : ");
            String input = scanner.nextLine();
            if(!Utility.validNumberBetween(input,1,7)){
                System.out.println("\nEnter Valid Option (1-7)\n");
                continue;
            }
            int choice = Integer.parseInt(input);

            switch(choice){
                case 1 :
                    System.out.print("Enter Guest's Name : ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Mobile Number (10 Digits) : ");
                    String contact_No = scanner.nextLine();
                    while(!Utility.isTenDigitNumber(contact_No)){
                        System.out.print("Enter Valid (10 Digit Number) : ");
                        contact_No = scanner.nextLine();
                    }
                    long contactNo = Long.parseLong(contact_No);
                    System.out.print("Enter Turf ID : ");
                    String turf_ID = scanner.nextLine();
                    while(!Utility.isInteger(turf_ID)){
                        System.out.print("Enter Valid Turf ID : ");
                        turf_ID = scanner.nextLine();
                    }
                    int turfId = Integer.parseInt(turf_ID);
                    System.out.print("Enter Total Number of Bookings : ");
                    String BookingsNo = scanner.nextLine();
                    while(!Utility.isInteger(BookingsNo)){
                        System.out.print("Enter Valid Number of Bookings : ");
                        BookingsNo = scanner.nextLine();
                    }
                    int bookings = Integer.parseInt(BookingsNo);
                    if(!turfDb.checkTurfById(connection,turfId)){
                        System.out.println("\nNo Turfs With Turf ID : "+ turfId + " found\n" );
                        continue;
                    }
                    // WILL CHECK FOR AVAILABILIY
                    reservationDB.addBooking(connection,email,name,contactNo,turfId,bookings);
                    break ;
                case 2 :
                    reservationDB.showAllBooking(connection,email);
                    break ;
                case 3 :
                    turfDb.showAllTurf(connection);
                    break ;
                case 4 :
                    System.out.print("Enter The Lower Range: ");
                    String lower = scanner.nextLine();
                    while(!Utility.isInteger(lower)){
                        System.out.print("Enter Valid Number : ");
                        lower = scanner.nextLine();
                    }
                    int lowerRange = Integer.parseInt(lower);
                    System.out.print("Enter The Higher Range: ");
                    String higher = scanner.nextLine();
                    while(!Utility.isInteger(higher)){
                        System.out.print("Enter Valid Number : ");
                        higher = scanner.nextLine();
                    }
                    int higherRange = Integer.parseInt(higher);
                    if(lowerRange>higherRange){
                        System.out.println("Lower Range is Larger than Upper Range!! ");
                        continue ;
                    }

                    turfDb.showTurfByRange(connection,lowerRange,higherRange);
                    break;
                case 6:
                    System.out.print("Enter The Reservation ID you want to delete : ");
                    String id = scanner.nextLine();
                    if(!Utility.isInteger(id)){
                        System.out.println("\nEnter Valid Reservation ID, Try Again\n");
                        break ;
                    }
                    int reservationId = Integer.parseInt(id);
                    boolean checkReservationID = reservationDB.checkReservationId(connection,reservationId);
                    if(!checkReservationID){
                        System.out.println("\nNo Reservation for Reservation ID : " + reservationId + " Found, Try Again\n");
                        break ;
                    }
                    reservationDB.deleteReservation(connection,reservationId);
                    break ;





                case 7 :

                    System.out.print("\nLOGGING OUT");
                    try {
                        for (int i = 0; i < 5; i++) {
                            System.out.print(".");
                            Thread.sleep(200);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println();
                    return ;
            }
        }


    }
}
