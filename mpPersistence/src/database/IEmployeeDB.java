package database;
/*
 * @author Nicklas
 */
import model.Employee;

public interface IEmployeeDB {

	//Added methods from EmployeeDB
	  Employee FindEmployeeByEmployeeID(int employeeID);
	  
	  void findAllEmployees();
	  
	  void addEmployee(Employee employee);
	  
	  void removeEmployee(Employee employee);
}
