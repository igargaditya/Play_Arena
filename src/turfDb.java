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


    public static Pair getAvailable(Connection connection, int turfId) {
        String query = "select * from turfDetail where turfId=?";
        int available = 0 ;
        int perPerson = 0 ;
        try(PreparedStatement statement= connection.prepareStatement(query)){
            statement.setInt(1,turfId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                available = rs.getInt("turfAvailable");
                perPerson = rs.getInt("perPersonPrice");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Pair(available,perPerson,turfId,0);

    }

    public static void updateTurfAvailability(Connection connection, int newAvail, int turfId) {
        String query = "update turfDetail set turfAvailable = ? WHERE turfId=?;";

        try(PreparedStatement statement= connection.prepareStatement(query)){
            statement.setInt(1,newAvail);
            statement.setInt(2,turfId);
            int rs = statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static int getPrice(Connection connection, int turfIdReverted) {
        String query = "select * from turfDetail where turfId=?";
        int perPerson = 0 ;
        try(PreparedStatement statement= connection.prepareStatement(query)){
            statement.setInt(1,turfIdReverted);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                perPerson = rs.getInt("perPersonPrice");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return perPerson;
    }
}

