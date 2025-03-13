//@author Pelle
package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;

public class CustomerDB implements ICustomerDB{
	
	private Connection connection;
	
	public CustomerDB() {
		this.connection = ConnectDB.getInstance().getConnection();
	
	}
	
	public Customer FindCustomerByCustomerID(int customerID) {
		String sql = "SELECT * FROM Customer WHERE customerID = ?";
	  try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, customerID);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
        	   
            return new Customer(
                rs.getString("cus_Name"),
                rs.getString("cus_Email"),
                rs.getString("customerCategory"),
                rs.getString("cus_Address"),
                rs.getString("cus_Zipcode"),
                rs.getString("cus_City"),
                rs.getString("cus_PhoneNo"),
                rs.getInt("customerID")
                
            		);
        }
	
	  } catch (SQLException e) {
	        System.err.println("Error retrieving customer: " + e.getMessage());
	    }

	    return null;
		}
		
	public void findAllCustomers() {
	    String sql = "SELECT * FROM Customer";

	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	           
	            System.out.println("Name: " + rs.getString("cus_Name"));
	            System.out.println("Email: " + rs.getString("cus_Email"));
	            System.out.println("customerCategory"+rs.getString("customerCategory"));
	            System.out.println("cus_Address" + rs.getString("cus_Address"));
	            System.out.println("cus_Zipcode"+ rs.getString("cus_Zipcode"));
	            System.out.println("cus_City" +rs.getString("cus_City"));
	            System.out.println("Phone: " + rs.getString("cus_PhoneNo"));  
	            System.out.println("Customer ID: " + rs.getInt("customerID"));
	            System.out.println("----------------------------");
	        }
	    } catch (SQLException e) {
	        System.err.println("Error retrieving customers: " + e.getMessage());
	  }
	}
		 public static void main(String[] args) {
		        CustomerDB customerDB = new CustomerDB();
		        Customer cus = customerDB.FindCustomerByCustomerID(02);

		        if (cus != null) {
		            System.out.println("Customer Found: " + cus.getName());
		        } else {
		            System.out.println("Customer not found.");
		        }
		    }
		
	
	
	
	
	
	
	
	
	
	
	}



