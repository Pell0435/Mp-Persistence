package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
/*
 *  @Mikal & Nicklas
 */
	private static ConnectDB instance;
	private static Connection connection;

	private ConnectDB() {
		try {
		       //Database Info
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String url = "jdbc:sqlserver://hildur.ucn.dk:1433;databaseName=DMA-CSD-S243_10632114;encrypt=true;trustServerCertificate=true";
			String user = "DMA-CSD-S243_10632114";
			String password = "Password1!";
			
			//Create Connection to Database
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Database forbundet sucessfuldt!");
            
            //Error message for database connection
		} catch (ClassNotFoundException e) {
	        System.err.println("SQL Server JDBC Driver not found.");
	        e.printStackTrace();
	        
		}catch (SQLException e){
			System.err.println("Database forbindelse fejlede...");
	        e.printStackTrace();
		}
	}
	
	public static ConnectDB getInstance() {
		if(instance == null) {
			instance = new ConnectDB();
		}
		return instance;
	} 
	
	public Connection getConnection() {
		return connection;
	}
	// Method for closing the connection to the database when not used
	 public static void closeConnection() {
	       	try{
	            connection.close();
	            instance= null;
	            System.out.println("The connection is closed");
	        }
	         catch (Exception e){
	            System.out.println("Error trying to close the database " +  e.getMessage());
	         }
	    }
	 public static boolean instanceNull() {
	       return (instance == null);
	    }    
	 
	 //Connection Status
	 public static boolean getStatus() {
	    	boolean isOpen = false;
	    	try {
	    		isOpen = (!connection.isClosed());
	    	} catch (Exception sclExc) {
	    		isOpen = false;
	    	}
	    	return isOpen;
	    }
}