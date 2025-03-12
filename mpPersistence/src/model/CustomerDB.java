package model;
import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDB {

	private static CustomerDB instance;
	private ArrayList<Customer> customers;
	
	public static CustomerDB getInstance() {
		if(instance == null) {
			instance = new CustomerDB();
		}
		return instance;
	}
	
	private CustomerDB() {
		customers = new ArrayList<>();
	}
	
	public void addCustomer (Customer c) throws IllegalArgumentException {
		if(findByCustomerID(c.getCustomerID()) == null) {
			Customer res = null;
			for (int i = 0 ; i <customers.size() && res == null; i++) {
				if(customers.get(i).getCustomerID().equalsIgnoreCase(CustomerID)) {
					res = Customers.get(i);
				}
		}
		return res;
	}

	public List<Customer> findAll() {
		return new ArrayList<>(this.customers);
	}

}
