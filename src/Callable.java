import java.sql.*;
public class Callable 
{
 public  static void main(String[] args)
 {
  int count=0;
  try
  {
   Connection con=DBConn.getConn();
   CallableStatement cs=con.prepareCall("{call GetEmployee()}");
   
   ResultSet rs =cs.executeQuery();
   
   //Read employee details
   while(rs.next())
   {
    System.out.println("emp_id : "+rs.getString("emp_id"));
          System.out.println("emp_name : "+rs.getString("emp_name"));
          System.out.println("emp_sal : "+rs.getString("sal"));
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