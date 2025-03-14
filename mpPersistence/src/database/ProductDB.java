package database;
/*
 * @author (Mikal)
 */
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.*;
import model.Product;


public class ProductDB implements IProductDB {

    private static ProductDB instance;
    private Connection connection;
    private ConnectDB connectDB;

    public ProductDB() {
        connectDB = ConnectDB.getInstance();
        connection = connectDB.getConnection();
        assertNotNull(connection, "Database connection should not be null");
    }

    public static ProductDB getInstance() {
        if (instance == null) {
            instance = new ProductDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    // metode til at tilføje et produkt
    public void addProduct(Product product) {
        String query = "INSERT INTO Products (productName, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, productID, productType, barcode, ssid) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPurchasePrice());
            stmt.setDouble(3, product.getSalesPrice());
            stmt.setDouble(4, product.getRentPrice());
            stmt.setString(5, product.getCountryOfOrigin());
            stmt.setInt(6, product.getMinStock());
            stmt.setString(7, product.getProductID());
            stmt.setString(8, product.getProductType());
            stmt.setString(9, product.getBarcode());
            stmt.setString(10, product.getSupplierID());
            stmt.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace(); // hvis der skulle opstå en fejl, printer den en detaljeret fejlbesked i console
        }
    }

    // metode til at fjerne et produkt
    public void removeProduct(Product product) {
        String query = "DELETE FROM Products WHERE productID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, product.getProductID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }
    // metode til at finde et produkt ved hjælp af dens ID
    public Product findProductByProductID(String productID) {
        Product product = null;
        String query = "SELECT productName, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, productID, productType, barcode, ssid FROM Products WHERE productID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, productID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                product = createProductFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return product;
        
    }

    /* hvis der bliver fundet et produkt ovenfor, 
     * bliver denne metode brugt til konvertere en række data fra en databse query til et java-objekt. 
     */
    private Product createProductFromResultSet(ResultSet rs) throws SQLException {
        return new Product(
            rs.getString("barcode"),
            rs.getString("productName"),
            rs.getString("manufacturerName"),
            rs.getString("productID"),
            rs.getInt("minStock"),
            rs.getDouble("purchasePrice"),
            rs.getDouble("salesPrice"),
            rs.getDouble("rentPrice"),
            rs.getString("countryOfOrigin"),
            rs.getString("productType"),
            rs.getString("ssid")
        );
    }


}
