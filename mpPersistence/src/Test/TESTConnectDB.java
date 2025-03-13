package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TESTConnectDB {

    @Test
    public void testDatabaseConnection() {
        String url = "jdbc:sqlserver://hildur.ucn.dk:1433;databaseName=DMA-CSD-S243_10632126;encrypt=true;trustServerCertificate=true;";
        String user = "DMA-CSD-S243_10632126";
        String password = "Password1!";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            assertNotNull(conn, "Connection should not be null");
            assertTrue(conn.isValid(1), "Connection should be valid"); //1 second timeout
        } catch (SQLException e) {
            fail("SQLException occurred: " + e.getMessage());
        }
    }

    @Test
    public void testDatabaseConnectionFailure() {
        String invalidUrl = "jdbc:sqlserver://invalid.ucn.dk:1433;databaseName=DMA-CSD-S243_10632126;encrypt=true;trustServerCertificate=true;";
        String user = "DMA-CSD-S243_10632126";
        String password = "Password1!";

        assertThrows(SQLException.class, () -> {
            DriverManager.getConnection(invalidUrl, user, password);
        }, "Should throw SQLException for invalid URL");

    }

    @Test
    public void testDatabaseConnectionFailureInvalidCredentials() {
        String url = "jdbc:sqlserver://hildur.ucn.dk:1433;databaseName=DMA-CSD-S243_10632126;encrypt=true;trustServerCertificate=true;";
        String user = "invalid_user";
        String password = "invalid_password";

        assertThrows(SQLException.class, () -> {
            DriverManager.getConnection(url, user, password);
        }, "Should throw SQLException for invalid credentials");

    }
}