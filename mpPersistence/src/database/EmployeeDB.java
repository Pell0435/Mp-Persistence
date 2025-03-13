package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Employee;

public class EmployeeDB implements IEmployeeDB {
	
	private Connection connection;
	
	public EmployeeDB() {
		 this.connection = ConnectDB.getInstance().getConnection();
	}

	public Employee FindEmployeeByEmployeeID(int employeeID) {
		String sql = "SELECT * FROM Employee WHERE employeeID = ?";
	  try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, employeeID);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
   
            return new Employee(
                rs.getString("employeeID"),
                rs.getString("emp_Name"),
                rs.getString("emp_PhoneNo"),
                rs.getString("emp_Email"),
                rs.getString("emp_Role")
            );
        }
	} catch (SQLException e) {
        System.err.println("Error retrieving employee: " + e.getMessage());
    }

    return null;
	}
	
	public void findAllEmployees() {
	    String sql = "SELECT * FROM Employee";

	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            System.out.println("Employee ID: " + rs.getString("employeeID"));
	            System.out.println("Name: " + rs.getString("emp_Name"));
	            System.out.println("Phone: " + rs.getString("emp_PhoneNo"));
	            System.out.println("Email: " + rs.getString("emp_Email"));
	            System.out.println("Role: " + rs.getString("emp_Role"));
	            System.out.println("----------------------------");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error retrieving employees: " + e.getMessage());
	  }
	}
	 
	public static void Main(String[] args) {
	    EmployeeDB employeeDB = new EmployeeDB();
	    employeeDB.findAllEmployees();
	}
	
}
