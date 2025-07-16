import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DbValidation {
    public static boolean checkUser(Connection connection, Scanner scanner,String email,String password){
        String query = "select * from userDetail where emailId = ? and password = ? ;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,email);
            statement.setString(2,password);
            try(ResultSet ans = statement.executeQuery()){
                return ans.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
