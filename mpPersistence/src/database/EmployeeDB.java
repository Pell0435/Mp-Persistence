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

	private Employee FindEmployeeByEmployeeID(String employeeID) {
		String sql = "SELECT employeeID FROM Employee";
	  try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, employeeID);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Create and return an Employee object with all attributes
            return new Employee(
                rs.getString("employeeID"),
                rs.getString("name"),
                rs.getString("phoneNo"),
                rs.getString("email"),
                rs.getString("role")
            );
        }
	} catch (SQLException e) {
        System.err.println("Error retrieving employee: " + e.getMessage());
    }

    return null; // Return null if no employee is found
}
	
	
}
