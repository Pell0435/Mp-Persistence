package Test;

import database.CustomerDB;

public class CustomerDBTest {
	    public static void main(String[] args) {
	        // Create an instance of CustomerDB
	        CustomerDB customerDB = new CustomerDB();

	        // Call the method to print all customers
	        customerDB.findAllCustomers();
	    }
}
