import java.util.Scanner;
import java.sql.*;
class JDBCUpdate {
  public static void main(String args[]) throws SQLException {
	  Connection con = DBConn.getConn();
      Statement stmt = con.createStatement();
  Scanner sc=new Scanner(System.in);
  
  System.out.println("Enter empid to update:");
  String empid=sc.nextLine();
  System.out.println("Enter new salary:");
  double newSalary=sc.nextDouble();
  //Build and execute update query
  int rowsAffected=stmt.executeUpdate("UPDATE emp1 SET salary ="+newSalary+
      "WHERE id='"+empid+"'");
  //Show result
  if(rowsAffected>0)
    System.out.println("Record updated successfully.");
  else
    System.out.println("Employee ID not found. Update failed.");
  stmt.close();
  con.close();
  sc.close();
}
}