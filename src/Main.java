
import java.sql.* ;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        try(Connection connection = DatabaseUtil.getConnection()){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Connecting to playArena Database");
            for(int i=0 ; i<5 ; i++){
                System.out.print(".");
                Thread.sleep(200);
            }
            System.out.println();
            System.out.println("Connected");
        }
        catch (SQLException e){
            System.out.println("Failed to Connect to Database");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



}
