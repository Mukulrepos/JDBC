import java.sql.*;
import java.util.Scanner;
public class d {

    public static void main(String[] args) throws ClassNotFoundException{
        String url ="jdbc:mysql://localhost:3306/headquator";
        String username = "root";
        String Password = "Mukul2004@";
        try (Scanner sc = new Scanner(System.in)) {
            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded successfully.");
            } catch (ClassNotFoundException e) {
                // Handle the exception if the driver is not found
                System.out.println("Driver not found: " + e.getMessage());
            }
            try{
                Connection wire = DriverManager.getConnection(url,username,Password);
                System.out.println("connection create successfully");
                Statement area = wire.createStatement();
                System.out.println("Enter the tasks to see the database");
                String task = sc.nextLine();
                ResultSet report =  area.executeQuery(task);
                while (report.next()){
                    int id = report.getInt("id");
                    String name = report.getString("name");
                    String job_title =report.getString("job_title");
                    double salary = report.getDouble("salary");

                    System.out.println("####################################");
                    System.out.println("People ID => "+id);
                    System.out.println("Name => "+name);
                    System.out.println("Job Title => "+job_title);
                    System.out.println("Salary => "+salary);
                    System.out.println("###############");
                }

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
