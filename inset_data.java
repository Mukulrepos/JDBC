import java.sql.*;
import java.util.Scanner;
public class inset_data {
    public static void main(String[] args) throws ClassNotFoundException {
        String url ="jdbc:mysql://localhost:3306/brahma";
        String Username = "root";
        try (Scanner sc = new Scanner(System.in)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Robot Machine Linked");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
            try{
                System.out.println("========================================================");
                System.out.println("Enter password sir or mam");
                String Password =sc.nextLine();
                try (Connection Sector = DriverManager.getConnection(url,Username,Password)) {
                    Thread.sleep(3000);
                    System.out.println("connection bridge is ready");
                    try (Statement state = Sector.createStatement()) {
                        System.out.println("Enter your query");
                        String task = sc.nextLine();
                        try (ResultSet ans = state.executeQuery(task)) {
                            while(ans.next()){
                                int studentId = ans.getInt("Student_id");
                                String studentName = ans.getString("Student_name");
                                int studentAge = ans.getInt("Student_age");
                                long studentPhoneNumber = ans.getLong("Student_phone_number");
                                String fatherName = ans.getString("Student_father_name");
                                String motherName = ans.getString("Student_mother_name");
                                String course = ans.getString("Student_course");
                                int totalFee = ans.getInt("Student_totalfee");
                                int pay = ans.getInt("Student_pay");
                                int due = ans.getInt("Student_due");
                                
// Printing the retrieved data
System.out.println("####################################");
System.out.println("Student ID => " + studentId);
System.out.println("Name => " + studentName);
System.out.println("Age => " + studentAge);
System.out.println("Phone Number => " + studentPhoneNumber);
System.out.println("Father's Name => " + fatherName);
System.out.println("Mother's Name => " + motherName);
System.out.println("Course => " + course);
System.out.println("Total Fee => " + totalFee);
System.out.println("Pay => " + pay);
System.out.println("Due => " + due);
System.out.println("####################################");
                            }
                        }
                    }
                }
                System.out.println("coonection cutt");
            }catch (SQLException | InterruptedException e){
                System.out.println(e.getMessage());
            }
        }



    }
}
