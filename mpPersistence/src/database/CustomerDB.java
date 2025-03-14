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
	
		public void addCustomer(Customer customer) {
			  String query = "INSERT INTO Customers (cus_Name, cus_Email, customerCategory, cus_Address, cus_Zipcode, cus_City, cus_PhoneNo, custoemrID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		        try (PreparedStatement stmt = connection.prepareStatement(query)) {
		            stmt.setString(1, customer.getName());
		            stmt.setString(2, customer.getEmail());
		            stmt.setString(3, customer.getCustomerCategory());
		            stmt.setString(4, customer.getAddress());
		            stmt.setString(5, customer.getZipcode());
		            stmt.setString(6, customer.getCity());
		            stmt.setString(7, customer.getPhoneNo());
		            stmt.setInt(8, customer.getCustomerID());
		            stmt.executeUpdate();
		        } catch (SQLException e) { 
		            e.printStackTrace(); // hvis der skulle opstå en fejl, printer den en detaljeret fejlbesked i console
		        }
		    }
			
		public void removeCustomer(Customer customer) {
			 String query = "DELETE FROM Customers WHERE customerID = ?";
		        try (PreparedStatement stmt = connection.prepareStatement(query)) {
		            stmt.setInt(1, customer.getCustomerID());
		            stmt.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace(); 
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



