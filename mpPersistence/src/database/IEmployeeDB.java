package database;

import model.Employee;

public interface IEmployeeDB {

	  Employee FindEmployeeByEmployeeID(int employeeID);
	  
	  void findAllEmployees();
}
