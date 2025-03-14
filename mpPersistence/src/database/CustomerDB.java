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
	//Method for finding a customer by its ID
	public Customer FindCustomerByCustomerID(int customerID) {
		//sql query
		String sql = "SELECT * FROM Customer WHERE customerID = ?";
		//Prepared Statement
	  try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, customerID);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
        	   //Customer Information
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
        
        //Exception if customer could nor be found
	  } catch (SQLException e) {
	        System.err.println("Error retrieving customer: " + e.getMessage());
	    }

	    return null;
		}
		//Method for finding all customers at once in list form
	public void findAllCustomers() {
		//sql query
	    String sql = "SELECT * FROM Customer";
	    //Prepared statement
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	           //Customer information in Organized list form
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
	        //Error exception
	    } catch (SQLException e) {
	        System.err.println("Error retrieving customers: " + e.getMessage());
	  }
	}
		//Method for adding a customer to the system
		public void addCustomer(Customer customer) {
			//sql query
			  String query = "INSERT INTO Customers (cus_Name, cus_Email, customerCategory, cus_Address, cus_Zipcode, cus_City, cus_PhoneNo, custoemrID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		      //Prepared statement 
			  try (PreparedStatement stmt = connection.prepareStatement(query)) {
		           //Customer Info
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
		//Method for removing a customer		
		public void removeCustomer(Customer customer) {
			//sql query
			String query = "DELETE FROM Customers WHERE customerID = ?";
		    //Prepared statement  
			try (PreparedStatement stmt = connection.prepareStatement(query)) {
		        //getter for the customer to delete
				stmt.setInt(1, customer.getCustomerID());
		            stmt.executeUpdate();
		        } catch (SQLException e) {
		            e.printStackTrace(); 
		        }
		    }
		 //Local Test
		 public static void main(String[] args) {
		        CustomerDB customerDB = new CustomerDB();
		        Customer cus = customerDB.FindCustomerByCustomerID(02);

		        if (cus != null) {
		            System.out.println("Customer Found: " + cus.getName());
		        } else {
		            System.out.println("Customer not found.");
		        }
		    }
		 //Result set
		 private Customer createCustomerFromResultSet(ResultSet rs) throws SQLException {
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
	}



