import java.sql.*;
public class Callable2 
{
 public  static void main(String[] args)
 {
  int count=0;
  try
  {
   Connection con=DBConn.getConn();
   CallableStatement cs=con.prepareCall("{call EmployeeReport()}");
   
   ResultSet rs =cs.executeQuery();
   
   //Read employee details
   while(rs.next())
   {
    System.out.println("emp_id : "+rs.getString("emp_id"));
          System.out.println("emp_name : "+rs.getString("emp_name"));
          System.out.println("emp_sal : "+rs.getString("sal"));
          System.out.println("emp_sal : "+rs.getString("salary_category"));
          System.out.println("emp_sal : "+rs.getString("total_employees"));
   }
   //Print count after loop
   System.out.println("Total Employees : "+count);
   
   //Close resources
   rs.close();
   cs.close();
   con.close();
  }
  catch (Exception e)
  {
   System.out.println("Database error: ");
   e.printStackTrace();
  }
 }
}