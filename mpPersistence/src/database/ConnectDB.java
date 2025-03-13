package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class ConnectDB {

	
private static final String serverAddress = ";hildur.ucn.dk";
private static final String databaseName = ";databaseName=DMA-CSD-S243_10632126";
private static String userName = ";DMA-CSD-S243_10632126";
private static String password = ";Password1!";
private static String encryption = ";encrypt=false";

private static Connection ctn;
private DatabaseMetaData dmd;

private static ConnectDB instance = null;

	private ConnectDB() {

	String url = serverAddress + databaseName + userName + password + encryption;
	System.out.println("URL Address: " + url);
	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Driver ok");
		}
		
		catch(Exception e) {
			System.out.println("Could not find the driver")
		}
	
		try{
		ctn = DriverManager.getConnection(url);
		ctn.setAutoCommit(true);
		dmd = ctn.getMetaData();
		System.out.println("Connected to " + dmd.getURL());
		}
	
		catch(Exception e) {
		System.out.println("Database connection failed");
		System.out.println(e.getMessage());
		System.out.println(url);
		}
	}
	
	public static void closeConnection() {
		try {
		ctn.close();
		instance = null;
		System.out.println("Connection was successfully lost");
		}
		catch(Exception e){
		System.out.println("Database was not closed successfully " + e.getMessage());
	}
}

	public Connection getDatabaseConnection() {
		return ctn;
}

	public static boolean instanceNull() {
		return (instance == null);
}
	public static ConnectDB getInstance() {
		if (instance == null) {
			instance = new ConnectDB();
		}
		return instance;
	}
	
	public static boolean getStatus() {
		boolean isOpen = false;
		try {
			isOpen = (!ctn.isClosed());
		}
		catch (Exception sclExc) {
			isOpen = false;
		}
		return isOpen;
	}

}
