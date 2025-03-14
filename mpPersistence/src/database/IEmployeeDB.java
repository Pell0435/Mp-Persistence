package database;

import model.Employee;

public interface IEmployeeDB {

	  Employee FindEmployeeByEmployeeID(int employeeID);
	  
	  void findAllEmployees();
	  
	  void addEmployee(Employee employee);
	  
	  void removeEmployee(Employee employee);
}
