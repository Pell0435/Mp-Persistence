package controller;
import database.EmployeeDB;
import model.Customer;
import model.Employee;
//Author Thomas
public class EmployeeController {
	private EmployeeDB employeeDB;

	public EmployeeController() {
		this.employeeDB = new EmployeeDB();
	}
	public Employee createEmployee(String name, String phoneNo, String email, String role, String employeeID) {
		Employee e = new Employee(name,phoneNo,email,role,employeeID);
		employeeDB.addEmployee(e);
		return e;
	}
	public Employee findEmployeeByEmployeeID(int employeeID) {
		return employeeDB.FindEmployeeByEmployeeID(employeeID);
	}
	//FindallCustomers
	public void findAllEmployees() {
		employeeDB.findAllEmployees();
	}
	//AddCustomer
	public void addEmployee(Employee employee) {
		employeeDB.addEmployee(employee);
		
	}
	//RemoveCustomer
	public void removeEmployee(Employee employee) {
		employeeDB.removeEmployee(employee);
		
	}
}
