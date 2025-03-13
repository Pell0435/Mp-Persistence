package Test;

import database.EmployeeDB;

public class EmployeeDBTest {
    public static void main(String[] args) {
        // Create an instance of EmployeeDB
        EmployeeDB employeeDB = new EmployeeDB();

        // Call the method to print all employees
        employeeDB.findAllEmployees();
    }
}
