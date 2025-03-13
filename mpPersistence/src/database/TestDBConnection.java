package database;


public class TestDBConnection {
    public static void main(String[] args) {
        ProductDB db = ProductDB.getInstance();  // Calls the singleton instance
        if (db.getConnection() != null) {
            System.out.println("Connection test successful!");
        } else {
            System.out.println("Connection test failed!");
        }
    }
}
