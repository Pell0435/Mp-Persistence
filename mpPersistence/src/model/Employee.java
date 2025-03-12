package model;


/**
 * @author (Nicklas)
 **/
public class Employee {
	private String employeeID;
	private String name;
	private String phoneNo;
	private String email;
	private String role;
	
	// Constructor
	public Employee(String employeeID, String name, String phoneNo, String email, String role) {
		// Initialization of instance variables
		this.employeeID = employeeID;
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.role = role;
	}
	
	//Setters and getters
	public void setEmployeeID(String newEmployeeID) {
		this.employeeID = newEmployeeID;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setPhoneNo(String newPhoneNo) {
		this.phoneNo = newPhoneNo;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public void setRole(String newRole) {
		this.role = newRole;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getRole() {
		return role;
	}
}

