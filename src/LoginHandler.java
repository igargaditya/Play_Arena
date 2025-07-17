import java.sql.Connection;
import java.util.Scanner;

public class LoginHandler {
    private final Connection connection;
    private final Scanner scanner;

    public LoginHandler(Connection connection, Scanner scanner) {
        this.scanner = scanner;
        this.connection = connection;
    }

    public void showMenu() {

        while (true) {
            System.out.println("\nWelcome To PLAYARENA");
            System.out.println("1. Login ");
            System.out.println("2. Signup");
            System.out.println("3. Exit ");

            System.out.print("Choose an option : ");
            String input = scanner.nextLine();


            if (!Utility.validNumberBetween(input,1,3)) {
                System.out.println("Enter Valid Option (1-3)");
                continue;
            }

            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:

                    System.out.print("Enter Email ID : ");
                    String email = scanner.nextLine();

                    System.out.print("Enter Password : ");
                    String password = scanner.nextLine();
                    if (!userDb.checkUser(connection, scanner, email, password)) {
                        System.out.println("Invalid Credentials, Try Again");
                        continue;
                    }

                    System.out.print("Logging In");
                    try {
                        for (int i = 0; i < 5; i++) {
                            System.out.print(".");
                            Thread.sleep(200);
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    MenuHandler.showMenu(connection,scanner,email) ;
                    continue;

                case 2 :
                    System.out.print("Enter Email ID: ");
                    String newEmail = scanner.nextLine();

                    System.out.print("Enter Password : ");
                    String newPassword = scanner.nextLine();

                    if(userDb.checkEmail(connection,newEmail)) {
                        System.out.println("Email ID Already Exist, Try Logging In");
                        continue;
                    }

                    userDb.addUser(connection,newEmail,newPassword);
                    System.out.println("New Account Created, Login Now");
                    continue;

                case 3 :
                    System.out.print("Thank You For Using PLAYARENA ");
                    try {
                        for (int i = 0; i < 5; i++) {
                            System.out.print(".");
                            Thread.sleep(200);
                        }
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    return ;

               }
            }

        }
    }

