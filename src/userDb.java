import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class userDb {
    public static boolean checkUser(Connection connection, Scanner scanner, String email, String password) {
        String query = "select * from userDetail where emailId = ? and password = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet ans = statement.executeQuery()) {
                return ans.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addUser(Connection connection, String email, String password) {
        String query = "Insert into userDetail(emailId,password) values (?,?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, password);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("User Created ");
            } else {
                System.out.println("Failed, Try Again");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkEmail(Connection connection, String email) {
        String query = "select * from userDetail where emailId = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try (ResultSet ans = statement.executeQuery()) {
                return ans.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
     }

}
