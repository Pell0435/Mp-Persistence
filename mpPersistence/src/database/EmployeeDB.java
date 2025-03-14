package database;
/*
 * Author: Nicklas
 */
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
	//Method for finding an Employee with ID
	public Employee FindEmployeeByEmployeeID(int employeeID) {
		//sql query
		String sql = "SELECT * FROM Employee WHERE employeeID = ?";
		//Prepared Statement
	  try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, employeeID);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
   
            return new Employee(
            	//Employee info
                rs.getString("employeeID"),
                rs.getString("emp_Name"),
                rs.getString("emp_PhoneNo"),
                rs.getString("emp_Email"),
                rs.getString("emp_Role")
            );
        }
      //Exception for errors
	} catch (SQLException e) {
        System.err.println("Error retrieving employee: " + e.getMessage());
    }

    return null;
	}
	//Method for finding all employees
	public void findAllEmployees() {
		//sql query
	    String sql = "SELECT * FROM Employee";
	    //Prepared Statement
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	//Employee Info organized in list form
	            System.out.println("Employee ID: " + rs.getString("employeeID"));
	            System.out.println("Name: " + rs.getString("emp_Name"));
	            System.out.println("Phone: " + rs.getString("emp_PhoneNo"));
	            System.out.println("Email: " + rs.getString("emp_Email"));
	            System.out.println("Role: " + rs.getString("emp_Role"));
	            System.out.println("----------------------------");
	        }
	      //Exception for Errors
	    } catch (SQLException e) {
	        System.err.println("Error retrieving employees: " + e.getMessage());
	  }
	}
	// Method to add an Employee
	public void addEmployee(Employee employee) {
		//sql query
		String query = "INSERT INTO Employees (employeeID, emp_Name, emp_PhoneNo, emp_Email, emp_Role) VALUES (?,?,?,?,?)";
		//Prepared statement
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, employee.getEmployeeID());
			stmt.setString(2, employee.getName());
			stmt.setString(3, employee.getPhoneNo());
			stmt.setString(4, employee.getEmail());
			stmt.setString(5, employee.getRole());
			
			//Exception for errors
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//Method for removing employees
	public void removeEmployee(Employee employee) {
		//sql query
		String query = "DELETE FROM Employees WHERE employeeID = ?";
		//Prepared Statement
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, employee.getEmployeeID());
			stmt.executeUpdate();
			
			//Exception for errors
		}	catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	//Result set - bliver ikke brugt lokalt?
	private Employee createEmployeeFromResultSet(ResultSet rs) throws SQLException {
        return new Employee(
            rs.getString("employeeID"),
            rs.getString("emp_Name"),
            rs.getString("emp_PhoneNo"),
            rs.getString("emp_Email"),
            rs.getString("emp_Role")
        );
    }
	 
	public static void Main(String[] args) {
	    EmployeeDB employeeDB = new EmployeeDB();
	    employeeDB.findAllEmployees();
	}
	
}
