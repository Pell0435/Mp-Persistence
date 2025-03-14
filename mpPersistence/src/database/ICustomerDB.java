//@author Pelle
package database;

import model.Customer;

public interface ICustomerDB {
	//Added methods from CustomerDB

		  Customer FindCustomerByCustomerID(int customerID);
		  
		  void findAllCustomers();
		  
		  void addCustomer(Customer customer);
		  
		  void removeCustomer(Customer customer);
	}

