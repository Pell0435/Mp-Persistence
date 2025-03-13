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
            // Create and return an Employee object with all attributes
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

    return null; // Return null if no employee is found
	}
	
	 public static void main(String[] args) {
	        EmployeeDB employeeDB = new EmployeeDB();
	        Employee emp = employeeDB.FindEmployeeByEmployeeID(02);

	        if (emp != null) {
	            System.out.println("Employee Found: " + emp.getName());
	        } else {
	            System.out.println("Employee not found.");
	        }
	    }
	
}
