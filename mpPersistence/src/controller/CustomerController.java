package controller;
import database.CustomerDB;
import model.Customer;
//Author Thomas
public class CustomerController {
	private CustomerDB customerDB;
	
	//Initialiser/Starter customerController
	public CustomerController() {
        this.customerDB = new CustomerDB(); 
	}
     //CreateCustomer - Makes customer   
	public Customer createCustomer(String name, String email, String phoneNo, String address, String zipcode, String city, String customerCategory, int customerID) {
		Customer c = new Customer (name, email, phoneNo, address, zipcode, city, customerCategory, customerID);
		customerDB.addCustomer(c);
		return c;
		
	}
	//findCustomerByCustomerID - Find customers by their ID number.
	public Customer findCustomerByCustomerID(int customerID) {
	    return customerDB.FindCustomerByCustomerID(customerID);

		
	}
	//FindallCustomers
	public void findAllCustomers() {
		customerDB.findAllCustomers();
	}
	//AddCustomer
	public void addCustomer(Customer customer) {
		customerDB.addCustomer(customer);
		
	}
	//RemoveCustomer
	public void removeCustomer(Customer customer) {
		customerDB.removeCustomer(customer);
		
	}
}
