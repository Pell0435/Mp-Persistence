package Test;
/*
 * @author (Mikal)
 */

import model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class TESTEmployee {

    private ConnectDB connectDB;
    private Connection connection;

    @BeforeEach
    public void setUp() {
        connectDB = ConnectDB.getInstance();
        connection = connectDB.getConnection();
        assertNotNull(connection, "Database connection should not be null");
    }

    @Test
    public void testFindEmployeeById() {
        Employee employee = findEmployeeById("3"); // Find Kent Andersen

        assertNotNull(employee, "Employee with ID 3 should be found");
        assertEquals("3", employee.getEmployeeID().trim());
        assertEquals("Kent Andersen", employee.getName().trim());
        assertEquals("+4521343678", employee.getPhoneNo().trim());
        assertEquals("kean@Westernstyle.com", employee.getEmail().trim());
        assertEquals("Accountant", employee.getRole().trim());
    }

    @Test
    public void testFindEmployeeByName() {
        Employee employee = findEmployeeByName("Hanne Pedersen");

        assertNotNull(employee, "Employee with name Hanne Pedersen should be found");
        assertEquals("2", employee.getEmployeeID().trim());
        assertEquals("Hanne Pedersen", employee.getName().trim());
        assertEquals("+4509463846", employee.getPhoneNo().trim());
        assertEquals("hape@Westerstyle.com", employee.getEmail().trim());
        assertEquals("Owner", employee.getRole().trim());
    }

    private Employee findEmployeeById(String employeeId) {
        String query = "SELECT employeeID, emp_Name, emp_PhoneNo, emp_Email, emp_Role FROM Employee WHERE employeeID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return createEmployeeFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail("SQLException occurred while finding employee by ID: " + e.getMessage());
        }
        return null;
    }

    private Employee findEmployeeByName(String empName) {
        String query = "SELECT employeeID, emp_Name, emp_PhoneNo, emp_Email, emp_Role FROM Employee WHERE emp_Name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, empName);
            ResultSet rs = stmt.executeQuery(); // Corrected line!
            if (rs.next()) {
                return createEmployeeFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail("SQLException occurred while finding employee by name: " + e.getMessage());
        }
        return null;
    }

    private Employee createEmployeeFromResultSet(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getString("employeeID"),
                rs.getString("emp_Name"),
                rs.getString("emp_PhoneNo"),
                rs.getString("emp_Email"),
                rs.getString("emp_Role")
        );
    }
}