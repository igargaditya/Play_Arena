import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class turfDb {
    public static boolean checkTurfById(Connection connection, int turfId) {
        String query = "select * from turfDetail where turfId = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, turfId);
            try (ResultSet ans = statement.executeQuery()) {
                return ans.next();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
          }
       }
    public static void showAllTurf(Connection connection) {
        String query = "select * from turfDetail";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            try(ResultSet rs = statement.executeQuery();) {

                System.out.println();
                System.out.println("+---------+----------------------------+----------+---------------+---------------+---------------------+");
                System.out.println("| Turf ID |         Turf Name          | Capacity | Availability  |   Location    |   Per Person Price  |");
                System.out.println("+---------+----------------------------+----------+---------------+---------------+---------------------+");

                while (rs.next()) {
                    System.out.printf("| %-7d | %-26s | %-8d | %-13d | %-13s | %-19d |\n",
                            rs.getInt("turfID"),
                            rs.getString("turfName"),
                            rs.getInt("turfCapacity"),
                            rs.getInt("turfAvailable"),
                            rs.getString("turfLocation"),
                            rs.getInt("perPersonPrice"));
                }

                System.out.println("+---------+----------------------------+----------+---------------+---------------+---------------------+");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void showTurfByRange(Connection connection, int lowerRange, int higherRange) {
        String query = "select * from turfDetail where perPersonPrice between ? and ?;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setInt(1,lowerRange);
            statement.setInt(2,higherRange);
            try(ResultSet rs = statement.executeQuery();) {

                System.out.println();
                System.out.println("+-----------+--------------------------+----------+---------------+---------------+---------------------+");
                System.out.println("| Turf ID   |        Turf Name         | Capacity | Availability  |   Location    |   Per Person Price  |");
                System.out.println("+-----------+--------------------------+----------+---------------+---------------+---------------------+");

                while (rs.next()) {
                    System.out.printf("| %-9d | %-24s | %-8d | %-13d | %-13s | %-19d |\n",
                            rs.getInt("turfID"),
                            rs.getString("turfName"),
                            rs.getInt("turfCapacity"),
                            rs.getInt("turfAvailable"),
                            rs.getString("turfLocation"),
                            rs.getInt("perPersonPrice"));
                }

                System.out.println("+-----------+--------------------------+----------+---------------+---------------+---------------------+");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

