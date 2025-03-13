package database;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class TestDBConnection {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://hildur.ucn.dk:1433;databaseName=DMA-CSD-S243_10632126;encrypt=false;trustServerCertificate=true;";
        String user = "DMA-CSD-S243_10632126";
        String password = "Password1!";
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected successfully!");
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
}
