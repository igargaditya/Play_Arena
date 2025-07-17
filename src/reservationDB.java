import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class reservationDB {
    public static void addBooking(Connection connection, String email, String name, long contactNo, int turfId, int bookings) {
        String query = "insert into reservations(emailId,guestName,contactNo,turfId,totalBookings)" +
                "values (?,?,?,?,?);";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,email);
            statement.setString(2,name);
            statement.setLong(3,contactNo);
            statement.setInt(4,turfId);
            statement.setInt(5,bookings);

            int rows = statement.executeUpdate();
            if(rows>0){
                System.out.println("\nReservation Made\n");
            }
            else{
                System.out.println("Error, Try Again");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showAllBooking(Connection connection,String email) {
        String query = "select * from reservations where emailId = ? ;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,email);
            try( ResultSet rs = statement.executeQuery()) {


                System.out.println();
                System.out.println("+-------------------+------------------+----------------+----------+-----------+---------------------+");
                System.out.println("|  Reservation ID   |     Guest        |    Contact     | Turf ID  | Bookings  |  Reservation  Date  |");
                System.out.println("+-------------------+------------------+----------------+----------+-----------+---------------------+");

                while (rs.next()) {
                    System.out.printf("| %-17s | %-16s | %-14d | %-8d | %-9d | %-10s |\n",
                            rs.getInt("RId"),
                            rs.getString("guestName"),
                            rs.getLong("contactNo"),
                            rs.getInt("turfId"),
                            rs.getInt("totalBookings"),
                            rs.getString("reservationDate"));
                }

                System.out.println("+-------------------+------------------+----------------+----------+-----------+---------------------+\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkReservationId(Connection connection, int reservationId) {
        String query = "select * from reservations where rId = ? ;";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reservationId);
            try (ResultSet ans = statement.executeQuery()) {
                return ans.next();
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteReservation(Connection connection, int reservationId) {
        String query = "delete from reservations where rId = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reservationId);
            int affected  = statement.executeUpdate();
            if(affected>0){
                System.out.print("Deleting Reservation");
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.print(".");
                        Thread.sleep(200);
                    }

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("\nReservation Deleted\n");
            }
            else{
                System.out.println("\nTry Again Later\n");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateReservation(Connection connection, int updateId, String updatedName, long updatedContact) {
        String query = "update reservations set guestName = ?, contactNo = ? WHERE rId=?;";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1,updatedName);
            statement.setLong(2,updatedContact);
            statement.setInt(3,updateId);
            int affect = statement.executeUpdate();
            if(affect>0){
                System.out.print("Updating");
                try {
                    for (int i = 0; i < 5; i++) {
                        System.out.print(".");
                        Thread.sleep(200);
                    }

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.print("\nUpdated Successfully\n\n");
            }
            else{
                System.out.println("\nTry Again Later\n\n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
