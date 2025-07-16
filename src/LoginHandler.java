import java.sql.Connection;
import java.util.Scanner;

public class Db {
    private final Connection connection;
    private final Scanner scanner;

    public Db(Connection connection, Scanner scanner) {
        this.scanner = scanner;
        this.connection = connection;
    }

    public void showMenu() {

        while (true) {
            System.out.println("Welcome To Turf Reservation Application");
            System.out.println("1. Login ");
            System.out.println("2. Signup");
            System.out.println("3. Exit ");

            System.out.print("Choose an option : ");
            String input = scanner.next();

            if (!Utility.validNumberBetween1_3(input)) {
                System.out.println("Enter Valid Number : ");
                continue;
            }

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:

                    System.out.print("Enter Email ID: ");
                    String email = scanner.next();

                    System.out.print("Enter Password : ");
                    String password = scanner.next();
                    if (!DbValidation.checkUser(connection, scanner, email, password)) {
                        System.out.println("Invalid Credentials, Try Again");
                        continue;
                    }

                    System.out.print("Logging In");
                    try {
                        for (int i = 0; i < 5; i++) {
                            System.out.print(".");
                            Thread.sleep(200);
                        }
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    MenuHandler.showMenu(connection,scanner,email) ;
                    continue;

                case 2 :
                    System.out.print("Enter Email ID: ");
                    String newEmail = scanner.next();

                    System.out.print("Enter Password : ");
                    String newPassword = scanner.next();

                    if(!DbValidation.checkEmail(connection,newEmail)) {
                        System.out.println("Email ID Already Exist, Try Logging In");
                        continue;
                    }
                    DbI

               }
            }

        }
    }
}
