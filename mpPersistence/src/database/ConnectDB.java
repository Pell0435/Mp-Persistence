package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	private static ConnectDB instance;
	private static Connection connection;

	private ConnectDB() {
		try {
		       
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String url = "jdbc:sqlserver://hildur.ucn.dk:1433;databaseName=DMA-CSD-S243_10632126;encrypt=false;trustServerCertificate=true";
			String user = "DMA-CSD-S243_10632126";
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
	
	public static ConnectDB getInstance() {
		if(instance == null) {
			instance = new ConnectDB();
		}
		return instance;
	} 
	
	public Connection getConnection() {
		return connection;
	}
	
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