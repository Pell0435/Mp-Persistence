package database;

import model.Customer;

public interface ICustomerDB {

		  Customer FindCustomerByCustomerID(int customerID);
	}

