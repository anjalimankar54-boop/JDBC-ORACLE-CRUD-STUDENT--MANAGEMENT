import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteStudent {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Step 1: Load JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Create Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "oracle"
            );

            // Step 3: Take student ID
            System.out.print("Enter Student ID to delete: ");
            int id = sc.nextInt();

            // Step 4: SQL DELETE Query
            String sql = "DELETE FROM students WHERE id = " + id;

            // Step 5: Execute query
            Statement stmt = con.createStatement();
            int result = stmt.executeUpdate(sql);

            // Step 6: Confirmation
            if (result > 0) {
                System.out.println("Student record deleted successfully!");
            } else {
                System.out.println("Student ID not found!");
            }

            // Step 7: Close connection
            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        sc.close();
    }
}