import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/PlayArena";
    private static  final String username = "root";
    private  static final String password = "yourpassword" ;


    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found");
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url , username, password);
    }
}
