package database;
import java.sql.*;

import model.Product;
// Author er Thomas og Mikal
public class ProductDB {

	private static ProductDB instance;
	private Connection connection;
	
	
	private ProductDB(){
		try {
	       
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String url = "jdbc:sqlserver://hildur.ucn.dk:1433;databaseName=DMA-CSD-S243_10632114;encrypt=true;trustServerCertificate=true";
			String user = "DMA-CSD-S243_10632114";
			String password = "Password1!";
			
			//opret forbindelse til databse
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Database forbundet sucessfuldt!");
            
            //detaljeret fejlbesked hvis forbindelsen mislykkedes
		} catch (ClassNotFoundException e) {
	        System.err.println("SQL Server JDBC Driver not found.");
	        e.printStackTrace();
	        
		}catch (SQLException e){
			System.err.println("Database forbindelse fejlede...");
	        e.printStackTrace();
		}
	}
	
	public static ProductDB getInstance() {
		if(instance == null) {
			instance = new ProductDB();
		}
		return instance;
	} 
	
	public Connection getConnection() {
		return connection;
	}
	
	public void addProduct(Product product) {
	    String query = "INSERT INTO Products (productName, purchasePrice, salesPrice, rentPricePerUnit, countryOfOrigin, minStock, productID, productType, barcode, ssid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, product.getName());  // productName
	        stmt.setDouble(2, product.getPurchasePrice());  // purchasePrice
	        stmt.setDouble(3, product.getSalesPrice());  // salesPrice
	        stmt.setDouble(4, product.getRentPricePerUnit());  // rentPricePerUnit
	        stmt.setString(5, product.getCountryOfOrigin());  // countryOfOrigin
	        stmt.setInt(6, product.getMinStock());  // minStock
	        stmt.setString(7, product.getProductID());  // productID (Primary Key)
	        stmt.setString(8, product.getProductType());  // productType
	        stmt.setString(9, product.getBarcode());  // barcode (Unique)
	        stmt.setString(10, product.getSsid());  // ssid (Foreign Key)
	        stmt.executeUpdate();  // Executes SQL INSERT
	    } catch (SQLException e) {
	        e.printStackTrace();  // Handles any SQL errors
	    }
	}
	
	
}
