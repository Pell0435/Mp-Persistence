//@author Pelle
package database;

import model.Customer;

public interface ICustomerDB {

		  Customer FindCustomerByCustomerID(int customerID);
		  
		  void findAllCustomers();
		  
		  void addCustomer(Customer customer);
		  
		  void removeCustomer(Customer customer);
	}

