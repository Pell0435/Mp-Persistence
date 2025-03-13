package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import database.ConnectDB;

class TestConnectDatabase {
	
	static ConnectDB ctn = null;


	@BeforeAll
public static void setUp() {
	ctn = ConnectDB.getInstance();
}
	@Test
	public void IsConnected() {
		ConnectDB.closeConnection();
		boolean wasNullified = ConnectDB.instanceNull();
		assertTrue(wasNullified);
		
		ctn = ConnectDB.getInstance();
		boolean connectionIsOpen = ConnectDB.getStatus();
		assertTrue(connectionIsOpen);

}
}